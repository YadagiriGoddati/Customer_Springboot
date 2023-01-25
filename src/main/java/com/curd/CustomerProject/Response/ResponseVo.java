/**
 * 
 */
package com.curd.CustomerProject.Response;

/**
 * @author Giri_
 *
 */
public class ResponseVo {

	private Integer status;
	private String message;
	private Object data;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "ResponseVo [status=" + status + ", message=" + message + ", data=" + data + "]";
	}
	
	
	
	
}
