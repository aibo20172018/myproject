
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 大数据信息
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class LoanBigdataInfo implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("")
	private Long loanId;

	@ApiModelProperty("大数据类型")
	private String bigdataType;

	@ApiModelProperty("报告编号")
	private String reportNo;

	@ApiModelProperty("身份证归属地")
	private String idcardQcellcore;

	@ApiModelProperty("手机号归属地")
	private String phoneQcellcore;

	@ApiModelProperty("数据说明")
	private String bigdataRemark;

	@ApiModelProperty("报告生成时间")
	private Date reportTime;

	@ApiModelProperty("报告路径")
	private String reportPath;

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
	 
	public void setBigdataType(String bigdataType) {
		this.bigdataType = bigdataType;
	}
	 
	public String getBigdataType() {
		return bigdataType;
	}
	 
	public void setReportNo(String reportNo) {
		this.reportNo = reportNo;
	}
	 
	public String getReportNo() {
		return reportNo;
	}
	 
	public void setIdcardQcellcore(String idcardQcellcore) {
		this.idcardQcellcore = idcardQcellcore;
	}
	 
	public String getIdcardQcellcore() {
		return idcardQcellcore;
	}
	 
	public void setPhoneQcellcore(String phoneQcellcore) {
		this.phoneQcellcore = phoneQcellcore;
	}
	 
	public String getPhoneQcellcore() {
		return phoneQcellcore;
	}
	 
	public void setBigdataRemark(String bigdataRemark) {
		this.bigdataRemark = bigdataRemark;
	}
	 
	public String getBigdataRemark() {
		return bigdataRemark;
	}
	 
	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}
	 
	public Date getReportTime() {
		return reportTime;
	}
	 
	public void setReportPath(String reportPath) {
		this.reportPath = reportPath;
	}
	 
	public String getReportPath() {
		return reportPath;
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
