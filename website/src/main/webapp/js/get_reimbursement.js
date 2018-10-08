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
	document.getElementById("trf_id").innerHTML="TRF ID: " + objects.trf_id + "<br/>Current Reimbursement: $" + Number.parseFloat(objects.trf_reimbursement).toFixed(2);
	document.getElementById("Avail_re").innerHTML="<br/>Available Reimbursement: $" + Number.parseFloat(objects.available_reimbursement).toFixed(2);
	document.getElementById("reimbursement").setAttribute("value", Number.parseFloat(objects.trf_reimbursement).toFixed(2));
	document.getElementById("TRF_ID").setAttribute("value", objects.trf_id);
	document.getElementById("avail_re").setAttribute("value", objects.available_reimbursement);
	document.getElementById("current_re").setAttribute("value", objects.trf_reimbursement);
	document.getElementById("reimbursement").setAttribute("onchange", "reimbursementchange()")
}

function reimbursementchange(){
	let cha_rei =Number.parseFloat(document.getElementById("reimbursement").value); //changed value
	let def_rei =Number.parseFloat(document.getElementById("reimbursement").getAttribute("value")); //default value
	let ava_rei =Number.parseFloat(document.getElementById("avail_re").value); //available
	let Avail= "<br/>Available Reimbursement: $" + (ava_rei-cha_rei+def_rei).toFixed(2);
	if ((ava_rei-cha_rei+def_rei).toFixed(2)<0){
		Avail= "<br/>Available Reimbursement: Exceeded Maximum by $" + (cha_rei-def_rei-ava_rei).toFixed(2); 
	}
	document.getElementById("Avail_re").innerHTML= Avail;
	if (cha_rei==def_rei){
		document.getElementById("exceedreason").innerHTML="";
		document.getElementById("exceedreason").style.display="none";
		document.getElementById("update_rei").style.display="none";
	}else if (cha_rei<def_rei){
		document.getElementById("exceedreason").innerHTML="";
		document.getElementById("exceedreason").style.display="none";
		document.getElementById("update_rei").style.display="block";
	}else if (cha_rei>def_rei){
		if(cha_rei-def_rei>ava_rei){
			document.getElementById("exceedreason").innerHTML="Exceed Reason: <input type='text' name='exceedreason' required/>";
			document.getElementById("exceedreason").style.display="block";	
		}
		document.getElementById("update_rei").style.display="block";
	}
}