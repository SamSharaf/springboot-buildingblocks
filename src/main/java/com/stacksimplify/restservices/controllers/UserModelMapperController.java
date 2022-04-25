package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.dtos.UserMmDTO;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;
import java.util.Optional;
import javax.validation.constraints.Min;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/modelmapper/users")
public class UserModelMapperController {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping("/{id}")
  public UserMmDTO getUserById(@PathVariable("id") @Min(1) Long id) throws UserNotFoundException {
    Optional<User> optionalUser = userRepository.findById(id);
    if(!optionalUser.isPresent()){
      throw new UserNotFoundException("User not found in user Repository");
    }
    User user = optionalUser.get();
    UserMmDTO userMmDTO = modelMapper.map(user, UserMmDTO.class);
    return userMmDTO;
  }

}
