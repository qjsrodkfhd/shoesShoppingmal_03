package shoesShoppingmall_domain;

public class Shoes {
	
	private int shoesNumber; //제품번호, 시스템에서 자동으로 1씩 증가
	private String shoesName; //제품명
	private String shoesCommant; //제품설명
	private int shoesPrice; //제품가격
	private String vendorName; //제조사명
	private int shoesCount; //제품수량
	private int shoesSize;
	private int maleCount;
	private int femaleCount;
	
	public Shoes(int shoesNumber, int shoesCount){
		
		this.shoesNumber = shoesNumber;
		this.shoesCount = shoesCount;
		
	}

	public Shoes(String shoesName, String shoesCommant, int shoesPrice, String vendorName, int shoesSize) {
		
		this.shoesName = shoesName;
		this.shoesCommant = shoesCommant;
		this.shoesPrice = shoesPrice;
		this.vendorName = vendorName;
		this.shoesSize = shoesSize;
	
	}

	public int getShoesNumber() {
		
		return shoesNumber;
		
	}

	public void setShoesNumber(int shoesNumber) {
		
		this.shoesNumber = shoesNumber;
		
	}

	public String getShoesName() {
		
		return shoesName;
		
	}

	public void setShoesName(String shoesName) {
		
		this.shoesName = shoesName;
		
	}

	public String getShoesCommant() {
		
		return shoesCommant;
		
	}

	public void setShoesCommant(String shoesCommant) {
		
		this.shoesCommant = shoesCommant;
		
	}

	public int getShoesPrice() {
		
		return shoesPrice;
		
	}

	public void setShoesPrice(int shoesPrice) {
		
		this.shoesPrice = shoesPrice;
		
	}

	public String getVendorName() {
		
		return vendorName;
		
	}

	public void setVendorName(String vendorName) {
		
		this.vendorName = vendorName;
		
	}

	public int getShoesSize() {
		
		return shoesSize;
		
	}

	public void setShoesSize(int shoesSize) {
		
		this.shoesSize = shoesSize;
		
	}

	public int getMaleCount() {
		
		return maleCount;
		
	}

	public void setMaleCount(int maleCount) {
		
		this.maleCount = maleCount;
		
	}

	public int getFemaleCount() {
		
		return femaleCount;
		
	}

	public void setFemaleCount(int femaleCount) {
		
		this.femaleCount = femaleCount;
		
	}

	
}
