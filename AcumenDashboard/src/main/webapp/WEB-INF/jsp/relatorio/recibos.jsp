<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Acumen</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet"
	href="<c:url value='/bootstrap/css/bootstrap.min.css'/>">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet"
	href="<c:url value='/dist/css/AdminLTE.min.css'/>">
<!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
<link rel="stylesheet"
	href="<c:url value='/dist/css/skins/_all-skins.min.css'/>">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<style>
.chart-legend li span {
	display: inline-block;
	width: 12px;
	height: 12px;
	margin-right: 5px;
}

ul {
	list-style-type: none;
}
</style>
<link rel="stylesheet"
	href="<c:url value='/resources/css/recibo.css'/>">
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Left side column. contains the logo and sidebar -->
		
		
		<jsp:include page="../menu/menu.jsp"></jsp:include>
		
		<!-- Content Wrapper. Contains page content -->
		<div class="content-wrapper">
			<!-- Content Header (Page header) -->
			<section class="content-header">
				<h1>
					Recibos Recebidos - Dezembro
				</h1>
			</section>

			<section class="content">
				<div class="row">
					<div class="box box-primary">
					
						<div class="recibo-div">
							<c:forEach items="${recibos}" var="rec">
								<div class="recibo-opt">
									<img class="recibo-img" src="${linkTo[ReciboController].buscarIMG(rec.id)}"/>
									<br/>
									<label>Usuário: ${rec.usuario}</label>
									<br/>
									<label>Centro de Custo: ${rec.centroCusto}</label>
									<br/>
									<label>Categoria: ${rec.categoria}</label>
									<br/>
									<label>Valor: <fmt:formatNumber value="${rec.valor}" minFractionDigits="2" type="currency" currencySymbol="R$"/></label>
									<br/>
									<label>Data: <fmt:formatDate value="${rec.dataEnvio}" pattern="dd/MM/yyyy" /></label>
								</div>
							</c:forEach>
							
						</div>
						</div>
					
				</div>

			</section>
		</div>
		<div class="control-sidebar-bg"></div>
		
		<jsp:include page="../menu/rodape.jsp"></jsp:include>
	</div>
	<!-- ./wrapper -->

	<!-- jQuery 2.1.4 -->
	<script src="<c:url value='/plugins/jQuery/jQuery-2.1.4.min.js'/>"></script>
	<!-- Bootstrap 3.3.5 -->
	<script src="<c:url value='/bootstrap/js/bootstrap.min.js'/>"></script>
	<!-- ChartJS 1.0.1 -->
	<script src="<c:url value='/plugins/chartjs/Chart.min.js'/>"></script>
	<!-- FastClick -->
	<script src="<c:url value='/plugins/fastclick/fastclick.min.js'/>"></script>
	<!-- AdminLTE App -->
	<script src="<c:url value='/dist/js/app.min.js'/>"></script>
	<!-- AdminLTE for demo purposes -->
	<script src="<c:url value='/dist/js/demo.js'/>"></script>
	<!-- page script -->

</body>
</html>
