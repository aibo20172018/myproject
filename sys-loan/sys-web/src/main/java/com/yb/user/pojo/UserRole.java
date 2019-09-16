
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
public class UserRole implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**/
	private Long userId;
	/**/
	private Long roleId;

	 
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	 
	public Long getUserId() {
		return userId;
	}
	 
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	 
	public Long getRoleId() {
		return roleId;
	}
}
