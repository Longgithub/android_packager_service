package com.mobanker.android.packager.utils;

import java.io.Serializable;

public class ResponseEntity<T> implements Serializable {
	private static final long serialVersionUID = -720807478055084231L;
	
	private String status;
	private String error;
	private String msg;
	private T data;

	private String pageCount;

	private String code;
	public ResponseEntity(){
		
	}
	
	public ResponseEntity(String status){
		this.status = status;
	}
	
	/*public ResponseEntity(String status, String error){
		this.status = status;
		this.error = error;
	}*/
	
	public ResponseEntity(String status, T data){
		this.status = status;
		this.data = data;
	}
	
	public ResponseEntity(String status, T data, String pageCount){
		this.status = status;
		this.data = data;
		this.pageCount = pageCount;
	}
	
	public ResponseEntity(String status, String error, String msg, T data){
		this.status = status;
		this.error = error;
		this.msg = msg;
		this.data = data;
	}
	
	public String getStatus() {
		return status;
	}

	public ResponseEntity<T> setStatus(String status) {
		this.status = status;
		return this;
	}

	public String getError() {
		return error;
	}

	public ResponseEntity<T> setError(String error) {
		this.error = error;
		return this;
	}

	public String getMsg() {
		return msg;
	}

	public ResponseEntity<T> setMsg(String msg) {
		this.msg = msg;
		return this;
	}

	public T getData() {
		return data;
	}

	public ResponseEntity<T> setData(T data) {
		this.data = data;
		return this;
	}

	public String getPageCount() {
		return pageCount;
	}

	public void setPageCount(String pageCount) {
		this.pageCount = pageCount;
	}

}

