package com.yb.loan.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * 申请表录单
 */
@ApiModel()
@Data
public class LoanInfoVo {

    @NotNull(message = "借款人姓名不能为空")
    @Length(max = 10)
    @ApiModelProperty("借款人姓名")
    private String controllName;

    @NotNull
    @ApiModelProperty("核心企业")
    private String companyName;

    @NotNull
    @ApiModelProperty("经销商名称")
    private String sellName;

    @NotNull
    @ApiModelProperty("经销商区域")
    private String sellArea;

    @NotNull
    @ApiModelProperty("手机号")
    private String mobile;

    @NotNull
    @ApiModelProperty("验证码")
    private String code;

}
