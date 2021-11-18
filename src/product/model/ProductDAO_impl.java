package product.model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.CompanyVO;

import util.Util;

public class ProductDAO_impl implements ProductDAO_interface{

	//新增
	private static final String INSERT = "INSERT INTO product" +
	"(product_id,company_id,product_name,product_type,status,product_price,product_intro)" +
	"VALUES (?, ?, ?, ?, ?, ?, ?)";
	
	//修改商品資訊,商品ID跟店家ID不可異動
	private static final String UPDATE = "UPDATE product SET product_name = ?, product_type = ?, status = ?, product_price = ?,product_intro = ? WHERE product_id = ? ";
	
	//查詢單一店家所有商品
    private static final String FIND_BY_COMPANY = "SELECT * FROM product WHERE company_id = ?";
    //查詢單一種類所有商品
    private static final String FIND_BY_TYPE = "SELECT * FROM product WHERE product_type = ?";
    //查詢單一商品
    private static final String FIND_BY_PK = "SELECT * FROM product WHERE product_id = ?";
	//查詢全部商品資料
	private static final String GET_ALL = "SELECT * FROM product ORDER BY product_id";
	//查詢最新商品
	private static final String FIND_NEW = "SELECT * FROM product ORDER BY product_id desc";
	//用上下架狀態查詢商品
	private static final String FIND_STATUS = "SELECT * FROM product WHERE status = ?";
	
	//用static區塊載入驅動程式,讓驅動程式跟static一起建立起來
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	
	
	@Override
	public void insert(ProductVo productVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT);//得到preparestatement
			
			pstmt.setInt(1,productVo.getProductId());
			pstmt.setInt(2,productVo.getCompanyId());
			pstmt.setString(3,productVo.getProductName());
			pstmt.setInt(4,productVo.getProductType());
			pstmt.setInt(5,productVo.getStatus());
			pstmt.setInt(6,productVo.getProductPrice());
			pstmt.setString(7,productVo.getProductIntro());
			
			//提供完資料,可執行Update
			pstmt.executeUpdate();

			
		}catch(SQLException se) {
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
	public void update(ProductVo productVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE);//得到preparestatement
			
			pstmt.setString(1,productVo.getProductName());
			pstmt.setInt(2,productVo.getProductType());
			pstmt.setInt(3,productVo.getStatus());
			pstmt.setInt(4,productVo.getProductPrice());
			pstmt.setString(5,productVo.getProductIntro());
			pstmt.setInt(6,productVo.getProductId());
			
			//提供完資料,可執行Update
			pstmt.executeUpdate();

			
		}catch(SQLException se) {
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
	public List<ProductVo> findByCompany(int companyId) {
		List<ProductVo> products = new ArrayList<ProductVo>();
		ProductVo pro = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_COMPANY);
			pstmt.setInt(1,companyId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pro = new ProductVo();
				pro.setProductId(rs.getInt("product_id"));
				pro.setCompanyId(rs.getInt("company_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductType(rs.getInt("product_type"));
				pro.setStatus(rs.getInt("status"));
				pro.setProductPrice(rs.getInt("product_price"));
				pro.setProductIntro(rs.getString("product_intro"));
				products.add(pro);
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

		return products;
	}

	@Override
	public List<ProductVo> findByType(int productType) {
		List<ProductVo> products = new ArrayList<ProductVo>();
		ProductVo pro = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_TYPE);
			pstmt.setInt(1,productType);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pro = new ProductVo();
				pro.setProductId(rs.getInt("product_id"));
				pro.setCompanyId(rs.getInt("company_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductType(rs.getInt("product_type"));
				pro.setStatus(rs.getInt("status"));
				pro.setProductPrice(rs.getInt("product_price"));
				pro.setProductIntro(rs.getString("product_intro"));
				products.add(pro);
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

		return products;
	}
	
	@Override
	public ProductVo findByPrimaryKey(int productId) {
		ProductVo pro = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, productId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pro = new ProductVo();
				pro.setProductId(rs.getInt("product_id"));
				pro.setCompanyId(rs.getInt("company_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductType(rs.getInt("product_type"));
				pro.setStatus(rs.getInt("status"));
				pro.setProductPrice(rs.getInt("product_price"));
				pro.setProductIntro(rs.getString("product_intro"));

			
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

		return pro;
	}

	@Override
	public List<ProductVo> getAll() {
		List<ProductVo> products = new ArrayList<ProductVo>();
		ProductVo pro = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pro = new ProductVo();
				pro.setProductId(rs.getInt("product_id"));
				pro.setCompanyId(rs.getInt("company_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductType(rs.getInt("product_type"));
				pro.setStatus(rs.getInt("status"));
				pro.setProductPrice(rs.getInt("product_price"));
				pro.setProductIntro(rs.getString("product_intro"));
				products.add(pro);
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

		return products;
	}

	@Override
	public List<ProductVo> findNew() {
		List<ProductVo> products = new ArrayList<ProductVo>();
		ProductVo pro = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_NEW);
			rs = pstmt.executeQuery();

			while (rs.next()) {
					pro = new ProductVo();
					pro.setProductId(rs.getInt("product_id"));
					pro.setCompanyId(rs.getInt("company_id"));
					pro.setProductName(rs.getString("product_name"));
					pro.setProductType(rs.getInt("product_type"));
					pro.setStatus(rs.getInt("status"));
					pro.setProductPrice(rs.getInt("product_price"));
					pro.setProductIntro(rs.getString("product_intro"));
					products.add(pro);
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

			return products;
		
	}

	@Override
	public List<ProductVo> findStatus(int status) {
		List<ProductVo> products = new ArrayList<ProductVo>();
		ProductVo pro = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_STATUS);
			pstmt.setInt(1,status);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				pro = new ProductVo();
				pro.setProductId(rs.getInt("product_id"));
				pro.setCompanyId(rs.getInt("company_id"));
				pro.setProductName(rs.getString("product_name"));
				pro.setProductType(rs.getInt("product_type"));
				pro.setStatus(rs.getInt("status"));
				pro.setProductPrice(rs.getInt("product_price"));
				pro.setProductIntro(rs.getString("product_intro"));
				products.add(pro);
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

		return products;
	}

}
