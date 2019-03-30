<b:base title="${initParam.tema}">
    <link rel="stylesheet" href="style.css">
    <div class="container">
        <form class="box" action="${pageContext.request.contextPath}/Login" method="post">
            <h1>Login</h1>
            <input type="text" id="inputUsername" name="inputUsername"  placeholder="Username" required autofocus>
            <input type="password" id="inputPassword" name="inputPassword"  placeholder="Password" required>
          
         <input type="submit" name="" value="Login">
      </div>
    </b:base>

