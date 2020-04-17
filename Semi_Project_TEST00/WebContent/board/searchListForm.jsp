<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style.css">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script type="text/javascript">
   $('#myTab a').click(function(e) {
      e.preventDefault()
      $(this).tab('show')
   })
   $('#myTab a[href="#profile"]').tab('show') // Select tab by name
   $('#myTab a:first').tab('show') // Select first tab
   $('#myTab a:last').tab('show') // Select last tab
   $('#myTab li:eq(2) a').tab('show') // Select third tab (0-indexed)

   $(function() {
      $('#myTab a:last').tab('show')
   })
</script>
<style type="text/css">
.hori {
   list-style: none;
   float: left;
   margin-right: 20px;
   text-align: center;
}

.vert li {
   text-align: left;
   float: none;
   list-style: none;
   font-size: 15px;
   overflow: hidden;
   text-overflow: ellipsis;
   display: -webkit-box;
   -webkit-box-orient: vertical;
   word-wrap: break-word;
   line-wrap: break-word;
   line-height: 1.2em;
   height:5.8em;
   width: 430px;
}

th {
   font-size: 25px;
}

table {
   width: 100%;
}
</style>
</head>
<body>
   <%@ include file="../include/header.jsp"%>
   


   <div role="tabpanel">
      <c:set var="find" value="${find }" />
      <div class="container" style="height: 50px;">
         <!-- Nav tabs -->
         <ul class="nav nav-tabs" role="tablist"
            style="width: 700px; height: 50px;">
            <li role="presentation" class="active"><a href="#home"
               aria-controls="home" role="tab" data-toggle="tab">All</a></li>

            <li role="presentation"><a href="#profile"
               aria-controls="profile" role="tab" data-toggle="tab">Writer</a></li>

            <li role="presentation"><a href="#messages"
               aria-controls="messages" role="tab" data-toggle="tab">Title</a></li>

            <li role="presentation"><a href="#settings"
               aria-controls="settings" role="tab" data-toggle="tab">Content</a></li>
         </ul>
      </div>

      <!-- Tab panes -->

      <div class="tab-content">
         <div role="tabpanel" class="tab-pane active" id="home">
      <div class="container">
         <div style="float: right;">
         <%@ include file="../include/sidebar.jsp"%></div>
            <div style="width: 85%">
            

               <c:set var="list" value="${list }" />
               <h3>검색결과</h3>
               <hr align="center" width="100%" color="gray">

               <c:if test="${!empty list }">
                  <c:forEach var="dto" items="${list }">
                     <table style="width: 900px;">
                        <%-- <tr>
                           <th>${dto.getArticle_title() }</th>
                        </tr> --%>
                        <tr>
                           <td>
                              <ul>
                                 <c:if test="${!empty dto.getArticle_file1() }">
                                    <li class="hori"><a
                                       href="article.do?no=${dto.getArticle_no() }"> <img  style="border: 2px solid gray;"
                                          alt="썸네일" src="./upload/${dto.getArticle_file1() }"
                                          width="200" height="170" border="1" cellspacing="1">
                                    </a></li>
                                 </c:if>
                                 <c:if test="${empty dto.getArticle_file1() }">
                                    <li class="hori"><a
                                       href="article.do?no=${dto.getArticle_no() }"><img  style="border: 2px solid gray;"
                                          alt="썸네일" src="./images/no_image.jpg" width="200"
                                          height="170"></a></li>
                                 </c:if>
                                 <li class="hori" style="border-left-color: black; margin: auto;">
                                    <ul class="vert">
                                       <li style="font-size: 20px; width: 600px; height: 40px; margin: auto;">
                                       <a href="article.do?no=${dto.getArticle_no() }"><u>${dto.getArticle_title() }</u></a></li>
                                       <li><a href="article.do?no=${dto.getArticle_no() }">${dto.getArticle_cont() }</a></li>
                                       <li style="color: gray; margin-top: 25px; height: 20px;">[분야 :
                                          ${dto.getArticle_gen1() }]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[기자
                                          :<a
                                          href="href=<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }"
                                          onclick="window.open('<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }', '회원정보','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">${dto.getArticle_name() }기자</a>
                                          ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [작성일 :
                                          ${dto.getArticle_date().substring(0,10) }]
                                       </li>
                                    </ul>
                                 </li>

                              </ul>
                           </td>
                        </tr>

                     </table>
                     <hr width="80%" color="gray">
                  </c:forEach>
               </c:if>
               <c:if test="${empty list }">
                  <table>
                     <tr>
                        <td><h3>업로드한 내역이 없습니다.</h3></td>
                     </tr>
                  </table>
               </c:if>

               <div align="center">
                  <ul class="pagination">
                     <c:if test="${page > block }">
                        <li class="paginate_button previous"><a
                           href="board_search.do?page=1&find=${find}">◀◀</a></li>
                        <li><a
                           href="board_search.do?page=${startBlock - 1 }&find=${find}">◀</a>
                        </li>
                     </c:if>

                     <c:forEach begin="${startBlock }" end="${endBlock }" var="i">
                        <c:if test="${i==page }">
                           <li class="active"><a
                              href="board_search.do?page=${i }&find=${find}">${i }</a></li>
                        </c:if>
                        <c:if test="${i!=page }">
                           <li><a href="board_search.do?page=${i }&find=${find}">${i }</a>
                           </li>
                        </c:if>
                     </c:forEach>
                     <c:if test="${endBlock < allPage }">
                        <li><a
                           href="board_search.do?page=${endBlock + 1 }&find=${find}">▶</a></li>
                        <li class="paginate_button next"><a
                           href="board_search.do?page=${allPage }&find=${find}">▶▶</a></li>
                     </c:if>
                  </ul>
               </div>
            </div>
            </div>

         </div>




         <div role="tabpanel" class="tab-pane" id="profile">
            <div class="container">
            <div style="float: right;">
            <%@ include file="../include/sidebar.jsp"%></div>
            <div style="width: 85%">
               <c:set var="namelist" value="${namelist }" />
               <h3>검색결과</h3>
               <hr align="center" width="100%" color="gray">

               <c:if test="${!empty namelist }">
                  <c:forEach var="dto" items="${namelist }">
                     <table style="width: 750px;">
                        
                        <tr>
                           <td>
                              <ul>
                                 <c:if test="${!empty dto.getArticle_file1() }">
                                    <li class="hori">
                                    <a href="article.do?no=${dto.getArticle_no() }"><img style="border: 2px solid gray;"
                                          alt="썸네일" src="./upload/${dto.getArticle_file1() }"
                                          width="200" height="170"></a></li>
                                 </c:if>
                                 <c:if test="${empty dto.getArticle_file1() }">
                                    <li class="hori"><a
                                       href="article.do?no=${dto.getArticle_no() }"><img  style="border: 2px solid gray;"
                                          alt="썸네일" src="./images/no_image.jpg" width="200"
                                          height="170"></a></li>
                                 </c:if>
                                 <li class="hori">
                                    <ul class="vert">
                                       <li style="font-size: 20px; height: 40px;"><a
                                          href="article.do?no=${dto.getArticle_no() }"><u>${dto.getArticle_title() }</u></a></li>
                                       <li><a href="article.do?no=${dto.getArticle_no() }">${dto.getArticle_cont() }</a></li>
                                       <li style="color: gray; margin-top: 25px; height: 20px">[분야 :
                                          ${dto.getArticle_gen1() }]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[기자
                                          :<a
                                          href="href=<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }"
                                          onclick="window.open('<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }', '회원정보','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">${dto.getArticle_name() }기자</a>
                                          ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [작성일 :
                                          ${dto.getArticle_date().substring(0,10) }]
                                       </li>
                                    </ul>
                                 </li>

                              </ul>
                           </td>
                        </tr>

                     </table>
                     <hr width="80%" color="gray">
                  </c:forEach>
               </c:if>
               <c:if test="${empty namelist }">
                  <table>
                     <tr>
                        <td><h3>업로드한 내역이 없습니다.</h3></td>
                     </tr>
                  </table>
               </c:if>

               <div align="center">
                  <ul class="pagination">
                     <c:if test="${npage > nblock }">
                        <li class="paginate_button previous"><a
                           href="board_search.do?npage=1&find=${find}">◀◀</a></li>
                        <li><a
                           href="board_search.do?npage=${nstartBlock - 1 }&find=${find}">◀</a>
                        </li>
                     </c:if>

                     <c:forEach begin="${nstartBlock }" end="${nendBlock }" var="i">
                        <c:if test="${i==npage }">
                           <li class="active"><a
                              href="board_search.do?npage=${i }&find=${find}">${i }</a></li>
                        </c:if>
                        <c:if test="${i!=npage }">
                           <li><a href="board_search.do?npage=${i }&find=${find}">${i }</a>
                           </li>
                        </c:if>
                     </c:forEach>
                     <c:if test="${nendBlock < nallPage }">
                        <li><a
                           href="board_search.do?npage=${nendBlock + 1 }&find=${find}">▶</a></li>
                        <li class="paginate_button next"><a
                           href="board_search.do?npage=${nallPage }&find=${find}">▶▶</a></li>
                     </c:if>
                  </ul>
               </div>
            </div>
         </div>
         </div>
         <div role="tabpanel" class="tab-pane" id="messages">
            <div class="container">
            <div style="float: right;">
         <%@ include file="../include/sidebar.jsp"%></div>
            <div style="width: 85%">
               <c:set var="titlelist" value="${titlelist }" />
               <h3>검색결과</h3>
               <hr align="center" width="100%" color="gray">

               <c:if test="${!empty titlelist }">
                  <c:forEach var="dto" items="${titlelist }">
                     <table style="width: 750px;">
                        
                        <tr>
                           <td>
                              <ul>
                                 <c:if test="${!empty dto.getArticle_file1() }">
                                    <li class="hori"><a
                                       href="article.do?no=${dto.getArticle_no() }"><img  style="border: 2px solid gray;"
                                          alt="썸네일" src="./upload/${dto.getArticle_file1() }"
                                          width="200" height="170"></a></li>
                                 </c:if>
                                 <c:if test="${empty dto.getArticle_file1() }">
                                    <li class="hori"><a
                                       href="article.do?no=${dto.getArticle_no() }"><img  style="border: 2px solid gray;"
                                          alt="썸네일" src="./images/no_image.jpg" width="200"
                                          height="170"></a></li>
                                 </c:if>
                                 <li class="hori">
                                    <ul class="vert">
                                       <li style="font-size: 20px; height: 40px;"><a
                                          href="article.do?no=${dto.getArticle_no() }"><u>${dto.getArticle_title() }</u></a></li>
                                       <li><a href="article.do?no=${dto.getArticle_no() }">${dto.getArticle_cont() }</a></li>
                                       <li style="color: gray; margin-top: 25px; height: 20px">[분야 :
                                          ${dto.getArticle_gen1() }]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[기자
                                          :<a
                                          href="href=<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }"
                                          onclick="window.open('<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }', '회원정보','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">${dto.getArticle_name() }기자</a>
                                          ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [작성일 :
                                          ${dto.getArticle_date().substring(0,10) }]
                                       </li>
                                    </ul>
                                 </li>

                              </ul>
                           </td>
                        </tr>

                     </table>
                     <hr width="80%" color="gray">
                  </c:forEach>
               </c:if>
               <c:if test="${empty titlelist }">
                  <table>
                     <tr>
                        <td><h3>업로드한 내역이 없습니다.</h3></td>
                     </tr>
                  </table>
               </c:if>

               <div align="center">
                  <ul class="pagination">
                     <c:if test="${tpage > tblock }">
                        <li class="paginate_button previous"><a
                           href="board_search.do?tpage=1&find=${find}">◀◀</a></li>
                        <li><a
                           href="board_search.do?tpage=${tstartBlock - 1 }&find=${find}">◀</a>
                        </li>
                     </c:if>

                     <c:forEach begin="${tstartBlock }" end="${tendBlock }" var="i">
                        <c:if test="${i==tpage }">
                           <li class="active"><a
                              href="board_search.do?tpage=${i }&find=${find}">${i }</a></li>
                        </c:if>
                        <c:if test="${i!=tpage }">
                           <li><a href="board_search.do?tpage=${i }&find=${find}">${i }</a>
                           </li>
                        </c:if>
                     </c:forEach>
                     <c:if test="${tendBlock < tallPage }">
                        <li><a
                           href="board_search.do?tpage=${tendBlock + 1 }&find=${find}">▶</a></li>
                        <li class="paginate_button next"><a
                           href="board_search.do?tpage=${tallPage }&find=${find}">▶▶</a></li>
                     </c:if>
                  </ul>
               </div>
            </div>
         </div>
         </div>
         <div role="tabpanel" class="tab-pane" id="settings">
            <div class="container">
            <div style="float: right;">
            <%@ include file="../include/sidebar.jsp"%></div>
               <div style="width: 85%">
               <c:set var="contlist" value="${contlist }" />
               <h3>검색결과</h3>
               <hr align="center" width="100%" color="gray">

               <c:if test="${!empty titlelist }">
                  <c:forEach var="dto" items="${contlist }">
                     <table style="width: 750px;">
                        
                        <tr>
                           <td>
                              <ul>
                                 <c:if test="${!empty dto.getArticle_file1() }">
                                    <li class="hori"><a
                                       href="article.do?no=${dto.getArticle_no() }"><img  style="border: 2px solid gray;"
                                          alt="썸네일" src="./upload/${dto.getArticle_file1() }"
                                          width="200" height="170"></a></li>
                                 </c:if>
                                 <c:if test="${empty dto.getArticle_file1() }">
                                    <li class="hori"><a
                                       href="article.do?no=${dto.getArticle_no() }"><img  style="border: 2px solid gray;"
                                          alt="썸네일" src="./images/no_image.jpg" width="200"
                                          height="170"></a></li>
                                 </c:if>
                                 <li class="hori">
                                    <ul class="vert">
                                       <li style="font-size: 20px; height: 35px;"><a
                                          href="article.do?no=${dto.getArticle_no() }"><u>${dto.getArticle_title() }</u></a></li>
                                       <li><a href="article.do?no=${dto.getArticle_no() }">${dto.getArticle_cont() }</a></li>
                                       <li style="color: gray; margin-top: 10px;">[분야 :
                                          ${dto.getArticle_gen1() }]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;[기자
                                          :<a
                                          href="href=<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }"
                                          onclick="window.open('<%=request.getContextPath()%>/search_mine.do?writer=${dto.getArticle_writer() }', '회원정보','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');return false;">${dto.getArticle_name() }기자</a>
                                          ]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [작성일 :
                                          ${dto.getArticle_date().substring(0,10) }]
                                       </li>
                                    </ul>
                                 </li>

                              </ul>
                           </td>
                        </tr>

                     </table>
                     <hr width="80%" color="gray">
                  </c:forEach>
               </c:if>
               <c:if test="${empty contlist }">
                  <table>
                     <tr>
                        <td><h3>업로드한 내역이 없습니다.</h3></td>
                     </tr>
                  </table>
               </c:if>

               <div align="center">
                  <ul class="pagination">
                     <c:if test="${cpage > cblock }">
                        <li class="paginate_button previous"><a
                           href="board_search.do?cpage=1&find=${find}">◀◀</a></li>
                        <li><a
                           href="board_search.do?cpage=${cstartBlock - 1 }&find=${find}">◀</a>
                        </li>
                     </c:if>

                     <c:forEach begin="${cstartBlock }" end="${cendBlock }" var="i">
                        <c:if test="${i==cpage }">
                           <li class="active"><a
                              href="board_search.do?cpage=${i }&find=${find}">${i }</a></li>
                        </c:if>
                        <c:if test="${i!=cpage }">
                           <li><a href="board_search.do?cpage=${i }&find=${find}">${i }</a>
                           </li>
                        </c:if>
                     </c:forEach>
                     <c:if test="${cendBlock < callPage }">
                        <li><a
                           href="board_search.do?cpage=${cendBlock + 1 }&find=${find}">▶</a></li>
                        <li class="paginate_button next"><a
                           href="board_search.do?cpage=${callPage }&find=${find}">▶▶</a></li>
                     </c:if>
                  </ul>
               </div>
            </div>
         </div>

      </div>


   </div>
   <%@ include file="../include/footer.jsp"%>
</body>
</html>