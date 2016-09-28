package shoesShoppingmall_view_shoes;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.Shoes;

public class RegisterShoesView {

	private Scanner keyboard;
	
	public RegisterShoesView(){
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void shoesRegister(){
			
		System.out.println("제품명: ");
		String shoesName = keyboard.next();
		System.out.println("제품설명: ");
		String shoesCommant = keyboard.next();
		System.out.println("제품가격: ");
		int shoesPrice = keyboard.nextInt();
		System.out.println("제조사명: ");
		String vendorName = keyboard.next();
		System.out.println("신발사이즈: ");
		int shoesSize = keyboard.nextInt();
		
		Shoes shoes = new Shoes(shoesName, shoesCommant, shoesPrice, vendorName, shoesSize);
		
		//컨트롤로 요청
		Controllers.getShoesController().requestShoesRegist2(shoes);

		
	}
}
