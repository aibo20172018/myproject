
package com.yb.user.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@ApiModel
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("角色id")
	private Long id;
	@ApiModelProperty("角色名称")
	private String roleName;

	private List<Resources> resourcesList;

	 
	public void setId(Long id) {
		this.id = id;
	}
	 
	public Long getId() {
		return id;
	}
	 
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	 
	public String getRoleName() {
		return roleName;
	}

	public List<Resources> getResourcesList() {
		return resourcesList;
	}

	public void setResourcesList(List<Resources> resourcesList) {
		this.resourcesList = resourcesList;
	}
}
