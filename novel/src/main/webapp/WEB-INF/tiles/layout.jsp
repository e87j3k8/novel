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
</head>

<body>
	<t:insertAttribute name="header" />
	<t:insertAttribute name="body" />
	<t:insertAttribute name="footer" />
</body>
</html>