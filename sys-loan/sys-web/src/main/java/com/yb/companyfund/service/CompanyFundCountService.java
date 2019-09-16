package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.companyfund.pojo.CompanyFundCount;

import java.util.List;


/**
 * 资方日放款统计表
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface CompanyFundCountService extends BaseService{

    List<CompanyFundCount> listPageCompanyFundCount(CompanyFundCount companyFundCount, Pagination pagination);
}