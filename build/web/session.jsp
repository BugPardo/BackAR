
<b:base title="${initParam.tema}">
    <!--Boostrap-->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
   
    
	<nav class="navbar navbar-dark bg-primary">
<h1>Welcome, ${sessionScope.sessionFullname}</h1>
<ul class="nav justify-content-end">
  <li class="nav-item">
    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">logout</button>
  </li>
</ul>
</nav>


	<div class="container">
		<h1>Bienvenido, ${sessionScope.user}</h1>
		<h2>Tu Session</h2>
		<ul>
                        <li>Full Name: <strong>${sessionScope.sessionFullname }</strong></li>
			<li>Session Id: <strong>${sessionScope.sessionId }</strong></li>
			<li>Creation Time: <strong>${sessionScope.creationTime}</strong></li>
			<li>Last Accessed Time: <strong>${sessionScope.lastAccessedTime}</strong></li>
			<li>Max Inactive Interval: <strong>${sessionScope.maxInactiveInterval}</strong></li>
			<li>Visits: <strong>${sessionScope.visits }</strong></li>
		</ul>
		<form action="${pageContext.request.contextPath }/Sessions">
			<button class="btn btn-default btn-sm" type="submit">
	  			<span class="glyphicon glyphicon-ok" aria-hidden="true"></span> Add visit
			</button>
		</form>
		<br>
		<form action="${pageContext.request.contextPath }/Sessions">
			<input type="text" hidden="true" name="reset" value=""/>
			<button class="btn btn-default btn-sm" type="submit">
	  			<span class="glyphicon glyphicon-minus" aria-hidden="true"></span> Reset visits
			</button>
		</form>
		<h2>Tus Cookies</h2>
		<ul>
	
			<c:forEach var="ck" items="${cookie}">
				<li>${ck.key}: <strong>${ck.value.value}</strong></li>
			</c:forEach>
		</ul>
		<br>
		<form action="${pageContext.request.contextPath}/Logout">
			<button class="btn  btn-sm btn-primary" type="submit">
			<span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>Log out</button>
		</form>

	</div>
</b:base>