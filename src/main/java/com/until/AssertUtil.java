package com.until;

import java.util.Collection;

import com.common.ailuenum.APICode;
import com.define.exception.APIException;
import org.springframework.lang.Nullable;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

/**
 * 操作断言的工具类
 * @Author PengMvc
 * @Date 2022/5/24 22:54
 **/
public class AssertUtil {

	private static void throwApiException(APICode apiCode) {
		throw new APIException(apiCode);
	}
	
	private static void throwApiException(APICode apiCode, String message) {
		throw new APIException(apiCode, message);
	}

	private static void throwApiException(Integer apiCode, String message) {
		throw new APIException(apiCode, message);
	}
	
	/**
	 * 断言表达式为true
	 * @param expression
	 * @param apiCode
	 */
	public static void isTrue(boolean expression, APICode apiCode) {
		if (!expression) {
			throwApiException(apiCode);
		}
	}

	public static void isTrue(boolean expression,String messsage){
		if(expression){
			throw new IllegalArgumentException(messsage);
		}
	}

	public static void isTrue(boolean expression, APICode apiCode, String message) {
		if (!expression) {
			throwApiException(apiCode, message);
		}
	}

	public static void isTrue(boolean expression, Integer apiCode, String message) {
		if (!expression) {
			throwApiException(apiCode, message);
		}
	}

	/**
	 * 断言非空对象
	 * @param object
	 * @param apiCode
	 */
	public static void notNull(@Nullable Object object, APICode apiCode) {
		if (object == null) {
			throwApiException(apiCode);
		}
	}
	
	public static void notNull(@Nullable Object object, APICode apiCode, String message) {
		if (object == null) {
			throwApiException(apiCode, message);
		}
	}
	
	/**
	 * 断言文本有内容
	 * @param text
	 * @param apiCode
	 */
	public static void hasText(@Nullable String text, APICode apiCode) {
		if (!StringUtils.hasText(text)) {
			throwApiException(apiCode);
		}
	}
	
	public static void hasText(@Nullable String text, APICode apiCode, String message) {
		if (!StringUtils.hasText(text)) {
			throwApiException(apiCode, message);
		}
	}
	
	/**
	 * 断言非空数组
	 * @param array
	 * @param apiCode
	 */
	public static void notEmpty(@Nullable Object[] array, APICode apiCode) {
		if (ObjectUtils.isEmpty(array)) {
			throwApiException(apiCode);
		}
	}
	
	/**
	 * 断言非空集合
	 * @param collection
	 * @param apiCode
	 */
	public static void notEmpty(@Nullable Collection<?> collection, APICode apiCode) {
		if (CollectionUtils.isEmpty(collection)) {
			throwApiException(apiCode);
		}
	}
	
	public static void notEmpty(@Nullable Collection<?> collection, APICode apiCode, String message) {
		if (CollectionUtils.isEmpty(collection)) {
			throwApiException(apiCode, message);
		}
	}



}
