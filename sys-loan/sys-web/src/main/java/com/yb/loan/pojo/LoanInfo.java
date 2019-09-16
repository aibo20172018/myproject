
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 借款申请表
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-16 14:16:15
 */
@ApiModel
public class LoanInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("")
	private Long loanId;

	@ApiModelProperty("申请公司基本情况-申请编号")
	private String loanNo;

	@ApiModelProperty("申请日期")
	private String newDate;

	@ApiModelProperty("申请公司基本情况-单位全称")
	private String companyName;

	@ApiModelProperty("申请公司基本情况-法人名称")
	private String legalerName;

	@ApiModelProperty("申请公司基本情况-统一信用代码证")
	private String creditCode;

	@ApiModelProperty("申请公司基本情况-单位省份")
	private String companyProvince;

	@ApiModelProperty("申请公司基本情况-单位市区")
	private String companyCity;

	@ApiModelProperty("申请公司基本情况-单位详细地址")
	private String companyAddress;

	@ApiModelProperty("实际控制人或大股东基本信息实际控制人姓名-借款人姓名")
	private String controllName;

	@ApiModelProperty("实际控制人或大股东基本信息-实际控制人姓名")
	private String gender;

	@ApiModelProperty("实际控制人或大股东基本信息-婚姻状态")
	private String marital;

	@ApiModelProperty("实际控制人或大股东基本信息-最高学历")
	private String education;

	@ApiModelProperty("实际控制人或大股东基本信息-手机")
	private String mobile;

	@ApiModelProperty("实际控制人或大股东基本信息-邮箱")
	private String mail;

	@ApiModelProperty("实际控制人或大股东基本信息-身份证")
	private String idCard;

	@ApiModelProperty("实际控制人或大股东基本信息-证件有效期")
	private String beginCardperiod;

	@ApiModelProperty("实际控制人或大股东基本信息-证件有效期")
	private String endCardperiod;

	@ApiModelProperty("实际控制人或大股东基本信息-居住省份")
	private String houseProvince;

	@ApiModelProperty("实际控制人或大股东基本信息-居住城市")
	private String houseCity;

	@ApiModelProperty("实际控制人或大股东基本信息-户口所在区域")
	private String bookletArea;

	@ApiModelProperty("实际控制人或大股东基本信息-居住详细地址")
	private String houseArea;

	@ApiModelProperty("实际控制人或大股东基本信息-亲属姓名")
	private String familyName;

	@ApiModelProperty("实际控制人或大股东基本信息-关系 1 配偶 2 父母 3 子女 4 兄弟姐妹 5 其他")
	private String relation;

	@ApiModelProperty("实际控制人或大股东基本信息-亲属手机号（如已婚则需填配偶电话，未婚必须填一亲属号码）")
	private String familyMobile;

	@ApiModelProperty("与核心企业-所属核心企业管理区域")
	private String coreCompany;

	@ApiModelProperty("与核心企业-经销区域")
	private String sellArea;

	@ApiModelProperty("与核心企业-经销商名称")
	private String sellName;

	@ApiModelProperty("与核心企业-商户种类 1 专销 2 专营")
	private String businessType;

	@ApiModelProperty("与核心企业-经销商编号")
	private String businessNo;

	@ApiModelProperty("与核心企业-本年度评级")
	private String thisGrade;

	@ApiModelProperty("与核心企业-合作年限")
	private Integer cooperateYear;

	@ApiModelProperty("与核心企业-上年度采购额")
	private BigDecimal upGrade;

	@ApiModelProperty("与核心企业-上年度合同目标额")
	private BigDecimal upContractMoney;

	@ApiModelProperty("与下游采购商-下游合作数量")
	private Integer downCooperateNum;

	@ApiModelProperty("与下游采购商-上年度核心企业产品销售额")
	private BigDecimal upCoreCompanyMoney;

	@ApiModelProperty("与下游采购商-下游合作产品")
	private String cooperateProduct;

	@ApiModelProperty("与下游采购商-结算方式 1 现付 2 短赊 3 月结__天")
	private String balanceWay;

	@ApiModelProperty("贷款事项-申请授信额度")
	private BigDecimal creditMoney;

	@ApiModelProperty("贷款事项-申请期限")
	private Integer period;

	@ApiModelProperty("贷款事项-贷款用途")
	private String loanPurposeUse;

	@ApiModelProperty("贷款事项-银行账号")
	private String acctNo;

	@ApiModelProperty("贷款事项-开户银行")
	private String bankName;

	@ApiModelProperty("贷款事项-开户支行")
	private String bankSubname;

	@ApiModelProperty("贷款事项-开户名称")
	private String lendingName;

	@ApiModelProperty("补充资料-员工人数")
	private Integer staffNum;

	@ApiModelProperty("补充资料-目前行业从业年限")
	private Integer tradeYear;

	@ApiModelProperty("补充资料-经营场地地址")
	private String premises;

	@ApiModelProperty("补充资料-经营场地使用年限")
	private Integer premisesYear;

	@ApiModelProperty("补充资料-有无配置车辆")
	private String isCar;

	@ApiModelProperty("补充资料-配送车辆数")
	private Integer carNum;

	@ApiModelProperty("补充资料-有无仓库")
	private String isWarehouse;

	@ApiModelProperty("补充资料-仓库数")
	private Integer warehouseNum;

	@ApiModelProperty("补充资料-仓库地址（仓库地址与仓库数匹配")
	private String warehouseAddress;

	@ApiModelProperty("补充资料-子女数量")
	private Integer childrenNum;

	@ApiModelProperty("补充资料-房产数量")
	private Integer houseNum;

	@ApiModelProperty("补充资料-自有房产所在地")
	private String houseAddress;

	@ApiModelProperty("补充资料-1 自购商品房(本人/配偶名下） 2 租赁 3 自建房 4 父母或亲戚的房子 5 其它")
	private String houseType;

	@ApiModelProperty("补充资料-1 已付全款 2 按揭　")
	private String mortgageType;

	@ApiModelProperty("补充资料-合同期限")
	private Integer contractPeriod;

	@ApiModelProperty("补充资料-月租")
	private Integer monthlyRent;

	@ApiModelProperty("补充资料-其他经营状况")
	private String stateOperation;

	@ApiModelProperty("补充资料-是否经营其他业务")
	private String isRunbusiness;

	@ApiModelProperty("补充资料-其他业务年营业额")
	private BigDecimal otherTurnover;

	@ApiModelProperty("补充资料-备注")
	private String remark;

	@ApiModelProperty("补充资料-信用情况")
	private String creditStanding;

	@ApiModelProperty("业务初审建议-申请金额")
	private BigDecimal loanMoney;

	@ApiModelProperty("业务初审建议-建议金额")
	private BigDecimal adviseMoney;

	@ApiModelProperty("业务初审建议-建议期限")
	private Integer advisePeriod;

	@ApiModelProperty("业务初审建议-贷款利率")
	private BigDecimal loadRate;

	@ApiModelProperty("业务初审建议-还款方式")
	private String repayType;

	@ApiModelProperty("业务初审建议-考察时间")
	private String reviewTime;

	@ApiModelProperty("业务初审建议-考察员id")
	private String reviewId;

	@ApiModelProperty("业务初审建议-考察员")
	private String reviewOfficer;

	@ApiModelProperty("状态 1 录入4 准入核实 6 现场考察 8 风控初审通过 12 风控复审通过（待终审）36 已完成 55 拒绝")
	private String status;

	@ApiModelProperty("拒单渠道+拒单原因")
	private String refusalRemark;

	@ApiModelProperty("现场调查备注")
	private String fieldSurveyRemark;

	@ApiModelProperty("上一期经销商评级")
	private String upDealerGrade;

	@ApiModelProperty("当前经销商评级")
	private String currentDealerGrade;

	@ApiModelProperty("风险点分析及其他说明")
	private String riskRemark;

	@ApiModelProperty("初审审批结果 1  通过 2  拒绝 3  驳回")
	private String examResult;

	@ApiModelProperty("初审审批意见")
	private String examRemark;

	@ApiModelProperty("初审授信金额")
	private BigDecimal examMoney;

	@ApiModelProperty("初审期限")
	private Integer examPeriod;

	@ApiModelProperty("初审利率")
	private BigDecimal examRate;

	@ApiModelProperty("初审还款方式")
	private String examRepayType;

	@ApiModelProperty("初审放款条件及担保措施")
	private String examConditions;

	@ApiModelProperty("初审拒绝/驳回原因")
	private String examRefuse;

	@ApiModelProperty("初审拒绝子原因/驳回意见")
	private String examSonRefuse;

	@ApiModelProperty("复审拒绝/驳回原因")
	private String reviewRefuse;

	@ApiModelProperty("复审拒绝子原因/驳回意见")
	private String reviewSonRefuse;

	@ApiModelProperty("补充人id")
	private Long supplyId;

	@ApiModelProperty("补充时间")
	private Date supplyTime;

	@ApiModelProperty("初审人")
	private Long trialId;

	@ApiModelProperty("初审时间")
	private Date trialTime;

	@ApiModelProperty("复审人")
	private Long recheckId;

	@ApiModelProperty("复审时间")
	private Date recheckTime;

	@ApiModelProperty("创建时间")
	private Date createTime;

	 
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
	 
	public void setNewDate(String newDate) {
		this.newDate = newDate;
	}
	 
	public String getNewDate() {
		return newDate;
	}
	 
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	 
	public String getCompanyName() {
		return companyName;
	}
	 
	public void setLegalerName(String legalerName) {
		this.legalerName = legalerName;
	}
	 
	public String getLegalerName() {
		return legalerName;
	}
	 
	public void setCreditCode(String creditCode) {
		this.creditCode = creditCode;
	}
	 
	public String getCreditCode() {
		return creditCode;
	}
	 
	public void setCompanyProvince(String companyProvince) {
		this.companyProvince = companyProvince;
	}
	 
	public String getCompanyProvince() {
		return companyProvince;
	}
	 
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	 
	public String getCompanyCity() {
		return companyCity;
	}
	 
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}
	 
	public String getCompanyAddress() {
		return companyAddress;
	}
	 
	public void setControllName(String controllName) {
		this.controllName = controllName;
	}
	 
	public String getControllName() {
		return controllName;
	}
	 
	public void setGender(String gender) {
		this.gender = gender;
	}
	 
	public String getGender() {
		return gender;
	}
	 
	public void setMarital(String marital) {
		this.marital = marital;
	}
	 
	public String getMarital() {
		return marital;
	}
	 
	public void setEducation(String education) {
		this.education = education;
	}
	 
	public String getEducation() {
		return education;
	}
	 
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	 
	public String getMobile() {
		return mobile;
	}
	 
	public void setMail(String mail) {
		this.mail = mail;
	}
	 
	public String getMail() {
		return mail;
	}
	 
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	 
	public String getIdCard() {
		return idCard;
	}
	 
	public void setBeginCardperiod(String beginCardperiod) {
		this.beginCardperiod = beginCardperiod;
	}
	 
	public String getBeginCardperiod() {
		return beginCardperiod;
	}
	 
	public void setEndCardperiod(String endCardperiod) {
		this.endCardperiod = endCardperiod;
	}
	 
	public String getEndCardperiod() {
		return endCardperiod;
	}
	 
	public void setHouseProvince(String houseProvince) {
		this.houseProvince = houseProvince;
	}
	 
	public String getHouseProvince() {
		return houseProvince;
	}
	 
	public void setHouseCity(String houseCity) {
		this.houseCity = houseCity;
	}
	 
	public String getHouseCity() {
		return houseCity;
	}
	 
	public void setBookletArea(String bookletArea) {
		this.bookletArea = bookletArea;
	}
	 
	public String getBookletArea() {
		return bookletArea;
	}
	 
	public void setHouseArea(String houseArea) {
		this.houseArea = houseArea;
	}
	 
	public String getHouseArea() {
		return houseArea;
	}
	 
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	 
	public String getFamilyName() {
		return familyName;
	}
	 
	public void setRelation(String relation) {
		this.relation = relation;
	}
	 
	public String getRelation() {
		return relation;
	}
	 
	public void setFamilyMobile(String familyMobile) {
		this.familyMobile = familyMobile;
	}
	 
	public String getFamilyMobile() {
		return familyMobile;
	}
	 
	public void setCoreCompany(String coreCompany) {
		this.coreCompany = coreCompany;
	}
	 
	public String getCoreCompany() {
		return coreCompany;
	}
	 
	public void setSellArea(String sellArea) {
		this.sellArea = sellArea;
	}
	 
	public String getSellArea() {
		return sellArea;
	}
	 
	public void setSellName(String sellName) {
		this.sellName = sellName;
	}
	 
	public String getSellName() {
		return sellName;
	}
	 
	public void setBusinessType(String businessType) {
		this.businessType = businessType;
	}
	 
	public String getBusinessType() {
		return businessType;
	}
	 
	public void setBusinessNo(String businessNo) {
		this.businessNo = businessNo;
	}
	 
	public String getBusinessNo() {
		return businessNo;
	}
	 
	public void setThisGrade(String thisGrade) {
		this.thisGrade = thisGrade;
	}
	 
	public String getThisGrade() {
		return thisGrade;
	}
	 
	public void setCooperateYear(Integer cooperateYear) {
		this.cooperateYear = cooperateYear;
	}
	 
	public Integer getCooperateYear() {
		return cooperateYear;
	}
	 
	public void setUpGrade(BigDecimal upGrade) {
		this.upGrade = upGrade;
	}
	 
	public BigDecimal getUpGrade() {
		return upGrade;
	}
	 
	public void setUpContractMoney(BigDecimal upContractMoney) {
		this.upContractMoney = upContractMoney;
	}
	 
	public BigDecimal getUpContractMoney() {
		return upContractMoney;
	}
	 
	public void setDownCooperateNum(Integer downCooperateNum) {
		this.downCooperateNum = downCooperateNum;
	}
	 
	public Integer getDownCooperateNum() {
		return downCooperateNum;
	}
	 
	public void setUpCoreCompanyMoney(BigDecimal upCoreCompanyMoney) {
		this.upCoreCompanyMoney = upCoreCompanyMoney;
	}
	 
	public BigDecimal getUpCoreCompanyMoney() {
		return upCoreCompanyMoney;
	}
	 
	public void setCooperateProduct(String cooperateProduct) {
		this.cooperateProduct = cooperateProduct;
	}
	 
	public String getCooperateProduct() {
		return cooperateProduct;
	}
	 
	public void setBalanceWay(String balanceWay) {
		this.balanceWay = balanceWay;
	}
	 
	public String getBalanceWay() {
		return balanceWay;
	}
	 
	public void setCreditMoney(BigDecimal creditMoney) {
		this.creditMoney = creditMoney;
	}
	 
	public BigDecimal getCreditMoney() {
		return creditMoney;
	}
	 
	public void setPeriod(Integer period) {
		this.period = period;
	}
	 
	public Integer getPeriod() {
		return period;
	}
	 
	public void setLoanPurposeUse(String loanPurposeUse) {
		this.loanPurposeUse = loanPurposeUse;
	}
	 
	public String getLoanPurposeUse() {
		return loanPurposeUse;
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
	 
	public void setStaffNum(Integer staffNum) {
		this.staffNum = staffNum;
	}
	 
	public Integer getStaffNum() {
		return staffNum;
	}
	 
	public void setTradeYear(Integer tradeYear) {
		this.tradeYear = tradeYear;
	}
	 
	public Integer getTradeYear() {
		return tradeYear;
	}
	 
	public void setPremises(String premises) {
		this.premises = premises;
	}
	 
	public String getPremises() {
		return premises;
	}
	 
	public void setPremisesYear(Integer premisesYear) {
		this.premisesYear = premisesYear;
	}
	 
	public Integer getPremisesYear() {
		return premisesYear;
	}
	 
	public void setIsCar(String isCar) {
		this.isCar = isCar;
	}
	 
	public String getIsCar() {
		return isCar;
	}
	 
	public void setCarNum(Integer carNum) {
		this.carNum = carNum;
	}
	 
	public Integer getCarNum() {
		return carNum;
	}
	 
	public void setIsWarehouse(String isWarehouse) {
		this.isWarehouse = isWarehouse;
	}
	 
	public String getIsWarehouse() {
		return isWarehouse;
	}
	 
	public void setWarehouseNum(Integer warehouseNum) {
		this.warehouseNum = warehouseNum;
	}
	 
	public Integer getWarehouseNum() {
		return warehouseNum;
	}
	 
	public void setWarehouseAddress(String warehouseAddress) {
		this.warehouseAddress = warehouseAddress;
	}
	 
	public String getWarehouseAddress() {
		return warehouseAddress;
	}
	 
	public void setChildrenNum(Integer childrenNum) {
		this.childrenNum = childrenNum;
	}
	 
	public Integer getChildrenNum() {
		return childrenNum;
	}
	 
	public void setHouseNum(Integer houseNum) {
		this.houseNum = houseNum;
	}
	 
	public Integer getHouseNum() {
		return houseNum;
	}
	 
	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}
	 
	public String getHouseAddress() {
		return houseAddress;
	}
	 
	public void setHouseType(String houseType) {
		this.houseType = houseType;
	}
	 
	public String getHouseType() {
		return houseType;
	}
	 
	public void setMortgageType(String mortgageType) {
		this.mortgageType = mortgageType;
	}
	 
	public String getMortgageType() {
		return mortgageType;
	}
	 
	public void setContractPeriod(Integer contractPeriod) {
		this.contractPeriod = contractPeriod;
	}
	 
	public Integer getContractPeriod() {
		return contractPeriod;
	}
	 
	public void setMonthlyRent(Integer monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	 
	public Integer getMonthlyRent() {
		return monthlyRent;
	}
	 
	public void setStateOperation(String stateOperation) {
		this.stateOperation = stateOperation;
	}
	 
	public String getStateOperation() {
		return stateOperation;
	}
	 
	public void setIsRunbusiness(String isRunbusiness) {
		this.isRunbusiness = isRunbusiness;
	}
	 
	public String getIsRunbusiness() {
		return isRunbusiness;
	}
	 
	public void setOtherTurnover(BigDecimal otherTurnover) {
		this.otherTurnover = otherTurnover;
	}
	 
	public BigDecimal getOtherTurnover() {
		return otherTurnover;
	}
	 
	public void setRemark(String remark) {
		this.remark = remark;
	}
	 
	public String getRemark() {
		return remark;
	}
	 
	public void setCreditStanding(String creditStanding) {
		this.creditStanding = creditStanding;
	}
	 
	public String getCreditStanding() {
		return creditStanding;
	}
	 
	public void setLoanMoney(BigDecimal loanMoney) {
		this.loanMoney = loanMoney;
	}
	 
	public BigDecimal getLoanMoney() {
		return loanMoney;
	}
	 
	public void setAdviseMoney(BigDecimal adviseMoney) {
		this.adviseMoney = adviseMoney;
	}
	 
	public BigDecimal getAdviseMoney() {
		return adviseMoney;
	}
	 
	public void setAdvisePeriod(Integer advisePeriod) {
		this.advisePeriod = advisePeriod;
	}
	 
	public Integer getAdvisePeriod() {
		return advisePeriod;
	}
	 
	public void setLoadRate(BigDecimal loadRate) {
		this.loadRate = loadRate;
	}
	 
	public BigDecimal getLoadRate() {
		return loadRate;
	}
	 
	public void setRepayType(String repayType) {
		this.repayType = repayType;
	}
	 
	public String getRepayType() {
		return repayType;
	}
	 
	public void setReviewTime(String reviewTime) {
		this.reviewTime = reviewTime;
	}
	 
	public String getReviewTime() {
		return reviewTime;
	}
	 
	public void setReviewId(String reviewId) {
		this.reviewId = reviewId;
	}
	 
	public String getReviewId() {
		return reviewId;
	}
	 
	public void setReviewOfficer(String reviewOfficer) {
		this.reviewOfficer = reviewOfficer;
	}
	 
	public String getReviewOfficer() {
		return reviewOfficer;
	}
	 
	public void setStatus(String status) {
		this.status = status;
	}
	 
	public String getStatus() {
		return status;
	}
	 
	public void setRefusalRemark(String refusalRemark) {
		this.refusalRemark = refusalRemark;
	}
	 
	public String getRefusalRemark() {
		return refusalRemark;
	}
	 
	public void setFieldSurveyRemark(String fieldSurveyRemark) {
		this.fieldSurveyRemark = fieldSurveyRemark;
	}
	 
	public String getFieldSurveyRemark() {
		return fieldSurveyRemark;
	}
	 
	public void setUpDealerGrade(String upDealerGrade) {
		this.upDealerGrade = upDealerGrade;
	}
	 
	public String getUpDealerGrade() {
		return upDealerGrade;
	}
	 
	public void setCurrentDealerGrade(String currentDealerGrade) {
		this.currentDealerGrade = currentDealerGrade;
	}
	 
	public String getCurrentDealerGrade() {
		return currentDealerGrade;
	}
	 
	public void setRiskRemark(String riskRemark) {
		this.riskRemark = riskRemark;
	}
	 
	public String getRiskRemark() {
		return riskRemark;
	}
	 
	public void setExamResult(String examResult) {
		this.examResult = examResult;
	}
	 
	public String getExamResult() {
		return examResult;
	}
	 
	public void setExamRemark(String examRemark) {
		this.examRemark = examRemark;
	}
	 
	public String getExamRemark() {
		return examRemark;
	}
	 
	public void setExamMoney(BigDecimal examMoney) {
		this.examMoney = examMoney;
	}
	 
	public BigDecimal getExamMoney() {
		return examMoney;
	}
	 
	public void setExamPeriod(Integer examPeriod) {
		this.examPeriod = examPeriod;
	}
	 
	public Integer getExamPeriod() {
		return examPeriod;
	}
	 
	public void setExamRate(BigDecimal examRate) {
		this.examRate = examRate;
	}
	 
	public BigDecimal getExamRate() {
		return examRate;
	}
	 
	public void setExamRepayType(String examRepayType) {
		this.examRepayType = examRepayType;
	}
	 
	public String getExamRepayType() {
		return examRepayType;
	}
	 
	public void setExamConditions(String examConditions) {
		this.examConditions = examConditions;
	}
	 
	public String getExamConditions() {
		return examConditions;
	}
	 
	public void setExamRefuse(String examRefuse) {
		this.examRefuse = examRefuse;
	}
	 
	public String getExamRefuse() {
		return examRefuse;
	}
	 
	public void setExamSonRefuse(String examSonRefuse) {
		this.examSonRefuse = examSonRefuse;
	}
	 
	public String getExamSonRefuse() {
		return examSonRefuse;
	}
	 
	public void setReviewRefuse(String reviewRefuse) {
		this.reviewRefuse = reviewRefuse;
	}
	 
	public String getReviewRefuse() {
		return reviewRefuse;
	}
	 
	public void setReviewSonRefuse(String reviewSonRefuse) {
		this.reviewSonRefuse = reviewSonRefuse;
	}
	 
	public String getReviewSonRefuse() {
		return reviewSonRefuse;
	}
	 
	public void setSupplyId(Long supplyId) {
		this.supplyId = supplyId;
	}
	 
	public Long getSupplyId() {
		return supplyId;
	}
	 
	public void setSupplyTime(Date supplyTime) {
		this.supplyTime = supplyTime;
	}
	 
	public Date getSupplyTime() {
		return supplyTime;
	}
	 
	public void setTrialId(Long trialId) {
		this.trialId = trialId;
	}
	 
	public Long getTrialId() {
		return trialId;
	}
	 
	public void setTrialTime(Date trialTime) {
		this.trialTime = trialTime;
	}
	 
	public Date getTrialTime() {
		return trialTime;
	}
	 
	public void setRecheckId(Long recheckId) {
		this.recheckId = recheckId;
	}
	 
	public Long getRecheckId() {
		return recheckId;
	}
	 
	public void setRecheckTime(Date recheckTime) {
		this.recheckTime = recheckTime;
	}
	 
	public Date getRecheckTime() {
		return recheckTime;
	}
	 
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 
	public Date getCreateTime() {
		return createTime;
	}
}
