package com.yb.loan.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanBigdataInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 大数据信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Mapper
public interface LoanBigdataInfoDao extends BaseDao {

    List<LoanBigdataInfo> listPageLoanBigdataInfo(@Param("loanBigdataInfo") LoanBigdataInfo loanBigdataInfo, @Param("pagination") Pagination pagination);
}
