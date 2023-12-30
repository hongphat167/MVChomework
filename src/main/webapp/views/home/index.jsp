<%@taglib prefix="me" uri="/WEB-INF/template" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<me:bg title="Mini Shop">
    <jsp:attribute name="content">
        <form class="form-search" method="get" action="${pageContext.request.contextPath}/home/search.html">
            <input type="text" placeholder="Search..." name="q">
            <button class="btn btn-primary">Search</button>
        </form>

        <div class="page-header">
            Products
        </div>

        <div class="products">
            <div class="row">
                <c:forEach var="product" items="${list}">
                    <div class="col-3">
                        <div class="item">
                            <img alt="${product.title}" src="${pageContext.request.contextPath}/upload/${product.imageUrl}">
                            <div class="info">
                                <a href="${pageContext.request.contextPath}/home/detail.html?id=${product.id}">
                                    ${product.title}
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>

        <ul class="pagination">
            <c:forEach begin="1" end="${n}" step="1" var="i">
                <li class="page-item">
                    <a class="page-link" href="${pageContext.request.contextPath}/home.html?p=${i}">
                        ${i}
                    </a>
                </li>
            </c:forEach>
        </ul>
    </jsp:attribute>
</me:bg>
