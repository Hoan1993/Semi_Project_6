package util;

import java.util.Random;

public class MakeRandomPwd {
	
	public String RandomPwd() {
		String result = null;
		Random rnd =new Random();
		StringBuffer buf =new StringBuffer();
		for(int i=0;i<20;i++){

		    // rnd.nextBoolean() 는 랜덤으로 true, false 를 리턴. true일 시 랜덤 한 소문자를, false 일 시 랜덤 한 숫자를 StringBuffer 에 append 한다.

		    if(rnd.nextBoolean()){

		        buf.append((char)((int)(rnd.nextInt(26))+97));

		    }else{

		        buf.append((rnd.nextInt(10)));

		    }

		}
		result = buf.toString();
		
		return result;
	}
}
