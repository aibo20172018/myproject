
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 征信历史
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class LoanCreditHist implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("loan_id")
	private Long loanId;

	@ApiModelProperty("报告类型 1  信用 2  抵押 3  担保 4 总数")
	private String reportType;

	@ApiModelProperty("融资来源")
	private String loanSrc;

	@ApiModelProperty("贷款金额")
	private BigDecimal loanMoney;

	@ApiModelProperty("期限（月）")
	private Integer loanPeriod;

	@ApiModelProperty("用途")
	private String loanPurpose;

	@ApiModelProperty("发放日期")
	private Date loanTime;

	@ApiModelProperty("到期日期")
	private Date dueTime;

	@ApiModelProperty("月还款额")
	private BigDecimal repayMoney;

	@ApiModelProperty("贷款余额")
	private BigDecimal loanBalance;

	@ApiModelProperty("逾期1期以内")
	private Integer withinOverdue1;

	@ApiModelProperty("逾期2期以内")
	private Integer withinOverdue2;

	@ApiModelProperty("逾期3期以内")
	private Integer withinOverdue3;

	@ApiModelProperty("逾期4期以内")
	private Integer withinOverdue4;

	@ApiModelProperty("逾期5期及以上")
	private Integer aboveOverdue5;

	@ApiModelProperty("贷款总笔数")
	private Integer loanTotalnum;

	@ApiModelProperty("贷款总金额")
	private BigDecimal loanTotalmoney;

	@ApiModelProperty("贷款总余额")
	private BigDecimal loanTotalbalance;

	@ApiModelProperty("月总还款额")
	private BigDecimal repayTotalmoney;

	@ApiModelProperty("近两年贷款总逾期次数")
	private Integer overdueTotalnum;

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
	 
	public void setReportType(String reportType) {
		this.reportType = reportType;
	}
	 
	public String getReportType() {
		return reportType;
	}
	 
	public void setLoanSrc(String loanSrc) {
		this.loanSrc = loanSrc;
	}
	 
	public String getLoanSrc() {
		return loanSrc;
	}
	 
	public void setLoanMoney(BigDecimal loanMoney) {
		this.loanMoney = loanMoney;
	}
	 
	public BigDecimal getLoanMoney() {
		return loanMoney;
	}
	 
	public void setLoanPeriod(Integer loanPeriod) {
		this.loanPeriod = loanPeriod;
	}
	 
	public Integer getLoanPeriod() {
		return loanPeriod;
	}
	 
	public void setLoanPurpose(String loanPurpose) {
		this.loanPurpose = loanPurpose;
	}
	 
	public String getLoanPurpose() {
		return loanPurpose;
	}
	 
	public void setLoanTime(Date loanTime) {
		this.loanTime = loanTime;
	}
	 
	public Date getLoanTime() {
		return loanTime;
	}
	 
	public void setDueTime(Date dueTime) {
		this.dueTime = dueTime;
	}
	 
	public Date getDueTime() {
		return dueTime;
	}
	 
	public void setRepayMoney(BigDecimal repayMoney) {
		this.repayMoney = repayMoney;
	}
	 
	public BigDecimal getRepayMoney() {
		return repayMoney;
	}
	 
	public void setLoanBalance(BigDecimal loanBalance) {
		this.loanBalance = loanBalance;
	}
	 
	public BigDecimal getLoanBalance() {
		return loanBalance;
	}
	 
	public void setWithinOverdue1(Integer withinOverdue1) {
		this.withinOverdue1 = withinOverdue1;
	}
	 
	public Integer getWithinOverdue1() {
		return withinOverdue1;
	}
	 
	public void setWithinOverdue2(Integer withinOverdue2) {
		this.withinOverdue2 = withinOverdue2;
	}
	 
	public Integer getWithinOverdue2() {
		return withinOverdue2;
	}
	 
	public void setWithinOverdue3(Integer withinOverdue3) {
		this.withinOverdue3 = withinOverdue3;
	}
	 
	public Integer getWithinOverdue3() {
		return withinOverdue3;
	}
	 
	public void setWithinOverdue4(Integer withinOverdue4) {
		this.withinOverdue4 = withinOverdue4;
	}
	 
	public Integer getWithinOverdue4() {
		return withinOverdue4;
	}
	 
	public void setAboveOverdue5(Integer aboveOverdue5) {
		this.aboveOverdue5 = aboveOverdue5;
	}
	 
	public Integer getAboveOverdue5() {
		return aboveOverdue5;
	}
	 
	public void setLoanTotalnum(Integer loanTotalnum) {
		this.loanTotalnum = loanTotalnum;
	}
	 
	public Integer getLoanTotalnum() {
		return loanTotalnum;
	}
	 
	public void setLoanTotalmoney(BigDecimal loanTotalmoney) {
		this.loanTotalmoney = loanTotalmoney;
	}
	 
	public BigDecimal getLoanTotalmoney() {
		return loanTotalmoney;
	}
	 
	public void setLoanTotalbalance(BigDecimal loanTotalbalance) {
		this.loanTotalbalance = loanTotalbalance;
	}
	 
	public BigDecimal getLoanTotalbalance() {
		return loanTotalbalance;
	}
	 
	public void setRepayTotalmoney(BigDecimal repayTotalmoney) {
		this.repayTotalmoney = repayTotalmoney;
	}
	 
	public BigDecimal getRepayTotalmoney() {
		return repayTotalmoney;
	}
	 
	public void setOverdueTotalnum(Integer overdueTotalnum) {
		this.overdueTotalnum = overdueTotalnum;
	}
	 
	public Integer getOverdueTotalnum() {
		return overdueTotalnum;
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
