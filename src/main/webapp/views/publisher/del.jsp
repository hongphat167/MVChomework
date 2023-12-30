<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="me" uri="/WEB-INF/template"%>
<me:bg title="Publisher Deletion">
    <jsp:attribute name="content">
        <div class="page-header">Delete Publisher</div>
        
        <c:choose>
            <c:when test="${success}">
                <p class="success">Publisher deleted successfully!</p>
            </c:when>
            <c:otherwise>
                <p>Are you sure you want to delete the publisher?</p>

                <form method="post" class="form">
                    <input type="hidden" name="id" value="${o.id}">
                    
                    <div>
                        <label>Name</label>
                        <span>${o.name}</span>
                    </div>

                    <div>
                        <button class="btn btn-danger" type="submit">Delete</button>
                    </div>
                </form>
            </c:otherwise>
        </c:choose>

        <c:if test="${not empty msg}">
            <p class="error">${msg}</p>
        </c:if>
    </jsp:attribute>
</me:bg>
