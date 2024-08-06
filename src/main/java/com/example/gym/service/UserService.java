package com.example.gym.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gym.model.User;
import com.example.gym.repo.UserRepo;

@Service
public class UserService {
    
    @Autowired
     private UserRepo UserRepo;

     public List<User> findAllUsers() {
        return UserRepo.findAll();
     }

     public User findUserById(Long userId) {
      return UserRepo.findById(userId).orElse(null);
  }

     public User addUser(User user){
        return UserRepo.save(user);
     }

     public User updateUser(Long uid, User user) {
      Optional<User> optionalUser = UserRepo.findById(uid);
      if (optionalUser.isPresent()) {
          User existingUser = optionalUser.get();
          existingUser.setUname(user.getUname());
          existingUser.setUmail(user.getUmail());
         //  existingUser.setUpass(user.getUpass());
          return UserRepo.save(existingUser);
      }
      return user;
  }

     public void deleteUser(Long userId){
      UserRepo.deleteById(userId);
     }
}
