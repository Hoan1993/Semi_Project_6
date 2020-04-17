<%-- 기사 본문이 출력되는 페이지 --%>
<%-- 페이지가 아예 이렇게 넘어오는 게 아니고 메인 리스트에서 가운데만 이걸로 전환되게끔 --%>

<%@page import="com.sist.model.FavoriteVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
   href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
   src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
.header {
   
}

.container {
   width: 960px;
   margin: 0 auto 0 auto;
   padding-top: 3px;
}

.news-post {
   border-bottom: 1px solid #dfdfdf;
   margin-bottom: 0px;
   padding-bottom: 20px;
}

.news-post-title {
   margin-bottom: 25px;
   font-size: 40px;
}

.news_btns_left {
   vertical-align: middle;
   float: left;
}

.news_btns_left>a {
   height: 25px;
   padding: 5px 6px 6px 6px;
   color: #4e4e4e;
   border: solid 1px #dfdfdf;
   background-color: #fff;
}

a > span {
   min-height: 25px;
   line-height: 25px;
}

.news_btns_right {
   text-align: right;
}

.news_btns_right span {
   height: 25px;
   padding: 5px;
   border: 1px solid #dfdfdf;
   color: #4e4e4e;
}

.news-main {
   float: left;
   padding: 0px;
   border-bottom: 1px solid #dfdfdf;
   margin-bottom: 30px;
}

.news-cont {
   float: left;
   padding: 30px 30px 70px 30px;
   border-right: 1px solid #dfdfdf;
}

.news-side {
   float: right;
   padding: 30px 0px 70px 30px;
}

.side-carousel {
   margin-bottom: 15px;
}

#inputBtn {
   margin-top: 5px;
}

#comOutput {
   margin-top: 60px;
   padding-top: 20px;
   border-top: 1px solid #dfdfdf;
}

.icon-flipped {
	color: #337ab7;
    transform: scaleY(-1);
    -moz-transform: scaleY(-1);
    -webkit-transform: scaleY(-1);
    -ms-transform: scaleY(-1);
}
</style>
<script type="text/javascript">
$(document).ready(function() {
   function needLogin() {
      alert("로그인이 필요합니다.")
   };

   function alreadyFav() {
      alert("이미 저장된 기사입니다.")
   };

   $("#pageUrl").val(window.location.href);
   
   $.ajax({
      type : "post",
      url : "./fav_check.do",
      data : {
         no : "${requestScope.Cont.getArticle_no()}",
         email : "${sessionScope.loginUser.getMem_email() }"
      },
      success :
         function(data){
            if(data==0){
               $("#favBtn").removeClass("glyphicon-star")
               $("#favBtn").addClass("glyphicon-star-empty")
            }else if(data>0){
               $("#favBtn").removeClass("glyphicon-star-empty")
               $("#favBtn").addClass("glyphicon-star")
            }
         },
      error : function(){
      }
   });
   
   $(".news_btns_right").on("click", ".glyphicon-star", function() {
      if(!$("#loginUser").val()){
         needLogin()
      }else {
         alreadyFav()
      }
   })
   
   $(".news_btns_right").on("click", ".glyphicon-star-empty", function() {
      if(!$("#loginUser").val()){
         needLogin()
      }else {
         $.ajax({
            type : "post",
            url : "./fav_check.do",
            data : {
               no : "${requestScope.Cont.getArticle_no()}",
               email : "${sessionScope.loginUser.getMem_email() }"
            },
            success :
               function(data){
                  if(data==0){
                     $("#myModal1").modal("show")
                  }else if(data>0){
                     alreadyFav()
                  }
               },
            error : function(){
            }
         });
      }
   })

   $("#btnSave").click(function() {
      if(!$("#loginUser").val()){
         needLogin()
      }else{
         $.ajax({
            type : "post",
            url : "./fav_write.do",
            data : {
               no : "${requestScope.Cont.getArticle_no()}",
               email : "${sessionScope.loginUser.getMem_email() }",
               title : "${requestScope.Cont.getArticle_title()}"
            },
            success : function(data) {
               if(data==0){
                  alert("스크랩에 실패하였습니다")               
               }else if (data>0) {
                  alert("저장되었습니다.")
                  $("#favBtn").removeClass("glyphicon-star-empty")
                  $("#favBtn").addClass("glyphicon-star")
                  $("#favBtn").click(function(){
                     alreadyFav()
                     })         
               }
            },
            error : function(){
            }
         })
      }
   });
   
   $("#myModal2").on('shown.bs.modal', function(){
      $("#pageUrl").select()
      $("#pageUrl").focus()
      document.execCommand('copy')
     });
   
   $("#reportBtn").click(function(){
      if(!$("#loginUser").val()){
         alert("로그인이 필요합니다.")
      }else{
         window.open('${pageContext.request.contextPath }/article_report.do?no=${news.getArticle_no() }','popup','left=1280,width=600,height=960')
         }
   });
});
</script>
<script type="text/javascript">

