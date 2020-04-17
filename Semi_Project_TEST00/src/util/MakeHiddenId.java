package util;

public class MakeHiddenId {
	
	public String makeHiddenId(String email) {

		// 골뱅이 기준으로 아이디 뒷부분 네 개를 별로 만든다.
		String result = "";
		String[] temp = email.split("@");

		int start = temp[0].length() - 4;
		int end = temp[0].length() - 1;

		
		for (int i = 0; i < start; i++) {
			result += temp[0].charAt(i);
		}

		for (int i = start; i <= end; i++) {
			result += '*';
		}

		result += '@' + temp[1];

		
		return result;
	}
}
