package com.yb.loan.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanCreditHist;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 征信历史
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Mapper
public interface LoanCreditHistDao extends BaseDao {

    List<LoanCreditHist> listPageLoanCreditHist(@Param("loanCreditHist") LoanCreditHist loanCreditHist, @Param("pagination") Pagination pagination);
}
