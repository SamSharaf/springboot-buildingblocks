package com.stacksimplify.restservices.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.springframework.hateoas.ResourceSupport;

@Entity
@Table(name = "orders")
public class Order extends ResourceSupport {
  @Id
  @GeneratedValue
  private Long orderid;

  private String orderdescription;

  @ManyToOne(fetch = FetchType.LAZY)
//  @JoinColumn(name = "user_id")
  @JsonIgnore
  private User user;

//  public User getUser() {
//    return user;
//  }

  public Long getOrderid() {
    return this.orderid;
  }

  public void setOrderid(final Long orderid) {
    this.orderid = orderid;
  }

  public String getOrderdescription() {
    return this.orderdescription;
  }

  public void setOrderdescription(final String orderdescription) {
    this.orderdescription = orderdescription;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(final User user) {
    this.user = user;
  }
}
