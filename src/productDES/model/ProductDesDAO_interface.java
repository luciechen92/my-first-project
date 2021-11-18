package productDES.model;

import java.util.List;

public interface ProductDesDAO_interface {
	
	public void insert(ProductDesVO productDesVO);
	public void update (ProductDesVO productDesVO);
	public ProductDesVO findByPrimaryKey(int productDesId);//找單項
	public List<ProductDesVO> findByProductId(int productId);//用商品id找細類
	public List<ProductDesVO> findByProductStock(int productStock);//用庫存來找
	public List<ProductDesVO> getall();//查全部明細
	
	
}
