<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url value="/j_spring_security_logout" var="logoutUrl" />
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/assets/img/apple-icon.png" />
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/assets/img/favicon.png" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>Material Dashboard by Creative Tim</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />
    <meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <!-- Bootstrap core CSS     -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />
    <!--  Material Dashboard CSS    -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/material-dashboard.css?v=1.2.0" rel="stylesheet" />
    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/demo.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath}/resources/assets/datepicker/dist/datepicker.min.css" rel="stylesheet" />
    <!--     Fonts and icons     -->
    <link href="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap4.min.css" rel="stylesheet">
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='http://fonts.googleapis.com/css?family=Roboto:400,700,300|Material+Icons' rel='stylesheet' type='text/css'>
	<style>
		input.parsley-error
		{
		  color: #B94A48 !important;
		  background-color: #F2DEDE !important;
		  border: 1px solid #EED3D7 !important;
		}
		
	</style>
</head>
<body>
    <div class="wrapper">
        <div class="sidebar" data-color="purple" data-image="${pageContext.request.contextPath}/resources/assets/img/sidebar-1.jpg">
            <!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | blue | green | orange | red"

        Tip 2: you can also add an image using data-image tag
    -->
            <div class="logo">
                <a href="http://www.creative-tim.com" class="simple-text">
                    Ebc Development
                </a>
            </div>
            <div class="sidebar-wrapper">
                <ul class="nav">
                    <li>
                        <a href="dashboard.html">
                            <i class="material-icons">dashboard</i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                     <li class="active">
                        <a href="${pageContext.request.contextPath }/myclass">
                            <i class="material-icons">library_books</i>
                            <p>Class</p>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/pembahasan">
                             <i class="material-icons">bubble_chart</i>
                            <p>Materi</p>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/account">
                            <i class="material-icons">person</i>
                            <p>User Account</p>
                        </a>
                    </li>
                     <li>
                        <a href="#" id="logout">
                            <i class="material-icons">block</i>
                            <p>Logout</p>
                        </a>
                    </li>
                    <form action="${logoutUrl}" method="post" id="logoutForm">
					  <input type="hidden"
						name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					</form>
                </ul>
            </div>
        </div>
        <div class="main-panel">
            <nav class="navbar navbar-primary navbar-absolute">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="#"> Class Training </a>
                    </div>
                    <div class="collapse navbar-collapse">
                        
                        <form class="navbar-form navbar-right" role="search">
                            <div class="form-group  is-empty">
                                <input type="text" class="form-control" placeholder="Search">
                                <span class="material-input"></span>
                            </div>
                            <button type="submit" class="btn btn-white btn-round btn-just-icon">
                                <i class="material-icons">search</i>
                                <div class="ripple-container"></div>
                            </button>
                        </form>
                    </div>
                </div>
            </nav>
            <div class="content">
                <div class="container-fluid">
                    <div class="row">
	                    <div class="col-lg-12 col-md-12">
			                    <c:if test="${not empty message}">
									<div  class="alert alert-info" >
										<c:out value="${message }"></c:out>
									</div>	
								</c:if>
	                            <div class="card">
	                                <div class="card-header" data-background-color="transparent">
	                                    <h4 class="title">Form Add Class</h4>
	                                </div>
	                             	<div class="card-content table-responsive">
	                             		 
	                             	<form:form action="${pageContext.request.contextPath }/myclass/save" commandName="commandClass" method="POST">
									<form:errors path="*" cssClass="errorblock" element="div"/>
									<div class="form-group">
										<label for="name">Name</label>
										<form:input type="text" path="title" class="form-control" id="title" placeholder="Enter Class Title" />
										 <form:errors style="color: red;" path="title"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Description Class</label>
										<form:input type="text" path="description" class="form-control" id="description" placeholder="Enter Training Description" />
										 <form:errors style="color: red;" path="description"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Trainer</label>
										<form:input type="text" path="trainer" class="form-control" id="trainer" placeholder="Enter Trainer Name" />
										 <form:errors style="color: red;" path="trainer"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Programming Language</label>
										<form:select class="form-control" path="programmingLanguage">
										    <form:options items="${lgList}" />
										</form:select>
									</div>
									<input type="submit" id="add-book" class="btn btn-sm btn-primary" value="Add" />		
								</form:form>
	                     			</div>
	                 			</div>
	                   	</div>
                	</div>
                    <div class="row">
                    <div class="col-lg-12 col-md-12">
                            <div class="card">
                                <div class="card-header" data-background-color="orange">
                                    <h4 class="title">List Training Classes</h4>
                                    <p class="category">
                                </div>
                                <div class="card-content table-responsive">
                                    <table id="table-user" class="table table-hover">
                                        <thead class="text-warning">
                                            <th>Title</th>
                                            <th>Description</th>
                                            <th>Programing</th>
                                            <th>Trainer</th>
                                            <th>Action</th>
                                        </thead>
                                        <tbody>
                                             <c:forEach var="mc" items="${myPagination.dataPopulate }">
                                            	<tr>
                                            		<td><c:out value="${mc.title }"></c:out></td>
                                            		<td><c:out value="${mc.description }"></c:out></td>
                                            		<td><c:out value="${mc.programmingLanguage }"></c:out></td>
                                            		<td><c:out value="${mc.trainer }"></c:out></td>
                                            		<td>
                                            			<button id="${mc.id }" type="button" rel="tooltip" title="Edit ${mc.title }" class="btn btn-success btn-simple btn-xs btn-edit">
										                    <i class="fa fa-edit"></i>
										                </button>
										                <button id="${mc.id }" type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs btn-delete">
										                    <i class="fa fa-times"></i>
										                </button>
                                            		</td>
                                            	</tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                     <div>${myPagination.completeLinkePage }</div>
                                </div>
                            </div>
                        </div>
    
                    </div>
                </div>
            </div>
            <footer class="footer">
                <div class="container-fluid">
                    <nav class="pull-left">
                        <ul>
                            <li>
                                <a href="#">
                                    Home
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Company
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Portfolio
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    Blog
                                </a>
                            </li>
                        </ul>
                    </nav>
                    <p class="copyright pull-right">
                        &copy;
                        <script>
                            document.write(new Date().getFullYear())
                        </script>
                        <a href="http://www.creative-tim.com">Creative Tim</a>, made with love for a better web
                    </p>
                </div>
            </footer>
        	<div>
        		<%@ include file="./modal/edit-class.html" %>
        	</div>
        </div>
    </div>
    
