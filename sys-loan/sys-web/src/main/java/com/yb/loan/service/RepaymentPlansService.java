package com.yb.loan.service;
 
import com.yb.base.utils.base.service.BaseService;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.RepaymentPlans;

import java.util.List;


/**
 * 还款计划
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */

public interface RepaymentPlansService extends BaseService{

    List<RepaymentPlans> listPageRepaymentPlans(RepaymentPlans repaymentPlans, Pagination pagination);
}