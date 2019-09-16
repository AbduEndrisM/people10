package com.people10;

import lombok.Data;

import java.io.Serializable;

@Data
public class JsonResponse<T> implements Serializable {
    T data;
    Integer status;
    String message;
    public JsonResponse(String message, T data, Integer status){
        this.message = message;
        this.data = data;
        this.status = status;
    }
    public JsonResponse(String message, T data){
        this.message = message;
        this.data = data;
        this.status = 200;
    }
    public JsonResponse(String message){
        this.message = message;
        this.data = null;
        this.status = 200;
    }
}
