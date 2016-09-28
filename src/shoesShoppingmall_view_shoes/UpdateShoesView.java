package shoesShoppingmall_view_shoes;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class UpdateShoesView {

	private Scanner keyboard;
	
	public UpdateShoesView()
	{
		keyboard = new Scanner(System.in);
	}
	public void getUpdateShoesName() {
		System.out.print("수정할 신발이름 입력: ");
		String name = keyboard.next();
		Controllers.getShoesController().requestUpdateShoesName(name);
	}

	public void getUpdateShoesCommant() {
		System.out.print("수정할 신발정보 입력: ");
		String commat = keyboard.next();
		Controllers.getShoesController().requestUpdateShoesCommat(commat);
		
	}

	public void getUpdateShoesPrice() {
		System.out.print("수정할 신발가격 입력: ");
		int price = keyboard.nextInt();
		Controllers.getShoesController().requestUpdateShoesPrice(price);
		
	}

	public void getUpdateShoesVendor() {
		System.out.print("수정할 신발제조사 입력: ");
		String vendor = keyboard.next();
		Controllers.getShoesController().requestUpdateShoesvendorVendor(vendor);
		
	}

	public void getUpdateShoesSize() {
		System.out.print("수정할 신발사이즈 입력: ");
		int size = keyboard.nextInt();
		Controllers.getShoesController().requestUpdateShoesSize(size);
		
	}

}
