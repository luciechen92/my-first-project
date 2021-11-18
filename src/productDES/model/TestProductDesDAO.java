package productDES.model;

import java.util.List;

public class TestProductDesDAO {
	
	
	public static void main(String[] args) {
		
		ProductDesDAO_interface test1 = new ProductDesDAO_impl();
		
		//新增
//		ProductDesVO pdv1 = new ProductDesVO();
//		pdv1.setProductDesId(85);
//		pdv1.setProductId(64);
//		//商品尺寸0:F 1:S 2:M 3:L 4:XL
//		pdv1.setProductSize(0);
//		
//		pdv1.setProductColor("灰");
//		pdv1.setProductStock(10);
//		
//		//上架狀態0:下架1:上架,預設0
//		pdv1.setStatus(0);
//		
//		pdv1.setProductPrice(980);
//		test1.insert(pdv1);
//		System.out.println("insert okay");
		
		//修改
//		ProductDesVO pdv2 = new ProductDesVO();
//		pdv2.setProductId(1);
//		pdv2.setProductSize(0);
//		pdv2.setProductColor("透明橘");
//		pdv2.setProductStock(15);
//		pdv2.setStatus(0);
//		pdv2.setProductPrice(599);
//		pdv2.setProductDesId(1);
//		test1.update(pdv2);
//		System.out.println("update okay");
		
		//查詢by PK
//		ProductDesVO pdv3 = test1.findByPrimaryKey(2);
//		System.out.println("商品明細ID:" + pdv3.getProductDesId() + ",");
//		System.out.println("商品ID:" + pdv3.getProductId() + ",");
//		System.out.println("商品尺寸:" + pdv3.getProductSize() + ",");
//		System.out.println("商品顏色:" + pdv3.getProductColor() + ",");
//		System.out.println("商品庫存:" + pdv3.getProductStock() + ",");
//		System.out.println("商品狀態:" + pdv3.getStatus() + ",");
//		System.out.println("商品價格:" + pdv3.getProductPrice() + ",");
		
		//查詢 by product_id
//		List <ProductDesVO> list = test1.findByProductId(16);
//		for(ProductDesVO prodesList : list){
//			System.out.println("商品明細ID:" + prodesList.getProductDesId() + ",");
//			System.out.println("商品ID:" + prodesList.getProductId() + ",");
//			System.out.println("商品尺寸:" + prodesList.getProductSize() + ",");
//			System.out.println("商品顏色:" + prodesList.getProductColor() + ",");
//			System.out.println("商品庫存:" + prodesList.getProductStock() + ",");
//			System.out.println("商品狀態:" + prodesList.getStatus() + ",");
//			System.out.println("商品價格:" + prodesList.getProductPrice() + ",");
//			System.out.println("------------------------------------------");
//			
//		}
		
		//查詢 by product_stock
//		List <ProductDesVO> list2 = test1.findByProductStock(10);
//		for(ProductDesVO prodesList : list2) {
//			System.out.println("商品明細ID:" + prodesList.getProductDesId() + ",");
//			System.out.println("商品ID:" + prodesList.getProductId() + ",");
//			System.out.println("商品尺寸:" + prodesList.getProductSize() + ",");
//			System.out.println("商品顏色:" + prodesList.getProductColor() + ",");
//			System.out.println("商品庫存:" + prodesList.getProductStock() + ",");
//			System.out.println("商品狀態:" + prodesList.getStatus() + ",");
//			System.out.println("商品價格:" + prodesList.getProductPrice() + ",");
//			System.out.println("------------------------------------------");
//			
//		}
		
		//查全部明細
		List <ProductDesVO> list3 = test1.getall();
		for(ProductDesVO prodesList : list3) {
			System.out.println("商品明細ID:" + prodesList.getProductDesId() + ",");
			System.out.println("商品ID:" + prodesList.getProductId() + ",");
			System.out.println("商品尺寸:" + prodesList.getProductSize() + ",");
			System.out.println("商品顏色:" + prodesList.getProductColor() + ",");
			System.out.println("商品庫存:" + prodesList.getProductStock() + ",");
			System.out.println("商品狀態:" + prodesList.getStatus() + ",");
			System.out.println("商品價格:" + prodesList.getProductPrice() + ",");
			System.out.println("------------------------------------------");
			
		}
	}

}
