
package com.yb.user.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@ApiModel
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty("用户编号")
	private Long id;

	private String userName;
	/**/
	private String passWord;
	/**/
	private Date createTime;
	/**/
	private Date updateTime;
	/**/
	private String email;
	/**/
	private String phone;
	@ApiModelProperty("是否锁定 0未锁定1锁定")
	private int lock;

	private List<Role> roles;

	private String type;

	public void setId(Long id) {
		this.id = id;
	}
	 
	public Long getId() {
		return id;
	}
	 
	public void setUserName(String userName) {
		this.userName = userName;
	}
	 
	public String getUserName() {
		return userName;
	}
	 
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	 
	public String getPassWord() {
		return passWord;
	}
	 
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	 
	public Date getCreateTime() {
		return createTime;
	}
	 
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	 
	public Date getUpdateTime() {
		return updateTime;
	}
	 
	public void setEmail(String email) {
		this.email = email;
	}
	 
	public String getEmail() {
		return email;
	}

	public int getLock() {
		return lock;
	}

	public void setLock(int lock) {
		this.lock = lock;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	 
	public String getPhone() {
		return phone;
	}


	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
