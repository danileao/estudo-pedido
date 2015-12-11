<%@tag description="[Jqplot] acesse: http://www.jqplot.com/docs/ para documentação" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/jquery.jqplot.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.barRenderer.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.pieRenderer.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.meterGaugeRenderer.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.categoryAxisRenderer.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.pointLabels.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.canvasTextRenderer.min.js"></script>

<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.donutRenderer.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.canvasAxisTickRenderer.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.dateAxisRenderer.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.highlighter.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.cursor.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.canvasOverlay.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/plugins/jqplot.enhancedLegendRenderer.min.js"></script>

<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/syntaxhighlighter/scripts/shCore.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/syntaxhighlighter/scripts/shBrushJScript.min.js"></script>
<script type="text/javascript" src="/AcumenDashboard/resources/jquery/jqplot/syntaxhighlighter/scripts/shBrushXml.min.js"></script>

<link rel="stylesheet" type="text/css" href="/AcumenDashboard/resources/jquery/jqplot/jquery.jqplot.css" />  		
<link rel="stylesheet" type="text/css" href="/AcumenDashboard/resources/jquery/jqplot/custom-style.css" />
<link rel="stylesheet" type="text/css" href="/AcumenDashboard/resources/css/dashboard.css" />

<script type="text/javascript" charset="utf-8" src="/AcumenDashboard/resources/jquery/jquery.bindWithDelay.js"></script>
<script type="text/javascript" charset="utf-8" src="/AcumenDashboard/resources/jquery/jqplot/jqplot-controller.js"></script>
<script type="text/javascript" charset="utf-8" src="/AcumenDashboard/resources/jquery/jquery.fileDownload.js"></script>
<script type="text/javascript" charset="utf-8" src="/AcumenDashboard/resources/jquery/jqplot/jqplot-exportToImage.js"></script>
<script type="text/javascript" charset="utf-8" src="/AcumenDashboard/resources/jquery/jquery.PrintArea.js"></script>



<script type="text/javascript"> 
	$(document).ready(function(){
	$.jsDate.regional['pt-br'] = {
        monthNames: ['Janeiro','Fevereiro','Março','Abril','Maio','Junho','Julho','Agosto','Setembro','Outubro','Novembro','Dezembro'],
        monthNamesShort: ['Jan','Fev','Mar','Abr','Mai','Jun','Jul','Ago','Set','Out','Nov','Dez'],
       	dayNames: ['Domingo','Segunda','Terça','Quarta','Quinta','Sexta','Sábado'],
        dayNamesShort: ['Dom','Seg','Ter','Qua','Qui','Sex','Sab'],
        formatString: '%d-%m-%Y'
    };
	$.jsDate.regional.getLocale();

	$("html").attr("lang","pt-BR");
	});	
</script>