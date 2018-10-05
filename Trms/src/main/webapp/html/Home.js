window.onload = function() {
	getUserInfo();
}

function getUserInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let user = JSON.parse(xhttp.responseText);
			setValues(user);
		}
	}

	xhttp
			.open("GET", 'http://localhost:8080/TRMSRuntime/html/UserJSON.do',
					true);
	xhttp.send();

}

function setValues(user) {
	document.getElementById("exampleInputEmail1").innerHTML = "The username is: "
			+ user.username;
	document.getElementById("exampleInputPassword1").innerHTML = "The password is: "
			+ user.password;

}