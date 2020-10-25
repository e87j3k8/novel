<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<div class="content">
	<div class="productList">
		<c:forEach items="${ list }" var="list">
		<ul>
			<li>${ list.title }</li>
		</ul>
		</c:forEach>
	</div>
</div>