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
	<style type="text/css">	
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
                     <li>
                        <a href="${pageContext.request.contextPath }/myclass">
                            <i class="material-icons">library_books</i>
                            <p>Class</p>
                        </a>
                    </li>
                    <li class="active">
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
                        <a class="navbar-brand" href="#"> Pembahasan Materi </a>
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
	                                    <h4 class="title">Tambah Materi</h4>
	                                </div>
	                             	<div class="card-content table-responsive">
	                             <form:form action="${pageContext.request.contextPath }/pembahasan/save" commandName="commandPembahasan" method="POST">
									<form:errors path="*" cssClass="errorblock" element="div"/>
									<div class="form-group">
										<label for="sectionTitle">Title</label>
										<form:input type="text" path="sectionTitle" class="form-control" id="sectionTitle" placeholder="Enter Class Title" />
										 <form:errors style="color: red;" path="sectionTitle"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">URL Video</label>
										<form:input type="text" path="videosUrl" class="form-control" id="videosUrl" placeholder="Enter video URL" />
										 <form:errors style="color: red;" path="videosUrl"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Category</label>
										<form:input type="text" path="category" class="form-control" id="category" placeholder="Enter Category" />
										 <form:errors style="color: red;" path="category"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">File URL</label>
										<form:input type="text" path="fileUrl" class="form-control" id="fileUrl" placeholder="Enter Category" />
										 <form:errors style="color: red;" path="fileUrl"></form:errors>
									</div>
									<div class="form-group">
										<label for="name">Blog URL</label>
										<form:input type="text" path="blogUrl" class="form-control" id="blogUrl" placeholder="Enter Category" />
										 <form:errors style="color: red;" path="blogUrl"></form:errors>
									</div>
									<%-- <div class="form-group">
										<label for="name">Programming Language</label>
										<select class="form-control" >
											<c:forEach var="myval" items="lgList">
												<option value="java">java</option>
												<option value="php">php</option>
												<option value=".NET">.NET</option>
											</c:forEach>
										</select>
									</div> --%>
									<div class="form-group">
										<label for="name">Programming Language</label>
										  <form:select class="form-control"  path="myClass.id">
										  	<c:forEach items="${listClass }" var="myclass">
										  		 <form:option value="${myclass.id }">${myclass.title} (${myclass.programmingLanguage})</form:option>
										  	</c:forEach>
										  </form:select>
									</div>
									<div class="form-group">
										<label for="name">Materi Pembahasan</label>
										<form:textarea style="width: 100%; min-height: 150px;" path="contentText" id="contentText"/>
										<div id="exampleid">
										 <form:errors style="color: red;" path="contentText"></form:errors>
									</div>
									<input type="submit" id="add-book" class="btn btn-sm btn-primary" value="Save" />		
								</form:form> 
	                     			</div>
	                 			</div>
	                   	</div>
                	</div>
                    <div class="row">
                    <div class="col-lg-12 col-md-12">
                            <div class="card">
                                <div class="card-header" data-background-color="orange">
                                    <h4 class="title">List Materi</h4>
                                    <p class="category">
                                </div>
                                <div class="card-content table-responsive">
                                    <table id="table-user" class="table table-hover">
                                        <thead class="text-warning">
                                            <th>Title</th>
                                            <th>Video URL</th>
                                            <th>Category</th>
                                            <th>File URL</th>
                                            <th>Blog URL</th>
                                            <th>Action</th>
                                        </thead>
                                        <tbody>
                                             <c:forEach var="bahasan" items="${myPagination.dataPopulate }">
                                            	<tr>
                                            		<td><c:out value="${bahasan.sectionTitle }"></c:out></td>
                                            		<td><c:out value="${bahasan.videosUrl }"></c:out></td>
                                            		<td><c:out value="${bahasan.category }"></c:out></td>
                                            		<td><c:out value="${bahasan.fileUrl }"></c:out></td>
                                            		<td><c:out value="${bahasan.blogUrl }"></c:out></td>
                                            		<td>
                                            			<button id="${bahasan.id }" type="button" rel="tooltip" title="Edit ${mc.title }" class="btn btn-success btn-simple btn-xs btn-edit">
										                    <i class="fa fa-edit"></i>
										                </button>
										                <button id="${bahasan.id }" type="button" rel="tooltip" title="Remove" class="btn btn-danger btn-simple btn-xs btn-delete">
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
            	<%@ include file="./modal/edit-pembahasan.html" %>
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
    	
    	//set style editor 
    	
    	$('.btn-delete').on('click', function(){
    		var id = $(this).attr('id');
    		var conf = confirm('Are you sure delete data ?');
    		if(conf == true){
    			//do delete
    			ajaxSetUp();
    			$.ajax({
    				type: 'DELETE',
    				url : '${pageContext.request.contextPath}/pembahasan/delete/'+id,
    				success: function(data){
    					window.location = '${pageContext.request.contextPath}/pembahasan';
    				}
    			});
    		}
    		
    		return false;
    	});
    	
    	$(".btn-edit").on('click', function(){
    		var id = $(this).attr('id');
    		ajaxSetUp();
    		$.ajax({
    			url : "${pageContext.request.contextPath}/pembahasan/get?id="+id,
    			type: 'GET',
    			success: function(data){
    				$('#id-bahasan').val(data.id);
    				$('#title-bahasan').val(data.sectionTitle);
    				$('#category-bahasan').val(data.category);
    				$('#file-url-bahasan').val(data.fileUrl);
    				$('#video-url-bahasan').val(data.videosUrl);
    				$('#blog-url-bahasan').val(data.blogUrl);
    				$('#content-bahasan').val(data.contentText);
    				
    			}, dataType: 'json'
    		});
    		$('#edit-bahasan-modal').modal();
    	});
    	
    	$('#btn-update-bahasan-submit').on('click', function(){
    		var pembahasan = {
    				id : $('#id-bahasan').val(),
    				sectionTitle: $('#title-bahasan').val(),
    				category: $('#category-bahasan').val(),
    				fileUrl: $('#file-url-bahasan').val(),
    				videosUrl: $('#video-url-bahasan').val(),
    				blogUrl: $('#blog-url-bahasan').val(),
    				contentText: $('#content-bahasan').val()
    		};
    		console.log(pembahasan);
    		ajaxSetUp();
    		$.ajax({
    			url : '${pageContext.request.contextPath}/pembahasan/update',
    			type: 'PUT',
    			contentType: 'application/json',
    			data : JSON.stringify(pembahasan),
    			success : function(data){
    				window.location = "${pageContext.request.contextPath}/pembahasan";
    			}, error: function(){
					alert('update failed!!');
    			}
    		});
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