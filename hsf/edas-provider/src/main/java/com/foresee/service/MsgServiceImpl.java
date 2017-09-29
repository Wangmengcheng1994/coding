package com.foresee.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.foresee.vo.Msg;
@Service(value="msgService")
public class MsgServiceImpl implements MsgService {

	public String pushMsg(Msg msg) {
		System.out.println("接收到推送信息"+msg.getTitle());
		return "信息已经推送";
	}

	public List<Msg> getAllMsg() {
		List<Msg> msgs = new ArrayList<Msg>();
		Msg msg = new Msg();
		msg.setTitle("信息提醒");
		msg.setContent("信息内容");
		msg.setCreateTime(new Date());
		msg.setState("未读");
		msgs.add(msg);
		return msgs;
	}

}
