package com.yb.loan.controller;


import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.loan.pojo.LoansCore;
import com.yb.loan.service.LoansCoreService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 借款核心信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/loansCore")
public class  LoansCoreController extends BaseController {
    @Autowired
	private LoansCoreService loansCoreService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<LoansCore> listPageData(LoansCore loansCore, Pagination pagination){
        PageInfo<LoansCore> result = new PageInfo<>();
        result.setList(loansCoreService.listPageLoansCore(loansCore,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
