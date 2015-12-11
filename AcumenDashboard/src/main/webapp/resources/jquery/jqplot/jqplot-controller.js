(function($) {
$().ready(function() {
	
	$.jqConfig = {
            initialConfig: {grid: {backgroundColor: 'white'},axesDefaults: {tickOptions: {showMark: true,showGridline: true,show: false,showLabel: false}}}
	};
						
	$.extend({
		replaceAll: function(string, token, newtoken) {
	    	while (string.indexOf(token) != -1) {
	     		string = string.replace(token, newtoken);
	    	}
	    	return string;
	    },
	    setChartSize: function(){
	    	$('.grafico').each( function() {
	    		$(this).css("height",parseInt(parseInt($.replaceAll($(this).css("width")," px",""))*0.5));
    		});
	    	$('.meter-gauge-list').each( function() {
	    		var itens = $(this).children('li').length;
	    		$($(this).children('li')).each( function(index,meterGauge) {
	    			$(meterGauge).find(".meter").css("height",parseInt((parseInt($.replaceAll($('.meter-gauge-list').css("width")," px",""))/itens)*0.5));
	    		});
    		});
	    },
	    calcBarWidth: function(valores,elemento){
	    	var size = null;
	    	var count = 0;
	    	$.each(valores, function(index, itens){
	    		$.each(itens, function(index, value){
	    			count++;
	    		});
    		});
	    		    	
	    	if(((parseInt($.replaceAll($("#"+elemento).css("width")," px",""))/valores.length)/2)>10){
	    		size = parseInt((parseInt($.replaceAll($("#"+elemento).css("width")," px",""))/count)/2);
	    	}
	    	return size;
	    },
	    getData: function(url,idObjeto,grafico,callbackFnk){
	    	$.setChartSize();
	    	$("#"+idObjeto).removeClass("carregado");
    		$("#"+idObjeto).find(".jqplot-noData-container").remove();
		    $("#"+idObjeto).parent().find(".jqplot-image-button").remove();
		    $("#"+idObjeto).parent().find(".jqplot-image-container").remove();
		    $("#"+idObjeto).parent().parent().find(".default-list").find(".action-export").remove();
		    
			var pai = $("#"+idObjeto);
			var loadingArea = $("<div>").addClass("loading-chart");
			var icone = $("<div>").addClass("loading-icon");
			var mensagem = $("<div>").addClass("loading-message-chart");
			$("<span>").html("Carregando...").appendTo(mensagem);
			icone.appendTo(loadingArea);
			mensagem.appendTo(loadingArea);	
			loadingArea.appendTo(pai);
			$.post( url, $( "#form" ).serialize(),function() {})
			.done(function(data) {
				loadingArea.remove();
				$("#"+idObjeto).addClass("carregado");
				if(typeof callbackFnk == 'function'){
			        callbackFnk.call(this, data);
				}
			})
			.fail(function() {
				$.noty.closeAll();
    			$.gerarNotificacao("center","error",false,"Atenção","Erro ao carregar as informações");
				$("#"+idObjeto).addClass("carregado");
				loadingArea.remove();
				grafico =  grafico.destroy();
				grafico = $.jqplot(idObjeto, [[null]],$.jqConfig.initialConfig);
			});
	    },
	    getDataMeter: function(url,idObjeto,callbackFnk){
	    	$.setChartSize();
			$.post( url, $( "#form" ).serialize(),function() {})
			.done(function(data) {
				if(typeof callbackFnk == 'function'){
			        callbackFnk.call(this, data);
				}
			})
			.fail(function() {
				$.noty.closeAll();
    			$.gerarNotificacao("center","error",false,"Atenção","Erro ao carregar as informações");
				$("#"+idObjeto).empty();
			});
	    },
	    getChartDataMeter: function(url,funcaoRetorno,idObjeto){
	    	
	    	$.getDataMeter(url,idObjeto,function(data){	
	    		var valoresGrafico = new Array();
				var seriesGrafico = new Array();
								
				$.each(data.valores, function(index, dataLista){
					$.each(dataLista, function(index, dataItem){
						valoresGrafico.push([dataItem.label,parseFloat(dataItem.valor)]);
					});
				});
				if(data.series!=null){
					$.each(data.series, function(index, data){
						seriesGrafico.push({label: data});
					});
				}
				funcaoRetorno({valores: valoresGrafico,series : seriesGrafico,extras:(data.extras == null ? null : data.extras)});	
    		});	    	
	    },	    
	    getChartData: function(url,funcaoRetorno,idObjeto,grafico){
	    	$.getData(url,idObjeto,grafico,function(data){
	    		var valoresGrafico = new Array();
				var seriesGrafico = new Array();
								
				$.each(data.valores, function(index, dataLista){
					var valoresLista = new Array();
					$.each(dataLista, function(index, dataItem){
						valoresLista.push([dataItem.label,parseFloat(dataItem.valor)]);	
					});
					valoresGrafico.push(valoresLista);
				});
				if(data.series!=null){
					$.each(data.series, function(index, data){
						seriesGrafico.push({label: data});
					});
				}
				
				funcaoRetorno({valores:  (valoresGrafico==0 ? [[]] : valoresGrafico),series : seriesGrafico,extras:(data.extras == null ? null : data.extras)});
    		});	    	
	    },
	    getChartDataStacked: function(url,funcaoRetorno,idObjeto,grafico){
	    	$.getData(url,idObjeto,grafico,function(data){
	    		var valoresGrafico = new Array();
				var seriesGrafico = new Array();
				var labelsGrafico = new Array();
								
				$.each(data.valores, function(index, dataLista){
					var valoresLista = new Array();
					var labelsLista = new Array();
					$.each(dataLista, function(index, dataItem){
						labelsLista.push(dataItem.label);
						valoresLista.push(parseFloat(dataItem.valor));	
					});
					valoresGrafico.push(valoresLista);
					labelsGrafico.push(labelsLista);
				});
				if(data.series!=null){
					$.each(data.series, function(index, data){
						seriesGrafico.push({label: data});
					});
				}
				funcaoRetorno({valores: valoresGrafico,labels: labelsGrafico, series : seriesGrafico,extras:(data.extras == null ? null : data.extras)});
	    	});
	    },
	    getChartDataBarLine: function(url,funcaoRetorno,idObjeto,grafico){
	    	$.getData(url,idObjeto,grafico,function(data){
	    		var valoresGrafico = new Array();
				var barrasGrafico = new Array();
								
				$.each(data.valores, function(index, dataLista){
					if(index+1<data.valores.length){
						barrasGrafico.push({renderer:$.jqplot.BarRenderer,label:(data.series!=null ? data.series[index] : "Não informado")});
					}
					else{
						barrasGrafico.push({xaxis:'x2axis', yaxis:'y2axis',label:(data.series!=null ? data.series[index] : "Não informado"),pointLabels: {show: false}});
					}
					var valoresLista = new Array();
					$.each(dataLista, function(indexItem, dataItem){
						valoresLista.push([dataItem.label,parseFloat(dataItem.valor)]);
					});
					valoresGrafico.push(valoresLista);
				});
				funcaoRetorno({valores: valoresGrafico,barras : barrasGrafico,extras:(data.extras == null ? null : data.extras)});	
    		});	    	
	    },
	    getChartDataStackedBarLine: function(url,funcaoRetorno,idObjeto,grafico){
	    	$.getData(url,idObjeto,grafico,function(data){
	    		var valoresGrafico = new Array();
				var seriesGrafico = new Array();
				var labelsGrafico = new Array();
				var barrasGrafico = new Array();
								
				$.each(data.valores, function(index, dataLista){
					if(index+1<data.valores.length){
						barrasGrafico.push({renderer:$.jqplot.BarRenderer,label:(data.series!=null ? data.series[index] : "Não informado")});
					}
					else{
						barrasGrafico.push({xaxis:'x2axis', yaxis:'y2axis',label:(data.series!=null ? data.series[index] : "Não informado"),pointLabels: {show: false}});
					}					
					var valoresLista = new Array();
					var labelsLista = new Array();
					$.each(dataLista, function(index, dataItem){
						labelsLista.push(dataItem.label);
						valoresLista.push(parseFloat(dataItem.valor));	
					});
					valoresGrafico.push(valoresLista);
					labelsGrafico.push(labelsLista);
				});
				if(data.series!=null){
					$.each(data.series, function(index, data){
						seriesGrafico.push({label: data});
					});
				}
				funcaoRetorno({valores: valoresGrafico,barras : barrasGrafico,labels: labelsGrafico, series : seriesGrafico,extras:(data.extras == null ? null : data.extras)});
	    	});
	    },
	    printBoxArea: function(campo){

    		var mode = "iframe";
            var close = false;
            var extraCss = "";
            var keepAttr = ["class","id","style"];
            
            var headElements = '<meta charset="utf-8" />,<meta http-equiv="X-UA-Compatible" content="IE=edge"/>';

            var options = { mode : mode, popClose : close, extraCss : extraCss, retainAttr : keepAttr, extraHead : headElements };
            
            $(campo).printArea( options );	    	
	    	
	    	
	    }
	});
	
	$.setChartSize();
});

})(jQuery);