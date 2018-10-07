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
	document.getElementsByName('Us')[0].placeholder= user.userName;
	document.getElementsByName('Pas')[0].placeholder= user.passWord;
	document.getElementsByName('fn')[0].placeholder= user.firstName;
	document.getElementsByName('ln')[0].placeholder= user.lastName;
	document.getElementsByName('EID')[0].placeholder= user.userId;
	document.getElementsByName('Add')[0].placeholder= user.address;
	document.getElementsByName('Eml')[0].placeholder= user.email;
	document.getElementsByName('Ph')[0].placeholder= user.phoneNum;
	sessionStorage.setItem("EID", user.userName);
    // Retrieve
    
	//sessionStorage.setItem("EID","userId");
	/*document.getElementById("Us").innerHTML = "The username is: "
			+ user.userName;
	document.getElementById("Pas").innerHTML = "The password is: "
			+ user.passWord;*/

}