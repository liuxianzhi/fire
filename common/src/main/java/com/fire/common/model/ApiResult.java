package com.fire.common.model;

import lombok.Data;

@Data
public class ApiResult<T> {

    private static ApiResult SUCCESS = new ApiResult(1, null, "操作成功");

    private static ApiResult FAIL = new ApiResult(0, null, "操作失败");

    private Integer state;

    private T result;

    private String msg;

    public ApiResult(Integer state, T result, String msg) {
        this.state = state;
        this.result = result;
        this.msg = msg;
    }

    public static ApiResult success() {
        return SUCCESS;
    }

    public static <T> ApiResult<T> success(T result) {
        return new ApiResult(1, result, "操作成功");
    }

    public static ApiResult fail() {
        return FAIL;
    }

    public static <T> ApiResult<T> fail(String msg) {
        return new ApiResult(0, null, msg);
    }
}
