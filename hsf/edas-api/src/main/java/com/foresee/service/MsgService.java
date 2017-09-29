package com.foresee.service;

import java.util.List;

import com.foresee.vo.Msg;

public interface MsgService {
	/**
	 * 信息推送
	 * @param msg
	 * @return
	 */
	public String pushMsg(Msg msg);
	
	/**
	 * 信息查询
	 * @param msg
	 * @return
	 */
	public List<Msg> getAllMsg();
	
}
