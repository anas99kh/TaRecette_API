package com.tarecette.api.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * Classe utilitaire pour la gestion des tokens JWT.
 * Cette classe fournit des méthodes pour générer, valider et extraire des informations
 * des tokens JWT utilisés pour l'authentification.
 */
@Component
public class JwtUtil {

    @Value("${jwt.secret:votre_secret_par_defaut}")
    private String SECRET_KEY;

    @Value("${jwt.expiration:3600000}")
    private long EXPIRATION_TIME; // 1 heure par défaut

    /**
     * Génère un token JWT pour l'utilisateur identifié par son email.
     *
     * @param email l'email de l'utilisateur
     * @return le token JWT généré
     */
    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, email);
    }

    /**
     * Crée un token JWT avec les claims spécifiés et le sujet.
     *
     * @param claims les claims à inclure dans le token
     * @param subject le sujet du token (généralement l'email de l'utilisateur)
     * @return le token JWT créé
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                .compact();
    }

    /**
     * Valide un token JWT pour un utilisateur spécifié.
     *
     * @param token le token JWT à valider
     * @param username le nom d'utilisateur (email) à vérifier
     * @return true si le token est valide pour l'utilisateur spécifié, sinon false
     */
    public Boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    /**
     * Extrait le nom d'utilisateur (email) du token JWT.
     *
     * @param token le token JWT
     * @return le nom d'utilisateur extrait
     */
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Extrait la date d'expiration du token JWT.
     *
     * @param token le token JWT
     * @return la date d'expiration
     */
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extrait un claim spécifique du token JWT.
     *
     * @param token le token JWT
     * @param claimsResolver la fonction pour extraire le claim
     * @return le claim extrait
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * Extrait tous les claims du token JWT.
     *
     * @param token le token JWT
     * @return tous les claims
     */
    private Claims extractAllClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    /**
     * Vérifie si le token JWT est expiré.
     *
     * @param token le token JWT
     * @return true si le token est expiré, sinon false
     */
    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }
}
