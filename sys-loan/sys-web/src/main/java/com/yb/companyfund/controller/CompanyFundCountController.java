package com.yb.companyfund.controller;


import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.companyfund.pojo.CompanyFundCount;
import com.yb.loan.service.CompanyFundCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 资方日放款统计表
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/companyFundCount")
public class  CompanyFundCountController {
    @Autowired
	private CompanyFundCountService companyFundCountService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<CompanyFundCount> listPageData(CompanyFundCount companyFundCount, Pagination pagination){
        PageInfo<CompanyFundCount> result = new PageInfo<>();
        result.setList(companyFundCountService.listPageCompanyFundCount(companyFundCount,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
