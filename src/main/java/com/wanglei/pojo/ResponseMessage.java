package com.wanglei.pojo;

import com.wanglei.util.MakeResponse;
import lombok.Data;

@Data
public class ResponseMessage<T> implements MakeResponse {
    private Integer status;
    private String message;
    private T data;
    private Integer count;

    public ResponseMessage(T data, Integer count) {
        this.data = data;
        this.count = count;
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
