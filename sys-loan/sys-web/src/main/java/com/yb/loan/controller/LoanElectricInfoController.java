package com.yb.loan.controller;

import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.loan.pojo.LoanElectricInfo;
import com.yb.loan.service.LoanElectricInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 风控初审电核信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/loanElectricInfo")
public class  LoanElectricInfoController extends BaseController {
    @Autowired
	private LoanElectricInfoService loanElectricInfoService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<LoanElectricInfo> listPageData(LoanElectricInfo loanElectricInfo, Pagination pagination){
        PageInfo<LoanElectricInfo> result = new PageInfo<>();
        result.setList(loanElectricInfoService.listPageLoanElectricInfo(loanElectricInfo,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
