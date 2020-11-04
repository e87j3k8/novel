<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/product.css">
<div class="content">
	<c:if test="${ not empty genreList }">
	<div class="genreNav">
		<ul>
			<c:forEach var="genre" items="${ genreList }">
			<li>
				<a href="/products/genre/${genre.genreId }">
					<span>${ genre.genreNm }</span>
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	</c:if>
	<div class="productList">
		<ul>
			<c:forEach items="${ list }" var="list">
			<li>
				<a href="/products/view/${ list.novelId }">
				<table>
					<tr>
						<td class="novelGenre">
							<span>[${ list.genre }]</span>
							<c:if test="${ not empty list.genre2 }">
							<span>[${ list.genre2 }]</span>
							</c:if>
						</td>
					</tr>
					<tr>
						<td>
							<c:if test="${ isNew eq true }">
							<span class="isNew">UPDATE!</span>
							</c:if>
							<span class="authorNm">${ list.authorNm }</span>
							<span>-</span>
							<span class="novelTitle">${ list.title }</span>
						</td>
					</tr>
					<tr>
						<td>
							<span>조회수 : ${ list.viewAll }</span>
							<span>좋아요 : ${ list.like }</span>
							<span>싫어요 : ${ list.dislike }</span>
						</td>
					</tr>
				</table>
				</a>
			</li>
			</c:forEach>
		</ul>
	</div>
	<c:if test="${ last gt 1 }">
	<div class="page">
		<ul>
			<c:if test="${ page gt view }">
			<li class="arrowBtn">
				<a href="/products/all?page=${ start-1 }">&lt;</a>
			</li>
			</c:if>
			<c:forEach var="i" begin="${ start }" end="${ end }">
			<li class="pgNum <c:if test="${ i eq page }">now</c:if>">
				<a href="/products/all?page=${ i }">${ i }</a>
			</li>
			</c:forEach>
			<c:if test="${ end lt last }">
			<li class="arrowBtn">
				<a href="/products/all?page=${ end+1 }">&gt;</a>
			</li>
			</c:if>
		</ul>
	</div>
	</c:if>
</div>
