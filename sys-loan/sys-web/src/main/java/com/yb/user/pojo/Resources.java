
package com.yb.user.pojo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 
 * 
 * @author ybing
 * @email 
 * @date 2018-09-12 11:25:16
 */
@ApiModel
public class Resources implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**/
	@ApiModelProperty(notes = "编号")
	private Long id;

	@ApiModelProperty(notes = "名称")
	private String name;

	private String url;

	@ApiModelProperty(notes = "权限描述")
	private String permission;

	@ApiModelProperty(notes = "父编号")
	private Long pId;

	@ApiModelProperty(notes = "资源类型 0（菜单）1（按钮）")
	private String type;

	@ApiModelProperty(notes = "排序")
	private int sort;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public Long getpId() {
		return pId;
	}

	public void setpId(Long pId) {
		this.pId = pId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}
}
