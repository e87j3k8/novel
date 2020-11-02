<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="/resources/css/item.css">
<script src="/resources/js/item.js"></script>
<div class="content">
	<div class="itemInfo">
		<div class="subtitle">
			<h3>${ item.subtitle }</h3>
		</div>
		<div class="itemContent">
			${item.content }
		</div>
	</div>
</div>