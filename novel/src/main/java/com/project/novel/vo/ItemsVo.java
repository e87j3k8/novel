package com.project.novel.vo;

import java.util.Date;

public class ItemsVo {
	private long itemId;
	private long novelId;
	private String subtitle;
	private String content;
	private Date regDate;
	public long getItemId() {
		return itemId;
	}
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	public long getNovelId() {
		return novelId;
	}
	public void setNovelId(long novelId) {
		this.novelId = novelId;
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
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
}
