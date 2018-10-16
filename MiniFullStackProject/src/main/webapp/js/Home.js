function setValues(user) {
	document.getElementById("fname").innerHTML = "First name: " + user.firstname;
	document.getElementById("lname").innerHTML = "Last name: " + user.lastname;
	document.getElementById("street").innerHTML = "Street: " + user.street;
	document.getElementById("city").innerHTML = "City: " + user.city;
	document.getElementById("state").innerHTML = "State: " + user.state;
	document.getElementById("country").innerHTML = "Country: " + user.country;
	document.getElementById("zip").innerHTML = "Zip code: " + user.zipcode;
	document.getElementById("color").innerHTML = "Favorite color: " + user.favcolor;
	document.getElementById("animal").innerHTML = "Favorite animal: " + user.favanimal;
}

function getUserInfo() {
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {
			var user = JSON.parse(xhr.responseText);
			setValues(user);
		}
	}
	xhr.open("GET", "http://localhost:8081/MiniFullStackProject/html/UserJSON.do", true);
	xhr.send();
}

window.onload = function() {
	getUserInfo();
}