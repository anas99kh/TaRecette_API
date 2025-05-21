package com.tarecette.api.services;


import com.tarecette.api.entities.Utilisateur;

public interface AuthService {
    String login(String email, String password);
    void register(Utilisateur utilisateur);

}
