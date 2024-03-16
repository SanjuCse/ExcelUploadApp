<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Home Page</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
    <link
            href="../../css/bootstrap.min.css"
            rel="stylesheet"></link>
    <script
            src="../../js/bootstrap.bundle.min.js"></script>
</head>
<body>
<div class="container mt-5">
	<c:if test="${!empty resultMsg}">
		<c:set var="STATUS" value="${Status}" />
		<c:set var="SUCCESS" value="Success" />
		<c:set var="FAILURE" value="Failure" />
		
		
<%-- 		<c:if test="${fn:toUpperCase(str1) eq fn:toUpperCase(str2)}"> --%>
<!--     		Strings are equal ignoring case. -->
<%-- 		</c:if> --%>
		
		<c:if test="${fn:toUpperCase(SUCCESS) eq fn:toUpperCase(STATUS)}">
	        <div class="alert alert-success fade show alert-dismissible">
	            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	            <span>${resultMsg}</span>
	        </div>
	    </c:if>
		<c:if test="${fn:toUpperCase(FAILURE) eq fn:toUpperCase(STATUS)}">
	        <div class="alert alert-danger fade show alert-dismissible">
	            <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
	            <span>${resultMsg}</span>
	        </div>
	    </c:if>
	</c:if>
    <h1 class="text-center text-success border rounded">Upload Excel Sheet</h1>
    <frm:form cssClass="form-control" enctype="multipart/form-data">
        <table class="table">
            <tbody class="col">
            <tr class="text-center">
            	<td>
					<div class="mb-3">
						<input class="form-control" type="file" name="file" id="formFile">
					</div>
            	</td>
                <td>
					<div class="mb-3">
		                <input type="submit" value="Upload" class="btn btn-primary">
		            </div>
		        </td>
            </tr>
            </tbody>
        </table>
    </frm:form>
</div>
</body>
</html>
