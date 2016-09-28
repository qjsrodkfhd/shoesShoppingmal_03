package shoesShoppingmall_repository;

import java.util.ArrayList;

import shoesShoppingmall_domain.Shoes;

public class ShoesRepository {
	
	private static ArrayList<Shoes> shoes;
	private static int shoesNumber;
	
	public ShoesRepository(){
		
		shoes = new ArrayList<Shoes>();
		shoesNumber = 0;
		
	}

	public static int getShoesNumber() {
		
		return shoesNumber;
		
	}

	public static void setShoesNumber(int shoesNumber) {
		
		ShoesRepository.shoesNumber = shoesNumber;
		
	}

	public static ArrayList<Shoes> getShoes() {
		
		return shoes;
		
	}
	
	
}
