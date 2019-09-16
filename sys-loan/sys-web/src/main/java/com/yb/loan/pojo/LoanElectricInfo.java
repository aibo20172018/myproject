
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 风控初审电核信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class LoanElectricInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("")
	private Long loanId;

	@ApiModelProperty("电核联系人")
	private String electricCore;

	@ApiModelProperty("联系电话")
	private String phone;

	@ApiModelProperty("是否接通")
	private String isConnect;

	@ApiModelProperty("是否知晓借款")
	private String isKnowLoan;

	@ApiModelProperty("与借款人关系")
	private String loanRelation;

	@ApiModelProperty("电核记录")
	private String electricRecord;

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
	 
	public void setElectricCore(String electricCore) {
		this.electricCore = electricCore;
	}
	 
	public String getElectricCore() {
		return electricCore;
	}
	 
	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	public String getPhone() {
		return phone;
	}
	 
	public void setIsConnect(String isConnect) {
		this.isConnect = isConnect;
	}
	 
	public String getIsConnect() {
		return isConnect;
	}
	 
	public void setIsKnowLoan(String isKnowLoan) {
		this.isKnowLoan = isKnowLoan;
	}
	 
	public String getIsKnowLoan() {
		return isKnowLoan;
	}
	 
	public void setLoanRelation(String loanRelation) {
		this.loanRelation = loanRelation;
	}
	 
	public String getLoanRelation() {
		return loanRelation;
	}
	 
	public void setElectricRecord(String electricRecord) {
		this.electricRecord = electricRecord;
	}
	 
	public String getElectricRecord() {
		return electricRecord;
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
