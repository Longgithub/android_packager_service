package com.mobanker.android.packager.utils;

public enum ErrorCode implements BaseEnum {
    SYS_OK(1, "处理成功！"), PARAM_IS_NULL(ErrorCode.ERROR_CODE + 1, "id为空"), ERROR_SEND_CODE(ErrorCode.ERROR_CODE + 2, "验证码发送失败"), ERROR_CHECK_CODE(ErrorCode.ERROR_CODE + 3, "验证码校验未通过"), PARAMS_ILLEGE(ErrorCode.ERROR_CODE + 4, "参数错误"), PARAMS_PHONE(ErrorCode.ERROR_CODE + 5, "手机号参数缺失!"), PARAMS_CAPTCHA(ErrorCode.ERROR_CODE + 6, "验证码参数缺失!"), ERROR_EXIST_PHONE(ErrorCode.ERROR_CODE + 7, "该手机号码已被注册!"), ERROR_CODEID(ErrorCode.ERROR_CODE + 8, "codeId为空!"), PARAMS_PHONE_ERROR(ErrorCode.ERROR_CODE + 9, "手机号参数缺失!"),
    ERROR_PARAMS_GET_IMGCODE(ErrorCode.ERROR_CODE + 10, "获取Banner信息失败!"),
    SYS_ERROR(ErrorCode.ERROR_CODE + 11, "系统异常"),
    PARAM_VALID(ErrorCode.ERROR_CODE + 12, "参数异常"),
    SYS_FIlE_EXCEPTION(ErrorCode.ERROR_CODE + 13, "上传文件异常");

    /**
     * 默认ERROR_CODE.<br>
     * 按公司要求8位长度，前两位产品。
     */
    public static final int ERROR_CODE = 400;

    private Integer code;
    private String message;

    private ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public Integer getCode() {
        // TODO Auto-generated method stub
        return code;
    }

    @Override
    public String getMessage() {
        // TODO Auto-generated method stub
        return message;
    }
    }
