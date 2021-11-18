package product.model;

import java.util.List;

public class TestProductDAO {
	
	public static void main(String[]args) {
		
		ProductDAO_interface test1 = new ProductDAO_impl();
		
		//新增
//		ProductVo pv1 = new ProductVo();
//		pv1.setProductId(64);
//		pv1.setCompanyId(2);
//		pv1.setProductName("登山炊煮茶壺套鍋");
//		
//		//type對應 1:衣著背包鞋子2:工具照明3:炊具4:帳篷寢具
//		pv1.setProductType(3);
//		//status對應 0:下架1:上架
//		pv1.setStatus(0);
//		
//		pv1.setProductPrice(980);
//		pv1.setProductIntro("3人用");
//		test1.insert(pv1);
//		System.out.println("insert okay");
		
		//修改
//		ProductVo pv2 = new ProductVo();
//		pv2.setProductName("透氣登山外套");
//		pv2.setProductType(1);
//		pv2.setStatus(0);
//		pv2.setProductPrice(1249);
//		pv2.setProductIntro("");
//		pv2.setProductId(42);
//		test1.update(pv2);
//		System.out.println("update okay");
		
		
		//查詢by PK
//		ProductVo pv3 = test1.findByPrimaryKey(1);
//		System.out.println("商品ID:" + pv3.getProductId() + ",");
//		System.out.println("店家ID:" + pv3.getCompanyId() + ",");
//		System.out.println("商品名稱:" + pv3.getProductName() + ",");
//		System.out.println("商品類別:" + pv3.getProductType() + ",");
//		System.out.println("商品狀態:" + pv3.getStatus() + ",");
//		System.out.println("商品價格:" + pv3.getProductPrice() + ",");
//		System.out.println("商品簡介:" + pv3.getProductIntro() + ",");
		
//		//查詢by 店家ID
//		List <ProductVo> list = test1.findByCompany(2);
//		for( ProductVo products : list) {
//			System.out.println("商品ID:" + products.getProductId() + ",");
//			System.out.println("商品名稱:" + products.getProductName() + ",");
//			System.out.println("商品類別:" + products.getProductType() + ",");
//			System.out.println("商品狀態:" + products.getStatus() + ",");
//			System.out.println("商品價格:" + products.getProductPrice() + ",");
//			System.out.println("商品簡介:" + products.getProductIntro() + ",");
//			System.out.println("----------------------");
//		
//		}
//		//查詢by 商品類別
//		List<ProductVo> list2 = test1.findByType(4);
//		for( ProductVo products : list2) {
//			System.out.println("商品ID:" + products.getProductId() + ",");
//			System.out.println("店家ID:" + products.getCompanyId() + ",");
//			System.out.println("商品名稱:" + products.getProductName() + ",");
//			System.out.println("商品類別:" + products.getProductType() + ",");
//			System.out.println("商品狀態:" + products.getStatus() + ",");
//			System.out.println("商品價格:" + products.getProductPrice() + ",");
//			System.out.println("商品簡介:" + products.getProductIntro() + ",");
//			System.out.println("----------------------");
//		}
		
//		//查全部資料
//		List<ProductVo> list3 = test1.getAll();
//		for(ProductVo products : list3) {
//			System.out.println("商品ID:" + products.getProductId() + ",");
//			System.out.println("店家ID:" + products.getCompanyId() + ",");
//			System.out.println("商品名稱:" + products.getProductName() + ",");
//			System.out.println("商品類別:" + products.getProductType() + ",");
//			System.out.println("商品狀態:" + products.getStatus() + ",");
//			System.out.println("商品價格:" + products.getProductPrice() + ",");
//			System.out.println("商品簡介:" + products.getProductIntro() + ",");
//			System.out.println("----------------------");
//		}
		
		
//		//查最新商品
//		List<ProductVo> list4 = test1.findNew();
//		for(ProductVo products :list4) {
//			System.out.println("商品ID:" + products.getProductId() + ",");
//			System.out.println("店家ID:" + products.getCompanyId() + ",");
//			System.out.println("商品名稱:" + products.getProductName() + ",");
//			System.out.println("商品類別:" + products.getProductType() + ",");
//			System.out.println("商品狀態:" + products.getStatus() + ",");
//			System.out.println("商品價格:" + products.getProductPrice() + ",");
//			System.out.println("商品簡介:" + products.getProductIntro() + ",");
//			System.out.println("----------------------");
//		}
		
		//用上下架狀態查商品
		List<ProductVo> list5 = test1.findStatus(1);
		for(ProductVo products : list5) {
			System.out.println("商品ID:" + products.getProductId() + ",");
			System.out.println("店家ID:" + products.getCompanyId() + ",");
			System.out.println("商品名稱:" + products.getProductName() + ",");
			System.out.println("商品類別:" + products.getProductType() + ",");
			System.out.println("商品狀態:" + products.getStatus() + ",");
			System.out.println("商品價格:" + products.getProductPrice() + ",");
			System.out.println("商品簡介:" + products.getProductIntro() + ",");
			System.out.println("----------------------");
			
		}
	}

}
