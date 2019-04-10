<b:base title="${initParam.tema}">
    <link rel="stylesheet" href="style.css">
    <div class="container">
        <form class="box" action="${pageContext.request.contextPath}/Login" method="post">
            <h1>Login</h1>
            <input type="text" id="inputUsername" name="inputUsername"  placeholder="Username" required autofocus>
            <input type="password" id="inputPassword" name="inputPassword"  placeholder="Password" required>
          <div class="alert alert-warning" role="alert">
            <li><strong>${sessionScope.erroruser }</strong></li>
          </div>
         <input type="submit" name="" value="Login">
      </div>
    </b:base>

