
var str ="hi";
var type_of;

window.onload = function() {
	console.log("We loaded the menu.js");
	getUserId();
	getReimbursements();
}

//not sure if this is necessary
function getUserId(){
	var xhr = new XMLHttpRequest();

	
	xhr.open("GET", "http://localhost:8080/GreenBull-Reimbursement/html/MenuJSON.do", true);
	xhr.send();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			str = xhr.responseText;
			
			let user = JSON.parse(xhr.responseText);
			
			type_of = user.type_of_id;
			str = user.firstName + " " + user.lastName + "!";
			console.log("user is: " + type_of);
			setValues(user);
		}
	};
}


function getReimbursements(){
	var xhr = new XMLHttpRequest();

	
	xhr.open("GET", "http://localhost:8080/GreenBull-Reimbursement/html/MenuReimbursements.do", true);
	xhr.send();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			str = xhr.responseText;
			
			let reimbs = JSON.parse(xhr.responseText);
			
			createForms(reimbs);
		}
	};
}


function setValues(user){
	document.getElementById("empName").innerText = str;
}

function createForms(reimbs){

	console.log("user is: " + type_of);
	
	var leng = reimbs.length;
	
	var tables_ref = document.getElementsByTagName("tbody");
	var tr = tables_ref[0];
	
	for(var i = 0; i < leng; i++){
		//create the row
		var newRow = document.createElement("TR");
		tr.appendChild(newRow);
		//create each column
		//date
		var newCol = document.createElement("TD");
	    newCol.innerHTML = reimbs[i].date_month + '/' + reimbs[i].date_day + '/' + reimbs[i].date_year;
		newRow.appendChild(newCol);

		//name of employee
			//only get this if we're anyone besides the employee
		if(type_of > 0){
			newCol = document.createElement("TD");
	        newCol.innerHTML = reimbs[i].fname + ' ' + reimbs[i].lname;
			newRow.appendChild(newCol);
		}
		
        //course
        newCol = document.createElement("TD");
        newCol.innerHTML = reimbs[i].course_name;
		newRow.appendChild(newCol);

        //form link
        newCol = document.createElement("TD");
        var formId = "viewForm" + i;
        newCol.innerHTML = '<input type="submit" id="viewform" class="button" name= "form_id" value="' + reimbs[i].id + '">'; //'<a href="viewForm">View Form ' + i + '</a>';//
		newRow.appendChild(newCol);
  
        //status
			//only get this if we're the employee
		if(type_of < 1){
			var status_text = 'Unknown';
			switch(reimbs[i].status){
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
					status_text = 'Pending';
					break;
				case 5:
					status_text = 'Approved';
					break;
				case -1:
					status_text = 'Denied';
					break;
			}
		
	        newCol = document.createElement("TD");
	        newCol.innerHTML = status_text;
	        newRow.appendChild(newCol);
		}
	}
}