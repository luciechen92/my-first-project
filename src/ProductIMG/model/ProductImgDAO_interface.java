package ProductIMG.model;

import java.util.List;

public interface ProductImgDAO_interface {
	public void insert(ProductImgVO productImgVO);
	public void update(ProductImgVO productImgVO);
	public void delete (int productImgId);//用照片ID來刪除照片資料
	public List<ProductImgVO> findbyproDes(int productDesId);//用商品明細來查
	
}
