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
                    Bank Mega
                </a>
            </div>
            <div class="sidebar-wrapper">
                <ul class="nav">
                    <li class="active">
                        <a href="dashboard.html">
                            <i class="material-icons">dashboard</i>
                            <p>Dashboard</p>
                        </a>
                    </li>
                     <li>
                        <a href="${pageContext.request.contextPath }/department">
                            <i class="material-icons">library_books</i>
                            <p>Department</p>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/employee">
                             <i class="material-icons">bubble_chart</i>
                            <p>Employee</p>
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
                        <a class="navbar-brand" href="#"> Employee Datatable </a>
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
	                                    <h4 class="title">Form Add Employee</h4>
	                                </div>
	                             	<div class="card-content table-responsive">
	                             		 
	                             	<form:form action="${pageContext.request.contextPath }/employee/dosave" commandName="employeeForm" method="POST">
									<%-- <form:errors path="*" cssClass="errorblock" element="div"/> --%>
									<div class="form-group">
										<label for="name">Name</label>
										<form:input type="text" path="name" class="form-control" id="code" placeholder="Enter Your Name" />
										 <form:errors style="color: red;" path="name"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Email</label>
										<form:input type="text" path="email" class="form-control" id="code" placeholder="Enter Your Email" />
										 <form:errors style="color: red;" path="email"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Salary</label>
										<form:input type="text" path="salary" class="form-control" id="code" placeholder="Must be Number, ex: 2000" />
										 <form:errors style="color: red;" path="salary"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Birth Date</label>
										<form:input id="birthDate123" type="text" path="birthDate" class="form-control"/>
										 <form:errors style="color: red;" path="birthDate"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Department</label>
										<form:select  path="department.id">
											<c:forEach var="department" items="${departments }">
												<form:option value="${department.id }">
													<c:out value="${department.departmentName }"></c:out>
												</form:option>
											</c:forEach>
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
                                    <h4 class="title">List Employee</h4>
                                    <p class="category">
                                </div>
                                <div class="card-content table-responsive">
                                    <table id="table-user" class="table table-hover">
                                        <thead class="text-warning">
                                            <th>Name</th>
                                            <th>Email</th>
                                            <th>Salary</th>
                                            <th>Birth Date</th>
                                            <th>Department</th>
                                            <th>Action</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="employee" items="${employees }">
                                            	<tr>
                                            		<td><c:out value="${employee.name }"></c:out></td>
                                            		<td><c:out value="${employee.email }"></c:out></td>
                                            		<td><c:out value="${employee.salary }"></c:out></td>
                                            		<td><c:out value="${employee.birthDate }"></c:out></td>
                                            		<td><c:out value="${employee.department.departmentName }"></c:out></td>
                                            		<td>
                                            			<button id="${employee.id }" type="button" rel="tooltip" title="Edit ${employee.name }" class="btn btn-success btn-simple btn-xs btn-edit">
										                    <i class="fa fa-edit"></i>
										                </button>
										                <button id="${employee.id }" type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs btn-delete">
										                    <i class="fa fa-times"></i>
										                </button>
                                            		</td>
                                            	</tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
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
        </div>
    </div>
    <%@include file="/WEB-INF/pages/modal/edit-employee.html" %>
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
    	//setting up datepicker
    	$('#birthDate123').datepicker();
    	
    	 function ajaxSetUp(){
    		 var token = $("meta[name='_csrf']").attr("content");
    		  var header = $("meta[name='_csrf_header']").attr("content");
    		  $(document).ajaxSend(function(e, xhr, options) {
    		    xhr.setRequestHeader(header, token);
    		  });
    	 }
    	 
    	 $('#table-user').DataTable();
    	 
    	 $('.btn-delete').on('click', function(){
    		 var conf = confirm("Are you sure delete this data ?");
    		 if(conf == true){
    			 var id = $(this).attr("id");
    			 
    			 ajaxSetUp();
    			 $.ajax({
    				 url : '${pageContext.request.contextPath}/employee/delete/'+id,
    				 type: 'DELETE',
    				 success: function(data){
    					 window.location = "${pageContext.request.contextPath}/employee";
    				 }, error : function(){
    					 alert('delete data failed..!!');
    				 }
    			 });
    		 }
    		 
    		 return false;
    	 });
    	 
    	 $(".btn-edit").on('click', function(){
    		 var id = $(this).attr('id');
    		 $.ajax({
    			 url : '${pageContext.request.contextPath}/employee/get/'+ id,
    			 type: 'GET',
    			 success : function(data){
    				 $('#name-employee').val(data.name);
    				 $('#edit-department').val(data.department.id);
    				 $('#id-employee').val(data.id);
    				 $('#birthDate').val(data.birthDate);
    				 $('#email-employee').val(data.email);
    				 $('#salary-employee').val(data.salary);
    			 },
    			 dataType: 'json'
    		 })
    		 
    		$('#edit-employee-modal').modal();
    	 });
    	 
    	 $('#btn-update-employee-submit').on('click', function(){
    		var validate = $('#form-edit-employee').parsley();
    		if(validate.validate()){
    			var employee = {
    				name : $('#name-employee').val(),
       				id :  $('#id-employee').val(),
       				email : $('#email-employee').val(),
       				salary : $('#salary-employee').val(),
       				birthDate :  $('#birthDate').val(),
       				department : {
       					id : $('#edit-department').val()
       				}
    			}
    			
    			ajaxSetUp();
    			$.ajax({
    				url : '${pageContext.request.contextPath}/employee/save',
    				type: 'POST',
    				data: JSON.stringify(employee),
    				contentType: "application/json",
    				success : function(data){
    					window.location = "${pageContext.request.contextPath}/employee";
    				},error: function(){
    					alert('update failed');
    				}
    			});
    		}
    	 });
    	 
    	 //logout event button
    	 $('#logout').click(function(event){
    		 event.preventDefault();
    		$('#logoutForm').submit();
    	 });
    });
</script>

</html>