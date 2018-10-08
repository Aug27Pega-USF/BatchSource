window.addEventListener("load", get_reimbursement());

function get_reimbursement() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status==200) {
			let objects = JSON.parse(xhttp.responseText);
			console.log(objects);
			setReimbursement(objects);
		}
	}
	
	xhttp.open("GET", 'http://localhost:8080/website/html/updateReimbursement.do', true); 
	xhttp.send();
	
}

function setReimbursement(objects){
	document.getElementById("trf_id").innerHTML="TRF ID: " + objects.trf_id + "<br/>Current Reimbursement: $" + Number.parseFloat(objects.trf_reimbursement).toFixed(2)
	+ "<br/>Available Reimbursement: $" + Number.parseFloat(objects.available_reimbursement).toFixed(2);
	document.getElementById("reimbursement").setAttribute("value", Number.parseFloat(objects.trf_reimbursement).toFixed(2));
	document.getElementById("TRF_ID").setAttribute("value", objects.trf_id);
	document.getElementById("current_re").setAttribute("value", objects.available_reimbursement);
	document.getElementById("avail_re").setAttribute("value", objects.trf_reimbursement);
	document.getElementById("reimbursement").setAttribute("onchange", "reimbursementchange()")
}

function reimbursementchange(){
	let cha_rei =Number.parseFloat(document.getElementById("reimbursement").value);
	let def_rei= Number.parseFloat(document.getElementById("reimbursement").getAttribute("value"));
	
}