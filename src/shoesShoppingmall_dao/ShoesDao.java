package shoesShoppingmall_dao;

import java.util.ArrayList;

import shoesShoppingmall_domain.Shoes;
import shoesShoppingmall_repository.ShoesRepository;

public class ShoesDao {

	public ShoesDao(){

		new ShoesRepository();

	}

	//신발등록
	public boolean registShoes(Shoes shoes){

		boolean success = false;

		//신발 등록수 증가
		int shoesNumber = ShoesRepository.getShoesNumber();
		int nextShoesNumber = shoesNumber + 1;
		ShoesRepository.setShoesNumber(nextShoesNumber);
		shoes.setShoesNumber(nextShoesNumber);

		ArrayList<Shoes> currentShoes = ShoesRepository.getShoes();
		currentShoes.add(shoes);

		success = true;


		return success;

	}


	//신발리스트 보기
	public ArrayList<Shoes> listShoes(){

		ArrayList<Shoes> shoesList = null;


		shoesList = ShoesRepository.getShoes();


		return shoesList;

	}


	//신발 상세내용
	public Shoes oneList(int selectShoesNumber){

		Shoes shoes = null;


		for(int i = 0; i < ShoesRepository.getShoes().size(); i ++){
			if(selectShoesNumber == ShoesRepository.getShoes().get(i).getShoesNumber()){

				shoes = ShoesRepository.getShoes().get(i);
				break;

			}
		}


		return shoes;

	}

	//신발 삭제
	public boolean deleteShoes(int shoesNumber){

		boolean success = false;

		for(int i = 0; i <  ShoesRepository.getShoes().size(); i++){
			if(shoesNumber == ShoesRepository.getShoes().get(i).getShoesNumber()){

				ShoesRepository.getShoes().remove(i);
				success = true;
				break;

			}
		}

		return success;
	}

	public boolean updateShoesName(int shoesNumber, String name) {
		boolean success = false;

		ArrayList<Shoes> shoes = ShoesRepository.getShoes();

		for(int i = 0; i < shoes.size() ; i++)
		{
			if(shoesNumber == shoes.get(i).getShoesNumber())
			{
				shoes.get(i).setShoesName(name);
				success = true;
				break;
			}
		}

		return success;
	}

	public boolean updateShoesCommat(int shoesNumber, String commat) {
		boolean success = false;

		ArrayList<Shoes> shoes = ShoesRepository.getShoes();

		for(int i = 0; i < shoes.size() ; i++)
		{
			if(shoesNumber == shoes.get(i).getShoesNumber())
			{
				shoes.get(i).setShoesCommant(commat);
				success = true;
				break;
			}
		}

		return success;
	}

	public boolean updateShoesPrice(int shoesNumber, int price) {
		boolean success = false;

		ArrayList<Shoes> shoes = ShoesRepository.getShoes();

		for(int i = 0; i < shoes.size() ; i++)
		{
			if(shoesNumber == shoes.get(i).getShoesNumber())
			{
				shoes.get(i).setShoesPrice(price);
				success = true;
				break;
			}
		}

		return success;
	}

	public boolean updateShoesVendor(int shoesNumber, String vendor) {
		boolean success = false;

		ArrayList<Shoes> shoes = ShoesRepository.getShoes();

		for(int i = 0; i < shoes.size() ; i++)
		{
			if(shoesNumber == shoes.get(i).getShoesNumber())
			{
				shoes.get(i).setVendorName(vendor);
				success = true;
				break;
			}
		}

		return success;
	}

	public boolean updateShoesSize(int shoesNumber, int size) {
		boolean success = false;

		ArrayList<Shoes> shoes = ShoesRepository.getShoes();

		for(int i = 0; i < shoes.size() ; i++)
		{
			if(shoesNumber == shoes.get(i).getShoesNumber())
			{
				shoes.get(i).setShoesSize(size);
				success = true;
				break;
			}
		}

		return success;
	}

	//신발 수정
}
