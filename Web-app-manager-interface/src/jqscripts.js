

$( document ).ready(function() {
	// id = {db call}
	$("#main #user1").text( getName(1) );
	$("#main #user2").text( getName(2) );
	$("#main #user3").text( getName(3) );
	$("#main #user4").text( getName(4) );
	$("#main #icon1").attr("src", "img/ghana_flag.png" );
	$("#main #icon2").attr("src", "img/uk_flag.png" );
	$("#main #icon3").attr("src", "img/us_flag.png" );
	$("#main #icon4").attr("src", "img/afghan_flag.png" );
 	$("textarea#ExampleMessage1").val( getMsg(1) );
 	$("textarea#ExampleMessage2").val( getMsg(2) );
	$("#tableId").DataTable();
});

// fake data fn
function getName(id) {
	switch (id) {
		case 1:
		return "(Ghana Student) Adoby";
		case 2:
		return "(UK Student) Alice";
		case 3:
		return "(US Student) Bob";
		case 4:
		return "(Afghan Student) Radu";
	}
}

function getMsg(id) {
	switch (id) {
		case 1:
		return "Hello Alice. I was so interested to hear about your troubles with your first world problems! Let me tell you about how our forests are being destroyed.";
		case 2:
		return "What is your opinion on 9/11?";
	}
}


