<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file="../includes/header.jsp" %>

     <!-- Page Heading -->
     <h1 class="h3 mb-4 text-gray-800">Store List Page</h1>
  <form action = "/store/register" method = 'get'>
  <div class="form-group">
    <div class="col-sm-offset-2 col-sm-10">
      <button type="submit" class="btn btn-danger">맛집등록</button>
    </div>
  </div>
</form>

<table class="table">
  <thead>
    <tr>
      <th scope="col">SNO</th>
      <th scope="col">NAME</th>
      <th scope="col">LAT</th>
      <th scope="col">LNG</th>
      <th scope="col">MENU</th>
      <th scope="col">REGDATE</th>
      <th scope="col">UPDATE DATE</th>
    </tr>
  </thead>
  <tbody>
 <c:forEach items="${stores}" var="store"> 
    <tr>
      <td>${store.sno}</td>
      <td><a href='/store/view?sno=${store.sno}'>${store.name}</a></td>
      <td>${store.lat}</td>
      <td>${store.lng}</td>
      <td>${store.menu}</td>
      <td>${store.regdate}</td>
      <td>${store.updateDate}</td>
    </tr>
</c:forEach>
  </tbody>
</table>




<%@include file="../includes/footer.jsp" %>
