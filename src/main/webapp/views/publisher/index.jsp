<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="me" uri="/WEB-INF/template"%>
<me:bg title="Publisher">
    <jsp:attribute name="content">
        <div class="page-header">Manage Publisher</div>
        <p>
            <a href="${pageContext.request.contextPath}/publisher/add.html">Add New Publisher</a>
        </p>
        <form method="post" action="${pageContext.request.contextPath}/publisher/del.html">
            <table class="table">
                <thead>
                    <tr>
                        <td><button class="btn btn-info">Delete</button></td>
                        <th>Id</th>
                        <th>Name</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${list}" var="o">
                        <tr>
                            <td>
                                <input type="checkbox" value="${o.id}" name="ids">
                            </td>
                            <td>${o.id}</td>
                            <td>${o.name}</td>
                            <td>
                                <a href="${pageContext.request.contextPath}/publisher/edit.html?id=${o.id}">
                                    <img src="${pageContext.request.contextPath}/views/images/edit.png" alt="Edit">
                                </a>
                            </td>
                            <td>
                                <a href="${pageContext.request.contextPath}/publisher/del.html?id=${o.id}">
                                    <img src="${pageContext.request.contextPath}/views/images/trash.png" alt="Delete">
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </form>
    </jsp:attribute>
</me:bg>
