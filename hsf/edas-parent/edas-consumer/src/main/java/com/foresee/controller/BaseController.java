package com.foresee.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.foresee.util.StringUtil;


public class BaseController {
	
	/**
	 * 把requestData封装成map对象
	 * @param requestData
	 * @return
	 */
	@SuppressWarnings("unchecked")
	protected Map<String,Object> getReqMap(HttpServletRequest request){
		try {
			if (!StringUtil.isEmpty(request.getParameter("requestData"))) {
				return new ObjectMapper().readValue(request.getParameter("requestData"), Map.class);
			} else {
				Map<String, Object> requestDataMap = new HashMap<String, Object>();
				Enumeration<String> paramrEnum = request.getParameterNames();
				while (paramrEnum.hasMoreElements()) {
					String name = paramrEnum.nextElement();
					requestDataMap.put(name, request.getParameter(name));
				}
				return requestDataMap;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 把data封装成特定格式的返回对象
	 * @param data
	 * @param operateFlag
	 * @param operateDesc
	 * @return
	 */
	protected Map<String,Object> getRetMap(Map<String,Object> data,boolean operateFlag,String operateDesc){
		Map<String,Object> ret = new HashMap<String,Object>();
		Map<String,Object> head = new HashMap<String,Object>();
		head.put("operateFlag", operateFlag);
		head.put("operateDesc", operateDesc);
		ret.put("head", head);
		ret.put("data", data);
		return ret;
	}
	
	/**
	 * 以jsonP的方式往页面返回结果
	 * @param request
	 * @param response
	 * @param responseData
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	protected void returnJsonP(HttpServletRequest request,HttpServletResponse response,Map<String,Object> responseData) throws JsonGenerationException, JsonMappingException, IOException{
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		String callback = request.getParameter("callback");
		response.getWriter().write(callback+"("+new ObjectMapper().writeValueAsString(responseData)+");");
		response.getWriter().flush();
		response.getWriter().close();
	}
	
	/**
	 * 获取客户端请求的service
	 * @param request
	 * @return
	 */
	protected String getService(HttpServletRequest request) {
		String service = request.getParameter("service");
		if (!StringUtil.isEmpty(service)) {
			return service;
		}
		return null;
	}
}
