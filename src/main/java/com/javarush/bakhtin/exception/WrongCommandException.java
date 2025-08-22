package com.javarush.bakhtin.exception;

public class WrongCommandException extends RuntimeException {
  public WrongCommandException() {
    super();
  }

  public WrongCommandException(String message) {
        super(message);
    }

  public WrongCommandException(String message, Throwable cause) {
    super(message, cause);
  }

  public WrongCommandException(Throwable cause) {
    super(cause);
  }
}
