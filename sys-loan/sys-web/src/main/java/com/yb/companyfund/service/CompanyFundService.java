package com.yb.companyfund.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.companyfund.pojo.CompanyFund;

import java.util.List;


/**
 * 放款资金方管理
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface CompanyFundService extends BaseService{

    List<CompanyFund> listPageCompanyFund(CompanyFund companyFund, Pagination pagination);
}