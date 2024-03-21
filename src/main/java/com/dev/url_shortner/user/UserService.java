package com.dev.url_shortner.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addNewUser(User user) {
        try {
            if (userRepository.findUserByEmail(user.getEmail()) != null) {
                throw new IllegalStateException("email taken");
            }
            userRepository.save(user);
        } catch (Exception e) {
            if (e instanceof IllegalStateException) {
                throw e;
            }
            throw new IllegalStateException("Something went wrong. Please try again.");
        }
    }

    public void deleteUser(String email) {
        User user = userRepository.findUserByEmail(email);
        if (user == null) {
            throw new IllegalStateException("user with email " + email + " does not exist");
        }
        userRepository.delete(user);
    }

}
