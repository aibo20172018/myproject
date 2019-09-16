
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 还款计划
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class RepaymentPlans implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("还款流水")
	private Long repaymentSq;

	@ApiModelProperty("借款id")
	private Long loanId;

	@ApiModelProperty("申请编号 二代系统独有")
	private String loanNo;

	@ApiModelProperty("合同编号")
	private String contractNo;

	@ApiModelProperty("产品类型")
	private String productType;

	@ApiModelProperty("还款人用户id")
	private Long repayUserid;

	@ApiModelProperty("还款期数")
	private Integer planNo;

	@ApiModelProperty("应还款时间")
	private Date repayTime;

	@ApiModelProperty("还款日（节假日顺延）")
	private Date repayHolidaytime;

	@ApiModelProperty("还款总额")
	private BigDecimal repayTotalmoney;

	@ApiModelProperty("应还款本金 应还本金=以合同金额按ppmt公式计算（除最后一期）；最后一期应还本金=上期剩余本金")
	private BigDecimal repayMoney;

	@ApiModelProperty("应还款利息 应还利息=剩余本金*月利率")
	private BigDecimal repayInterest;

	@ApiModelProperty("应还居间服务费 合同金额*月期收比例（居间）")
	private BigDecimal repayIntermediaryfee;

	@ApiModelProperty("应还提前还款手续费")
	private BigDecimal repayAdvancePenaltyfee;

	@ApiModelProperty("剩余本金")
	private BigDecimal remainPrincipal;

	@ApiModelProperty("剩余总本息 (方便计算罚息)")
	private BigDecimal remainMoneyinterest;

	@ApiModelProperty("提前结清金额 提前结清金额=剩余本金+应还利息（当期）+提前还款违约金-退费")
	private BigDecimal advanceMoney;

	@ApiModelProperty("实还款时间")
	private Date realRepayTime;

	@ApiModelProperty("实还款本金")
	private BigDecimal realMoeny;

	@ApiModelProperty("实还款利息")
	private BigDecimal realInterest;

	@ApiModelProperty("实还居间服务费")
	private BigDecimal realIntermediaryfee;

	@ApiModelProperty("实还提前还款违约金 合同金额*1%；注：第一期、第二期、最后一期无提前还款违约金")
	private BigDecimal realAdvancePenaltyfee;

	@ApiModelProperty("逾期天数")
	private Integer overdueDay;

	@ApiModelProperty("逾期违约金 剩余本息*天数*0.1％")
	private BigDecimal overdueMoney;

	@ApiModelProperty("是否提前结清 0 未结清 1 正常结清 2 提前结清")
	private String isAdvance;

	@ApiModelProperty("还款状态 0 未还款 1 准备还款 2 还款中 3 已还款")
	private String status;

	@ApiModelProperty("扫描时间")
	private Date loopTime;

	@ApiModelProperty("创建时间")
	private Date createdTime;

	@ApiModelProperty("备注")
	private String remark;

	 
	public void setRepaymentSq(Long repaymentSq) {
		this.repaymentSq = repaymentSq;
	}
	 
	public Long getRepaymentSq() {
		return repaymentSq;
	}
	 
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
	 
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	 
	public String getContractNo() {
		return contractNo;
	}
	 
	public void setProductType(String productType) {
		this.productType = productType;
	}
	 
	public String getProductType() {
		return productType;
	}
	 
	public void setRepayUserid(Long repayUserid) {
		this.repayUserid = repayUserid;
	}
	 
	public Long getRepayUserid() {
		return repayUserid;
	}
	 
	public void setPlanNo(Integer planNo) {
		this.planNo = planNo;
	}
	 
	public Integer getPlanNo() {
		return planNo;
	}
	 
	public void setRepayTime(Date repayTime) {
		this.repayTime = repayTime;
	}
	 
	public Date getRepayTime() {
		return repayTime;
	}
	 
	public void setRepayHolidaytime(Date repayHolidaytime) {
		this.repayHolidaytime = repayHolidaytime;
	}
	 
	public Date getRepayHolidaytime() {
		return repayHolidaytime;
	}
	 
	public void setRepayTotalmoney(BigDecimal repayTotalmoney) {
		this.repayTotalmoney = repayTotalmoney;
	}
	 
	public BigDecimal getRepayTotalmoney() {
		return repayTotalmoney;
	}
	 
	public void setRepayMoney(BigDecimal repayMoney) {
		this.repayMoney = repayMoney;
	}
	 
	public BigDecimal getRepayMoney() {
		return repayMoney;
	}
	 
	public void setRepayInterest(BigDecimal repayInterest) {
		this.repayInterest = repayInterest;
	}
	 
	public BigDecimal getRepayInterest() {
		return repayInterest;
	}
	 
	public void setRepayIntermediaryfee(BigDecimal repayIntermediaryfee) {
		this.repayIntermediaryfee = repayIntermediaryfee;
	}
	 
	public BigDecimal getRepayIntermediaryfee() {
		return repayIntermediaryfee;
	}
	 
	public void setRepayAdvancePenaltyfee(BigDecimal repayAdvancePenaltyfee) {
		this.repayAdvancePenaltyfee = repayAdvancePenaltyfee;
	}
	 
	public BigDecimal getRepayAdvancePenaltyfee() {
		return repayAdvancePenaltyfee;
	}
	 
	public void setRemainPrincipal(BigDecimal remainPrincipal) {
		this.remainPrincipal = remainPrincipal;
	}
	 
	public BigDecimal getRemainPrincipal() {
		return remainPrincipal;
	}
	 
	public void setRemainMoneyinterest(BigDecimal remainMoneyinterest) {
		this.remainMoneyinterest = remainMoneyinterest;
	}
	 
	public BigDecimal getRemainMoneyinterest() {
		return remainMoneyinterest;
	}
	 
	public void setAdvanceMoney(BigDecimal advanceMoney) {
		this.advanceMoney = advanceMoney;
	}
	 
	public BigDecimal getAdvanceMoney() {
		return advanceMoney;
	}
	 
	public void setRealRepayTime(Date realRepayTime) {
		this.realRepayTime = realRepayTime;
	}
	 
	public Date getRealRepayTime() {
		return realRepayTime;
	}
	 
	public void setRealMoeny(BigDecimal realMoeny) {
		this.realMoeny = realMoeny;
	}
	 
	public BigDecimal getRealMoeny() {
		return realMoeny;
	}
	 
	public void setRealInterest(BigDecimal realInterest) {
		this.realInterest = realInterest;
	}
	 
	public BigDecimal getRealInterest() {
		return realInterest;
	}
	 
	public void setRealIntermediaryfee(BigDecimal realIntermediaryfee) {
		this.realIntermediaryfee = realIntermediaryfee;
	}
	 
	public BigDecimal getRealIntermediaryfee() {
		return realIntermediaryfee;
	}
	 
	public void setRealAdvancePenaltyfee(BigDecimal realAdvancePenaltyfee) {
		this.realAdvancePenaltyfee = realAdvancePenaltyfee;
	}
	 
	public BigDecimal getRealAdvancePenaltyfee() {
		return realAdvancePenaltyfee;
	}
	 
	public void setOverdueDay(Integer overdueDay) {
		this.overdueDay = overdueDay;
	}
	 
	public Integer getOverdueDay() {
		return overdueDay;
	}
	 
	public void setOverdueMoney(BigDecimal overdueMoney) {
		this.overdueMoney = overdueMoney;
	}
	 
	public BigDecimal getOverdueMoney() {
		return overdueMoney;
	}
	 
	public void setIsAdvance(String isAdvance) {
		this.isAdvance = isAdvance;
	}
	 
	public String getIsAdvance() {
		return isAdvance;
	}
	 
	public void setStatus(String status) {
		this.status = status;
	}
	 
	public String getStatus() {
		return status;
	}
	 
	public void setLoopTime(Date loopTime) {
		this.loopTime = loopTime;
	}
	 
	public Date getLoopTime() {
		return loopTime;
	}
	 
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}
	 
	public Date getCreatedTime() {
		return createdTime;
	}
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	 
	public String getRemark() {
		return remark;
	}
}
