window.addEventListener("load", view_trf());

function view_trf() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status==200) {
			let trf_list = JSON.parse(xhttp.responseText);
			setValues(trf_list);
		}
	}
	
	xhttp.open("GET", 'http://localhost:8080/website/html/TRFviewJSON.do', true); 
	xhttp.send();
	
}

function setValues(trf_list){
	for (i=0; i<trf_list.length; i++){
		if (trf_list[i].passing_grade==null){
			trf_list[i].passing_grade="N/A"
		}
		let current_status="Approved";
		if(trf_list[i].supervisor_approval_exist=="N"){
			current_status="Waiting for Direct Supervisor Approval";
		} else if (trf_list[i].head_approval_exist=="N"){
			current_status="Waiting for Department Head Approval";
		} else if (trf_list[i].benco_approval_exist=="N"){
			current_status="Waiting for Benefits Coordinator Approval";
		} else if (trf_list[i].supervisor_approval_exist=="A" && trf_list[i].head_approval_exist=="A" &&trf_list[i].benco_approval_exist=="A"){
			current_status="Reimbursement Form Processed. Reimbursement has been awarded.";
		} else if (trf_list[i].supervisor_approval_exist=="A"){
			current_status="Waiting for Presentation Approval by Direct Supervisor";
		} else if (trf_list[i].benco_approval_exist=="A"){
			current_status="Waiting for Grade Approval by BenCo";
		}
		let pr_re = Number.parseFloat(trf_list[i].projected_reimbursement).toFixed(2);
		let button = "";
		if(trf_list[i].grading_format =="Presentation" && current_status=="Approved"){
			button = "<form action='SubmitPresentation.do' method='POST'> <input type='text' name='TRF_ID' style='display:none' value='"
				+  trf_list[i].trf_id
				+ "'//> <input type='file' name='filename' accept= '.pdf, .png, .jpeg, .txt, .doc' required//><input type='submit' value='Submit' //> </form>";
		} else if (current_status=="Approved"){
			button = "<form action='SubmitGradingFormat.do' method='POST'> <input type='text' name='TRF_ID' style='display:none' value='"
				+ trf_list[i].trf_id
				+ "'//> <input type='file' name='filename' accept= '.pdf, .png, .jpeg, .txt, .doc' required//><input type='submit' value='Submit' //> </form>";
		}
		
		var eachrow= "<tr>" + "<td>" + trf_list[i].trf_id + "</td>"
		+ "<td>" + "$"+ pr_re + "</td>"
		+ "<td>" + trf_list[i].datetime + "</td>"
		+ "<td>" + trf_list[i].location + "</td>"
		+ "<td>" + trf_list[i].description + "</td>"
		+ "<td>" + trf_list[i].event_type_id  + "</td>"
		+ "<td>" + trf_list[i].grading_format+ "</td>"
		+ "<td>" + trf_list[i].passing_grade + "</td>"
		+ "<td>" + trf_list[i].justification + "</td>"
		+ "<td>" + current_status + "</td>"
		+ "<td>" + button + "</td>"
		+ "</tr>";
		document.getElementById("trfbody").innerHTML+=eachrow;
	}
}