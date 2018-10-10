
var str ="hi";
var uid;

window.onload = function() {
	console.log("We loaded the form.js");
	
	getUserId();
	//document.getElementById("empName").innerText = str;
	//getReimbursements();
}

//not sure if this is necessary

function getUserId(){
	var xhr = new XMLHttpRequest();
	console.log("1");
	
	xhr.open("GET", "http://localhost:8080/GreenBull-Reimbursement/html/MenuJSON.do", true);
	xhr.send();
	
	xhr.onreadystatechange = function() {
		console.log("readyState: " + xhr.readyState + ", " + "status: " + xhr.status);
		if(xhr.readyState == 4 && xhr.status == 200){
			str = xhr.responseText;
			console.log("3");
			let user = JSON.parse(xhr.responseText);
			
			uid = user.id;
			str = user.firstName + " " + user.lastName;
			console.log("user is: " + user.id);
			setValues(user);
		}
	};
}

/*
function getReimbursements(){
	var xhr = new XMLHttpRequest();

	
	xhr.open("GET", "http://localhost:8080/GreenBull-Reimbursement/html/MenuReimbursements.do", true);
	xhr.send();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			str = xhr.responseText;
			
			let reimbs = JSON.parse(xhr.responseText);
			
			document.getElementById("reimb").innerText = reimbs[0].id; //str <- shows all of them
		}
	};
}
*/

function setValues(user){
	document.getElementById("empName").innerText = user.firstName + " " + user.lastName;
	//document.getElementById("type").innerHTML="The type of this user is: " + user.type;
}
