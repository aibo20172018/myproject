package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanBigdataInfo;

import java.util.List;


/**
 * 大数据信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface LoanBigdataInfoService extends BaseService{

    List<LoanBigdataInfo> listPageLoanBigdataInfo(LoanBigdataInfo loanBigdataInfo, Pagination pagination);
}