package com.liu.bean;

public class Page {

	private int pageNum=1;//��ǰҳ��
	private int pageSize=5;//ÿҳ��ʾ����
	private int pageSum;//��ҳ��
	private int pageTotal;//������
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageSum() {
		this.pageSum=this.pageTotal%this.pageSize==0 ? this.pageTotal/this.pageSize:(this.pageTotal/this.pageSize+1);
		return pageSum;
	}
	public void setPageSum(int pageSum) {
		this.pageSum = pageSum;
	}
	public int getPageTotal() {
		return pageTotal;
	}
	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}
	public Page(int pageNum, int pageSize, int pageSum, int pageTotal) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
		this.pageSum = pageSum;
		this.pageTotal = pageTotal;
	}
	public Page() {
		super();
	}
}
