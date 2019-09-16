package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoansCore;

import java.util.List;


/**
 * 借款核心信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface LoansCoreService extends BaseService{

    List<LoansCore> listPageLoansCore(LoansCore loansCore, Pagination pagination);
}