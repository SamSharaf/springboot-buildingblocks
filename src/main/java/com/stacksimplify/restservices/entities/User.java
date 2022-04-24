package com.stacksimplify.restservices.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user", schema = "PUBLIC")  // h2 has the default schema
public class User {
  @Id
  @GeneratedValue
  private long id;
  @NotEmpty(message = "Username is Mandatory field. Please provide it")
  @Column(name = "user_name", length = 200, nullable = false, unique = true)
  private String username;
  @Size(min = 2, message = "FirstName should have at least 2 characters")
  @Column(length = 200, nullable = false)
  private String firstname;
  @Column(length = 200, nullable = false)
  private String lastname;
  @Column(length = 200, nullable = false)
  private String email;
  @Column(length = 200, nullable = false)
  private String role;
  @Column(length = 50, nullable = false, unique = true)
  private String ssn;

  @OneToMany(mappedBy = "user")
  private List<Order> orders;

  public User() {
  }

  public User(final long id, final String username, final String firstname, final String lastname, final String email, final String role, final String ssn) {
    this.id = id;
    this.username = username;
    this.firstname = firstname;
    this.lastname = lastname;
    this.email = email;
    this.role = role;
    this.ssn = ssn;
  }

  public List<Order> getOrders() {
    return this.orders;
  }

  public void setOrders(final List<Order> orders) {
    this.orders = orders;
  }

  public long getId() {
    return this.id;
  }

  public void setId(final long id) {
    this.id = id;
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

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(final String role) {
    this.role = role;
  }

  public String getSsn() {
    return this.ssn;
  }

  public void setSsn(final String ssn) {
    this.ssn = ssn;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", email='" + email + '\'' +
        ", role='" + role + '\'' +
        ", ssn='" + ssn + '\'' +
        '}';
  }
}
