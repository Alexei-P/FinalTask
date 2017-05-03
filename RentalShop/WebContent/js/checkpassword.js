/**
 * 
 */
$(document).ready(function() {
	$("#button_submit").click(function() {
		var pas1 = $("#pas1").val();
		var pas2 = $("#pas2").val();
		var hasError = false;

		if (pas1 == '') {
			hasError = true;
		} else if (pas2 == '') {
			hasError = true;
		} else if (pas1 != pas2) {
			hasError = true;
		}
		if (hasError == true) {
			alert("Enter correct password");
		}else {
			$("form").submit();
		}
	});
});