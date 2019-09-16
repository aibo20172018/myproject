package com.yb.loan.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * 风控复审
 */
@ApiModel
@Data
public class RiskReviewLoanVo extends RiskFirstTrialLoanVo {

    @ApiModelProperty("初审建议金额")
    private BigDecimal adviseMoney;

    @ApiModelProperty("初审建议期限")
    private BigDecimal advisePeriod;
}
