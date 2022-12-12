package com.fsm.util;

import java.util.List;

public class FormatUtil {

	public static boolean isNullOrEmpty(Object str) {
		boolean result = false;
		if (str == null) {
			result = true;
		}
		return result;
	}

	public static boolean isNullOrEmpty(List list) {
		boolean result = false;
		if (list == null || list.isEmpty()) {
			result = true;
		}
		return result;
	}

	public static boolean isNullOrEmpty(String[] str) {

		boolean result = false;
		if (str == null || str.length == 0) {
			result = true;
		}
		return result;
	}

	public static boolean isNullOrEmpty(String str) {
		boolean result = false;
		if (str == null || str.trim().isEmpty()) {
			result = true;
		}
		return result;
	}

}
