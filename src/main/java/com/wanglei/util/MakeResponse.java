package com.wanglei.util;

import com.wanglei.pojo.ResponseMessage;

public interface MakeResponse {
    ResponseMessage success();
    ResponseMessage error(int code, String message);
}
