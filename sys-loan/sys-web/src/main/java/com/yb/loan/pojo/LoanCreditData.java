
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 企业信用数据
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class LoanCreditData implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("")
	private Long loanId;

	@ApiModelProperty("1  企业财务数据 2  人均产值、固定成本支出情况")
	private String comType;

	@ApiModelProperty("项目")
	private String subject;

	@ApiModelProperty("报表数")
	private Integer reportNum;

	@ApiModelProperty("核实数")
	private Integer checkNum;

	@ApiModelProperty("核实依据、方法")
	private String checkRemak;

	@ApiModelProperty("上一年度（万元）")
	private BigDecimal upyearMoney;

	@ApiModelProperty("月均（万元）")
	private BigDecimal monthlyAve;

	@ApiModelProperty("备注1")
	private String remak;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("备注")
	private String remark;

	 
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	 
	public Long getLoanId() {
		return loanId;
	}
	 
	public void setComType(String comType) {
		this.comType = comType;
	}
	 
	public String getComType() {
		return comType;
	}
	 
	public void setSubject(String subject) {
		this.subject = subject;
	}
	 
	public String getSubject() {
		return subject;
	}
	 
	public void setReportNum(Integer reportNum) {
		this.reportNum = reportNum;
	}
	 
	public Integer getReportNum() {
		return reportNum;
	}
	 
	public void setCheckNum(Integer checkNum) {
		this.checkNum = checkNum;
	}
	 
	public Integer getCheckNum() {
		return checkNum;
	}
	 
	public void setCheckRemak(String checkRemak) {
		this.checkRemak = checkRemak;
	}
	 
	public String getCheckRemak() {
		return checkRemak;
	}
	 
	public void setUpyearMoney(BigDecimal upyearMoney) {
		this.upyearMoney = upyearMoney;
	}
	 
	public BigDecimal getUpyearMoney() {
		return upyearMoney;
	}
	 
	public void setMonthlyAve(BigDecimal monthlyAve) {
		this.monthlyAve = monthlyAve;
	}
	 
	public BigDecimal getMonthlyAve() {
		return monthlyAve;
	}
	 
	public void setRemak(String remak) {
		this.remak = remak;
	}
	 
	public String getRemak() {
		return remak;
	}
	 
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 
	public Date getCreateTime() {
		return createTime;
	}
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	 
	public String getRemark() {
		return remark;
	}
}
