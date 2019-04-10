package com.wanglei.pojo;

import com.wanglei.util.MakeResponse;
import lombok.Data;

@Data
public class ResponseMessage<T> implements MakeResponse {
    private Integer status;
    private String message;
    private T data;

    public ResponseMessage(T data) {
        this.data = data;
    }

    @Override
    public ResponseMessage success() {
        this.status = 200;
        this.message = "OK";
        return this;
    }

    @Override
    public ResponseMessage error(int status, String message) {
        this.status = status;
        this.message = message;
        return this;
    }
}
