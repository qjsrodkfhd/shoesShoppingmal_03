package shoesShoppingmall_view_shoes;

import java.util.ArrayList;

import shoesShoppingmall_domain.Shoes;

public class ShowAllShoesView {
	
	private ArrayList<Shoes> shoesList;
	
	public ShowAllShoesView(ArrayList<Shoes> shoesList){
		
		this.shoesList = shoesList;
		
	}
	
	public void AllShowShoes(){
		
		System.out.println("                *상품전체 리스트*                ");
		System.out.println("********************************************");
		System.out.println("제품번호\t신발명\t신발설명\t신발가격\t제조사\t사이즈(cm)");
		
		for(int i = 0; i < shoesList.size(); i++){
			
			System.out.print(shoesList.get(i).getShoesNumber() + "\t");
			System.out.print(shoesList.get(i).getShoesName() + "\t");
			System.out.print(shoesList.get(i).getShoesCommant() + "\t");
			System.out.print(shoesList.get(i).getShoesPrice() + "\t");
			System.out.print(shoesList.get(i).getVendorName() + "\t");
			System.out.println(shoesList.get(i).getShoesSize() + "\t");
			System.out.println("");
			
		} 
			
	}
}
