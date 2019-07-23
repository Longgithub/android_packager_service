package com.mobanker.android.packager.utils;

/**
 * 枚举类基类.<br>
 * 建议所有枚举类实现本接口，强制实现读取枚举编码与枚举消息.<br>
 * 
 * @author liuxiang
 *
 */
public interface BaseEnum {
	/**
	 * 返回编码.<br>
	 * 
	 * @return
	 */
	Integer getCode();

	/**
	 * 返回编码消息.<br>
	 * 
	 * @return
	 */
	String getMessage();
}
