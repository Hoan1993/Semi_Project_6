package controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Food_DAO;
import model.Food_VO;
import model.MemberVO;
import view.Button_Calandar;
import view.DetailViewForSC2;


public class SchdulingController {
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	int today = cal.get(Calendar.DATE);
	
	int end_date = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
	int randomRecom = 0;
	int i = 0;
	int end_Point = 0;
	int inputPrice = 0;
	
	Food_DAO fDao = Food_DAO.getInstance();
	MemberVO mVo = new MemberVO();
	
	public SchdulingController() {
		// TODO Auto-generated constructor stub
	}

	public void insertToDB(String inputPrice, MemberVO mVo) {
		
		/*System.out.println(inputPrice+" 잘 받아 왔습니다.");*/
		this.mVo = mVo;
		this.inputPrice = Integer.parseInt(inputPrice);
		
		
		
		validateCheck();
		inputBudgetToDB();
		makeDays();
		new Button_Calandar(mVo);
		
		
		
		
	}
	private void inputBudgetToDB() {
		fDao.insertBudgetToDB(inputPrice, mVo.getUserid());
		
		
	}

	// 버튼이 처음 눌려지는게 아니라면, 기존에 있던 스케쥴링은 모두 지운다. 
	private void validateCheck() {
		int result = fDao.countTableRows();
		if(result != 0) {
			fDao.deleteTable(mVo.getUserid());
		} 
		
	}

	private void makeDays() {
		
		i=today;
		end_Point = 0;
		int last_price = 0;
		if(inputPrice >= 0) {
			while(i<= end_date && inputPrice >= 0) {
				end_Point = i;
				
				int price = 0;
				if(week_chk(year, month, i) == true) {
					i++;
					continue;
				}
			
				int counts = fDao.calcCount();
				randomRecom = (int)(Math.random()*(counts-1))+1;
				/*System.out.println(i+" : "+randomRecom);*/
				price = fDao.getPriceByRandomNum(randomRecom);
				
				inputPrice -= price;
				last_price = price;
				if(inputPrice < 0) {
					end_Point = i;
					break;
				}
				fDao.insertFoodInfoToDB(mVo.getUserid(),i, randomRecom);
				
			// 스케쥴링 성공 여부 확인
			/*	int result = fDao.insertFoodInfoToDB(mVo.getUserid(),i, randomRecom);*/
			
			/*	if(result == 1) {
					System.out.println(i+"일"+" 스케쥴링 성공");
				} else {
					System.out.println(i+"일"+" 스케쥴링 실패");
				}*/
			
				i++;

			} 
		}
		
		
		if(inputPrice < 0) {
			JOptionPane.showMessageDialog(null, end_Point+"일부터는 물만 먹어야 합니다.");
	
			for(i=end_Point; i<=end_date; i++) {
			
				if(week_chk(year, month, i) == true) {
					i++;
					continue;
				}
				fDao.insertFoodInfoToDB(mVo.getUserid(),i, 21);
			}
		}
		// 잔액을 넣는다.
		fDao.inputBalance(mVo.getUserid(), inputPrice+last_price);
		
		
		
	}

	private boolean week_chk(int year, int month, int day) {
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
			if(i == 1 || i == 7) {
				result = true;
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		return result; 
	
	}
	// 여기서 사용되는 테이블은 mycaltest와 food_table2
	// mycaltest의 foodnum과 food_tabe2의 bno를 연동해, food_table2의 로우를 가져오는 작업. 
	public void chooseDate(MemberVO mVo, Food_VO fVo, int selectDay) {
		Food_VO fVo2 = new Food_VO();
		fVo2 = fDao.getInfoByDay(mVo.getUserid(), selectDay);
		DetailViewForSC2 dsc = new DetailViewForSC2(mVo, fVo2);
		dsc.setVisible(true);
		
		
	}
	
}
