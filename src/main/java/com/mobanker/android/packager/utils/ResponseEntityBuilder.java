package com.mobanker.android.packager.utils;
import java.io.Serializable;

public final class ResponseEntityBuilder {
    /**
     * 返回成功.
     */
    public static final String RESPONSE_OK = "1";
    /**
     * 返回失败.
     */
    public static final String RESPONSE_FAIL = "0";

    /**
     * 构造一个失败响应.<br>
     * 用于构造一个比较用见或是常用的失败响应。<br>
     *
     * @param enums 常见错误枚举类的一个实例.<br>
     * @return
     */
    public static <T> ResponseEntity<T> buildErrorResponse(ErrorCodeEnum enums) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(RESPONSE_FAIL);
        entity.setError(String.valueOf(enums.getCode()));
        entity.setMsg(enums.getMessage());
        return entity;
    }

    public static <T> ResponseEntity<T> buildErrorResponse(ErrorCode enums) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(RESPONSE_FAIL);
        entity.setError(String.valueOf(enums.getCode()));
        entity.setMsg(enums.getMessage());
        return entity;
    }

//	/**
//	 * 构造一个失败响应.<br>
//	 *
//	 * @param enums
//	 * @return
//	 */
//	@Deprecated
//	public static ResponseEntity<String> buildErrorResponse(ErrorCodeEnum enums) {
//		ResponseEntity<String> entity = new ResponseEntity<String>();
//		entity.setStatus(RESPONSE_FAIL);
//		entity.setError(String.valueOf(enums.getCode()));
//		entity.setMsg(enums.getMessage());
//		return entity;
//	}

    /**
     * 构造一个失败响应.<br>
     *
     * @param error   失败错误编码.<br>
     * @param message 失败错误说明.<br>
     * @return
     */
    public static <T> ResponseEntity<T> buildErrorResponse(String error, String message) {
        ResponseEntity<T> entity = new ResponseEntity<>();
        entity.setStatus(RESPONSE_FAIL);
//        if (StringUtils.isBlank(error) || !StringUtils.isNumeric(error)) {
//            error = "401";
//        }
        entity.setError(error);
        entity.setMsg(message);
        return entity;
    }

    /**
     * 构造一个正常响应.<br>
     * <p>
     * 响应数据.<br>
     *
     * @return
     */
    public static <T> ResponseEntity buildNormalResponse() {
        //规范：所有正常请求(status="1",error="00000000"),code与pageCount属性被废弃.
        return new ResponseEntity(RESPONSE_OK, "00000000");
    }

    /**
     * 构造一个正常响应.<br>
     *
     * @param data 响应数据.<br>
     * @return
     */
    public static <T> ResponseEntity<T> buildNormalResponse(T data) {
        ResponseEntity<T> entity = buildNormalResponse();
        entity.setData(data);
        return entity;
    }

    /**
     * 构造一个错误响应.<br>
     *
     * @param data 响应数据.<br>
     * @return
     */
    public static <T> ResponseEntity<T> buildUnNormalResponse(T data, ErrorCodeEnum enums) {
        ResponseEntity<T> entity = buildErrorResponse(enums);
        entity.setData(data);
        return entity;
    }
//	public static <T> ResponseEntity<Map<String,T>> buildNormalResponse(String key,T data) {
//		Map<String,T> result = new HashMap<>();
//		result.put(key, data);
//		
//		ResponseEntity<Map<String,T>> entity = buildNormalResponse();
//		entity.setData(result);
//		return entity;
//	}

    public static <T> Boolean isSuccess(ResponseEntity<T> entity) {
        return entity.getStatus().equals(RESPONSE_OK);
    }

    public static <T> Boolean isSuccess2(ResponseEntity<T> entity) {
        return entity.getStatus().equals(RESPONSE_OK) && entity.getError().equals("00000000");
    }

    /**
     * 适用于接口返回data为null时业务不成功的场景
     */
    public static <T> Boolean isSuccess3(ResponseEntity<T> entity) {
        return entity.getStatus().equals(RESPONSE_OK) && entity.getError().equals("200") && entity.getData() != null;
    }
    public static <T extends Serializable> T getEntity(ResponseEntity<T> entity) {
        if (isSuccess(entity)) {
            return (T) entity.getData();

        }
        return null;
    }

}
