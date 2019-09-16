package com.yb.loan.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 风控初审
 */
@ApiModel
@Data
public class RiskFirstTrialLoanVo extends InspectLoanVo {
    @ApiModelProperty("风控评分 信用级别 A 100分（含）以上 B 90-99分 C 80-89分 D 70-79分 E 60-69分以下 F 60分以下")
    private String creditLevel;
}
