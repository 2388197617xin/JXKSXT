package com.chen.tools;

import javax.servlet.http.HttpServletRequest;

public class IPUtil {
	public static String getRealIpAddr(HttpServletRequest request) {
		  String ip = request.getHeader("x-forwarded-for");
		  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		    ip = request.getHeader("Proxy-Client-IP");
		  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		    ip = request.getHeader("WL-Proxy-Client-IP");
		  if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))
		    ip = request.getRemoteAddr();
		  return ip;
		}
}
