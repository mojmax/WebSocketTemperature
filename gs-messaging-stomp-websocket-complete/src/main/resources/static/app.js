var stompClient = null;

function setConnected(connected) {
    $("#connect").prop("disabled", connected);
    
    $("#disconnect").prop("disabled", !connected);
    if (connected) {
    	$("#raspyconnection").text(" Connected");
        $("#conversation").show();
    }
    else {
    	$("#raspyconnection").text(" Disconnected");
        $("#conversation").hide();
    }
    $("#greetings").html("");
}
// Automatic Self  Connected with Sefl Invoking Function
var connect = (function() {
	return function() {
		    var socket = new SockJS('/gs-guide-websocket');
		    stompClient = Stomp.over(socket);
		    stompClient.connect({}, function (frame) {
		        setConnected(true);
		        console.log('Connected: ' + frame);
		        stompClient.subscribe('/topic/temperature', function (response) {
		            showTemperature(response);
		        });
		        
		    });		
	}
})();


function disconnect() {
    if (stompClient !== null) {
        stompClient.disconnect();
    }
    setConnected(false);
    console.log("Disconnected");
}
function scale() {
	stompClient.send("/app/scale",{},JSON.stringify({}));
}

function sendName() {
    stompClient.send("/app/hello", {}, JSON.stringify({'name': $("#name").val()}));
}

function showTemperature(message) {
	var response = JSON.parse(message.body)
    $("#greetings").append("<tr><td>" + response.content + "</td></tr>");
	$("#scale").text( response.scale);
	$("#temperature").text(" " + response.temperature);
	$("#umidity").text(" " + response.umidity + "%");
}

$(function () {
    $("form").on('submit', function (e) {
        e.preventDefault();
    });
    $( "#connect" ).click(function() { connect(); });
    $( "#disconnect" ).click(function() { disconnect(); });
    $( "#getu" ).click(function() { sendName(); });
    $( "#gett" ).click(function() { sendName(); });
    $( "#scale" ).click(function() { scale(); });
});

