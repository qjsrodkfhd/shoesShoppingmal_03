package shoesShoppingmall_view_carts;

import java.util.ArrayList;

import shoesShoppingmall_Controllers.Controllers;
import shoesShoppingmall_domain.OrderShoes;
import shoesShoppingmall_domain.Shoes;

public class CartsListView {
	
	private ArrayList<OrderShoes> orderShoes;
	private ArrayList<Shoes> shoes;
	
	public CartsListView(ArrayList<OrderShoes> orderShoes, ArrayList<Shoes> shoes){
		
		this.orderShoes = orderShoes;
		this.shoes = shoes;
			
	}
	
	//신발 주문 리스트
	public void CartsList(){
		
		int totalPrice = 0;
		
		System.out.println("                   신발 주문 리스트                                    ");
		System.out.println("[ 주문번호 \t 주문수량 \t 신발이름 \t 신발가격 \t 제조사 \t 신발사이즈 \t]");
		
		
		if(orderShoes.size() == 0){
			
			System.out.println("[ 주문한 상품이 없습니다.]");
			
		} else{
			
			for(int i = 0; i < orderShoes.size(); i++){
				
				System.out.print(orderShoes.get(i).getOrderNumber() + "\t");
				System.out.print(orderShoes.get(i).getOrderCount() + "\t");
				
				for(int j = 0 ; i < shoes.size(); i ++){
					if(shoes.get(i).getShoesNumber() == orderShoes.get(j).getOrderNumber()){
						
						System.out.print(shoes.get(j).getShoesName() + "\t");
						System.out.print(shoes.get(j).getShoesPrice() + "\t");
						
						totalPrice = totalPrice + (shoes.get(j).getShoesPrice() * orderShoes.get(i).getOrderCount());
						
						System.out.print(shoes.get(j).getVendorName() + "\t");
						System.out.println(shoes.get(j).getShoesSize() + "\t");
						
					}
				}
			}
		}
		
		System.out.println("전체 주문 금액: " + totalPrice);
		
		Controllers.getOrderController().requestShowOrderMenu();
		
	}
	

}
