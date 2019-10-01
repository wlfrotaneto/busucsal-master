<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<link rel="stylesheet" href="/css/busucsal.css" />
<link rel="stylesheet" href="/webjars/bootstrap/4.1.3/css/bootstrap.min.css" />
<title>BusUCSal</title>
</head>
<body>
	<header>
		<div class="collapse bg-dark" id="navbarHeader">
			<div class="container">
				<div class="row">
					<div class="col-sm-8 col-md-7 py-4">
						<h4 class="text-white">Sobre</h4>
						<p class="text-muted">Horários do BusUCSal UCSal.</p>
					</div>
					<div class="col-sm-4 offset-md-1 py-4">
						<h4 class="text-white">Contato</h4>
						<ul class="list-unstyled">
							<li><a href="#" class="text-white">Siga no Twitter</a></li>
							<li><a href="#" class="text-white">Curta no Facebook</a></li>
							<li><a href="#" class="text-white">Email</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div class="navbar navbar-dark bg-dark box-shadow">
			<div class="container d-flex justify-content-between">
				<a href="#" class="navbar-brand d-flex align-items-center"> <strong>BusUCSal</strong>
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarHeader" aria-controls="navbarHeader"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>
			</div>
		</div>
	</header>
	<main role="main">
	<div class="album py-5 bg-light">
		<div class="container">
			<div class="row">
				<h1>Adicionar Usuários</h1>	
			</div>		
			<div class="row">			
				<form action="usuario" method="post">
					Usuário:<br> <input type="text" name="usuario" value="${user.usuario}"><br>
					Senha:<br> <input type="text" name="senha" value="${user.senha}"><br>
					<input type="submit" value="Enviar"><br>
				</form>
			</div>
		</div>
	</div>
	</main>
	<footer class="text-muted">
		<div class="container">
			<p class="float-right">
				<a href="#">Voltar para o Topo</a>
			</p>
			<p>BusUCSal é &copy; UCSal!</p>
		</div>
	</footer>
	<script src="/webjars/jquery/3.3.1-1/jquery.min.js"></script>
	<script src="/webjars/popper.js/1.14.4/umd/popper.min.js"></script>
	<script src="/webjars/bootstrap/4.1.3/js/bootstrap.min.js"></script>
	<script src="/webjars/holderjs/2.5.2/holder.min.js"></script>
<script type="text/javascript">
</script>
</body>
</html>