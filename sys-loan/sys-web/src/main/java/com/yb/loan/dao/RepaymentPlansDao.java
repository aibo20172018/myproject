package com.yb.loan.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.RepaymentPlans;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 还款计划
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Mapper
public interface RepaymentPlansDao extends BaseDao {

    List<RepaymentPlans> listPageRepaymentPlans(@Param("repaymentPlans") RepaymentPlans repaymentPlans, @Param("pagination") Pagination pagination);
}
