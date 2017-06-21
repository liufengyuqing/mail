package com.tedu.util;

import java.util.UUID;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class MailUtil {
    public static String randomUUID(){
    	//创建对象
    	//产生每次不重复的字符串
    	UUID r = UUID.randomUUID();//UUID无构造函数，不可改
    	return r.toString();
    }
    public static String rand(){
    	String str = "";
		str += (int) (Math.random() * 9 + 1);//产生一位（1-10）
		for (int i = 0; i < 5; i++) {
			str += (int) (Math.random() * 10);//
		}
		String num = str;
		return num;
    }
    
    // 方法参数为（目标对象，内容）
    public static void sendEmail(String email,String content){ 
    	SimpleEmail mailUtil = new SimpleEmail();
    	//服务器地址
    	mailUtil.setHostName("smtp.163.com");
    	//发件地址:邮箱，授权码（"zhaoyong1230@126.com", "zyq13572871783"）//126授权码：qm123456
    	mailUtil.setAuthentication("18392533494@163.com", "asd369258147dsa");//QQ   smtp:ughmuiftketvbeac   pop3:blbktqbqgppdbbbg   shouquan:dpovvzugjwpfbcgh
    	//mailUtil.setAuthentication("zhaoyong1230@126.com", "zyq13572871783");
    	//设置内容编码
    	mailUtil.setCharset("utf-8");
    	//目的邮箱
    	try {
			mailUtil.addTo(email);
			//mailUtil.setFrom("qiaominy@126.com");
			mailUtil.setFrom("18392533494@163.com");
			//设置主题、内容
			mailUtil.setSubject("邮箱验证码:来自刘志伟的问候!");
			mailUtil.setMsg(content);
			mailUtil.setSSL(true);
			mailUtil.send();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			//邮箱错误
			e.printStackTrace();
		}
    	
    }
    public static void main(String[] args) {
		String uUIDStr = randomUUID();
		System.out.println(uUIDStr);
		//fab1d4df-bd61-446d-8ee7-0b12e1224c5f
		//7776a04f-2ef0-4d53-9e06-b8a93b00277a
		//4364d834-0075-40f5-afe2-6ab8b9e2e67a
		//sendEmail("1768020298@qq.com", uUIDStr);//qq邮箱接收不到：邮件被自动放入垃圾箱了，将发件地址加入白名单即可
		sendEmail("1768020298@qq.com","亲爱的用户：\n\n\n您好！感谢您使用甜小码服务，您正在进行邮箱验证，本次请求的验证码为：" + MailUtil.rand()
				+ "\n\n\n甜小码账号团队" );
	}
    
}
