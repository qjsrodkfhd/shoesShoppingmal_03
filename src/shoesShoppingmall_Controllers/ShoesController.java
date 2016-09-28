package shoesShoppingmall_Controllers;

import java.util.ArrayList;
import java.util.Scanner;

import shoesShoppingmall_dao.ShoesDao;
import shoesShoppingmall_domain.Shoes;
import shoesShoppingmall_view.AlertView;
import shoesShoppingmall_view_shoes.ShowAllShoesView;
import shoesShoppingmall_view_shoes.UpdateShoesView;
import shoesShoppingmall_view_shoes.DeleteShoesView;
import shoesShoppingmall_view_shoes.RegisterShoesView;
import shoesShoppingmall_view_shoes.SelectOneShoesView;
import shoesShoppingmall_view_shoes.ShowAdminMenuView;

public class ShoesController {

	private Scanner keyboard;
	private Controllers controller;
	private ShoesDao shoesDao;
	private SelectOneShoesView selectOneShoesView;
	private int shoesNumber;

	public ShoesController(){

		keyboard = new Scanner(System.in);
		shoesDao = new ShoesDao();
		selectOneShoesView = new SelectOneShoesView();

	}

	//신발 등록 뷰 초기화
	public void requestShoesRegist(){

		RegisterShoesView shoesRegisterView = new RegisterShoesView();
		shoesRegisterView.shoesRegister();

	}

	//신발 등록
	public boolean requestShoesRegist2(Shoes shoes){

		boolean success = shoesDao.registShoes(shoes);

		AlertView alertView = new AlertView();

		if(success) {
			alertView.alert("제품 등록 성공");
		} else {
			alertView.alert("제품 등록 실패");
		}

		return success;

	}

	//신발 리스트보기
	public ArrayList<Shoes> shoesList(){

		ArrayList<Shoes> shoesList = shoesDao.listShoes();

		ShowAllShoesView allShoesView = new ShowAllShoesView(shoesList);
		
		return shoesList;

	}

	//신발 상세정보 뷰 불러오기
	public void requestShoesOne(){

		selectOneShoesView.oneSelectedShoes();

	}

	//신발 상세정보 
	public void requestShoesOne2(int shoesNumber){
		this.shoesNumber = shoesNumber;
		//원하는 리스트 선택하기 
		Shoes selectShoesOne = shoesDao.oneList(shoesNumber);

		AlertView alertView = new AlertView();

		//원하는 리스트 불러오기
		if(selectShoesOne == null) {

			alertView.alert("찾으시는 제품이 없습니다.");
			alertView.alert("제품 컨트롤러에 제품 목복 보기 요청함.");

			//페이지 전환
			requestAdminPage();

		} else {

			selectOneShoesView.oneShoewShoes(selectShoesOne);

		}

	}

	//신발 삭제 뷰 불러오기
	public void requestShoesDelete(){

		DeleteShoesView deleteShoes = new DeleteShoesView();
		deleteShoes.deleteShoes();
		
	}
	
	//신발 삭제
	public boolean requestShoesDelete2(int shoesNumber){
	
		
		boolean success = shoesDao.deleteShoes(shoesNumber);

		AlertView alertView = new AlertView();

		if(success) {
			alertView.alert("삭제 성공");
		} else {
			alertView.alert("삭제 실패");
		}

		return success;
	}

	//제품 관리 페이지 뷰 불러오기
	public void requestAdminPage(){

		ShowAdminMenuView showAdminMunu = new ShowAdminMenuView();
		showAdminMunu.ShowAdminMenu();
		
	}
	
	//제품 관리 페이지
	public void requestAdminPage2(int selectedAdminMeue){
		
		
		if(selectedAdminMeue == 1){
			
			requestShoesRegist();
			Controllers.getAdminController().requestShoesManegement();
			
		}else if(selectedAdminMeue == 2){
			
			requestShoesOne();
			Controllers.getAdminController().requestShoesManegement();
			
		} else if(selectedAdminMeue == 3){
			
			requestShoesDelete();
			Controllers.getAdminController().requestShoesManegement();
			
		} else if(selectedAdminMeue == 4){
			
			Controllers.getAdminController().requestAdminPage();
			
		} else{
			
			AlertView alertView = new AlertView();
			alertView.alert("잘못입력하셨습니다. 다시 입력해주세요.");
			Controllers.getAdminController().requestAdminPage();
			
		}


	}

	public void requestShoesUpdate(int selectedNumber) {
		// TODO Auto-generated method stub
		//System.out.println("1.신발명 \t 2.신발설명 \t 3.신발가격 \t 4.제조사 \t 5.사이즈 \t 6. 제품관리메뉴");
		UpdateShoesView updateShoesView = new UpdateShoesView();
		if(selectedNumber == 1)
		{
			
			updateShoesView.getUpdateShoesName();
			
		}
		else if(selectedNumber == 2)
		{
			
			updateShoesView.getUpdateShoesCommant();
		}
		else if(selectedNumber == 3)
		{
			
			updateShoesView.getUpdateShoesPrice();
		}
		else if(selectedNumber == 4)
		{
			
			updateShoesView.getUpdateShoesVendor();
		}
		else if(selectedNumber == 5)
		{
			updateShoesView.getUpdateShoesSize();
		}
		else if(selectedNumber == 6)
		{
			Controllers.getAdminController().requestShoesManegement();
		}
		else
		{
			AlertView alertView = new AlertView();
			alertView.alert("잘못입력하셨습니다. 다시 입력해주세요.");
			Controllers.getAdminController().requestShoesManegement();
		}
		
	}

	public void requestUpdateShoesName(String name) {
		AlertView alertView = new AlertView();
		boolean success = shoesDao.updateShoesName(shoesNumber,name);
		if(success)
		{
			alertView.alert("이름 변경 성공");
		}
		else
		{
			alertView.alert("이름 변경 실패");
		}
		
	}

	public void requestUpdateShoesCommat(String commat) {
		AlertView alertView = new AlertView();
		boolean success = shoesDao.updateShoesCommat(shoesNumber,commat);
		if(success)
		{
			alertView.alert("설명 변경 성공");
		}
		else
		{
			alertView.alert("설명 변경 실패");
		}
		
	}

	public void requestUpdateShoesPrice(int price) {
		AlertView alertView = new AlertView();
		boolean success = shoesDao.updateShoesPrice(shoesNumber,price);
		if(success)
		{
			alertView.alert("가격 변경 성공");
		}
		else
		{
			alertView.alert("가격 변경 실패");
		}
		
	}

	public void requestUpdateShoesvendorVendor(String vendor) {
		AlertView alertView = new AlertView();
		boolean success = shoesDao.updateShoesVendor(shoesNumber,vendor);
		if(success)
		{
			alertView.alert("제조사 변경 성공");
		}
		else
		{
			alertView.alert("제조사 변경 실패");
		}
		
	}

	public void requestUpdateShoesSize(int size) {
		AlertView alertView = new AlertView();
		boolean success = shoesDao.updateShoesSize(shoesNumber,size);
		if(success)
		{
			alertView.alert("신발 변경 성공");
		}
		else
		{
			alertView.alert("신발 변경 실패");
		}
		
	}


}
