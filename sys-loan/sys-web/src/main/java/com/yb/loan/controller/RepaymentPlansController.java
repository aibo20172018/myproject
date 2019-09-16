package com.yb.loan.controller;

import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.loan.pojo.RepaymentPlans;
import com.yb.loan.service.RepaymentPlansService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 还款计划
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/repaymentPlans")
public class  RepaymentPlansController {
    @Autowired
	private RepaymentPlansService repaymentPlansService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<RepaymentPlans> listPageData(RepaymentPlans repaymentPlans, Pagination pagination){
        PageInfo<RepaymentPlans> result = new PageInfo<>();
        result.setList(repaymentPlansService.listPageRepaymentPlans(repaymentPlans,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
