package com.project.novel.vo;

public class NovelVo extends UserVo{
	private long novelId;
	private long authorId;
	private String title;
	private String genre;
	private String genre2;
	private long like;
	private long dislike;
	private long viewAll;
	private String regDt;
	
	public long getNovelId() {
		return novelId;
	}
	public void setNovelId(long novelId) {
		this.novelId = novelId;
	}
	public long getAuthorId() {
		return authorId;
	}
	public void setAuthorId(long authorId) {
		this.authorId = authorId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getGenre2() {
		return genre2;
	}
	public void setGenre2(String genre2) {
		this.genre2 = genre2;
	}
	public long getLike() {
		return like;
	}
	public void setLike(long like) {
		this.like = like;
	}
	public long getDislike() {
		return dislike;
	}
	public void setDislike(long dislike) {
		this.dislike = dislike;
	}
	public long getViewAll() {
		return viewAll;
	}
	public void setViewAll(long viewAll) {
		this.viewAll = viewAll;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	
	
}
