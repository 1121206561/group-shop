package cn.youxu.shop.common;

public enum ResultCode {
    SUCCESS(20000),
    ERROR(20001);

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
