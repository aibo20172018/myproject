package com.yb.companyfund.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.companyfund.pojo.CompanyFundCount;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 资方日放款统计表
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Mapper
public interface CompanyFundCountDao extends BaseDao {

    List<CompanyFundCount> listPageCompanyFundCount(@Param("companyFundCount") CompanyFundCount companyFundCount, @Param("pagination") Pagination pagination);
}
