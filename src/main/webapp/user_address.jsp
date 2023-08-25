<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Address</title>
<%@include file="all_component/allCSS.jsp"%>
</head>
<body style="background-color: #f0f1f2;">
	<%@include file="all_component/navbar.jsp"%>

	<div class="container mt-2">
		<div class="row p-3">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					<h3 class="text-center text-success">Add Address</h3>
						<form action="">
							<div class="form-row">
								<div class="form-group col-md-6">
									<label for="inputpassword4">Address</label> <input type="text"
										class="form-control" id="inputpassword4">
								</div>

								<div class="form-group col-md-6">
									<label for="inputpassword4">Landmark</label> <input type="text"
										class="form-control" id="inputpassword4">
								</div>
							</div>
							<div class="form-row">
								<div class="form-group col-md-4">
									<label for="inputEmail4">City</label> <input type="text"
										class="form-control" id="inputEmail4">
								</div>
								
								<div class="form-group col-md-4">
									<label for="inputpassword4">State</label> <input type="text"
										class="form-control" id="inputpassword4">
								</div>
								
								<div class="form-group col-md-4">
									<label for="inputEmail4">Pin Code</label> <input type="text"
										class="form-control" id="inputEmail4">
								</div>
							</div>
							<div class="text-center">
							 <button class="btn btn-warning text-white">Add Address</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>