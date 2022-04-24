package com.stacksimplify.restservices.controllers;

import com.stacksimplify.restservices.entities.Order;
import com.stacksimplify.restservices.entities.User;
import com.stacksimplify.restservices.exceptions.UserNotFoundException;
import com.stacksimplify.restservices.repositories.UserRepository;
import com.stacksimplify.restservices.services.UserService;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/hateoas/users")
@Validated
public class UserHateoasController {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserService userService;

  @GetMapping("/{id}")
  public Resource<User> getUserById(@PathVariable("id") @Min(1) Long id){
    try {
      Optional<User> optionalUser = userService.getUserById(id);
      User user = optionalUser.get();
      long userid = user.getUserid();
      ControllerLinkBuilder linkBuilder = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid);
      Link selfLink = linkBuilder.withSelfRel();
      user.add(selfLink);
      Resource<User> userResource = new Resource<>(user);
      return userResource;
    } catch (UserNotFoundException e) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
    }
  }
  @GetMapping
  public Resources<User> getAllUsers() throws UserNotFoundException {
    List<User> allUsers = userService.getAllUsers();
    for (User user:allUsers) {
      // Selflink
      long userid = user.getUserid();
      ControllerLinkBuilder linkBuilder = ControllerLinkBuilder.linkTo(this.getClass()).slash(userid);
      Link selfRel = linkBuilder.withSelfRel();
      user.add(selfRel);

      //Relationship link with all Orders
      OrderHateoasController hateoasController = ControllerLinkBuilder.methodOn(OrderHateoasController.class);
      Resources<Order> orders = hateoasController.getAllOrders(userid);
      Link ordersLink = ControllerLinkBuilder.linkTo(orders).withRel("all-orders");
      user.add(ordersLink);
    }
    // Self link for allUsers
    ControllerLinkBuilder linkTo = ControllerLinkBuilder.linkTo(this.getClass());
    Link allUserslink = linkTo.withSelfRel();
    return new Resources<User>(allUsers, allUserslink);
  }

}