function com_Up(no) {
   var comNo=no;// 댓글 번호
   
   
   $.ajax({
      type: "post",
      url : "./ajax/comUp.jsp",
      datatype : "jsp",
      data :  {"comNo" : comNo},
      
      success : function (data) {
         if(data==0){ // 중복인 경우
            alert("이미 추천였습니다.") ;
         }else {    // 중복 아닌경우
            alert("좋아요가 반영되었습니다.") ;            
            $("#comUp_"+no).val(data);
         }   

         
      },
      error : function() {
         alert("다시 시도해주세요.");
      }
      
   });
}

function com_Down(no) {
   var comNo=no;// 댓글 번호
   
   
   $.ajax({
      type: "post",
      url : "./ajax/comDown.jsp",
      data :  {"comNo" : comNo},
      datatype : "jsp",
      
      success : function (data) {
         if(data==0){ // 중복인 경우
            alert("이미 추천하였습니다.") ;
         }else {    // 중복 아닌경우
            alert("싫어요가 반영되었습니다.") ;            
            $("#comDown_"+no).val(data);
         }
         
      },
      error : function() {
         alert("다시 시도해주세요.");
      }
   });
}

function Dont_Up() {
   alert("로그인후 이용해주세요");
}

function Dont_Down() {
   alert("로그인후 이용해주세요");
}
</script>
</head>
<c:set var="news" value="${Cont }" />
<body>
   <div>
      <%@ include file="../include/header.jsp"%>
   </div>

   <input type="hidden" id="loginUser"
      value="${sessionScope.loginUser.getMem_email()}">

   <div class="container">
      <div>
         <form action="board_update.do" method="post" class="frm">
            <c:set var="article" value="${Cont }" />

            <input type="hidden" id="writer" name="writer"
               value="${news.getArticle_writer() }"> <input type="hidden"
               id="no" name="no" value="${news.getArticle_no() }">

            <div class="news-header">
               <h4>${news.getArticle_gen1() }</h4>
            </div>
            <div class="news-post">
               <h3 class="news-post-title">${news.getArticle_title() }</h3>

               <div class="news_btns">
                  <div class="news_btns_left">
                     <a style="margin-right: 4px"
                        href="http://localhost:8282/Project_Template01/board_pro.do?email=${news.getArticle_writer() }"
                        onclick="window.open(this.href,'회원정보','width=800px, height=500px, scrollbars=no'); return false;">
                        <span class="glyphicon glyphicon-user">${news.getArticle_name() }</span>
                     </a> <a href="javascript:void(0)"><span
                        class="glyphicon glyphicon-calendar">${news.getArticle_date() }</span></a>
                     <c:if
                        test="${sessionScope.loginUser.getMem_email() == news.getArticle_writer()}">
                        <input type="submit" id="form-submit"
                           class="btn btn-primary btn-sm" value="수정하기"
                           style="height: 28px">
                     </c:if>
                  </div>
                  <div style="float: right; width: auto;"></div>
                  <div class="news_btns_right">
                     <a href="javascript:void(0)"><span id="favBtn"
                        class="glyphicon glyphicon-star-empty"></span></a> <a
                        data-toggle="modal" href="#myModal2"> <span id="shareBtn"
                        class="glyphicon glyphicon-share"></span></a> <a
                        href="javascript:void(0)"><span id="reportBtn"
                        class="glyphicon glyphicon-exclamation-sign"></span></a>
                  </div>
               </div>
            </div>

            <div class="news-main" style="width: 100%;">
               <div class="news-cont" style="width: 75%; float: left;">
                  <font style="vertical-align: inherit;">${news.getArticle_cont() }</font>
               </div>
               <!-- /.news-post -->
               <!-- /.news-main -->
               <div class="news-side" style="width: 25%; float: left;">
                  <div class="side-carousel">
                     <%@ include file="../include/sidebar_carousel.jsp"%></div>
                  <div class="side-list">
                     <%@ include file="../include/sidebar.jsp"%></div>
               </div>
            </div>
         </form>
         <!--댓글 작성  -->
         <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
         <c:set var="list" value="${comList }" />
         <c:set var="mem" value="${getMem }" />
         <div id="comInput">
            <h4>댓글 ${fn:length(list)}</h4>
            <div>
               <%--  <input type="hidden"  name="article_no" value="${article.getArticle_no() }"> --%>
               <form method="post"
                  action="<%=request.getContextPath()%>/comemnt_write.do?no=${article.getArticle_no() }">
                  <div>
                     <textarea rows="3" name="comt_cont" placeholder="댓글을 입력하세요"
                        style="width: 100%; resize:none;"></textarea>
                  </div>
                  <div id="inputBtn">
                     <input type="reset" class="btn pull-right btn-default"
                        value="다시작성"> <input type="submit" style="margin-right: 5px;"
                        class="btn pull-right btn-success" value="등록">
                  </div>
               </form>
            </div>
         </div>
         <!-- 작성한 댓글 불러와서 출력하기. -->
         <div id="comOutput">
            <table style='table-layout: fixed; width: 100%;'>
               <c:if test="${!empty list }">
                  <c:forEach items="${list }" var="vo">
                     <tr>
                        <td />
                        <c:if test="${vo.getCom_writer() == mem.getMem_email() }">
                           <td align="right"><a
                              href="com_delete.do?no=${vo.getCom_no() }&article_no=${vo.getArticle_no()}">&nbsp;삭제</a>
                           </td>
                        </c:if>
                     </tr>
                     <tr>
                        <th><a href="http://localhost:8282/Project_Template01/board_pro.do?email=${vo.getCom_writer()}"
                        onclick="window.open(this.href,'댓글 작성자 프로필','width=800, height=500, scrollbars=no'); return false;">
                        ${vo.getCom_writer()}</a></th><td align="right">${vo.getCom_date() }</td>
                     </tr>

                     <tr>
                        <td>${vo.getCom_cont() }<br></td>
                     </tr>
                     <!-- 좋아요, 싫어요 기능 구현 -->

                     <tr>
                        <td />
                        <td align="right"><c:if
                              test="${mem.getMem_email() != null }">
                              <input type="image" src="./images/good.PNG"
                                 onclick="com_Up(${vo.getCom_no() })" value="좋아요">
                              <input readonly type="text"
                                 style="width: 30px; background-color: transparent; border: 0 solid black; text-align: right;"
                                 id="comUp_${vo.getCom_no() }" value=${vo.getCom_up() }>
                   &nbsp;&nbsp;
                  <input type="image" src="./images/bad.PNG"
                                 onclick="com_Down(${vo.getCom_no() })" value="싫어요">
                              <input readonly type="text"
                                 style="width: 30px; background-color: transparent; border: 0 solid black; text-align: right;"
                                 id="comDown_${vo.getCom_no() }" value=${vo.getCom_down() }>
                           </c:if> <c:if test="${mem.getMem_email() == null }">
                              <input type="image" src="./images/good.PNG"
                                 onclick="Dont_Up()" value="좋아요">
                              <input readonly type="text"
                                 style="width: 30px; background-color: transparent; border: 0 solid black; text-align: right;"
                                 id="comUp_${vo.getCom_no() }" value=${vo.getCom_up() }>
                   &nbsp;&nbsp;
                  <input type="image" src="./images/bad.PNG"
                                 onclick="Dont_Down()" value="싫어요">
                              <input readonly type="text"
                                 style="width: 30px; background-color: transparent; border: 0 solid black; text-align: right;"
                                 id="comDown_${vo.getCom_no() }" value=${vo.getCom_down() }>
                           </c:if></td>

                     </tr>

                     <tr>
                        <!-- 대댓글 구현 reply -->
                        <td align="left" colspan="2"><a class=${vo.getCom_no() }
                           onclick="this.nextElementSibling.style.display=(this.nextElementSibling.style.display=='none')?'block':'none';"
                           href="javascript:void(0)">답글 작성</a>
                           <div style="DISPLAY: none">

                              <!-- 대댓글 출력하기 -->
                              <div align="left" style="padding-left: 15px;">
                                 <h5 class=${vo.getCom_no() }></h5>
                                 <table style="width: 100%;">
                                    <c:set var="reply" value="${replyList }" />
                                    <c:if test="${!empty reply }">
                                       <c:forEach items="${reply }" var="reply">
                                          <c:if test="${reply.getCom_no() == vo.getCom_no() }">
                                             <tr>
                                                <th><span class="glyphicon glyphicon glyphicon-share-alt icon-flipped"></span>${reply.getReply_write()}</th>
                                                <td align="right">${reply.getReply_date() }</td>
                                                <c:if
                                                   test="${reply.getReply_write() == mem.getMem_email() }">
                                                   <td><a
                                                      href="com_delete.do?no=${reply.getCom_no() }&article_no=${reply.getArticle_no()}">&nbsp;삭제</a>
                                                   </td>
                                                </c:if>
                                             </tr>
                                             <tr>
                                                <td style="padding-left: 14px;">${reply.getReply_cont() }<input type="hidden"
                                                   value=${vo.getCom_no() }></td>
                                             </tr>
                                          </c:if>
                                       </c:forEach>
                                       <!-- 대댓글의 갯수 구현 -->
                                       <script>
                                    if($("input[value=${vo.getCom_no() }]").length !=0 ){
                                       $("a[class=${vo.getCom_no() }]").text("답글 "+$("input:hidden[value=${vo.getCom_no() }]").length);
                                    }
                                    </script>

                                    </c:if>
                                 </table>
                              </div>
                              <!-- 대댓글 작성창 -->
                              <form method="post"
                                 action="<%=request.getContextPath()%>/reply_write.do">
                                 <input type="hidden" name="article_no"
                                    value="${article.getArticle_no() }"> <input
                                    type="hidden" name="com_no" value="${vo.getCom_no() }">
                                 <br />
                                 <div style="width: 800px; float: left; padding:10px; margin-bottom:10px; border-bottom: 1px solid #dfdfdf;">
                                    <span><strong>댓글의 댓글</strong></span>
                                 <table style="width: 100%;">
                                    <tr>
                                       <td colspan="2"><textarea style="width: 100%; resize: none;" rows="3" cols="30"
                                             name="reply_cont" placeholder="댓글의 댓글을 입력하세요."></textarea></td>
                                    </tr>
                                    <tr>
                                       <td />
                                       <td><input type="reset"
                                          class="btn pull-right btn-default btn-sm" value="다시작성"> <input
                                          type="submit" class="btn pull-right btn-success btn-sm" style="margin-right: 3px;"
                                          value="등록"></td>
                                    </tr>
                                 </table>
                                 </div>
                              </form>
                           </div>
                           <hr /></td>
                     </tr>
                  </c:forEach>

               </c:if>
               <c:if test="${empty list }">
                  <tr>
                     <td colspan="4" align="center">
                        <h3>검색된 레코드가 없습니다.</h3>
                     </td>
                  </tr>
               </c:if>
            </table>
            <!-- 페이징 처리 -->
            <div>
               <ul class="pagination">
                  <c:if test="${page > block }">
                     <!-- 4>3 -->
                     <li class="paginate_button previous"><a
                        href="article.do?no=${article.getArticle_no() }&page=1">◀◀</a></li>
                     <li><a
                        href="article.do?no=${article.getArticle_no() }&page=${startBlock - 1 }">◀</a></li>
                  </c:if>

                  <c:forEach begin="${startBlock }" end="${endBlock }" var="i">
                     <c:if test="${i == page }">
                        <!-- 페이지가 같으면 -->
                        <li class="active"><a
                           href="article.do?no=${article.getArticle_no() }&page=${i }">${i }</a></li>
                     </c:if>
                     <c:if test="${i != page }">
                        <!--같지않으면  -->
                        <li><a
                           href="article.do?no=${article.getArticle_no() }&page=${i }">${i }</a></li>
                     </c:if>

                  </c:forEach>

                  <c:if test="${endBlock < allPage }">
                     <li><a
                        href="article.do?no=${article.getArticle_no() }&page=${endBlock + 1 }">▶</a></li>
                     <li class="paginate_button next"><a
                        href="article.do?no=${article.getArticle_no() }&page=${allPage }">▶▶</a></li>

                  </c:if>
               </ul>
            </div>
         </div>
      </div>
   </div>

   <!-- Modal1 -->
   <div class="modal fade" id="myModal1" role="dialog"
      style="margin-top: 200px;">
      <div class="modal-dialog modal-sm">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title">스크랩</h4>
            </div>
            <div class="modal-body">
               <p>스크랩된 기사에 등록하시겠습니까?</p>
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
               <button type="button" class="btn btn-primary" data-dismiss="modal"
                  id="btnSave">등록</button>
            </div>
         </div>
         <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
   </div>
   <!-- /.modal -->

   <!-- Modal2 -->
   <div class="modal fade" id="myModal2" role="dialog"
      style="margin-top: 200px;">
      <div class="modal-dialog modal-sm">
         <div class="modal-content">
            <div class="modal-header">
               <h4 class="modal-title">클립보드 복사</h4>
            </div>
            <div class="modal-body">
               <h5>해당 기사의 주소가 복사되었습니다.</h5>
               <input type="text" id="pageUrl">
            </div>
            <div class="modal-footer">
               <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
            </div>
         </div>
         <!-- /.modal-content -->
      </div>
      <!-- /.modal-dialog -->
   </div>
   <!-- /.modal -->
</body>
</html>