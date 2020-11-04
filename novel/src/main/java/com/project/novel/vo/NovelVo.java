package com.project.novel.vo;

public class NovelVo {
	private static final int VIEWPAGE = 5; 
	private long novelId;
	private long authorId;
	private String authorNm;
	private String title;
	private String genre;
	private String genre2;
	private int genreCode;
	private long like;
	private long dislike;
	private long viewAll;
	private String regDt;
	private boolean isNew;
	
	/* 검색조건 임시 */
	private int page;
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	/* 검색조건 임시 */
	
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
	public String getAuthorNm() {
		return authorNm;
	}
	public void setAuthorNm(String authorNm) {
		this.authorNm = authorNm;
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
	public int getGenreCode() {
		return genreCode;
	}
	public void setGenreCode(int genreCode) {
		this.genreCode = genreCode;
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
	public boolean isNew() {
		return isNew;
	}
	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}
	public int getVIEWPAGE() {
		return VIEWPAGE;
	}
	
}
