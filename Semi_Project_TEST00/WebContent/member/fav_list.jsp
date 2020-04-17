<%@page import="com.sist.model.FavoriteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.20/css/dataTables.bootstrap.min.css">
<script src="https://cdn.datatables.net/1.10.20/js/jquery.dataTables.min.js"></script>
<script src="https://cdn.datatables.net/1.10.20/js/dataTables.bootstrap.min.js"></script>
<style type="text/css">
div.container {
	width: 100%;
}

thead > tr > th {
	font-weight: normal;
	color: #fff;
	background-color: #337ab7;
    border-color: #2e6da4;
}

tr > * {
	text-align: center;
}

#favCont {
	border-top: 0px;
}

</style>

<script type="text/javascript">
$(document).ready(function() {
   $('#favTable').DataTable( {
       ajax: {
		type: "POST", 
		url: "${pageContext.request.contextPath }/fav_data.do",
		data : {
			domain : window.location.href,
			email : "${sessionScope.loginUser.getMem_email() }"
				},
           dataType: "json"
       },
        columns: [
        	{ data: "number" },
            { data: "article" },
            { data: "date" },
            { data: "delete" }
        ],
        columnDefs: [
            {
                targets: "_all",
                className: 'dt-center'
            }
          ]
   });
});

function favDelete(no) {
	if("${sessionScope.loginUser.getMem_email() }"=="${param.email }") {
	   $.ajax({
			type : "post",
			url : "./fav_delete.do",
			data : {
				no : no
			},
			success :
				function(data){
					alert(data)
					location.reload();
				},
			error : function(){
			}
		});
	}else {
		alert("본인의 댓글만 삭제할 수 있습니다.")
	}
}
</script>
</head>
<body>
<div id="favCont" class="panel panel-info">
<div id="favBody" class="panel-body">
<table id="favTable" class="table table-bordered hover" style="width:100%">
    <thead>
        <tr>
            <th class="col-sm-2" style="padding-right: 8px; padding-left: 8px;">번    호</th>
            <th class="col-sm-5" style="padding-right: 8px; padding-left: 8px;">게 시 물</th>
            <th class="col-sm-3" style="padding-right: 8px; padding-left: 8px;">등 록 일</th>
            <th class="col-sm-2" style="padding-right: 8px; padding-left: 8px;">삭    제</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Row 1 Data 0</td>
            <td>Row 1 Data 1</td>
            <td>Row 1 Data 2</td>
            <td>Row 1 Data 3</td>
        </tr>
        <tr>
            <td>Row 2 Data 0</td>
            <td>Row 2 Data 1</td>
            <td>Row 2 Data 2</td>
            <td>Row 2 Data 3</td>
        </tr>
    </tbody>
</table>
</div>
</div>
</body>
</html>