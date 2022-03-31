package com.stacksimplify.restservices.hello;

public class UserDetails {
  private String firstname;
  private String lastname;
  private String city;

  public UserDetails(final String firstname, final String lastname, final String city) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.city = city;
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

  public String getCity() {
    return this.city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  @Override
  public String toString() {
    return "UserDetails{" +
        "firstname='" + firstname + '\'' +
        ", lastname='" + lastname + '\'' +
        ", city='" + city + '\'' +
        '}';
  }
}
