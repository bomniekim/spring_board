<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="/WEB-INF/views/layout/header.jsp"%>
<!DOCTYPE html>
<html>
   <head>
      <meta charset="UTF-8">
      <title>board</title>
   </head>
   <body>
      <article>
         <div class="container" role="main">
            <h2>board Content</h2>
            <div class="bg-white rounded shadow-sm">
               <div class="board_title">
                  <c:out value="${boardContent.title}"/>
               </div>
               <div class="board_info_box">
                  <span class="board_author">
                     <c:out value="${boardContent.reg_id}"/>
                     ,
                  </span>
                  <span class="board_date">
                     <c:out value="${boardContent.reg_dt}"/>
                  </span>
               </div>
               <div class="board_content">${boardContent.content}</div>
               <div class="board_tag">
                  TAG : 
                  <c:out value="${boardContent.tag}"/>
               </div>
            </div>
            <div style="margin-top : 20px">
               <button type="button" class="btn btn-sm btn-primary" id="btnUpdate">수정</button>
               <button type="button" class="btn btn-sm btn-primary" id="btnDelete">삭제</button>
               <button type="button" class="btn btn-sm btn-primary" id="btnList">목록</button>
            </div>
         </div>
      </article>
   </body>
     <script>
     const btnList = document.querySelector("#btnList");
     const btnUpdate = document.querySelector("#btnUpdate");
     
     btnList.addEventListener("click", ()=>{
         	location.href = "${pageContext.request.contextPath}/board/getBoardList";
         });
     
     btnUpdate.addEventListener("click", ()=>{
    	let url = "${pageContext.request.contextPath}/board/editForm";
 		url = url + "?bid="+${boardContent.bid};
 		url = url + "&mode=edit";
 		// mode 인자는, 입력 폼을 신규 입력 이외에 수정에서도 같이 사용하므로 필요한 인자 (신규 입력과 수정 입력 구분)

 		location.href = url;

        });

              
         
      </script>
</html>