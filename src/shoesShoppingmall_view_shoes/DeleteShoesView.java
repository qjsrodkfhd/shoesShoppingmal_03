package shoesShoppingmall_view_shoes;

import java.util.Scanner;

import shoesShoppingmall_Controllers.Controllers;

public class DeleteShoesView {
	
	private Scanner keyboard;
	
	public DeleteShoesView(){
		
		keyboard = new Scanner(System.in);
		
	}
	
	public void deleteShoes(){
		
		System.out.println(" [����� �Ź� ���� �������Դϴ�.] ");
		System.out.println("");
		System.out.println(" �����Ͻ� ��ǰ��ȣ�� �Է��� �ּ���: ");
		int shoesNumber = keyboard.nextInt();
		
		//��Ʈ�ѷ� ��û
		Controllers.getShoesController().requestShoesDelete2(shoesNumber);
	
	}
}
