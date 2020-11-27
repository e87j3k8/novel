<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<header id="header">
	<div style="width:990px; margin:0 auto; overflow:hidden; position:relative">
		<style>
			.webtoon_logo{float:left;margin-top:32px}
			.webtoon_logo img{vertical-align:middle}
		</style>
		<h1 style="margin-top:25px;">
			<a href="/">
				<img src="" width="125" height="30" alt="">
			</a>
		</h1>
		<form name="mainSearchForm" method="get" class="totalSearchArea" action="" onsubmit="">
			<fieldset>
				<legend>통합검색</legend>
				<input type="hidden" name="sl_search" value="book">
				<input type="text" id="search" name="sl_keyword" value="" title="검색어 입력" size="10" class="inputText">
				<input type="submit" alt="검색">
			</fieldset>
		</form>
	</div>
	<div class="category">
		<ul>
			<li>
				<a href="/products/all">
					<span>전체작품</span>
				</a>
			</li>
			<li>
				<a href="/products/genre/1">
					<span>작품장르별</span>
				</a>
			</li>
			<%-- <li>
				<a href="/products/ranking">
					<span>작품랭킹별</span>
				</a>
			</li> --%>
		</ul>
	</div>
</header>