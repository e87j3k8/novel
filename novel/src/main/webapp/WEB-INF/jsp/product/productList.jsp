<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css" href="/resources/css/product.css">
<!-- <script src="/resources/js/main.js"></script> -->
<div class="content">
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
</div>