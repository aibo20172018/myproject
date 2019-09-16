package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanSixdata;

import java.util.List;


/**
 * 近6个月数据
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface LoanSixdataService extends BaseService{

    List<LoanSixdata> listPageLoanSixdata(LoanSixdata loanSixdata, Pagination pagination);
}