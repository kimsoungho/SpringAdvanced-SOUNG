package com.example.intermediate.controller.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ResponseDto<T> {
  private boolean success;
  private T data;//제니릭, 뭐든 받겠다.
  private Error error;

  //제네릭을 쓸거야!
  public static <T> ResponseDto<T> success(T data) {
    return new ResponseDto<>(true, data, null);
  }

  @Getter
  @AllArgsConstructor
  static class Error {
    private String code;
    private String message;
  }

  public static <T> ResponseDto<T> fail(String code, String message) {
    return new ResponseDto<>(false, null, new Error(code, message));
  }
}
