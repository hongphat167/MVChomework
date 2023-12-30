<form method="post" class="form">
	<p>
		<label>Username</label> <input type="text" name="usr">
	</p>
	<p>
		<label>Password</label> <input type="password" name="pwd">
	</p>
	<p>
		<label>Email</label> <input type="text" name="email">
	</p>
	<p>
		<label>Gender</label> <select name="gender">
			<option value="0">Male</option>
			<option value="1">Female</option>
			<option value="2">Undefined</option>
		</select>
	</p>
	<p>
		<button>Register</button>
	</p>
</form>
<%
if (request.getMethod().equals("POST")) {
%>
<p>
	Username:
	<%=request.getParameter("usr")%></p>
<p>
	Password:
	<%=request.getParameter("pwd")%></p>
<p>
	Email:
	<%=request.getParameter("email")%></p>
<p>
	Gender:
	<%=request.getParameter("gender")%></p>
<%
}
%>
