package com.foresee.controller;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.foresee.service.MsgService;
import com.foresee.vo.Msg;

@Controller
@RequestMapping(value = "/service")
public class MsgController extends BaseController {
	@Resource
	private MsgService msgService;
	
	/**
	 * 查询信息接口
	 * @param request
	 * @param response
	 * @param nsrsbh
	 * @param timeOut
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@RequestMapping(value = "/query/querytztx.do")
	public void querytztx(HttpServletRequest request, HttpServletResponse response, String nsrsbh, String timeOut)
			throws JsonGenerationException, JsonMappingException, IOException {
		HashMap<String, Object> resultData = new HashMap<String, Object>();
		System.out.println("调用查询信息接口");
		try {
			List<Msg> records = msgService.getAllMsg();
			System.out.println("调用调用查询信息接口成功");
			Msg msg = new Msg();
			msg.setContent("推送信息内容");
			msg.setTitle("信息标题");
			msg.setCreateTime(new Date());
			msg.setState("未读");
			String re = msgService.pushMsg(msg);
			System.out.println("调用信息推送接口成功"+re);
			resultData.put("records", records);
			resultData.put("flag", "ok");
		} catch (Exception e) {
			resultData.put("flag", "error");
			e.printStackTrace();
		}
		this.returnJsonP(request, response, resultData);
	}

}
