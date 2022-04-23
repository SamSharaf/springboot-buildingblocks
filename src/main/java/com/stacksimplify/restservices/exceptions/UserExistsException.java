package com.stacksimplify.restservices.exceptions;

public class UserExistsException extends Exception {

  private static final long serialVersionUID = 1904585489531578456L;

  public UserExistsException(final String message) {
    super(message);
  }
}
