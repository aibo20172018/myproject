package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanCreditHist;

import java.util.List;


/**
 * 征信历史
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface LoanCreditHistService extends BaseService{

    List<LoanCreditHist> listPageLoanCreditHist(LoanCreditHist loanCreditHist, Pagination pagination);
}