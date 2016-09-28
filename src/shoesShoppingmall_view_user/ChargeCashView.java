package shoesShoppingmall_view_user;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class ChargeCashView {
	
	private Scanner keyboard;
	
	public ChargeCashView()
	{
		keyboard = new Scanner(System.in);
	}

	public void chargeCash() {
		System.out.print("충전하실 금액을 입력하세요 : ");
		int point = keyboard.nextInt();
		
		Controllers.getUserController().requestChargeCash2(point);
		
	}

}
