package com.wl.myweb.api.model;

/**
 * Created by wul on 1/11/17.
 */
public enum ReturnCode {
    SUCCESS("00","成功"),FAIL("10","失败"),FAIL_HAVE_EXIST("11","失败-已存在");
    public String code;

    public String value;

    ReturnCode(String code, String value) {
        this.code = code;
        this.value = value;
    }
}
