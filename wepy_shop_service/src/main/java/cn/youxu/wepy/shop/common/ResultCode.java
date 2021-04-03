package cn.youxu.wepy.shop.common;

public enum ResultCode {
    SUCCESS(200),
    ERROR(201);

    private int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
