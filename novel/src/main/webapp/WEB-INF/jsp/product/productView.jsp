<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet" type="text/css" href="/resources/css/product.css">
<script src="/resources/js/novel.js"></script>
<div id="novel" class="content">
	<div class="novelInfo">
		<div>
			<span>[${ novel.genre }]</span>
			<c:if test="${ not empty novel.genre2 }">
			<span>[${ novel.genre2 }]</span>
			</c:if>
			<span class="title">${ novel.title }</span>
		</div>
		<div class="author">
			<span>작가 </span>
			<span>${ novel.authorNm }</span>
		</div>
		<div>
			<button id="like" class="recommend">
				<span>좋아요 : </span>
				<span class="cnt">${ novel.like }</span>
			</button>
			<button id="dislike" class="recommend">
				<span>싫어요 : </span>
				<span class="cnt">${ novel.dislike }</span>
			</button>
		</div>
	</div>
	<div class="itemList">
		<ul>
			<c:forEach var="list" items="${ list }" varStatus="status">
			<li>
				<a href="/item/${list.itemId}">
					<span class="idx">${ status.count }</span>
					<span class="subtitle">${ list.subtitle }</span>
					<span class="view">
						<span>조회수: </span>
						<span>${ list.view }</span>
					</span>
					<span class="regDt">${ list.regDate }</span>
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	
</div>