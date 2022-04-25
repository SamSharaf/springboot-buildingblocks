package com.stacksimplify.restservices.dtos;

import com.stacksimplify.restservices.entities.Order;
import java.util.List;

public class UserMmDTO {
  private Long userid;
  private String username;
  private String firstname;
  private List<Order> orders;

  public Long getUserid() {
    return this.userid;
  }

  public void setUserid(final Long userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(final String firstname) {
    this.firstname = firstname;
  }

  public List<Order> getOrders() {
    return this.orders;
  }

  public void setOrders(final List<Order> orders) {
    this.orders = orders;
  }
}
