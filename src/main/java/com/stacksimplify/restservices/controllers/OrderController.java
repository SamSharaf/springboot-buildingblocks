package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.OrderNotFoundException;
import com.stacksimplify.restservices.repositories.OrderRepository;
import com.stacksimplify.restservices.repositories.UserRepository;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class OrderController {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private OrderRepository orderRepository;

  @GetMapping("/{userid}/orders")
  public List<Order> getAllOrders(@PathVariable Long userid) throws UserNotFoundException {
    Optional<User> optionalUser = userRepository.findById(userid);
    if (!optionalUser.isPresent()){
      throw new UserNotFoundException("User Not Found");
    }
    return optionalUser.get().getOrders();
  }

  @PostMapping("{userid}/orders")
  public Order createOrder(@PathVariable Long userid, @RequestBody Order order) throws UserNotFoundException {
    Optional<User> optionalUser = userRepository.findById(userid);
    if (!optionalUser.isPresent()){
      throw new UserNotFoundException("User Not Found");
    }
    User user = optionalUser.get();
    order.setUser(user);
    return orderRepository.saveAndFlush(order);
  }


  @GetMapping("/{userid}/orders/{orderid}")
  public Order getOrderByOrderId(@PathVariable("userid") Long userid, @PathVariable("orderid") Long orderid) throws UserNotFoundException, OrderNotFoundException {
    Optional<User> optionalUser = userRepository.findById(userid);
    if (!optionalUser.isPresent()){
      throw new UserNotFoundException("User Not Found");
    }
    Optional<Order> optionalOrder = orderRepository.findById(orderid);
    if (!optionalOrder.isPresent()){
      throw new OrderNotFoundException("Order Not Found");
    }
    return optionalOrder.get();
  }
}
