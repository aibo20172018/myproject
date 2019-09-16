package com.yb.loan.controller;

import com.yb.base.utils.base.vo.response.BaseRespons;
import com.yb.base.utils.base.vo.response.PageResponsVO;
import com.yb.base.utils.paging.PageInfo;
import com.yb.loan.pojo.LoanDocuments;
import com.yb.loan.service.LoanDocumentsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yb.base.utils.paging.Pagination;




/**
 * 借款客户资料
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:26
 */
@Api(description = "")
@RestController
@RequestMapping("/loanDocuments")
public class  LoanDocumentsController {
    @Autowired
	private LoanDocumentsService loanDocumentsService;

    @ApiOperation(value = "分页查询")
    @PostMapping("/listPageData.json")
    public PageResponsVO<LoanDocuments> listPageData(LoanDocuments loanDocuments, Pagination pagination){
        PageInfo<LoanDocuments> result = new PageInfo<>();
        result.setList(loanDocumentsService.listPageLoanDocuments(loanDocuments,pagination));
        result.setTotal(pagination.getTotal());
        return BaseRespons.ok(result);
    }
}
 
