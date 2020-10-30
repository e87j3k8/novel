package com.project.novel.vo;

import java.util.Date;

public class ItemsVo extends NovelVo {
	private long itemId;
	private String subtitle;
	private String content;
	private String regDate;
	private long view;
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public String getSubtitle() {
		return subtitle;
	}
	public void setSubtitle(String subtitle) {
		this.subtitle = subtitle;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public long getView() {
		return view;
	}
	public void setView(long view) {
		this.view = view;
	}
	
}
