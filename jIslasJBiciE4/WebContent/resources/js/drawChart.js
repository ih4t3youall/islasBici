google.load("visualization", "1", {
		packages : [ "corechart" ]
	});
	google.setOnLoadCallback(drawChart);

	function drawChart() {
		var urlActual = window.location.href; 
		var url = urlActual.replace("/faces/estadisticas.xhtml","rest/estadisticasJbici/Usuario"); // Completar con URL del servicio REST
		$.getJSON(url, function(data) {

			var googleData = new google.visualization.DataTable();
			googleData.addColumn('string', 'Operacion');
			googleData.addColumn('number', 'Cantidad');
			var total = data.length;

			for (i = 0; i < total; i++) {
				googleData.addRow([ data[i].operacion, data[i].cantidad ]);

			}

			var chart = new google.visualization.PieChart(document
					.getElementById('chart_div'));
			chart.draw(googleData, {
				width : 450,
				height : 300,
				title : 'Operaciones sobre Entidad Usuario',
				is3D : true
			});
		});
	}