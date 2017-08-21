package com.songxinjing.erp.form;

public class SimpleRspBody {

	private boolean result;

	private String msg;

	private Object data;
	
	public SimpleRspBody(boolean result, String msg, Object data) {
		this.result = result;
		this.msg = msg;
		this.data = data;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
