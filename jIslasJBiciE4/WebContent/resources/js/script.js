function initialize() {
	var mapCanvas = document.getElementById('map');
	var mapOptions = {
		center : new google.maps.LatLng(-34.920, -57.953),
		zoom : 8,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	}
	var map = new google.maps.Map(mapCanvas, mapOptions)
}

function loadScript() {

	var script = document.createElement('script');

	script.type = 'text/javascript';

	script.src = 'https://maps.googleapis.com/maps/api/js?sentor=false&callback=initialize';

	document.body.appendChild(script);

}
function loadScriptToAddStation() {
	var script = document.createElement('script');

	script.type = 'text/javascript';

	script.src = 'https://maps.googleapis.com/maps/api/js?sentor=false&callback=initializeToStation';

	document.body.appendChild(script);

}
//VARIABLES GLOBALES JAVASCRIPT
var marker;
var latLng;
var map;
function initializeToStation() {
	var mapCanvas = document.getElementById('map');
	latLng = new google.maps.LatLng(-34.920, -57.953)
	var mapOptions = {
		center :latLng,
		zoom : 18,
		mapTypeId : google.maps.MapTypeId.ROADMAP
	}
	map = new google.maps.Map(mapCanvas, mapOptions);
	 
	
	// CREACION DEL MARCADOR
	marker = new google.maps.Marker({
		position : latLng,
		title : 'Arrastrame si quieres',
		map : map,
		draggable : true
	});
	// Escucho el CLICK sobre el mapa y actualizo la posicion del marcador
	google.maps.event.addListener(map, 'click', function(event) {
		updateMarker(event.latLng);
	});
}
//ACTUALIZO LA POSICION
function updateMarker(location) {
	marker.setPosition(location);
	updateMarkerPosition(location);		
}
// RECUPERO LOS DATOS LON LAT Y DIRECCION Y LOS PONGO EN EL FORMULARIO
function updateMarkerPosition(latLng) {
	document.form_mapa.longitud.value = latLng.lng();
	document.form_mapa.latitud.value = latLng.lat();
} 	
// RECUPERO LOS DATOS LON (X) y LAT (Y), luego LOS PONGO EN EL FORMULARIO
  function updateMarkerPosition (latLng) {
	var inputTextX = document.getElementById("#{estacionBean.ubicacionX.clientId}");
	inputTextX.value =latLng.lng();
	var inputTextY = document.getElementById("#{estacionBean.ubicacionY.clientId}");
	inputTextY.value = latLng.lat();
  }