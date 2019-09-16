package com.yb.companyfund.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.companyfund.pojo.CompanyFund;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 放款资金方管理
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Mapper
public interface CompanyFundDao extends BaseDao {

    List<CompanyFund> listPageCompanyFund(@Param("companyFund") CompanyFund companyFund, @Param("pagination") Pagination pagination);
}
