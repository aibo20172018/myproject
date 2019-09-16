
package com.yb.department.pojo;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * 
 * @author ybing
 * @email 746514632@qq.com
 * @date 2019-04-15 22:39:25
 */
@ApiModel
public class SysDepartment implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("部门id")
	private Integer id;

	@ApiModelProperty("部门名称")
	private String depName;

	 
	public void setId(Integer id) {
		this.id = id;
	}
	 
	public Integer getId() {
		return id;
	}
	 
	public void setDepName(String depName) {
		this.depName = depName;
	}
	 
	public String getDepName() {
		return depName;
	}
}
