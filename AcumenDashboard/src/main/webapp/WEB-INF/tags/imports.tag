<%@ tag language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="ps" tagdir="/WEB-INF/tags" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

 <!-- Bootstrap 3.3.4 -->
    <link href="<c:url value='/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet" type="text/css" />    
    <!-- FontAwesome 4.3.0 -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
    <!-- Ionicons 2.0.0 -->
    <link href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css" rel="stylesheet" type="text/css" />    
    <!-- Theme style -->
    <link href="<c:url value='/dist/css/AdminLTE.min.css'/>" rel="stylesheet" type="text/css" />
    <!-- AdminLTE Skins. Choose a skin from the css/skins 
         folder instead of downloading all of them to reduce the load. -->
    <link href="<c:url value='/dist/css/skins/_all-skins.min.css'/>" rel="stylesheet" type="text/css" />
    <!-- iCheck -->
    <link href="<c:url value='/plugins/iCheck/flat/blue.css'/>" rel="stylesheet" type="text/css" />
    <!-- Morris chart -->
    <link href="<c:url value='/plugins/morris/morris.css'/>" rel="stylesheet" type="text/css" />
    <!-- jvectormap -->
    <link href="<c:url value='/plugins/jvectormap/jquery-jvectormap-1.2.2.css'/>" rel="stylesheet" type="text/css" />
        <!-- DataTables -->
    <link rel="stylesheet" href="<c:url value='/plugins/datatables/dataTables.bootstrap.css'/>">
    <!-- Date Picker -->
    <link href="<c:url value='/plugins/datepicker/datepicker3.css'/>" rel="stylesheet" type="text/css" />
    <!-- Daterange picker -->
    <link href="<c:url value='/plugins/daterangepicker/daterangepicker-bs3.css'/>" rel="stylesheet" type="text/css" />
    <!-- bootstrap wysihtml5 - text editor -->
    <link href="<c:url value='/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css'/>" rel="stylesheet" type="text/css" />
    
        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    <!-- jQuery 2.1.4 -->
    <script src="<c:url value='/plugins/jQuery/jQuery-2.1.4.min.js'/>"></script>
    <!-- jQuery UI 1.11.2 -->
    <script src="http://code.jquery.com/ui/1.11.2/jquery-ui.min.js" type="text/javascript"></script>
    <!-- Resolve conflict in jQuery UI tooltip with Bootstrap tooltip -->
    <script>
      $.widget.bridge('uibutton', $.ui.button);
    </script>
    <!-- Bootstrap 3.3.2 JS -->
    <script src="<c:url value='/bootstrap/js/bootstrap.min.js" type="text/javascript'/>"></script>    
    <!-- Morris.js charts -->
    <script src="http://cdnjs.cloudflare.com/ajax/libs/raphael/2.1.0/raphael-min.js"></script>
    <script src="<c:url value='/plugins/morris/morris.min.js'/>" type="text/javascript"></script>
    <!-- Sparkline -->
    <script src="<c:url value='/plugins/sparkline/jquery.sparkline.min.js'/>" type="text/javascript"></script>
    <!-- jvectormap -->
    <script src="<c:url value='/plugins/jvectormap/jquery-jvectormap-1.2.2.min.js'/>" type="text/javascript"></script>
    <script src="<c:url value='/plugins/jvectormap/jquery-jvectormap-world-mill-en.js'/>" type="text/javascript"></script>
    <!-- jQuery Knob Chart -->
    <script src="<c:url value='/plugins/knob/jquery.knob.js'/>" type="text/javascript"></script>
    <!-- daterangepicker -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.10.2/moment.min.js" type="text/javascript"></script>
    <script src="<c:url value='/plugins/daterangepicker/daterangepicker.js'/>" type="text/javascript"></script>
    <!-- datepicker -->
    <script src="<c:url value='/plugins/datepicker/bootstrap-datepicker.js'/>" type="text/javascript"></script>
    <!-- Bootstrap WYSIHTML5 -->
    <script src="<c:url value='/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js'/>" type="text/javascript"></script>
    <!-- Slimscroll -->
    <script src="<c:url value='/plugins/slimScroll/jquery.slimscroll.min.js'/>" type="text/javascript"></script>
    <!-- FastClick -->
    <script src='<c:url value="/plugins/fastclick/fastclick.min.js"/>'></script>
    <!-- DataTables -->
    <script src="<c:url value='/plugins/datatables/jquery.dataTables.min.js'/>"></script>
    <!-- AdminLTE App -->
    <script src="<c:url value='/dist/js/app.min.js" type="text/javascript'/>"></script>    
   <!-- ChartJS 1.0.1 -->
    <script src="<c:url value='/plugins/chartjs/Chart.min.js'/>"></script>
    <!-- FastClick -->
    <script src="<c:url value='/plugins/fastclick/fastclick.min.js'/>"></script>
    
    <!-- AdminLTE dashboard demo (This is only for demo purposes) -->
    <script src="<c:url value='/dist/js/pages/dashboard.js'/>" type="text/javascript"></script>    
    
    <!-- AdminLTE for demo purposes -->
    <script src="<c:url value='/dist/js/demo.js'/>" type="text/javascript"></script>
    