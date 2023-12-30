
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="post" class="form">
	<p>
		<label>Username</label> <input type="text" name="usr">
	</p>
	<p>
		<label>Password</label> <input type="password" name="pwd">
	</p>
	<p>
		<button>Login</button>
	</p>
</form>
<c:if test="${pageContext.request.method == 'POST'}">
	<p>Username: ${param.usr}</p>
	<p>Password: ${param.pwd}</p>
</c:if>
