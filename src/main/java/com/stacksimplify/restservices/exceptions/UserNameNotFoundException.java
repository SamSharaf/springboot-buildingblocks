package com.stacksimplify.restservices.exceptions;

public class UserNameNotFoundException extends Exception {

  private static final long serialVersionUID = -8233201493962973620L;

  public UserNameNotFoundException(final String message) {
    super(message);
  }
}
