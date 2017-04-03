package com.obao.util;

import java.util.List;

public class PageModel<T> {
	private long totalRecords;// 总记录数据
	private List<T> list;// 结果集
	private long pageNo;// 当前页
	private long PageSize;// 每一页显示多少数据

	/**
	 * 取得第一页
	 *
	 * @return
	 */
	public long getTopPageNo() {
		return 1;
	}

	/**
	 * 取得上一页
	 *
	 * @return
	 */
	public long getPreviousPageNo() {
		if (pageNo <= 1) {
			return 1;
		} else {
			return pageNo - 1;
		}

	}

	/**
	 * 取得下一页
	 *
	 * @return
	 */
	public long getNextPageNo() {
		if (pageNo >= getTotalPages()) {
			return getTotalPages() == 0 ? 1 : getTotalPages();
		}
		return pageNo + 1;
	}

	/**
	 * 取得最后一页
	 *
	 * @return
	 */
	public long getBottomPageNo() {
		return getTotalPages() == 0 ? 1 : getTotalPages();
	}
	/**
	 * 取得总页数
	 * @return
	 */
	public long getTotalPages() {
		return (totalRecords + PageSize - 1) / PageSize;
	}
	/**
	 * 开始索引下标
	 * @return
	 */
	public long beginLimit(){
		if (pageNo >= getTotalPages()) {
			pageNo=getTotalPages();
		}
		return PageSize*(pageNo-1);
	}
	/**
	 * end索引下标
	 * @return
	 */
	public long endLimit(){
		return getPageSize()*getPageNo()-1;
	}
	public long getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(long totalRecords) {
		this.totalRecords = totalRecords;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public long getPageNo() {
		return pageNo;
	}

	public void setPageNo(long pageNo) {
		this.pageNo = pageNo;
	}

	public long getPageSize() {
		return PageSize;
	}

	public void setPageSize(long pageSize) {
		PageSize = pageSize;
	}

}
