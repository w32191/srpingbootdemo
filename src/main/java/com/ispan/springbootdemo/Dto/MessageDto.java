package com.ispan.springbootdemo.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;

public class MessageDto implements Serializable {

  @JsonProperty("message")
  private String msg;

  public MessageDto() {
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
