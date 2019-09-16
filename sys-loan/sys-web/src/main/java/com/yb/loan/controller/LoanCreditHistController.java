package com.yb.loan.controller;


import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.loan.pojo.LoanCreditHist;
import com.yb.loan.service.LoanCreditHistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 征信历史
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/loanCreditHist")
public class  LoanCreditHistController {
    @Autowired
	private LoanCreditHistService loanCreditHistService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<LoanCreditHist> listPageData(LoanCreditHist loanCreditHist, Pagination pagination){
        PageInfo<LoanCreditHist> result = new PageInfo<>();
        result.setList(loanCreditHistService.listPageLoanCreditHist(loanCreditHist,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
