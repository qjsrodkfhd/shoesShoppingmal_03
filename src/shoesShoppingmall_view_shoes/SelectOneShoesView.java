package shoesShoppingmall_view_shoes;

import java.util.ArrayList;
import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.Shoes;

public class SelectOneShoesView {
	
	private Scanner keyboard;
	
	public SelectOneShoesView(){
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void oneSelectedShoes(){
				
		System.out.println("    제품 상세 페이지 입니다.    ");
		System.out.println("*************************");
		System.out.println(" 원하시는 제품번호를 입력해주세요. ");
		System.out.println(" 제품번호: ");
		int shoesNumber = keyboard.nextInt();
		
		//컨트롤로 요청
		Controllers.getShoesController().requestShoesOne2(shoesNumber);
		
	}
	
	public void oneShoewShoes(Shoes shoes){
		
		System.out.println("                * 상품상세 리스트 *               ");
		System.out.println("********************************************");
		System.out.println("제품번호\t신발명\t신발설명\t신발가격\t제조사\t사이즈(cm)");
		
		System.out.print(shoes.getShoesNumber() + "\t");
		System.out.print(shoes.getShoesName() + "\t");
		System.out.print(shoes.getShoesCommant() + "\t");
		System.out.print(shoes.getShoesPrice() + "\t");
		System.out.print(shoes.getVendorName() + "\t");
		System.out.println(shoes.getShoesSize() + "\t");
		System.out.println("");
		this.showUpdateMenu();
	}
	
	public void showUpdateMenu()
	{
		System.out.println("[ 상품수정메뉴 ]");
		System.out.println("1.신발명 \t 2.신발설명 \t 3.신발가격 \t 4.제조사 \t 5.사이즈 \t 6. 제품관리메뉴");
		int selectedNumber = keyboard.nextInt();
		
		Controllers.getShoesController().requestShoesUpdate(selectedNumber);
	}

}
