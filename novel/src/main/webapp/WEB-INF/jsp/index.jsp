<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<link rel="stylesheet" type="text/css" href="/resources/css/main.css">
<script src="/resources/js/main.js"></script>
<div id="main" class="content">
	<div id="rankingTop" class="rankingTop">
	</div>
</div>
<template id="rankingTopTemplate">
	<h2>랭킹TOP5</h2>
	<ul>
		{{#each data}}
		<li>
			<a href="/products/view/{{novelId}}">
				<div class="idx">
					<span>{{index @index}}</span>
					<span>위</span>
				</div>
				<div class="title">{{title}}</div>
			</a>
		</li>
		{{/each}}
	</ul>
</template>