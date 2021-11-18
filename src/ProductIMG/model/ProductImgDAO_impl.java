package ProductIMG.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import util.Util;

public class ProductImgDAO_impl implements ProductImgDAO_interface {
	
	
	private static final String INSERT = "INSERT INTO product_img"+
	"(product_img_id,product_des_id,product_img)"+
	"VALUES(?, ?, ?)";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	private static final String FIND_BY_PRODES = "";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	@Override
	public void insert(ProductImgVO productImgVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1, productImgVO.getProductImgId());
			pstmt.setInt(2, productImgVO.getProductDesId());
			//setting picture >set Bytes
			byte[] pic = getPictureByteArray("/Users/luciechen/Documents/shanshan/products/womenClothes-shop1use/8-1.jpeg");
			pstmt.setBytes(3,pic);
			pstmt.executeUpdate();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch(IOException ie) {
			ie.printStackTrace();
		}finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
			
			if (con != null) {
				try {
					con.close();
				} catch (SQLException se) {
					se.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void update(ProductImgVO productImgVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int productImgId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductImgVO> findbyproDes(int productDesId) {
		// TODO Auto-generated method stub
		return null;
	}

	//-----------------------------傳照片methods------------------------------
	// 使用byte[] upload picture
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}
}
