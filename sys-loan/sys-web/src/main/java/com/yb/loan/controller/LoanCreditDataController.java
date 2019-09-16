package com.yb.loan.controller;


import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.loan.pojo.LoanCreditData;
import com.yb.loan.service.LoanCreditDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 企业信用数据
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/loanCreditData")
public class  LoanCreditDataController extends BaseController {
    @Autowired
	private LoanCreditDataService loanCreditDataService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<LoanCreditData> listPageData(LoanCreditData loanCreditData, Pagination pagination){
        PageInfo<LoanCreditData> result = new PageInfo<>();
        result.setList(loanCreditDataService.listPageLoanCreditData(loanCreditData,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
