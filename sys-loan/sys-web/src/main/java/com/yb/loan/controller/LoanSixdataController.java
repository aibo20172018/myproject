package com.yb.loan.controller;

import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.loan.pojo.LoanSixdata;
import com.yb.loan.service.LoanSixdataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 近6个月数据
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/loanSixdata")
public class  LoanSixdataController extends BaseController {
    @Autowired
	private LoanSixdataService loanSixdataService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<LoanSixdata> listPageData(LoanSixdata loanSixdata, Pagination pagination){
        PageInfo<LoanSixdata> result = new PageInfo<>();
        result.setList(loanSixdataService.listPageLoanSixdata(loanSixdata,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
