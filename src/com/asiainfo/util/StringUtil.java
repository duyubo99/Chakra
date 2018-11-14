package com.asiainfo.util;

/**
 * 字符串工具类
 */
public class StringUtil {
	/**
	 * 将字符串转换成数组,按照tag分割
	 */
	public static String[] str2Arr(String str,String tag){
		if(ValidateUtil.isValid(str)){
			return str.split(tag);
		}
		return null ;
	}

	/**
	 * 判断在values数组中是否含有指定value字符串
	 */
	public static boolean contains(String[] values, String value) {
		if(ValidateUtil.isValid(values)){
			for(String s : values){
				if(s.equals(value)){
					return true ;
				}
			}
		}
		return false;
	}

	/**
	 * 将数组变换成字符串
	 */
	public static String arr2Str(Object[] arr,String splitStr) {
		String temp = "" ;
		if(ValidateUtil.isValid(arr)){
			for(Object s : arr){
				temp = temp + s + splitStr;
			}
			return temp.substring(0,temp.length() - 1);
		}
		return temp;
	}
	/**
	 * 将数组变换成字符串
	 */
	public static String arr2Str(Object[] arr,String splitStr,String str) {
		String temp = "" ;
		if(ValidateUtil.isValid(arr)){
			for(Object s : arr){
				temp = temp + str + s + str + splitStr;
			}
			return temp.substring(0,temp.length() - 1);
		}
		return temp;
	}
}
