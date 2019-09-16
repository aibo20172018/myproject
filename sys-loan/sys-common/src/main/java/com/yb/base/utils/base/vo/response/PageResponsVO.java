package com.yb.base.utils.base.vo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel("分页结果")
public class PageResponsVO <T>   implements Serializable{
	private static final long serialVersionUID = 2354881465436907718L;

	@ApiModelProperty("状态0成功1失败")
	protected int code = 0;

	@ApiModelProperty("结果集")
	protected List<T> data;

	@ApiModelProperty("每页多少条")
	protected int pageSize;

	@ApiModelProperty("页数")
	protected int pageNumber;

	@ApiModelProperty("总记录数")
	protected int count = 0;
	
	public PageResponsVO(int pageNumber,int pageSize,int count,List<T> list) {
		this.pageSize = pageSize;
		this.pageNumber = pageNumber;
		this.count = count;
		this.data=list;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		if(data != null && data.size()>0){
			this.data = data;
		}else {
			this.code = 1;
		}
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}
}
