<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../temps/bootStrap_css.jsp"></c:import>
     </head>
    


	<c:import url="../temps/header.jsp"></c:import>
    
  	<section id="contents" class="container-fluid" >
    	<div class="row mt-4">
			<form action="./update" method="post">
			  <input type="hidden" name="region_id" value="${dto.region_id}">	
			  <div class="mb-3">
			    <label for="regionName" class="form-label">RegionName</label>
			    <input type="text" name="region_name" value="${dto.region_name}" class="form-control" id="regionName">
			  </div>

			  <button type="submit" class="btn btn-primary">Update</button>
			</form>    		
    	
    	</div>
    
    </section>
   
    
    	<c:import url="../temps/bootStrap_js.jsp"></c:import>
     </body>
</html>