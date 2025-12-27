package com.examly.springapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.UserRepo;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserRepo userRepo;
    
    @Override
    public User createUser(User user) {
        return userRepo.save(user);
    }
    
    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }
    
    @Override
    public User getUserById(Long id) {
        return userRepo.findById(id).orElse(null);
    }
    
    @Override
    public User updateUser(Long id, User user) {
        user.setId(id);
        return userRepo.save(user);
    }
    
    @Override
    public List<User> getUsersByRole(String role) {
        return userRepo.findByRole(role);
    }
    
    @Override
    public List<User> getUsersByUsernameAndRole(String username, String role) {
        return userRepo.findByUsernameAndRole(username, role);
    }
}
