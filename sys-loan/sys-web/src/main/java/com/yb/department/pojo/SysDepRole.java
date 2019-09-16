
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
public class SysDepRole implements Serializable {
	private static final long serialVersionUID = 1L;
	

	@ApiModelProperty("角色id")
	private Integer roleId;

	@ApiModelProperty("部门id")
	private Integer depId;

	 
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	 
	public Integer getRoleId() {
		return roleId;
	}
	 
	public void setDepId(Integer depId) {
		this.depId = depId;
	}
	 
	public Integer getDepId() {
		return depId;
	}
}
