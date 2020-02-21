package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import model.MemberDAO;

public class Button_Calandar_Controller {

	public Button_Calandar_Controller() {
		
	}

	public void scheduling(String userid, String money) {
		MemberDAO mDao = MemberDAO.getInstance();
		
		Calendar cal = Calendar.getInstance();
		int today = cal.DATE-1;
		int end_date = cal.getActualMaximum(cal.DAY_OF_MONTH);
		
		int inputMoney = Integer.parseInt(money);
		
		
		
		int menu1 = 1000;
		int menu2 = 2000;
		int menu3 = 3000;
		int menu4 = 4000;
		int menu5 = 5000;
		
		int randomRecom = 0;
		int endPoint = 0;
		
		int temp = 0;
		
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH)+1;
		
		/*for(int i=today; i<=end_date; i++) {*/
		int i=today;
		while(i<= end_date) {
			
			if(week_chk(year, month, i) == true) {
				i++;
				continue;
			}

			/*randomRecom = (int)(Math.random()*5)+1;*/
			/*randomRecom = 1;
			if(randomRecom == 1) {*/
				
			inputMoney -= menu1;
				/*if(inputMoney < 0) {
					System.out.println("잔액 : "+(inputMoney+menu1));
					System.out.println("이제 물만 먹어야 합니다.");
					endPoint = i;
					temp = menu1;
					break;
				}*/
			System.out.println(i+"일에는 "+" : 돈까스"+", 돈까스가격 : "+menu1+"원, 잔액: "+inputMoney);
			String date = "";
			date += Integer.toString(year);
			date += Integer.toString(month);
			date += Integer.toString(i);
			System.out.println(userid+", "+date);
				
			mDao.makeSchedule(userid, i);
				
			i++;
				
/*			} */
/*			else if(randomRecom == 2) {
				inputMoney -= menu2;
				if(inputMoney < 0) {
					System.out.println("잔액 : "+(inputMoney+menu2));
					System.out.println("이제 물만 먹어야 합니다.");
					endPoint = i;
					temp = menu2;
					break;
				}
				System.out.println(i+"일에는 "+" : 김치찌개"+", 김치찌개 가격 : "+menu2+"원, 잔액: "+inputMoney);
			}
			else if(randomRecom == 3) {
				inputMoney -= menu3;
				if(inputMoney < 0) {
					System.out.println("잔액 : "+(inputMoney+menu3));
					System.out.println("이제 물만 먹어야 합니다.");
					endPoint = i;
					temp = menu3;
					break;
				}
				System.out.println(i+"일에는 "+" : 감자탕"+", 감자탕가격 : "+menu3+"원, 잔액: "+inputMoney);
				}
			else if(randomRecom == 4) {
				inputMoney -= menu4;
				if(inputMoney < 0) {
					System.out.println("잔액 : "+(inputMoney+menu4));
					System.out.println("이제 물만 먹어야 합니다.");
					endPoint = i;
					temp = menu4;
					break;
				}
				System.out.println(i+"일에는 "+" : 순대국"+", 순대국가격 : "+menu4+"원, 잔액: "+inputMoney);
				}
			else if(randomRecom == 5) {
				inputMoney -= menu5;
				if(inputMoney < 0) {
					System.out.println("잔액 : "+(inputMoney+menu5));
					System.out.println("이제 물만 먹어야 합니다.");
					endPoint = i;
					temp = menu5;
					break;
				}
				System.out.println(i+"일에는 "+" : 삼겹살"+", 삼겹살가격 : "+menu5+"원, 잔액: "+inputMoney);
				}*/
			
/*			
			if(inputMoney <= 0) {
				System.out.println("잔액 : "+inputMoney);
				System.out.println("이제 물만 먹어야 합니다.");
				break;
			}*/
		}
		
/*		for(int i=today; i<=end_date; i++) {
			recommendation = (int)(Math.random()*10)+1;
			System.out.println(i+" : "+recommendation);
			System.out.println();
		}*/
		if(inputMoney < 0) {
			for(i=endPoint; i<=end_date; i++) {
				if(week_chk(year, month, i) == true) {
					i++;
					continue;
				}
				System.out.println(i+"일에는 "+" : 물"+", 물 가격 : 0원, 잔액: "+(inputMoney+temp));
				}
			}
	

	}
	
	
	private static boolean week_chk(int year, int month, int day) {
		boolean result = false;
		
		String inputDate = ""; 
		inputDate	+= Integer.toString(year);
		inputDate	+= Integer.toString(month);
		inputDate	+= Integer.toString(day);
		
		
		DateFormat dateFormat = new SimpleDateFormat("yyyyMdd");
		try {
			Date date = dateFormat.parse(inputDate);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			
			int i= calendar.get(Calendar.DAY_OF_WEEK);
			// System.out.println("테스트 i가 들어오는가"+i);
			if(i == 1 || i == 7) {
				result = true;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result; 
	}
		
	

}
