
package com.yb.companyfund.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 放款资金方管理
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class CompanyFund implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("资金公司号 000 线下放款 001 钱爸爸 002 同盛小贷 003 保理 004 融资租赁")
	private String companyNo;

	@ApiModelProperty("资金公司名称")
	private String companyName;

	@ApiModelProperty("最大放款总额度")
	private BigDecimal maxLoanAmount;

	@ApiModelProperty("总放款额")
	private BigDecimal loanTotalamunt;

	@ApiModelProperty("资方放款在途总金额")
	private BigDecimal loanWayAmunt;

	@ApiModelProperty("开关 N 开 F 关")
	private String onoff;

	@ApiModelProperty("备注")
	private String remark;

	@ApiModelProperty("公司说明")
	private String companyDesc;

	 
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	 
	public String getCompanyNo() {
		return companyNo;
	}
	 
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	 
	public String getCompanyName() {
		return companyName;
	}
	 
	public void setMaxLoanAmount(BigDecimal maxLoanAmount) {
		this.maxLoanAmount = maxLoanAmount;
	}
	 
	public BigDecimal getMaxLoanAmount() {
		return maxLoanAmount;
	}
	 
	public void setLoanTotalamunt(BigDecimal loanTotalamunt) {
		this.loanTotalamunt = loanTotalamunt;
	}
	 
	public BigDecimal getLoanTotalamunt() {
		return loanTotalamunt;
	}
	 
	public void setLoanWayAmunt(BigDecimal loanWayAmunt) {
		this.loanWayAmunt = loanWayAmunt;
	}
	 
	public BigDecimal getLoanWayAmunt() {
		return loanWayAmunt;
	}
	 
	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}
	 
	public String getOnoff() {
		return onoff;
	}
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	 
	public String getRemark() {
		return remark;
	}
	 
	public void setCompanyDesc(String companyDesc) {
		this.companyDesc = companyDesc;
	}
	 
	public String getCompanyDesc() {
		return companyDesc;
	}
}
