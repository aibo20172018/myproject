
package com.yb.user.pojo;
import java.io.Serializable;
import java.util.Date;
import java.math.BigDecimal;

/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
public class RoleResources implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**/
	private Long roleId;
	/**/
	private Long resourcesId;

	 
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	 
	public Long getRoleId() {
		return roleId;
	}
	 
	public void setResourcesId(Long resourcesId) {
		this.resourcesId = resourcesId;
	}
	 
	public Long getResourcesId() {
		return resourcesId;
	}
}
