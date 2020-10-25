<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="t" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="fn" uri = "http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>웹노블</title>
<link rel="stylesheet" type="text/css" href="/resources/css/common.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/handlebars@latest/dist/handlebars.js"></script>
<script src="/resources/js/handlebars.custom.js"></script>
</head>
<body>
	<t:insertAttribute name="header" />
	<div id="content">
		<t:insertAttribute name="body" />
	</div>
	<t:insertAttribute name="footer" />
</body>
</html>