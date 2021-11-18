package com.model;

import java.util.List;

public interface CompanyDAO_interface {
	// 此介面定義對資料庫的相關存取抽象方法
	public void insert(CompanyVO companyVo);
	public void update(CompanyVO companyVo);
    public void delete(int companyId);//用ID來刪除店家資料
    public CompanyVO findByPrimaryKey(int companyId);//用ID找出店家資料
    public List<CompanyVO> getAll();//全部店家的資料,用集合來做回傳

}
