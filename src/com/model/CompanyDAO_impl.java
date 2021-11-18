package com.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Util;

public class CompanyDAO_impl implements CompanyDAO_interface {
//	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://localhost:3306/ShanShan?serverTimezone=Asia/Taipei";
//	private static final String USER = "root";
//	private static final String PASSWORD = "111ab267";
	
	//新增
	private static final String INSERT_STMT = "INSERT INTO company"+
	"(company_name,company_email,company_password,company_phone,company_cell,company_register_date,company_cetificate,company_banner,company_intro,company_owner,company_address)"+
	"VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	//修改
	private static final String UPDATE_STMT = "UPDATE company SET company_name = ?, company_email = ?, company_password = ?, company_phone = ?, company_cell = ?, company_banner = ?, company_intro = ?, company_owner = ?, company_address = ?  WHERE company_id = ? " ;
	
	//查詢單筆
	private static final String FIND_BY_PK = "SELECT * FROM company WHERE company_id = ?";
	//查詢全部資料
	private static final String GET_ALL = "SELECT * FROM company ORDER BY company_id";
	//刪除
	private static final String DELETE_STMT = "DELETE FROM company WHERE company_id = ?";
	
	
	//用static區塊載入驅動程式,讓驅動程式跟static一起建立起來
	static {
		try {
			Class.forName(Util.DRIVER);
		}catch(ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}
	@Override
	public void insert(CompanyVO companyVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);//得到preparestatement
			
			pstmt.setString(1,companyVo.getCompanyName());
			pstmt.setString(2,companyVo.getCompanyEmail());
			pstmt.setString(3,companyVo.getCompanyPassword());
			pstmt.setString(4,companyVo.getCompanyPhone());
			pstmt.setString(5,companyVo.getCompanyCell());
			
			// setting the date
			java.util.Date du = new java.util.Date();
			Date date = new Date(du.getTime());
			pstmt.setDate(6,date);
			
			//setting picture >inputsteam upload JDBC4.0
			InputStream is = getPictureStream("/Users/luciechen/Documents/shanshan/cetificate_pic.png");//傳入圖片路徑
			pstmt.setBlob(7,is);
			
			//setting picture >set Bytes
			byte[] pic = getPictureByteArray("/Users/luciechen/Documents/shanshan/company_banner/presetBanner.png");
			pstmt.setBytes(8,pic);
			
			pstmt.setString(9,companyVo.getCompanyIntro());
			pstmt.setString(10,companyVo.getCompanyOwner());
			pstmt.setString(11,companyVo.getCompanyAddress());
			
			//提供完資料,可執行Update
			pstmt.executeUpdate();
			is.close();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (IOException ie) {
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
	public void update(CompanyVO companyVo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(Util.URL,Util.USER,Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);//得到preparestatement
			
			pstmt.setString(1,companyVo.getCompanyName());
			pstmt.setString(2,companyVo.getCompanyEmail());
			pstmt.setString(3,companyVo.getCompanyPassword());
			pstmt.setString(4,companyVo.getCompanyPhone());
			pstmt.setString(5,companyVo.getCompanyCell());
			
//			// setting the date
//			java.util.Date du = new java.util.Date();
//			Date date = new Date(du.getTime());
//			pstmt.setDate(6,date);
			
//			//setting picture >inputsteam upload JDBC4.0
//			InputStream is = getPictureStream("/Users/luciechen/Documents/shanshan/cetificate_pic.png");//傳入圖片路徑
//			pstmt.setBlob(7,is);
			
			//setting picture >set Bytes
			byte[] pic = getPictureByteArray("/Users/luciechen/Documents/shanshan/company_banner/gogohiking.png");
			pstmt.setBytes(6,pic);
			
			pstmt.setString(7,companyVo.getCompanyIntro());
			pstmt.setString(8,companyVo.getCompanyOwner());
			pstmt.setString(9,companyVo.getCompanyAddress());
			pstmt.setInt(10,companyVo.getCompanyId());
			
			//提供完資料,可執行Update
			pstmt.executeUpdate();
//			is.close();
			
		}catch(SQLException se) {
			se.printStackTrace();
		}catch (IOException ie) {
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
	public void delete( int companyId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1,companyId);
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
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
	}
	@Override
	public CompanyVO findByPrimaryKey(int companyId) {
		CompanyVO com = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, companyId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				com = new CompanyVO();
				com.setCompanyId(rs.getInt("company_id"));
				com.setCompanyName(rs.getString("company_name"));
				com.setCompanyEmail(rs.getString("company_email"));
				com.setCompanyPhone(rs.getString("company_phone"));
				com.setCompanyCell(rs.getString("company_cell"));
				com.setCompanyIntro(rs.getString("company_intro"));
				com.setCompanyOwner(rs.getString("company_owner"));
				com.setCompanyAddress(rs.getString("company_address"));
			
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

		return com;
	}
	
	
	@Override
	public List<CompanyVO> getAll() {
		List<CompanyVO> companylist = new ArrayList<CompanyVO>();
		CompanyVO com = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				com = new CompanyVO();
				com.setCompanyId(rs.getInt("company_id"));
				com.setCompanyName(rs.getString("company_name"));
				com.setCompanyEmail(rs.getString("company_email"));
				com.setCompanyPhone(rs.getString("company_phone"));
				com.setCompanyCell(rs.getString("company_cell"));
				com.setCompanyIntro(rs.getString("company_intro"));
				com.setCompanyOwner(rs.getString("company_owner"));
				com.setCompanyAddress(rs.getString("company_address"));
				companylist.add(com);
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
		return companylist;
	}
	
	//-----------------------------傳照片methods------------------------------
	// 使用InputStream upload picture
	public static InputStream getPictureStream(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		return fis;
	}
		
	// 使用byte[] upload picture
	public static byte[] getPictureByteArray(String path) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		byte[] buffer = new byte[fis.available()];
		fis.read(buffer);
		fis.close();
		return buffer;
	}
	
}
