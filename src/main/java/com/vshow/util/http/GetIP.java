package com.vshow.util.http;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

/**
 * 获取IP
 *
 * @author ganzhigang
 * time: 2017年4月30日 下午10:57:15
 *
 */
public class GetIP {

	/**
	 * 从请求中获取真实的ip地址
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request){
		if (request == null)  
            return null;  
        String ip = request.getHeader("X-Forwarded-For");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))  
            ip = request.getHeader("Proxy-Client-IP");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))  
            ip = request.getHeader("WL-Proxy-Client-IP");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))  
            ip = request.getHeader("HTTP_CLIENT_IP");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))  
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");  
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip))  
            ip = request.getRemoteAddr();  
        if ("127.0.0.1".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip))  
            try {  
                ip = InetAddress.getLocalHost().getHostAddress();  
            }  
            catch (UnknownHostException unknownhostexception) {  
            }  
        return ip;
	}
}
