/**
 * @(#)ErrorCode.java, 2020/11/18.
 * <p/>
 * Copyright 2020 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.demo.exception;

public enum ErrorCode {
    OK(200, "OK"),
    FAIL(500, "ERROR");

    private int code;
    private String errorMsg;

    ErrorCode(int code, String errorMsg) {
        this.code = code;
        this.errorMsg = errorMsg;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public int getCode() {
        return code;
    }
}
