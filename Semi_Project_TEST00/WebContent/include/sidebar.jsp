<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/bootstrap-3.4.1.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
   integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
   crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
#st_line li {
   list-style: none;
   float: none;
   font-size: 15px;
   overflow: hidden;
   text-overflow: ellipsis;
   display: -webkit-box;
   align:left;
   -webkit-box-orient: vertical;
   line-wrap:break-word;
   line-height: 1.2em;
   height:1.2em;
   width: 80px;
}
</style>

</head>
<body>
<div align="left" style="width: 100%;">
         <div class="panel panel-default" >
            <div class="panel-heading">가장 많이 본 뉴스</div>
            <div class="panel-body">
               <c:set var="hit" value="${hit }" />
               <c:if test="${!empty hit }">
               <ul id="st_line" style="padding-inline-start: 0;">
               <li><font>1. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[0].getArticle_no()}">${hit[0].getArticle_title() }</a></li>
               <li><font>2. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[1].getArticle_no()}">${hit[1].getArticle_title() }</a></li>
               <li><font>3. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[2].getArticle_no()}">${hit[2].getArticle_title() }</a></li>
               <li><font>4. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[3].getArticle_no()}">${hit[3].getArticle_title() }</a></li>
               <li><font>5. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[4].getArticle_no()}">${hit[4].getArticle_title() }</a></li>
               <li><font>6. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[5].getArticle_no()}">${hit[5].getArticle_title() }</a></li>
               <li><font>7. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[6].getArticle_no()}">${hit[6].getArticle_title() }</a></li>
               <li><font>8. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[7].getArticle_no()}">${hit[7].getArticle_title() }</a></li>
               <li><font>9. </font><a href="<%=request.getContextPath() %>/article.do?no=${hit[8].getArticle_no()}">${hit[8].getArticle_title() }</a></li>
               </ul>
               
               </c:if>
               
      </div>
   </div>
</div>      
      
      
      
      
      
</body>
</html>