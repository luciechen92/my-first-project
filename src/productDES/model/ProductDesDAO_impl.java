package productDES.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import product.model.ProductVo;
import util.Util;

public class ProductDesDAO_impl implements ProductDesDAO_interface {

	//新增
	private static final String INSERT = "INSERT INTO product_description" +
	"(product_des_id,product_id,product_size,product_color,product_stock,status,product_price)" +
	"VALUES (?, ?, ?, ?, ?, ?, ?)";
	//修改
	private static final String UPDATE = "UPDATE product_description SET product_id = ?,product_size = ?,product_color = ?,product_stock = ?,status = ?,product_price = ? WHERE product_des_id =? ";
	//查詢byPK
	private static final String FIND_BY_PK = "SELECT * FROM product_description WHERE product_des_id = ?";
	//查詢by商品ID
	private static final String FIND_BY_PRODUCTID = "SELECT * FROM product_description WHERE product_id = ?";
	//查詢by有庫存
	private static final String FIND_BY_STOCK = "SELECT * FROM product_description WHERE product_stock = ?";
	//查全部
	private static final String GET_ALL = "SELECT * FROM product_description ORDER BY product_des_id";
	
	
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void insert(ProductDesVO productDesVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);
			pstmt.setInt(1,productDesVO.getProductDesId());
			pstmt.setInt(2,productDesVO.getProductId());
			pstmt.setInt(3, productDesVO.getProductSize());
			pstmt.setString(4, productDesVO.getProductColor());
			pstmt.setInt(5,productDesVO.getProductStock());
			pstmt.setInt(6, productDesVO.getStatus());
			pstmt.setInt(7, productDesVO.getProductPrice());
			
			pstmt.executeUpdate();
			
		}catch (SQLException se) {
			se.printStackTrace();
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
	public void update(ProductDesVO productDesVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);
			
			
			pstmt.setInt(1,productDesVO.getProductId());
			pstmt.setInt(2, productDesVO.getProductSize());
			pstmt.setString(3, productDesVO.getProductColor());
			pstmt.setInt(4,productDesVO.getProductStock());
			pstmt.setInt(5, productDesVO.getStatus());
			pstmt.setInt(6, productDesVO.getProductPrice());
			pstmt.setInt(7,productDesVO.getProductDesId());
			
			pstmt.executeUpdate();
			
		}catch (SQLException se) {
			se.printStackTrace();
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
	public ProductDesVO findByPrimaryKey(int productDesId) {
		ProductDesVO pvo = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, productDesId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pvo = new ProductDesVO();
				pvo.setProductDesId(rs.getInt("product_des_id"));
				pvo.setProductId(rs.getInt("product_id"));
				pvo.setProductSize(rs.getInt("product_size"));
				pvo.setProductColor(rs.getString("product_color"));
				pvo.setProductStock(rs.getInt("product_stock"));
				pvo.setStatus(rs.getInt("status"));
				pvo.setProductPrice(rs.getInt("product_price"));
			
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return pvo;
	}





	@Override
	public List<ProductDesVO> findByProductId(int productId) {
		List <ProductDesVO> prodesList = new ArrayList<ProductDesVO>();
		ProductDesVO pdv = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PRODUCTID);
			pstmt.setInt(1,productId);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				pdv = new ProductDesVO();
				pdv.setProductDesId(rs.getInt("product_des_id"));
				pdv.setProductId(rs.getInt("product_id"));
				pdv.setProductSize(rs.getInt("product_size"));
				pdv.setProductColor(rs.getString("product_color"));
				pdv.setProductStock(rs.getInt("product_stock"));
				pdv.setStatus(rs.getInt("status"));
				pdv.setProductPrice(rs.getInt("product_price"));
				prodesList.add(pdv);
				
			}
			
		}catch(SQLException se){
			se.printStackTrace();
			
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return prodesList;
	}





	@Override
	public List<ProductDesVO> findByProductStock(int productStock) {
		List <ProductDesVO> prodesList = new ArrayList<ProductDesVO>();
		ProductDesVO pdv = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_STOCK);
			pstmt.setInt(1,productStock);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				pdv = new ProductDesVO();
				pdv.setProductDesId(rs.getInt("product_des_id"));
				pdv.setProductId(rs.getInt("product_id"));
				pdv.setProductSize(rs.getInt("product_size"));
				pdv.setProductColor(rs.getString("product_color"));
				pdv.setProductStock(rs.getInt("product_stock"));
				pdv.setStatus(rs.getInt("status"));
				pdv.setProductPrice(rs.getInt("product_price"));
				prodesList.add(pdv);
				
			}
			
		}catch(SQLException se){
			se.printStackTrace();
			
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return prodesList;
	}

	@Override
	public List<ProductDesVO> getall() {
		List <ProductDesVO> prodesList = new ArrayList<ProductDesVO>();
		ProductDesVO pdv = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				pdv = new ProductDesVO();
				pdv.setProductDesId(rs.getInt("product_des_id"));
				pdv.setProductId(rs.getInt("product_id"));
				pdv.setProductSize(rs.getInt("product_size"));
				pdv.setProductColor(rs.getString("product_color"));
				pdv.setProductStock(rs.getInt("product_stock"));
				pdv.setStatus(rs.getInt("status"));
				pdv.setProductPrice(rs.getInt("product_price"));
				prodesList.add(pdv);
				
			}
			
		}catch(SQLException se){
			se.printStackTrace();
			
		}finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return prodesList;
	}
	
	
	
}
