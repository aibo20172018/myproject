
package com.yb.loan.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 借款客户资料
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:26
 */
@ApiModel
public class LoanDocuments implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("")
	private String uuid;

	@ApiModelProperty("")
	private Long loanId;

	@ApiModelProperty("文档类型（1级父节点）")
	private Integer fileTypeParent;

	@ApiModelProperty("文件名称（1级）")
	private String fileNameParent;

	@ApiModelProperty("文档类型（2级子节点）")
	private Integer fileTypeSon;

	@ApiModelProperty("文件名称（2级）")
	private String fileNameSon;

	@ApiModelProperty("文件大小,单位为kb")
	private Integer fileSize;

	@ApiModelProperty("保存的路径")
	private String fileUrl;

	@ApiModelProperty("创建人/上传人")
	private Long createUser;

	@ApiModelProperty("用于显示排序")
	private Integer orders;

	@ApiModelProperty("创建时间")
	private Date createTime;

	@ApiModelProperty("备注")
	private String remark;

	 
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	 
	public String getUuid() {
		return uuid;
	}
	 
	public void setLoanId(Long loanId) {
		this.loanId = loanId;
	}
	 
	public Long getLoanId() {
		return loanId;
	}
	 
	public void setFileTypeParent(Integer fileTypeParent) {
		this.fileTypeParent = fileTypeParent;
	}
	 
	public Integer getFileTypeParent() {
		return fileTypeParent;
	}
	 
	public void setFileNameParent(String fileNameParent) {
		this.fileNameParent = fileNameParent;
	}
	 
	public String getFileNameParent() {
		return fileNameParent;
	}
	 
	public void setFileTypeSon(Integer fileTypeSon) {
		this.fileTypeSon = fileTypeSon;
	}
	 
	public Integer getFileTypeSon() {
		return fileTypeSon;
	}
	 
	public void setFileNameSon(String fileNameSon) {
		this.fileNameSon = fileNameSon;
	}
	 
	public String getFileNameSon() {
		return fileNameSon;
	}
	 
	public void setFileSize(Integer fileSize) {
		this.fileSize = fileSize;
	}
	 
	public Integer getFileSize() {
		return fileSize;
	}
	 
	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}
	 
	public String getFileUrl() {
		return fileUrl;
	}
	 
	public void setCreateUser(Long createUser) {
		this.createUser = createUser;
	}
	 
	public Long getCreateUser() {
		return createUser;
	}
	 
	public void setOrders(Integer orders) {
		this.orders = orders;
	}
	 
	public Integer getOrders() {
		return orders;
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
