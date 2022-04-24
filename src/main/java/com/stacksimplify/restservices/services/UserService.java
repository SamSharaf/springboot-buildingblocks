package com.stacksimplify.restservices.services;


import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.repositories.UserRepository;
import com.stacksimplify.restservices.exceptions.UserExistsException;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public List<User> getAllUsers(){
    return userRepository.findAll();
  }

  public User createUser(User user) throws UserExistsException {
    User existingUser = userRepository.findByUsername(user.getUsername());
    if (!Objects.isNull(existingUser)){
      throw new UserExistsException("User already exists in repository");
    }
    return userRepository.saveAndFlush(user);
  }

  public Optional<User> getUserById(Long id) throws UserNotFoundException {
    Optional<User> user = userRepository.findById(id);
    if(!user.isPresent()){
      throw new UserNotFoundException("User not found in user Repository");
    }
    return user;
  }

  public User updateUserById(Long id, User user) throws UserNotFoundException {
    Optional<User> optionalUser = userRepository.findById(id);
    if(!optionalUser.isPresent()){
      throw new UserNotFoundException("User not found in user Repository, provide the correct user id");
    }
    user.setUserid(id);
    return userRepository.saveAndFlush(user);
  }

  public void deleteUserById(Long id) {
    Optional<User> optionalUser = userRepository.findById(id);
    if(!optionalUser.isPresent()){
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found in user Repository, provide the correct user id");
    }
    userRepository.deleteById(id);
  }

  public User getUserByUsername(String username){
    return userRepository.findByUsername(username);
  }
}
