package utils;

import javax.servlet.http.HttpServletRequest;

public class ProductUtils {
	
	public static long getNovelId(HttpServletRequest request) {
		String refer = (String)request.getHeader("REFERER");
		StringBuilder sb = new StringBuilder(request.getRequestURL().toString().replaceAll(request.getRequestURI(), ""));
		sb.append("/products/view/");
		return Long.parseLong(refer.replaceAll(sb.toString(), ""));
	}
	
	public static long getItemId(HttpServletRequest request) {
		String refer = (String)request.getHeader("REFERER");
		StringBuilder sb = new StringBuilder(request.getRequestURL().toString().replaceAll(request.getRequestURI(), ""));
		sb.append("/item/");
		return Long.parseLong(refer.replaceAll(sb.toString(), ""));
	}
}
