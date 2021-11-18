package com.model;
import java.util.List;

public class TestComapnyDAO {

	public static void main(String[] args) {
		CompanyDAO_interface test1 = new CompanyDAO_impl();
		
		//新增
		CompanyVO cv1 = new CompanyVO();
		cv1.setCompanyName("testDelete");
		cv1.setCompanyEmail("cookingintwm@yahoo.com.tw");
		cv1.setCompanyPassword("123456");
		cv1.setCompanyPhone("88887777");
		cv1.setCompanyCell("0951765971");
		cv1.getCompanyRegisterDate();
		cv1.getCompanyCetificate();
		cv1.getCompanyBanner();
		cv1.setCompanyIntro("提供您需要的登山煮飯裝備");
		cv1.setCompanyOwner("莊艾池");
		cv1.setCompanyAddress("臺中市東區東美街699號");
		test1.insert(cv1);
		System.out.println("insert okay");
		
		//修改
		CompanyVO cv2 = new CompanyVO();
		cv2.setCompanyName("updateTest");
		cv2.setCompanyEmail("testtest@gmail.com");
		cv2.setCompanyPassword("tttttt");
		cv2.setCompanyPhone("ttttttt");
		cv2.setCompanyCell("093333333");
//		cv2.getCompanyRegisterDate();  修改用不到
//		cv2.getCompanyCetificate(); 修改用不到
		cv2.getCompanyBanner();
		cv2.setCompanyIntro("aaaaaaaaaaaaaaa");
		cv2.setCompanyOwner("aa");
		cv2.setCompanyAddress("台中市台灣大道216號");
		cv2.setCompanyId(2);
		test1.update(cv2);
		
		//刪除
		test1.delete(9);
		System.out.println("delete success");
		
		//查詢單筆店家
		CompanyVO cv3 = test1.findByPrimaryKey(1);
		System.out.println("店家ID:" + cv3.getCompanyId() + ",");
		System.out.println("店家名稱:" + cv3.getCompanyName() + ",");
		System.out.println("店家信箱:" + cv3.getCompanyEmail() + ",");
		System.out.println("店家電話:" + cv3.getCompanyPhone() + ",");
		System.out.println("店家手機:" + cv3.getCompanyCell() + ",");
		System.out.println("店家簡介:" + cv3.getCompanyIntro() + ",");
		System.out.println("店家負責人:" + cv3.getCompanyOwner() + ",");
		System.out.println("店家地址:" + cv3.getCompanyAddress() + ".");
		System.out.println("----------------------");

		//查詢全部店家
		List<CompanyVO> list = test1.getAll();
		for(CompanyVO companylist : list) {
			System.out.println("店家ID:" + companylist.getCompanyId() + ",");
			System.out.println("店家名稱:" + companylist.getCompanyName() + ",");
			System.out.println("店家信箱:" + companylist.getCompanyEmail() + ",");
			System.out.println("店家電話:" + companylist.getCompanyPhone() + ",");
			System.out.println("店家手機:" + companylist.getCompanyCell() + ",");
			System.out.println("店家簡介:" + companylist.getCompanyIntro() + ",");
			System.out.println("店家負責人:" + companylist.getCompanyOwner() + ",");
			System.out.println("店家地址:" + companylist.getCompanyAddress() + ".");
			System.out.println("----------------------");
		}
	}
}
