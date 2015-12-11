$(function(){
	var data = {
		    labels: ["Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"],
		    datasets: [
		        {
		            label: "Hospedagem",
		            fillColor: "rgba(220,220,220,0.2)",
		            strokeColor: "rgba(220,220,220,1)",
		            pointColor: "rgba(220,220,220,1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(220,220,220,1)",
		            data: [65, 59, 80, 81, 56, 55, 40,2 ,3 , 2 ,3, 1]
		        },
		        {
		            label: "Alimentação",
		            fillColor: "rgba(151,187,205,0.2)",
		            strokeColor: "rgba(151,187,205,1)",
		            pointColor: "rgba(151,187,205,1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(151,187,205,1)",
		            data: [28, 48, 40, 19, 86, 27, 90, 40, 13 ,21 , 33 ,0]
		        },
		        {
		            label: "Transporte",
		            fillColor: "rgba(133, 15, 0, 0.2)",
		            strokeColor: "rgba(133, 15, 0, 1)",
		            pointColor: "rgba(133, 15, 0, 1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(133, 15, 0, 1)",
		            data: [10, 11, 2, 11, 24, 34, 12, 11,22 ,33 , 34 ,0]
		        },
		        {
		            label: "Eventos",
		            fillColor: "rgba(255, 255, 144,0.2)",
		            strokeColor: "rgba(255, 255, 144,1)",
		            pointColor: "rgba(255, 255, 144,1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(255, 255, 144,1)",
		            data: [15, 28, 22, 9, 6, 27, 9, 5,11 ,12 , 23 ,1]
		        },
		        {
		            label: "Outros",
		            fillColor: "rgba(177, 178, 144,0.2)",
		            strokeColor: "rgba(177, 178, 144,1)",
		            pointColor: "rgba(177, 178, 144,1)",
		            pointStrokeColor: "#fff",
		            pointHighlightFill: "#fff",
		            pointHighlightStroke: "rgba(177, 178, 144,1)",
		            data: [11, 5, 2, 3, 43, 11, 3, 5,3 ,3 , 4 ,0]
		        }
		        
		    ]
		};


	         var options = {
	        		///Boolean - Whether grid lines are shown across the chart
	        		    scaleShowGridLines : true,

	        		    //String - Colour of the grid lines
	        		    scaleGridLineColor : "rgba(0,0,0,.05)",

	        		    //Number - Width of the grid lines
	        		    scaleGridLineWidth : 1,

	        		    //Boolean - Whether to show horizontal lines (except X axis)
	        		    scaleShowHorizontalLines: true,

	        		    //Boolean - Whether to show vertical lines (except Y axis)
	        		    scaleShowVerticalLines: true,

	        		    //Boolean - Whether the line is curved between points
	        		    bezierCurve : true,

	        		    //Number - Tension of the bezier curve between points
	        		    bezierCurveTension : 0.4,

	        		    //Boolean - Whether to show a dot for each point
	        		    pointDot : true,

	        		    //Number - Radius of each point dot in pixels
	        		    pointDotRadius : 4,

	        		    //Number - Pixel width of point dot stroke
	        		    pointDotStrokeWidth : 1,

	        		    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
	        		    pointHitDetectionRadius : 20,

	        		    //Boolean - Whether to show a stroke for datasets
	        		    datasetStroke : true,

	        		    //Number - Pixel width of dataset stroke
	        		    datasetStrokeWidth : 2,

	        		    //Boolean - Whether to fill the dataset with a colour
	        		    datasetFill : true,

	         };

	         var ctx = document.getElementById("areaChart").getContext("2d");

	         var myChart = new Chart(ctx).Line(data, options);

	         document.getElementById('legendDiv').innerHTML = myChart.generateLegend();

});