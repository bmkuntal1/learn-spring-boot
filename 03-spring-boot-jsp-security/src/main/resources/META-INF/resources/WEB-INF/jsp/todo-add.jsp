<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="common/header.jspf"%>
      <div class="row">
      <div class="col-md-6">
         <div class="card p-3 my-5">
            <h1>Add Todo</h1>
            <pre>${errorMessage}</pre>
            <form:form method="post" modelAttribute="todo">
               <form:input type="hidden" path="id"/>
               <form:input type="hidden" path="done"/>
               <form:input type="hidden" path="username"/>
               Description:
               <!--<form:input type="text" path="description" required="required"/>-->
               <form:input type="text" path="description" required="required"/>
               <form:errors path="description" cssClass="text-danger"/>
               Target Date:
               <form:input type="date" path="targetDate" min="2022-01-01" max="2025-12-31"/>
               <input type="submit"/>
            </form:form>
            <div class="card-footer">
               <a href="/todo-list" class="btn btn-secondary">Todo List</a>
            </div>
         </div>
         <div>
         </div>
<%@ include file="common/footer.jspf"%>