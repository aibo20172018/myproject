package com.yb.loan.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanDocuments;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 借款客户资料
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:26
 */
@Mapper
public interface LoanDocumentsDao extends BaseDao {

    List<LoanDocuments> listPageLoanDocuments(@Param("loanDocuments") LoanDocuments loanDocuments, @Param("pagination") Pagination pagination);
}
