package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanDocuments;

import java.util.List;


/**
 * 借款客户资料
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:26
 */

public interface LoanDocumentsService extends BaseService{

    List<LoanDocuments> listPageLoanDocuments(LoanDocuments loanDocuments, Pagination pagination);
}