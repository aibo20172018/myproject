
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 近6个月数据
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class LoanSixdata implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("")
	private Long loanId;

	@ApiModelProperty("1  商品采购 2  下游采购")
	private String dataType;

	@ApiModelProperty("日期（1个月）")
	private String dataTime1;

	@ApiModelProperty("金额1")
	private BigDecimal dataMoney1;

	@ApiModelProperty("日期（2个月）")
	private String dataTime2;

	@ApiModelProperty("金额2")
	private BigDecimal dataMoney2;

	@ApiModelProperty("日期（3个月）")
	private String dataTime3;

	@ApiModelProperty("金额3")
	private BigDecimal dataMoney3;

	@ApiModelProperty("日期（4个月）")
	private String dataTime4;

	@ApiModelProperty("金额4")
	private BigDecimal dataMoney4;

	@ApiModelProperty("日期（5个月）")
	private String dataTime5;

	@ApiModelProperty("金额5")
	private BigDecimal dataMoney5;

	@ApiModelProperty("日期（6个月）")
	private String dataTime6;

	@ApiModelProperty("金额6")
	private BigDecimal dataMoney6;

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
	 
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	 
	public String getDataType() {
		return dataType;
	}
	 
	public void setDataTime1(String dataTime1) {
		this.dataTime1 = dataTime1;
	}
	 
	public String getDataTime1() {
		return dataTime1;
	}
	 
	public void setDataMoney1(BigDecimal dataMoney1) {
		this.dataMoney1 = dataMoney1;
	}
	 
	public BigDecimal getDataMoney1() {
		return dataMoney1;
	}
	 
	public void setDataTime2(String dataTime2) {
		this.dataTime2 = dataTime2;
	}
	 
	public String getDataTime2() {
		return dataTime2;
	}
	 
	public void setDataMoney2(BigDecimal dataMoney2) {
		this.dataMoney2 = dataMoney2;
	}
	 
	public BigDecimal getDataMoney2() {
		return dataMoney2;
	}
	 
	public void setDataTime3(String dataTime3) {
		this.dataTime3 = dataTime3;
	}
	 
	public String getDataTime3() {
		return dataTime3;
	}
	 
	public void setDataMoney3(BigDecimal dataMoney3) {
		this.dataMoney3 = dataMoney3;
	}
	 
	public BigDecimal getDataMoney3() {
		return dataMoney3;
	}
	 
	public void setDataTime4(String dataTime4) {
		this.dataTime4 = dataTime4;
	}
	 
	public String getDataTime4() {
		return dataTime4;
	}
	 
	public void setDataMoney4(BigDecimal dataMoney4) {
		this.dataMoney4 = dataMoney4;
	}
	 
	public BigDecimal getDataMoney4() {
		return dataMoney4;
	}
	 
	public void setDataTime5(String dataTime5) {
		this.dataTime5 = dataTime5;
	}
	 
	public String getDataTime5() {
		return dataTime5;
	}
	 
	public void setDataMoney5(BigDecimal dataMoney5) {
		this.dataMoney5 = dataMoney5;
	}
	 
	public BigDecimal getDataMoney5() {
		return dataMoney5;
	}
	 
	public void setDataTime6(String dataTime6) {
		this.dataTime6 = dataTime6;
	}
	 
	public String getDataTime6() {
		return dataTime6;
	}
	 
	public void setDataMoney6(BigDecimal dataMoney6) {
		this.dataMoney6 = dataMoney6;
	}
	 
	public BigDecimal getDataMoney6() {
		return dataMoney6;
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
