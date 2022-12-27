<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="common/header.jspf"%>
    			<h1>Login</h1>
    			<pre>${errorMessage}</pre>
    			<form method="post">
    				Email: <input type="text" name="email">
    				Password: <input type="password" name="password">
    				<input type="submit">
    			</form>
 <%@ include file="common/footer.jspf"%>