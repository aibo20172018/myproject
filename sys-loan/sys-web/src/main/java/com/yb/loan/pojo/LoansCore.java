
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 借款核心信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-16 16:04:15
 */
@ApiModel
public class LoansCore implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("loan_id")
	private Long loanId;

	@ApiModelProperty("申请公司基本情况-申请编号 ")
	private String loanNo;

	@ApiModelProperty("产品类型")
	private String productType;

	@ApiModelProperty("复审金额")
	private BigDecimal approvalAmount;

	@ApiModelProperty("复审期限")
	private Integer approvalPeriod;

	@ApiModelProperty("复审利率")
	private BigDecimal interestRate;

	@ApiModelProperty("复审还款方式 1 等额本息 2 先息后本 3 等本等息 4 等本等息-保证金")
	private String repayType;

	@ApiModelProperty("复审时间")
	private Date approvalTime;

	@ApiModelProperty("放款条件及担保措施")
	private String approvalConditions;

	@ApiModelProperty("复审审批意见")
	private String approvalRemark;

	@ApiModelProperty("银行审批金额")
	private BigDecimal bankAmount;

	@ApiModelProperty("银行审批期限")
	private Integer bankPeriod;

	@ApiModelProperty("银行审批利率")
	private BigDecimal bankRate;

	@ApiModelProperty("银行还款方式 1 等额本息 2 先息后本 3 等本等息")
	private String bankRepayType;

	@ApiModelProperty("复审时间")
	private Date bankApprovalTime;

	@ApiModelProperty("还款信息")
	private Date bankLoanTime;

	@ApiModelProperty("推送时间")
	private Date pushTime;

	@ApiModelProperty("计息时间")
	private Date interestTime;

	@ApiModelProperty("还款信息")
	private Date repayStartTime;

	@ApiModelProperty("还款信息")
	private Date repayLastTime;

	@ApiModelProperty("结清期数")
	private Integer advancePeriod;

	@ApiModelProperty("还款信息")
	private String realRepayEndTime;

	@ApiModelProperty("资金公司号/放款渠道 000 红岭创投")
	private String companyNo;

	@ApiModelProperty("银行账号")
	private String acctNo;

	@ApiModelProperty("开户银行")
	private String bankName;

	@ApiModelProperty("开户支行")
	private String bankSubname;

	@ApiModelProperty("开户名称")
	private String lendingName;

	@ApiModelProperty("居间费费率 3%")
	private BigDecimal rateIntermediaryfee;

	@ApiModelProperty("居间费实收总金额 3%")
	private BigDecimal realIntermediaryfee;

	@ApiModelProperty("保证金费率 3%")
	private BigDecimal rateIntermediaryfee2;

	@ApiModelProperty("保证金实收总金额 3%")
	private BigDecimal realIntermediaryfee2;

	@ApiModelProperty("1  代扣 2  转账")
	private String repayChannel;

	@ApiModelProperty("状态 1  资方待终审 2  资方审核通过（待签约）3  签约审核通过（放款中）4  放款成功 5  放款失败 6  资方审核失败")
	private String status;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("备注")
	private String remark;

	@ApiModelProperty("签约人id")
	private Long signId;

	@ApiModelProperty("签约时间")
	private Date signTime;

	@ApiModelProperty("签约复核人id")
	private Long signcheckId;

	@ApiModelProperty("签约复核时间")
	private Date signcheckTime;

	@ApiModelProperty("财务确认人id")
	private Long financeId;

	@ApiModelProperty("财务确认时间")
	private Date financeTime;

	 
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	 
	public Long getLoanId() {
		return loanId;
	}
	 
	public void setLoanNo(String loanNo) {
		this.loanNo = loanNo;
	}
	 
	public String getLoanNo() {
		return loanNo;
	}
	 
	public void setProductType(String productType) {
		this.productType = productType;
	}
	 
	public String getProductType() {
		return productType;
	}
	 
	public void setApprovalAmount(BigDecimal approvalAmount) {
		this.approvalAmount = approvalAmount;
	}
	 
	public BigDecimal getApprovalAmount() {
		return approvalAmount;
	}
	 
	public void setApprovalPeriod(Integer approvalPeriod) {
		this.approvalPeriod = approvalPeriod;
	}
	 
	public Integer getApprovalPeriod() {
		return approvalPeriod;
	}
	 
	public void setInterestRate(BigDecimal interestRate) {
		this.interestRate = interestRate;
	}
	 
	public BigDecimal getInterestRate() {
		return interestRate;
	}
	 
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	 
	public String getRepayType() {
		return repayType;
	}
	 
	public void setApprovalTime(Date approvalTime) {
		this.approvalTime = approvalTime;
	}
	 
	public Date getApprovalTime() {
		return approvalTime;
	}
	 
	public void setApprovalConditions(String approvalConditions) {
		this.approvalConditions = approvalConditions;
	}
	 
	public String getApprovalConditions() {
		return approvalConditions;
	}
	 
	public void setApprovalRemark(String approvalRemark) {
		this.approvalRemark = approvalRemark;
	}
	 
	public String getApprovalRemark() {
		return approvalRemark;
	}
	 
	public void setBankAmount(BigDecimal bankAmount) {
		this.bankAmount = bankAmount;
	}
	 
	public BigDecimal getBankAmount() {
		return bankAmount;
	}
	 
	public void setBankPeriod(Integer bankPeriod) {
		this.bankPeriod = bankPeriod;
	}
	 
	public Integer getBankPeriod() {
		return bankPeriod;
	}
	 
	public void setBankRate(BigDecimal bankRate) {
		this.bankRate = bankRate;
	}
	 
	public BigDecimal getBankRate() {
		return bankRate;
	}
	 
	public void setBankRepayType(String bankRepayType) {
		this.bankRepayType = bankRepayType;
	}
	 
	public String getBankRepayType() {
		return bankRepayType;
	}
	 
	public void setBankApprovalTime(Date bankApprovalTime) {
		this.bankApprovalTime = bankApprovalTime;
	}
	 
	public Date getBankApprovalTime() {
		return bankApprovalTime;
	}
	 
	public void setBankLoanTime(Date bankLoanTime) {
		this.bankLoanTime = bankLoanTime;
	}
	 
	public Date getBankLoanTime() {
		return bankLoanTime;
	}
	 
	public void setPushTime(Date pushTime) {
		this.pushTime = pushTime;
	}
	 
	public Date getPushTime() {
		return pushTime;
	}
	 
	public void setInterestTime(Date interestTime) {
		this.interestTime = interestTime;
	}
	 
	public Date getInterestTime() {
		return interestTime;
	}
	 
	public void setRepayStartTime(Date repayStartTime) {
		this.repayStartTime = repayStartTime;
	}
	 
	public Date getRepayStartTime() {
		return repayStartTime;
	}
	 
	public void setRepayLastTime(Date repayLastTime) {
		this.repayLastTime = repayLastTime;
	}
	 
	public Date getRepayLastTime() {
		return repayLastTime;
	}
	 
	public void setAdvancePeriod(Integer advancePeriod) {
		this.advancePeriod = advancePeriod;
	}
	 
	public Integer getAdvancePeriod() {
		return advancePeriod;
	}
	 
	public void setRealRepayEndTime(String realRepayEndTime) {
		this.realRepayEndTime = realRepayEndTime;
	}
	 
	public String getRealRepayEndTime() {
		return realRepayEndTime;
	}
	 
	public void setCompanyNo(String companyNo) {
		this.companyNo = companyNo;
	}
	 
	public String getCompanyNo() {
		return companyNo;
	}
	 
	public void setAcctNo(String acctNo) {
		this.acctNo = acctNo;
	}
	 
	public String getAcctNo() {
		return acctNo;
	}
	 
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	 
	public String getBankName() {
		return bankName;
	}
	 
	public void setBankSubname(String bankSubname) {
		this.bankSubname = bankSubname;
	}
	 
	public String getBankSubname() {
		return bankSubname;
	}
	 
	public void setLendingName(String lendingName) {
		this.lendingName = lendingName;
	}
	 
	public String getLendingName() {
		return lendingName;
	}
	 
	public void setRateIntermediaryfee(BigDecimal rateIntermediaryfee) {
		this.rateIntermediaryfee = rateIntermediaryfee;
	}
	 
	public BigDecimal getRateIntermediaryfee() {
		return rateIntermediaryfee;
	}
	 
	public void setRealIntermediaryfee(BigDecimal realIntermediaryfee) {
		this.realIntermediaryfee = realIntermediaryfee;
	}
	 
	public BigDecimal getRealIntermediaryfee() {
		return realIntermediaryfee;
	}
	 
	public void setRateIntermediaryfee2(BigDecimal rateIntermediaryfee2) {
		this.rateIntermediaryfee2 = rateIntermediaryfee2;
	}
	 
	public BigDecimal getRateIntermediaryfee2() {
		return rateIntermediaryfee2;
	}
	 
	public void setRealIntermediaryfee2(BigDecimal realIntermediaryfee2) {
		this.realIntermediaryfee2 = realIntermediaryfee2;
	}
	 
	public BigDecimal getRealIntermediaryfee2() {
		return realIntermediaryfee2;
	}
	 
	public void setRepayChannel(String repayChannel) {
		this.repayChannel = repayChannel;
	}
	 
	public String getRepayChannel() {
		return repayChannel;
	}
	 
	public void setStatus(String status) {
		this.status = status;
	}
	 
	public String getStatus() {
		return status;
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
	 
	public void setSignId(Long signId) {
		this.signId = signId;
	}
	 
	public Long getSignId() {
		return signId;
	}
	 
	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}
	 
	public Date getSignTime() {
		return signTime;
	}
	 
	public void setSigncheckId(Long signcheckId) {
		this.signcheckId = signcheckId;
	}
	 
	public Long getSigncheckId() {
		return signcheckId;
	}
	 
	public void setSigncheckTime(Date signcheckTime) {
		this.signcheckTime = signcheckTime;
	}
	 
	public Date getSigncheckTime() {
		return signcheckTime;
	}
	 
	public void setFinanceId(Long financeId) {
		this.financeId = financeId;
	}
	 
	public Long getFinanceId() {
		return financeId;
	}
	 
	public void setFinanceTime(Date financeTime) {
		this.financeTime = financeTime;
	}
	 
	public Date getFinanceTime() {
		return financeTime;
	}
}
