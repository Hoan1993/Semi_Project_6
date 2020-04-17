<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>빠루들고 찾아가기</title>
</head>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* #map {
	position: absolute;
	margin: auto;
} */

.container {
	width: 960px;
	
	padding-top: 3px;
    padding-right: 15px;
    padding-left: 15px;
    margin: 0 auto 0 auto;
    margin-right: auto;
    margin-left: auto;
    
}

.news-main {
	float:left;
	padding: 30px 15px 15px 0;
}

.side-carousel {
	margin-bottom: 15px;
}

.glyphicon {
	vertical-align: middle;
}

.news-cont {
	padding-left: 10px;
}

ul {
   list-style:none;
 }
 
 
.table-style table-col {
	border-collapse: collapse;
	text-align: left;
	line-height: 1.5;
	border-top: 3px solid #369;
	margin: 20px 10px; 
} 

.table-style table-col th {
	width: 147px;
	padding: 10px;
	font-weight: bold;
	vertical-align: top;
	color: #153d73;
	border-right: 1px solid #ccc;
	border- botton: 1px: solid #ccc;
	
}

.table-style table-col td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-right: 1px solid #ccc;
    border-bottom: 1px solid #ccc;
}
 
 
 
 
table.type07 {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;
    border: 1px solid #ccc;
    margin: 20px 10px;
}
table.type07 thead {
    border-right: 1px solid #ccc;
    border-left: 1px solid #ccc;
    background: #a0a0a0;
    
}
table.type07 thead th {
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    color: #fff;
    width: 200px;
}
table.type07 tbody th {
    width: 150px;
    padding: 10px;
    font-weight: bold;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
    background: #fcf1f4;
    width: 200px;
}
table.type07 td {
    width: 350px;
    padding: 10px;
    vertical-align: top;
    border-bottom: 1px solid #ccc;
} 
 
</style>

<body>


<%@ include file="../include/header.jsp"%>
<%-- <div style="float: right;">
		<%@ include file="../include/sidebar.jsp"%></div> --%>
		
<div class="container">		
	<div class="col-md-9 news-main">
	<div class="news-cont">
	<ul>
		<li>
		<div id="map" style="width:800px;height:450px; margin:auto;">
		</div>
		</li>
		<li>
			<ul class="txt-style">
			<li>
				<!-- <strong>교통편</strong> -->
			</li>
			</ul>
		</li>
		<li>
		<table class="type07">
		<caption><strong>TheEarlyTimes 교통편</strong></caption>
    		<thead>
   				 <tr>
    			    <th scope="cols">노선</th>
    			    <th scope="cols">승차정류장</th>
    			    <th scope="cols">하차정류장</th>
 			   </tr>
   			 </thead>
   			 <tbody>
   			 	<tr>
     			   <th scope="row">셔틀버스(오전 7시)</th>
      			   <td>용산역 </td>
      			   <td>서교빌딩</td>
  			    </tr>
   				 <tr>
     			   <th scope="row">661</th>
      			   <td>부천북부역</td>
      			   <td>서교빌딩</td>
  			    </tr>
    			<tr>
        			<th scope="row">5, 7729</th>
        			<td>용산역</td>
        			<td>서교빌딩</td>
    			</tr>
    			<tr>
        			<th scope="row">2호선 홍대입구역</th>
        			<td>-</td>
        			<td>1번 출구, 도보 10분</td>
    			</tr>
    		</tbody>
		</table>
		</li>
		<br /><br />
		
		<li>
			&nbsp;&nbsp;<strong>※주차지원 불가 </strong>
		
		</li>
	</ul>
	</div>
	
	
	</div>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<div class="col-md-3 news-side">
			<%-- <div class="side-carousel">
				<%@ include file="../include/sidebar_carousel.jsp"%></div> --%>
			
			<div></div>
			<br />
			<div class="side-list">
				<%@ include file="../include/sidebar.jsp"%></div>
	</div>
</div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=afd9ba36cfbaa6d5c4fddfcca110465c&libraries=services"></script>
<script>
var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
    mapOption = {
        center: new kakao.maps.LatLng(33.450701, 126.570667), // 지도의 중심좌표
        level: 3 // 지도의 확대 레벨
    };  

// 지도를 생성합니다    
var map = new kakao.maps.Map(mapContainer, mapOption); 

// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 마포구 서교동 447-5 풍성빌딩', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

        // 결과값으로 받은 위치를 마커로 표시합니다
        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">TheEarlyTimes 본사</div>'
        });
        infowindow.open(map, marker);

        // 지도의 중심을 결과값으로 받은 위치로 이동시킵니다
        map.setCenter(coords);
    } 
});    
</script>
</body>
</html>