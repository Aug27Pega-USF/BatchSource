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

	xhttp.open("GET", 'http://localhost:8080/Trms/html/UserJSON.do',
			true);
	xhttp.send();

}

function setValues(user) {
	document.getElementsByName('Username')[0].placeholder = user.userName;
	document.getElementsByName('firstname')[0].placeholder= user.firstName;
	document.getElementsByName('lastname')[0].placeholder= user.lastName;
	document.getElementsByName('EmployeeID')[0].placeholder= user.userId;
	document.getElementsByName('Address')[0].placeholder= user.address;
	document.getElementsByName('Email')[0].placeholder= user.email;
	document.getElementsByName('PhoneNumber')[0].placeholder= user.phoneNum;
	//sessionStorage.setItem("EID", user.userName);
    // Retrieve
    
	//sessionStorage.setItem("EID","userId");
	/*document.getElementById("Us").innerHTML = "The username is: "
			+ user.userName;
	document.getElementById("Pas").innerHTML = "The password is: "
			+ user.passWord;*/

}