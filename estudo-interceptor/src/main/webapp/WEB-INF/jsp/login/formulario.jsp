<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="/estudo-interceptor/resources/css/login.css" rel="stylesheet" type="text/css">
<title>Login</title>
</head>
<body>
	<form action="login" method="post">
		<div>
			<label>Usuário</label>
			<input type="text" name="login" />
		</div>
		<div>
			<label>Senha</label>
			<input type="password" name="senha">
		</div>
		<div class="button">
			<input type="submit" value="Entrar"/>
		</div>
	</form>
</body>
</html>