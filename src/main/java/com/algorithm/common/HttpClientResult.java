package com.algorithm.common;

import java.io.Serializable;

public class HttpClientResult implements Serializable {

    /**
     * 响应状态码
     */
    private int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 响应数据
     */
    private String content;

    HttpClientResult() {
    }

    HttpClientResult(int code) {
        super();
        this.code = code;
    }

    HttpClientResult(int code, String content) {
        super();
        this.code = code;
        this.content = content;
    }

}