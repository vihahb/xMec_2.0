package com.xtelsolution.xmec.xmec.model.rest;

import com.google.gson.annotations.Expose;

/**
 * Created by vivh on 23/08/2017.
 */

public class RestBasic {

    @Expose
    private Integer ErrorCode;
    @Expose
    private String Message;

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

}