</body>
<!--   Core JS Files   -->
<script src="${pageContext.request.contextPath}/resources/assets/js/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/assets/js/material.min.js" type="text/javascript"></script>
<!--  Charts Plugin -->
<script src="${pageContext.request.contextPath}/resources/assets/js/chartist.min.js"></script>
<!--  Dynamic Elements plugin -->
<script src="${pageContext.request.contextPath}/resources/assets/js/arrive.min.js"></script>
<!--  PerfectScrollbar Library -->
<script src="${pageContext.request.contextPath}/resources/assets/js/perfect-scrollbar.jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/assets/datepicker/dist/datepicker.js"></script>
<!--  Notifications Plugin    -->
<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-notify.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/parsley.js/2.8.0/parsley.min.js"></script>
<!-- Material Dashboard javascript methods -->
<script src="${pageContext.request.contextPath}/resources/assets/js/material-dashboard.js?v=1.2.0"></script>
<script src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js" />
<script src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js" />
<!-- Material Dashboard DEMO methods, don't include it in your project! -->
<script src="${pageContext.request.contextPath}/resources/assets/js/demo.js"></script>
<script type="text/javascript">
    $(document).ready(function() {
    	$('.btn-edit').on('click', function(){
    		var id = $(this).attr('id');
    		ajaxSetUp();
    		$.ajax({
    			type: 'GET',
    			url: '${pageContext.request.contextPath}/myclass/get/'+ id,
    			success: function(data){
    				$('#title-class').val(data.title);
    				$('#desc-class').val(data.description);
    				$('#id-class').val(data.id);
    			}
    		});
    		$("#edit-class-modal").modal();
    	});
    	
    	$('#btn-update-class-submit').click(function(){
    		var myclass = {
    			title : $('#title-class').val(),
    			description : $('#desc-class').val(),
    			id : $('#id-class').val()
    		}
    		
    		ajaxSetUp();
			$.ajax({
				type: 'PUT',
				contentType: 'application/json',
				data : JSON.stringify(myclass),
				url : '${pageContext.request.contextPath}/myclass/updclass',
				success: function(data){
					window.location = '${pageContext.request.contextPath}/myclass';
				}
			});
    	});
    	
    	$('.btn-delete').on('click', function(){
    		var id = $(this).attr('id');
    		var conf = confirm('Are you sure delete data ?');
    		if(conf == true){
    			//do delete
    			ajaxSetUp();
    			$.ajax({
    				type: 'DELETE',
    				url : '${pageContext.request.contextPath}/myclass/delete/'+id,
    				success: function(data){
    					window.location = '${pageContext.request.contextPath}/myclass';
    				}
    			});
    		}
    		
    		return false;
    	});
    	
    	function ajaxSetUp(){
	   		 var token = $("meta[name='_csrf']").attr("content");
	   		  var header = $("meta[name='_csrf_header']").attr("content");
	   		  $(document).ajaxSend(function(e, xhr, options) {
	   		    xhr.setRequestHeader(header, token);
	   		  });
	   	 }
    });
</script>

</html>