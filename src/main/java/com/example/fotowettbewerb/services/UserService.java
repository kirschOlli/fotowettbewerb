package com.example.fotowettbewerb.services;

import com.example.fotowettbewerb.Users;
import com.example.fotowettbewerb.repositories.UsersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    public Users registerUser(String username, LocalDate birthday){
        if (usersRepository.findByUsername(username).isPresent()){
            throw new RuntimeException("Name bereits vergeben");
        }
        Users user = new Users();
        user.setUsername(username);
        user.setBirthday(birthday);
        return usersRepository.save(user);

    }
}
