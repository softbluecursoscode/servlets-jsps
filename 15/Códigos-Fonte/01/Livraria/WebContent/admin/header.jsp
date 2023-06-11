<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">
<head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- This template was created by Mantis-a [http://www.mantisa.cz/]. For more templates visit Free website templates [http://www.mantisatemplates.com/]. -->

<meta name="Description" content="..." />
<meta name="Keywords" content="..." />
<meta name="robots" content="all,follow" />
<meta name="author" content="..." />
<meta name="copyright" content="Mantis-a [http://www.mantisa.cz/]" />

<meta http-equiv="Content-Script-Type" content="text/javascript" />

<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<!-- CSS -->
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css" type="text/css" media="screen, projection, tv" />
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style-print.css" type="text/css" media="print" />

<title>Livraria Virtual</title>
</head>

<body>
<div id="main">

	<!-- Header -->
	<div id="header">
		<div id="header-in">

		<!-- Your website name  -->
		<h1><a href="#">Livraria Virtual</a></h1>
		<!-- Your website name end -->
		
			<!-- Your slogan -->
			<h2>Seu Livro, Seu Conhecimento</h2>
			<!-- Your slogan end -->
		</div>
	</div>
	<!-- Header end -->
	
	<!-- Menu -->
	<div id="menu-box" class="cleaning-box">
	<a href="#skip-menu" class="hidden">Skip menu</a>
		<ul id="menu">
			<li class="first"> 
			<c:if test="${menuAtivo == 'livros' }">
				<a href="<%=request.getContextPath()%>/admin/ListarLivros.action" class="active">Livros</a>
			</c:if>
			<c:if test="${menuAtivo != 'livros' }">
				<a href="<%=request.getContextPath()%>/admin/ListarLivros.action">Livros</a>
			</c:if>
			</li>
			
			<c:if test="${menuAtivo == 'pedidos' }">
				<li><a href="<%=request.getContextPath()%>/admin/GerenciarPedidos.action" class="active">Pedidos</a></li>
			</c:if>
			<c:if test="${menuAtivo != 'pedidos' }">
				<li><a href="<%=request.getContextPath()%>/admin/GerenciarPedidos.action">Pedidos</a></li>
			</c:if>
			
		</ul>
	</div>
	<!-- Menu end -->
	
<hr class="noscreen" />

<div id="skip-menu"></div>
	
	<div id="content">
	
		<!-- Content box with white background and gray border -->
		<div id="content-box">
		
			<!-- Left column -->
			<div id="content-box-in-left">
				<div id="content-box-in-left-in">