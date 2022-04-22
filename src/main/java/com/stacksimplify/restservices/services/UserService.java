package com.stacksimplify.restservices.services;


import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.entities.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers(){
    return userRepository.findAll();
  }

  public User createUser(User user){
    return userRepository.saveAndFlush(user);
  }

  public Optional<User> getUserById(Long id){
    Optional<User> byId = userRepository.findById(id);
    return byId;
  }

  public User updateUserById(Long id, User user){
    user.setId(id);
    return userRepository.saveAndFlush(user);
  }

  public void deleteUserById(Long id){
    if (userRepository.findById(id).isPresent()){
      userRepository.deleteById(id);
    }
  }

  public User getUserByUsername(String username){
    return userRepository.findByUsername(username);
  }
}
