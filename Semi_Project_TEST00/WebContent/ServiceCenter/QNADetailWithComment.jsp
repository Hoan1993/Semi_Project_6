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
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap-theme.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<link rel="stylesheet" type="text/css" href="css/qna.css">
<script type="text/javascript" src="js/jquery-3.4.1.js"></script>


<style type="text/css">

.header {
}

.container {
	width: 960px;
	margin: 0 auto 0 auto;
	border: 1px solid #dfdfdf;
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

.news-cont {
	padding-left: 10px;
}

.news_btns_left {
	float: left;
}

.news_btns_left a {
	display: inline-block;
    height: 25px;
    padding: 5px;
    color: #4e4e4e;
    border: solid 1px #dfdfdf;
    background-color: #fff;
	vertical-align: bottom;
}

.glyphicon {
	vertical-align: middle;
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
	float:left;
	padding: 30px 15px 15px 0;
}

.news-side {
	float:right;
	padding: 30px 0 15px 15px;
	border-left: 1px solid #dfdfdf;
}

.side-carousel {
	margin-bottom: 15px;
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
<script type="text/javascript"> /* 이 부분은 qna 디테일 부분 */
function deleteQNA() {
	var email = document.getElementById('email').innerText;
	var num = document.getElementById('num').getAttribute('value');
	
	var checkLogin;
	
	alert(email+" "+num);
	
	$.ajax({
		type : "post",
		url : "./ServiceCenter/chechAndDelete.jsp",
		data : {"email": email, "num": num},
		datatype : "jsp",
		success: function(data) {
			checkLogin = data;
			var result = checkLogin.replace("<!DOCTYPE html>", "");
			var result2 = result.replace(/(\s*)/g, "");
			if(result2 > 0) {
				location.href = "boardQNA.do";
			} else {
				alert("본인이 쓴 글만 삭제할 수 있습니다.");
			}
			
		}, error: function() {
			alert("data error");
		}
	});	
}


function updateQNA() {
	var w = window.open("about:blank",'Q&A수정','width=600, height=500, toolbar=no, menubar=no, scrollbars=no, resizable=yes');
	
	var email = document.getElementById('email').innerText;
	var num = document.getElementById('num').getAttribute('value');
	
	
	
	var checkLogin;
	$.ajax({
		method:"POST",
		url: "./ServiceCenter/checkUpdateAuth.jsp",
		data : {"email": email},
		datatype: "jsp",
		success: function(data) {
			checkLogin = data;
			var result = checkLogin.replace("<!DOCTYPE html>", "");
			var result2 = result.replace(/(\s*)/g, "");
			
			if(result2 == 1) {
				w.location.href = "http://localhost:8282/Project_Template01/BoardQNAUpdate.do?num="+num;
			} else {
				w.close();
		        w.parent.alert("수정 권한이 없습니다.");
			}
			
		}, error: function() {
			alert("data error");
		}
	});
	
}

</script>


<style type="text/css">
.container {
    padding-right: 15px;
    padding-left: 15px;
    margin-right: auto;
    margin-left: auto;
    
}

.blog-post {
  margin-bottom: 60px;
}
.blog-post-title {
  margin-bottom: 5px;
  font-size: 40px;
}
.blog-post-meta {
  margin-bottom: 20px;
  color: #999;
}

#tb1 {
	border-right: none;
	border-left: none;
	border-top: none;
	border-bottom: none;
}
</style>

</head>
<c:set var="news" value="${Cont }" />
<body>
	<div>
		<%@ include file="../include/header.jsp"%>
	</div> 


	<input type="hidden" id="loginUser" value="${sessionScope.loginUser.getMem_email()}">
	


	<div class="container">
		<c:set var="article" value="${Cont }" />
		
		<input type="hidden" id="writer" name="writer" value="${news.getArticle_writer() }">
		<input type="hidden" id="no" name="no" value="${news.getArticle_no() }">
	
	
		<div class="col-md-9 news-main">
			<div class="news-cont">
				
		<!-- 상세보기 부분 -->	
				<div id="wrap" align="center">
					<input id="num" type="hidden" value="${board.num }">
					<h1> Q&A 상세보기 </h1>
					<table>
			
					<tr>
				
				</tr>	
				
				<tr>
					<th> 작성자 </th><td id="email">${board.email }</td>
					<th> 작성일/조회수 </th> <td>${board.writedate.substring(0,10) } / ${board.readcount }</td>
				</tr>
				<tr>
					<th> 제목 </th>
					<td colspan="3">${board.title }</td>
				</tr>
				
				<tr>
					<th>내용</th>
					<td colspan="20" id="tar"><textarea style="border: none" cols="145" rows="10" readonly>${board.content }</textarea></td>
				</tr>
			</table>
			<br><br>
			<input type="button" value="게시글 수정" onClick="updateQNA();">
			<input type="button" value="게시글 삭제" onClick="deleteQNA();">
			<input type="button" value="게시글 리스트" onClick="location.href='boardQNA.do'">		
			
	
			<br /><br />

		</div>
		
		<!-- 상세보기 부분  끝-->	
				
			</div>
			<!-- /.news-post -->
		
		</div>
		<!-- /.news-main -->



		<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>	
		
<!--댓글 작성  -->      
<div>
    <form method="post" action="<%=request.getContextPath()%>/comemnt_write.do?no=${article.getArticle_no() }">
   <%--  <input type="hidden"  name="article_no" value="${article.getArticle_no() }"> --%>
     <br><br>
     <div>
         <span><strong>Comments</strong></span> 
      </div>   
     <table id="tb1"> 
         <tr>
            <td/>
            <td><textarea style="width: 1100px" rows="3" cols="30"  name="comt_cont" placeholder="댓글을 입력하세요"></textarea>
                
            </td>
         </tr>
         <tr>
            <td/>
            <td>   
               <input type="reset" class="btn pull-right btn-default" value="다시작성">   
                       <input type="submit"  class="btn pull-right btn-success" value="등록">
            </td>
         </tr>
                           
          
    </table>
       
    
    </form>
</div>
<br/><br/>
<!-- 작성한 댓글 불러와서 출력하기. -->
<div  align="center">

      <table width="100%" style='table-layout:fixed;'>
      <c:set var="list" value="${comList }"/>
      <c:set var="mem" value="${getMem }"/>      
      <c:if test="${!empty list }">
         <c:forEach items="${list }" var="vo" >
            <tr>
               <td/>
               <c:if test="${vo.getCom_writer() == mem.getMem_email() }">               
               <td align="right">
                  <a  href="com_delete.do?no=${vo.getCom_no() }&article_no=${vo.getArticle_no()}" >&nbsp;삭제</a>                                 
               </td>               
               </c:if>
            </tr>
            <tr >
                <th >${vo.getCom_writer().substring(0,4)}</th> <td align="right">${vo.getCom_date() }</td> 
                
            </tr>
            
            <tr >
               
               <td>${vo.getCom_cont() }</td>
               
            </tr>
            <!-- 좋아요, 싫어요 기능 구현 -->
         
            <tr>
               
               <td/>
               <td  align="right" >
                  <c:if test="${mem.getMem_email() != null }">                                                                                     
                  <input type="image" src="./images/good.PNG"   onclick="com_Up(${vo.getCom_no() })" value="좋아요">                  
                  <input readonly type="text" style="width:30px;background-color:transparent;border:0 solid black;text-align:right;" id="comUp_${vo.getCom_no() }" value=${vo.getCom_up() }>
                   &nbsp;&nbsp;
                  <input type="image" src="./images/bad.PNG"    onclick="com_Down(${vo.getCom_no() })" value="싫어요">
                  <input readonly type="text" style="width:30px;background-color:transparent;border:0 solid black;text-align:right;" id="comDown_${vo.getCom_no() }" value=${vo.getCom_down() }>
                  </c:if>   
               
                  <c:if test="${mem.getMem_email() == null }">                                                                                     
                  <input type="image" src="./images/good.PNG"   onclick="Dont_Up()" value="좋아요">                  
                  <input readonly type="text" style="width:30px;background-color:transparent;border:0 solid black;text-align:right;" id="comUp_${vo.getCom_no() }" value=${vo.getCom_up() }>
                   &nbsp;&nbsp;
                  <input type="image" src="./images/bad.PNG"    onclick="Dont_Down()" value="싫어요">
                  <input readonly type="text" style="width:30px;background-color:transparent;border:0 solid black;text-align:right;" id="comDown_${vo.getCom_no() }" value=${vo.getCom_down() }>
                  </c:if>      
               </td>
               
            </tr>
            
            <tr><!-- 대댓글 구현 reply -->
               <td align="left">
               <a class=${vo.getCom_no() } onclick="this.nextSibling.style.display=(this.nextSibling.style.display=='none')?'block':'none';" 
               href="javascript:void(0)">답글 작성</a><div  style="DISPLAY: none">
               
                           <!-- 대댓글 출력하기 -->
                           <div align="center">
                           <h5 class=${vo.getCom_no() }></h5>
                              <table width="1100">
                                 
                                 <c:set var="reply" value="${replyList }" />
                                 <c:if test="${!empty reply }">
                                   <c:forEach items="${reply }" var="reply">
                                    <c:if test="${reply.getCom_no() == vo.getCom_no() }">
                                       <tr>
                                          <th>${reply.getReply_write().substring(0,4)}</th>
                                          <td align="right">${reply.getReply_date() }</td>
                                          <c:if
                                             test="${reply.getReply_write() == mem.getMem_email() }">
                                             <td><a
                                                href="com_delete.do?no=${reply.getCom_no() }&article_no=${reply.getArticle_no()}">&nbsp;삭제</a>
                                             </td>
                                          </c:if>
                                       </tr>

                                       <tr>
                                          <td>${reply.getReply_cont() }<input type="hidden" value=${vo.getCom_no() }></td>
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
                           <form method="post" action="<%=request.getContextPath()%>/reply_write.do">                              
                              <input type="hidden"  name="article_no" value="${article.getArticle_no() }">                                  
                              <input type="hidden"  name="com_no" value="${vo.getCom_no() }">                                  
                              <br/>
                              <div>
                                 <span><strong>Comments</strong></span>
                              </div>
                              <table >
                                 <tr>
                                    <td/>
                                    <td><textarea style="width: 700px" rows="3" cols="30"
                                          name="reply_cont" placeholder="댓글을 입력하세요"></textarea></td>
                                 </tr>
                                 <tr>
                                    <td />
                                    <td><input type="reset"
                                       class="btn pull-right btn-default" value="다시작성"> <input
                                       type="submit" class="btn pull-right btn-success" value="등록">
                                    </td>
                                 </tr>
                              </table>
                           </form>
                        </div>
                  <hr/>
               </td>                     
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
            <c:if test="${page > block }"> <!-- 4>3 -->
               <li class="paginate_button previous">
                  <a href="article.do?no=${article.getArticle_no() }&page=1">◀◀</a></li>
               <li><a href="article.do?no=${article.getArticle_no() }&page=${startBlock - 1 }">◀</a></li>
            </c:if>
            
            <c:forEach begin="${startBlock }" end="${endBlock }" var="i">
               <c:if test="${i == page }"> <!-- 페이지가 같으면 -->
                    <li class="active"><a href="article.do?no=${article.getArticle_no() }&page=${i }">${i }</a></li>
               </c:if>
               <c:if test="${i != page }"> <!--같지않으면  -->
                  <li><a href="article.do?no=${article.getArticle_no() }&page=${i }">${i }</a></li>
               </c:if>
                     
            </c:forEach>
            
            <c:if test="${endBlock < allPage }">
               <li><a href="article.do?no=${article.getArticle_no() }&page=${endBlock + 1 }">▶</a></li>
               <li class="paginate_button next">
                  <a href="article.do?no=${article.getArticle_no() }&page=${allPage }">▶▶</a></li>
               
            </c:if>
         </ul>
      </div>
   </div>  

		
</div>

<!-- Modal1 -->
<div class="modal fade" id="myModal1" role="dialog" style="margin-top: 200px;">
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
        <button type="button" class="btn btn-primary" data-dismiss="modal" id="btnSave">등록</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<!-- Modal2 -->
<div class="modal fade" id="myModal2" role="dialog" style="margin-top: 200px;">
  <div class="modal-dialog modal-sm">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">클립보드 복사</h4>
      </div>
      <div class="modal-body">
        <h5>해당 기사의 주소가 복사되었습니다.</h5><input type="text" id="pageUrl">
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
</html>