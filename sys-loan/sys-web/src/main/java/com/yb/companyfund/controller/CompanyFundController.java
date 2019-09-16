package com.yb.companyfund.controller;


import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.companyfund.pojo.CompanyFund;
import com.yb.companyfund.service.CompanyFundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.yb.base.utils.paging.Pagination;




/**
 * 放款资金方管理
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/companyFund")
public class  CompanyFundController {
    @Autowired
	private CompanyFundService companyFundService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<CompanyFund> listPageData(CompanyFund companyFund, Pagination pagination){
        PageInfo<CompanyFund> result = new PageInfo<>();
        result.setList(companyFundService.listPageCompanyFund(companyFund,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
