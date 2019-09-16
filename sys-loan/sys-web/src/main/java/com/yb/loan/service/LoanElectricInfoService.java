package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanElectricInfo;

import java.util.List;


/**
 * 风控初审电核信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface LoanElectricInfoService extends BaseService{

    List<LoanElectricInfo> listPageLoanElectricInfo(LoanElectricInfo loanElectricInfo, Pagination pagination);
}