<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<form method="post" class="form">
	<p>
		<label>Number</label> <select name="num">
			<c:forEach var="i" begin="2" end="9" step="1">
				<option value="${i}">${i}</option>
			</c:forEach>
		</select>
	</p>
	<p>
		<button>View</button>
	</p>
</form>
<c:if test="${pageContext.request.method == 'POST'}">
	<c:forEach var="i" begin="1" end="10" step="1">
		<p>${i}x ${param.num} = ${i * param.num}</p>
	</c:forEach>
</c:if>
