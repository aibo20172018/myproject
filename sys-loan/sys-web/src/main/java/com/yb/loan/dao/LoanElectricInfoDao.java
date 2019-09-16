package com.yb.loan.dao;

import com.yb.base.utils.base.dao.BaseDao;
import com.yb.base.utils.paging.Pagination;
import com.yb.loan.pojo.LoanElectricInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 风控初审电核信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Mapper
public interface LoanElectricInfoDao extends BaseDao {

    List<LoanElectricInfo> listPageLoanElectricInfo(@Param("loanElectricInfo") LoanElectricInfo loanElectricInfo, @Param("pagination") Pagination pagination);
}
