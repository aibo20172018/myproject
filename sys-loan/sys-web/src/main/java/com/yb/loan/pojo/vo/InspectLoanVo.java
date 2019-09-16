package com.yb.loan.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 考察
 */
@ApiModel
public class InspectLoanVo extends FirstTrialLoanVo {

    @ApiModelProperty("考察员编号")
    private String reviewId;

    @ApiModelProperty("考察员")
    private String reviewOfficer;
}
