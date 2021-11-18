package ProductIMG.model;

import java.io.Serializable;

import oracle.sql.BLOB;

public class ProductImgVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer productImgId;
	private Integer productDesId;
	private byte[] productImg;
	
	public ProductImgVO() {
		super();
	}
	
	public Integer getProductImgId() {
		return productImgId;
	}
	public void setProductImgId(Integer productImgId) {
		this.productImgId = productImgId;
	}
	public Integer getProductDesId() {
		return productDesId;
	}
	public void setProductDesId(Integer productDesId) {
		this.productDesId = productDesId;
	}
	public byte[] getProductImg() {
		return productImg;
	}
	public void setProductImg(byte[] productImg) {
		this.productImg = productImg;
	}

	
	
	
}
