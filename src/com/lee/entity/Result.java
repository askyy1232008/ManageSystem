package com.lee.entity;

import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;

import org.springframework.stereotype.Component;
/**
 * 接口响应返回信息类
 * @author lee
 * @time 20180503
 * @param <T>
 */
@Component
public class Result<T> implements Serializable {
	/**
	 * 默认值
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 接口调用成功，不需要返回对象
	 */
	public static <T> Result<T> newSuccess(){
		Result<T> result = new Result<>();
		result.setCode(200);
		return result;
	}
	
	/**
	 * 接口调用成功，有成功码、信息提示， 有返回对象
	 */
	public static <T> Result<T> newSuccess(int code , String message , T data , String url) {
		Result<T> result = new Result<>();
		result.setData(data);
		result.setCode(code);
		result.setMessage(message);
		result.setUrl(url);
		return result;
	}
	
	/**
	 * 接口调用成功，有成功码、信息提示， 没有返回对象
	 */
	public static <T> Result<T> newSuccess(int code , String message , String url){
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setMessage(message);
		result.setUrl(url);
		return result;
	}
	
	/**
	 * 接口调用失败，有错误码、错误信息 和描述，没有返回对象
	 */
	public static <T> Result<T> newFailure(int code, String message , String url){
		Result<T> result = new Result<>();
		result.setCode(code);
		result.setMessage(message);
		result.setUrl(url);
		return result;
	}
	
	/**
	 * 接口调用失败，返回异常信息
	 */
	public static <T> Result<T> newException(Exception e){
		Result<T> result = new Result<>();
		result.setCode(-1);
		result.setException(e);
		result.setMessage("异常错误,请联系开发人员！并将以下信息提供给开发人员: \n" + e.getStackTrace());
		return result;
	}
	private int code;
	private T data;
	private String message;
	private Exception exception;
	private String url;
	
	/** 判断返回结果是否成功 */
	public boolean success() {
		return code == 200;
	}
	/** 判断返回结果是否有结果对象 */
	public boolean hasData() {
		return code==200 && data!=null;
	}
	/** 判断返回结果是否有异常 */
	public boolean hasException() {
		return exception != null;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Exception getException() {
		return exception;
	}

	public void setException(Exception exception) {
		this.exception = exception;
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String toString() {
		StringBuilder result = new StringBuilder("Result");
		result.append("{code="+code);
		if(data!=null) result.append(", data="+data);
		if(message!=null) result.append(", message="+message);
		if(exception!=null) {
			StringWriter stringWriter = new StringWriter();
			exception.printStackTrace(new PrintWriter(stringWriter));
			result.append(", exception="+stringWriter.toString());
		}
		if(url!=null) result.append(", url="+url);
		result.append(" }");
		return result.toString();
	}
	/***
	 * 根据code 获取message
	 * @param code
	 * @return
	 */
	public final static String getCodeMessage(int code){
		String message = "";
		switch (code) {
		case -1:
			message = "抛出异常";
			break;
		case 200:
			message = "[GET]服务器成功返回用户请求的数据";
			break;
		case 201:
			message = "[POST]新建或修改数据成功";
			break;
		case 202:
			message = "[*]请求已经进入后台排队（异步任务）";
			break;
		case 204:
			message = "[POST]删除数据成功";
			break;
		case 400:
			message = "发出的请求有错误，请求参数不合法或格式错误";
			break;
		case 401:
			message = "没有登录或令牌、用户名、密码错误";
			break;
		case 403:
			message = "服务器已经理解请求，但是拒绝执行它，身份验证并不能提供任何帮助，没有权限操作资源";
			break;
		case 404:
			message = "请求失败，请求所希望得到的资源未被在服务器上发现";
			break;
		case 406:
			message = "请求的格式不可得（比如用户请求JSON格式，但是只有XML格式）";
			break;
		case 408:
			message = "服务器等候请求时发生超时";
			break;
		case 500:
			message = "服务器内部遇到错误，无法完成请求";
			break;
		default:  
			message = "未知错误";
			break;
		}
		return message;
	}
}
