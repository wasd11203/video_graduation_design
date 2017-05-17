package com.vshow.util.random;

import java.util.Random;

public class RandomNum {

	public static String randomCheckCode(String str){
		String temp = "";
		System.out.println("字符串长度："+str.length());
		Random random = new Random();
		
		for(int i = 0;i<4;i++){
			int num = random.nextInt(str.length());
			char c1 = str.charAt(num);
			temp += c1;
		}
		return temp;
	}
	
}
