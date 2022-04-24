package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resources;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hateoas/users")
public class OrderHateoasController {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private OrderRepository orderRepository;

  @GetMapping("/{userid}/orders")
  public Resources<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
    Optional<User> optionalUser = userRepository.findById(userid);
    if (!optionalUser.isPresent()){
      throw new UserNotFoundException("User Not Found");
    }
    User user = optionalUser.get();
    List<Order> orders = user.getOrders();
    return new Resources<Order>(orders);
  }
}
