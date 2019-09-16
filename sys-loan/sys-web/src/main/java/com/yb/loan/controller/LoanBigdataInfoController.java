package com.yb.loan.controller;


import com.yb.base.utils.base.controller.BaseController;
import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.loan.pojo.LoanBigdataInfo;
import com.yb.loan.service.LoanBigdataInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 大数据信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@Api(description = "")
@RestController
@RequestMapping("/loanBigdataInfo")
public class  LoanBigdataInfoController extends BaseController {
    @Autowired
	private LoanBigdataInfoService loanBigdataInfoService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<LoanBigdataInfo> listPageData(LoanBigdataInfo loanBigdataInfo, Pagination pagination){
        PageInfo<LoanBigdataInfo> result = new PageInfo<>();
        result.setList(loanBigdataInfoService.listPageLoanBigdataInfo(loanBigdataInfo,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
