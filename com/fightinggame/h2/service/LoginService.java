package com.fightinggame.h2.service;

import com.fightinggame.h2.entity.User;

import java.util.List;

public interface LoginService {
    String getLogin(String email, String password);

    String registerUser(String username, String email, String password);

    void addWin(String username);

    List<User> getScores();
}
