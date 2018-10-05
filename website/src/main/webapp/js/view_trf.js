window.addEventListener("load", view_trf());

function view_trf() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status==200) {
			let emp = JSON.parse(xhttp.responseText);
			setValues(emp);
		}
	}
	
	xhttp.open("GET", 'http://localhost:8080/website/html/EmpJSON.do', true); 
	xhttp.send();
	
}

function setValues(emp){
	let e_info = document.getElementsByTagName("body")[0].dataset;
	e_info.id = emp.user_id;
	e_info.refersto = emp.refersto;
	e_info.user_type_id = emp.user_type_id;
	e_info.first_name = emp.first_name;
	e_info.last_name = emp.last_name;
	e_info.basic_info_placeholder = emp.basic_info_placeholder;
	e_info.available_reimbursement = emp.available_reimbursement;
	e_info.pending_reimbursement = emp.pending_reimbursement;
	e_info.awarded_reimbursement = emp.awarded_reimbursement;
	e_info.isready = "true";
}