
package com.yb.companyfund.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资方日放款统计表
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class CompanyFundCount implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("日期")
	private String repayTime;

	@ApiModelProperty("资金公司号 000 线下放款 001 钱爸爸 002 同盛小贷 003 保理 004 融资租赁")
	private String companyNo;

	@ApiModelProperty("资金公司名称")
	private String companyName;

	@ApiModelProperty("日放款金额")
	private BigDecimal loanAmunt;

	@ApiModelProperty("备注")
	private String remark;

	 
	public void setRepayTime(String repayTime) {
		this.repayTime = repayTime;
	}
	 
	public String getRepayTime() {
		return repayTime;
	}
	 
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
	 
	public void setLoanAmunt(BigDecimal loanAmunt) {
		this.loanAmunt = loanAmunt;
	}
	 
	public BigDecimal getLoanAmunt() {
		return loanAmunt;
	}
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	 
	public String getRemark() {
		return remark;
	}
}
