package com.yb.base.utils.paging;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel
public class Pagination implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final int DEFAULT_PAGE_SIZE=15;
	public static final int DEFAULT_CURRENT_PAGE=1;
	public static final int DEFAULT_SKIP_SIZE=10;
	public static final int DEFAULT_CURRENT_SKIP=1;
	public static final int MAX_PAGE_SIZE=200;

	private int rows = DEFAULT_SKIP_SIZE; //每页显示记录数
	private int total;		//总条目数
	//private int totalResult;	//总记录数
	private int totalPage ; //总页数
	@ApiModelProperty("当前页")
	private int page= DEFAULT_CURRENT_SKIP;	//当前页
	//private int currentResult;	//当前记录起始索引
	@ApiModelProperty("每页显示记录数")
	private int limit = DEFAULT_SKIP_SIZE;

	private int offset;

	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
		totalPage = total%rows ==0 ? total/rows : (total/rows + 1); 		

	}
	public int getPage() {
		if(page<=1)
		{
			return 1;
		}
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}

	public void setLimit(int limit) {
		this.limit = limit;
		this.rows = limit;
	}

	public void setOffset(int offset) {
		this.offset = offset;

		int currentPage = offset == 0 ? 1 : offset;
		// 每页行数
		int showCount = this.limit == 0 ? 10 : this.limit;
		if (currentPage != 0) {
			this.page = currentPage / showCount + 1;
		}
	}

	public int getLimit() {
		return limit;
	}

	public int getOffset() {
		return offset;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
}
