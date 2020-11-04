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
			<a href="/"><img src="//cdn.joara.com/images/common/logo.gif" width="125" height="30" alt="JOARA"></a>
		</h1>
		<div class="webtoon_logo" style="">
			<a href="/">
			<span style="margin-left:20px"><img src="//cdn.joara.com/images/content/webtoon/h2_webso_on.png" alt="웹소설"></span></a>
			<img src="//cdn.joara.com/images/content/webtoon/img_h1bg.gif" alt="" style="margin-left:10px">
                  <!--<a href="http://webtoon.joara.com"><span style="margin-left:10px;"><img src="//cdn.joara.com/images/content/webtoon/h2_webtoon_off.png" alt="웹툰" /></span></a>-->
                  <a href="http://www.joara.com/third_bridge.php?execute_url=http%3A%2F%2Fwebtoon.joara.com%2F"><span style="margin-left:10px;"><img src="//cdn.joara.com/images/content/webtoon/h2_webtoon_renew.png" alt="웹툰"></span></a>
		</div>
		<form name="mainSearchForm" method="get" class="totalSearchArea" action="/search/search.html" onsubmit="return mainSearch(this);">
			<fieldset>
				<legend>통합검색</legend>
				<input type="hidden" name="sl_search" value="book">
				<input type="text" id="search" name="sl_keyword" value="" title="검색어 입력" size="10" class="inputText"><input type="image" src="//cdn.joara.com/images/common/btn/btn_totalSearch.gif" alt="검색">
				<span style="position:relative;"><img src="//cdn.joara.com/images/main/img_beta.gif" alt=""></span>
			</fieldset>
		</form>
		<div class="banner">
			<div id="roll_banner_control" class="pagt" style="z-index:100">
				<strong><span id="cur_roll_banner_count">1</span></strong>/<span id="max_roll_banner_count">2</span><a href="#" onclick="return false" name="prev"><img src="//cdn.joara.com/images/common/btn/btn_prev.gif" alt="이전"></a><a href="#" onclick="return false" name="next"><img src="//cdn.joara.com/images/common/btn/btn_next.gif" alt="다음"></a>
			</div>
			<div class="roll_banner" name="0" style="display:none">
					</div>
			<div class="roll_banner" name="1" style="display:none">
					</div>
			<div class="roll_banner" name="2" style="">
				<span class="random_banner" style="display:none">
				</span>
				<a href="http://banner.joara.com/banner/bannerGoUrl.inc.php?idx=1607&amp;url=http%3A%2F%2Fwww.joara.com%2Fmember%2Fget_mana.html" hidefocus="true" target="_blank">
					<img height="54" src="http://cf.joara.com/banner_file/20130807_123101.gif" width="174" border="0">
				</a>
				<img src="http://banner.joara.com/banner/bannerView.inc.php?idx=1607" style="display:none">
			</div>
			<div class="roll_banner" name="3" style="display:none">
				<span class="random_banner" style="display:none"></span>
				<a href="http://banner.joara.com/banner/bannerGoUrl.inc.php?idx=1708&amp;url=http%3A%2F%2Fwww.joara.com%2Fcs%2Ffaq%2F%3Fcategory1%3Djoara%26category2%3Dmembership" hidefocus="true" target="_blank">
					<img height="54" src="http://cf.joara.com/banner_file/20140328_170116.gif" width="174" border="0">
				</a>
			<img src="http://banner.joara.com/banner/bannerView.inc.php?idx=1708" style="display:none">
			</div>
		</div>
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