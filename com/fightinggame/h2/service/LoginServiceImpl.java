package com.fightinggame.h2.service;

import com.fightinggame.h2.entity.User;
import com.fightinggame.h2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private UserRepository userRepository;
    @Override
    public String getLogin(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null){
            return "Wrong email or password!";
        } else{
            String toPass = user.getPassword();
            if(toPass.equals(password)){
                return user.getUsername();
            } else{
                return "Wrong email or password!";
            }
        }
    }

    @Override
    public String registerUser(String username, String email, String password) {
        if(userRepository.findByEmail(email) == null){
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setWins(0);
            userRepository.save(user);
        } else{
            return "Email already registered!";
        }
        return "";
    }

    @Override
    public void addWin(String username) {
        User user = userRepository.findByUsername(username);
        user.setWins(user.getWins() + 1);System.out.println("!!");
        userRepository.deleteById(user.getId());
        userRepository.save(user);
    }

    @Override
    public List<User> getScores(){
        List<User> users = userRepository.findAll();
        return users;
    }
}
