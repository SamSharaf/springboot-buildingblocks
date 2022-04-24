package com.stacksimplify.restservices.exceptions;

import java.util.Date;

public class CustomErrorDetails {
  private Date timestamp;
  private String message;
  private String errorDetails;

  public CustomErrorDetails(final Date timestamp, final String message, final String errorDetails) {
    this.timestamp = timestamp;
    this.message = message;
    this.errorDetails = errorDetails;
  }

  public Date getTimestamp() {
    return this.timestamp;
  }

  public String getMessage() {
    return this.message;
  }

  public String getErrorDetails() {
    return this.errorDetails;
  }
}
