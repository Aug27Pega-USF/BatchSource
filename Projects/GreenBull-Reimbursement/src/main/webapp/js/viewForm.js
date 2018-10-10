
window.onload = function() {
	console.log("We loaded the viewForm.js");
	getReimbursements();
	
}

function getReimbursements(){
	var xhr = new XMLHttpRequest();
	
	xhr.open("GET", "http://localhost:8080/GreenBull-Reimbursement/html/FillForm.do", true);
	xhr.send();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			str = xhr.responseText;
			
			let reimb = JSON.parse(xhr.responseText);
			
			console.log(str);
			//document.getElementById("reimb").innerText = str;
			//setValues(reimb);
			getUserId(reimb);
		}
	};
}


//not sure if this is necessary
function getUserId(reimb){
	var xhr = new XMLHttpRequest();

	
	xhr.open("GET", "http://localhost:8080/GreenBull-Reimbursement/html/UserFormData.do", true);
	xhr.send();
	
	xhr.onreadystatechange = function() {
		if(xhr.readyState == 4 && xhr.status == 200){
			str = xhr.responseText;
			
			let user = JSON.parse(xhr.responseText);
			
			console.log("user is: " + user.id);
			console.log("user type: " + user.type_of_id);
			
			setValues(reimb);
			addAdminButtons(user.type_of_id);
		}
	};
}

function addAdminButtons(type){
	if(type > 0){
		var id_ref = document.getElementById("placeholder");
		
		//make the approve button
		var newRow = document.createElement("TR");
		id_ref.appendChild(newRow);
		
		var newForm = document.createElement("FORM");
		newForm.method = "POST";
		newForm.action = "ApproveForm.do";
		newForm.innerHTML = '<input type="Submit" class="form-control btn-primary" id="ApproveButton" value="Approve">';
		id_ref.appendChild(newForm);
		
		//make the deny button
		newForm = document.createElement("FORM");
		newForm.method = "POST";
		newForm.action = "DenyForm.do";
		newForm.innerHTML = '<input type="Submit" class="form-control btn-primary" id="DenyButton" value="Deny">';
		id_ref.appendChild(newForm);
	}
}

function setValues(reimb){
	document.getElementById("reimbursementFirstName").value = reimb.fname;//
	document.getElementById("reimbursementLastName").value = reimb.lname;//
	document.getElementById("reimbursementGrade").value = reimb.grade;//
	document.getElementById("reimbursementMonth").value = reimb.date_month;//
	document.getElementById("reimbursementDay").value = reimb.date_day;//
	document.getElementById("reimbursementYear").value = reimb.date_year;//
	document.getElementById("reimbursementApplicationMethod").value = reimb.application_method;//
	document.getElementById("reimbursementAddress").value = reimb.address;//
	document.getElementById("reimbursementCity").value = reimb.city;//
	document.getElementById("reimbursementState").value = reimb.state;//
	document.getElementById("reimbursementZipcode").value = reimb.zipcode;//
	document.getElementById("reimbursementCost").value = reimb.cost;//
	document.getElementById("reimbursementWorkTimeMissed").value = reimb.worktime_missed;//
	document.getElementById("reimbursementApprovalType").value = reimb.approval_type;//
	document.getElementById("reimbursementCourseName").value = reimb.course_name;//
	document.getElementById("reimbursementWorkDescription").value = reimb.work_description;//
}