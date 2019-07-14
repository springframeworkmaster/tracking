package com.tasks.tracking.errors;

import com.google.gson.annotations.SerializedName;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Error
 */
@Data
@AllArgsConstructor
public class ApiError {
  @SerializedName("code")
  private Integer code = null;

  @SerializedName("message")
  private String message = null;

}

