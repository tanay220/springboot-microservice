package com.ongraph.EmployeeService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseDTO<T> {

    boolean status = true;
    String message=" ";
    T data;

    public void setSuccessResponse(T data, String msg) {
        this.status = true;
        this.message = msg!=null?msg:" ";
        this.data = data!=null ?data: null;
    }

    public void setFailureResponse(String msg) {
        this.status = false;
        this.message = msg;
        this.data = null;
    }

    public void setErrorResponse(Exception ex, String msg) {
        status = false;
        this.message = msg!=null ?msg: ex.getMessage();
        this.data = null;
        ex.printStackTrace();
    }
}
