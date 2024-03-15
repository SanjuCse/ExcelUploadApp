<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib prefix="frm" uri="http://www.springframework.org/tags/form" %>
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
<!-- 	<form action="/upload" method="post" enctype="multipart/form-data"> -->
<!-- 		<button type="submit">Upload</button> -->
<!-- 	</form> -->
<!--     <div class="text-center mt-2"> -->
<!--         <a class="btn btn-primary" href="emp_report"><span class="bi bi-database"></span> Report Page</a> -->
<!--         <a class="btn btn-secondary" href="./"><span class="bi bi-house"></span> Home Page</a> -->
<!--     </div> -->
</div>
</body>
</html>
