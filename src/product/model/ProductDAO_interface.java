package product.model;

import java.util.List;

public interface ProductDAO_interface {
	// 此介面定義對資料庫的相關存取抽象方法
	public void insert(ProductVo productVo);
	public void update(ProductVo productVo);
    public ProductVo findByPrimaryKey(int productId);//用商品ID找出商品資料
    public List<ProductVo> findByCompany(int companyId);//用店家ID找出所有商品
    public List<ProductVo> findByType(int productType);//用商品type找出商品資料
    public List<ProductVo> findNew();//用商品ID排序找出最新商品
    public List<ProductVo> findStatus(int status);//用上下架狀態
    public List<ProductVo> getAll();//全部商品的資料,用集合來做回傳

}
