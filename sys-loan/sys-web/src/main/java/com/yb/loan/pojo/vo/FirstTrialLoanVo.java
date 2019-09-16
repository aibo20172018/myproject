package com.yb.loan.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 录入，准入核实订单
 */
@ApiModel
@Data
public class FirstTrialLoanVo {

    @ApiModelProperty("序号")
    private String loanNo;

    @ApiModelProperty("核心企业")
    private String companyName;

    @ApiModelProperty("借款人姓名")
    private String controllName;

    @ApiModelProperty("借款人手机号")
    private String mobile;

    @ApiModelProperty("经销商名称")
    private String sellName;

    @ApiModelProperty("申请金额（万元）")
    private String creditMoney;

    @ApiModelProperty("申请期限")
    private int period;

    private Date createTime;

    @ApiModelProperty("1 录入 4 准入核实 6现场考擦 8风控初审通过")
    private String status;

    private String remark;

    private Date startTime;

    private Date endTime;
}
