package ProductIMG.model;

public class TestProductImgDAO {
	public static void main(String[] args) {
		ProductImgDAO_interface test1 = new ProductImgDAO_impl();
		
		//新增
		ProductImgVO pimg1 = new ProductImgVO();
		pimg1.setProductImgId(136);
		pimg1.setProductDesId(28);
		pimg1.getProductImg();
		test1.insert(pimg1);
		System.out.println("insert okay");
		//修改
		
		//刪除
		
		//查詢 by product_des_id is this need?
	}
}
