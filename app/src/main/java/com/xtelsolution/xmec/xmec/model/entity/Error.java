package com.xtelsolution.xmec.xmec.model.entity;

import com.google.gson.annotations.Expose;

/**
 * Created by vivh on 23/08/2017.
 */

public class Error {

    @Expose
    private Integer ErrorCode;
    @Expose
    private String Message;

    public Error(Integer errorCode, String message) {
        ErrorCode = errorCode;
        Message = message;
    }

    public Integer getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(Integer errorCode) {
        ErrorCode = errorCode;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    @Override
    public String toString() {
        return "Error{" +
                "ErrorCode=" + ErrorCode +
                ", Message='" + Message + '\'' +
                '}';
    }
}
