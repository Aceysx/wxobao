package com.obao.util;

public class InvokeResult {

    private Object data;

    private String msg="";

    private boolean result;

    public static InvokeResult success(Object data) {
        InvokeResult resultData = new InvokeResult();
        resultData.data = data;
        resultData.result=true;
        return resultData;
    }

    public static InvokeResult success() {
        InvokeResult resultData = new InvokeResult();
        resultData.result=true;
        return resultData;
    }
    public static InvokeResult failure(String msg) {
        InvokeResult resultData = new InvokeResult();
        resultData.msg = msg;
        resultData.result=false;
        return resultData;
    }
    public Object getData() {
        return data;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }
}

