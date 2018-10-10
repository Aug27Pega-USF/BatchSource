window.addEventListener("load", dsdh_view_trf());

function dsdh_view_trf() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status==200) {
			let trf_list = JSON.parse(xhttp.responseText);
			dsdhsetValues(trf_list, document.getElementsByTagName("body")[0].dataset.isready);
		}
	}
	
	xhttp.open("GET", 'http://localhost:8080/website/html/DSDH_viewJSON.do', true); 
	xhttp.send();
	
}

function dsdhsetValues(trf_list, x){
	if (!x){
		setTimeout(dsdhsetValues.bind(trf_list,document.getElementsByTagName("body")[0].dataset.isready), 500);
	}
	if (document.getElementsByTagName("body")[0].dataset.user_type_id=="H"){
		dhsetValues(trf_list);
	}else if (document.getElementsByTagName("body")[0].dataset.user_type_id=="S"){
		dssetValues(trf_list);
	}
}

function dssetValues(trf_list){
	for (i=0; i<trf_list.length; i++){
		if (trf_list[i].passing_grade==null){
			trf_list[i].passing_grade="N/A"
		}
		let pr_re = Number.parseFloat(trf_list[i].projected_reimbursement).toFixed(2);
		let event_cost = Number.parseFloat(trf_list[i].event_cost).toFixed(2);
		let datetime= trf_list[i].event_datetime;
		let urgent="";
		let today= new Date();
		let newdate= new Date(datetime.slice(5,7)+"/"+datetime.slice(8,10)+"/"+datetime.slice(0,4));
		if ((newdate-today)/86400000<14){
			urgent="<br>URGENT: EVENT STARTS IN ABOUT "+ Math.round((newdate-today)/86400000)+ " DAYS!";
		}
		
		var eachrow= "<tr>" 
		+ "<td>" + trf_list[i].trf_ID + "</td>"
		+ "<td>" + trf_list[i].first_Name + " " +trf_list[i].last_name + "</td>"
		+ "<td>" + trf_list[i].user_id + "</td>"
		+ "<td>" + trf_list[i].basic_info_placeholder + "</td>"
		+ "<td>" + datetime + urgent + "</td>"
		+ "<td>" + trf_list[i].event_location + "</td>"
		+ "<td>" + trf_list[i].event_description + "</td>"
		+ "<td>" + "$"+ event_cost + "</td>"
		+ "<td>" + trf_list[i].grading_format + "</td>"
		+ "<td>" + trf_list[i].passing_grade + "</td>"
		+ "<td>" + trf_list[i].event_type_id + "</td>"
		+ "<td>" + trf_list[i].justification + "</td>"
		+ "<td>" + trf_list[i].attachments_exist + "</td>"
		+ "<td>" + trf_list[i].work_missed + "</td>"
		+ "<td>" + "$"+ pr_re + "</td>"
		+ "<td>" + "<form action=\"DSApprove.do\" method=\"POST\"><input type=\"text\" name=\"TRF_ID\" style=\"display:none\" value=\""+ trf_list[i].trf_ID + "\"/><input type=\"submit\" value=\"Approve\"/></form><form action=\"DSDeny.do\" method=\"POST\"><input type=\"text\" name=\"TRF_ID\" style=\"display:none\" value=\""+ trf_list[i].trf_ID + "\"//>Deny Reason:<input type='text' style='width:100px' name='denyreason' required><input type=\"submit\" value=\"Deny\"/></form>"+ "</td>" //HTML JANK
		+ "<td>" + "<form action=\"Request.do\" method=\"POST\"><input type=\"text\" name=\"TRF_ID\" style=\"display:none\" value=\""+ trf_list[i].trf_ID + "\"/><select name=\"user_level\" required><option value=\"Employee\">Employee</option></select><input type=\"submit\" value=\"Request More Information\"/></form>" + "</td>" //HTML JANK
		+ "</tr>";
		document.getElementById("trfbody").innerHTML+=eachrow;
	}
}

function dhsetValues(trf_list){
	for (i=0; i<trf_list.length; i++){
		if (trf_list[i].passing_grade==null){
			trf_list[i].passing_grade="N/A"
		}
		let pr_re = Number.parseFloat(trf_list[i].projected_reimbursement).toFixed(2);
		let event_cost = Number.parseFloat(trf_list[i].event_cost).toFixed(2);
		let datetime= trf_list[i].event_datetime;
		let urgent="";
		let today= new Date();
		let newdate= new Date(datetime.slice(5,7)+"/"+datetime.slice(8,10)+"/"+datetime.slice(0,4));
		if ((newdate-today)/86400000<14){
			urgent="<br>URGENT: EVENT STARTS IN ABOUT "+ Math.round((newdate-today)/86400000)+ " DAYS!";
		}
		var eachrow= "<tr>" 
		+ "<td>" + trf_list[i].trf_ID + "</td>"
		+ "<td>" + trf_list[i].first_Name + " " +trf_list[i].last_name + "</td>"
		+ "<td>" + trf_list[i].user_id + "</td>"
		+ "<td>" + trf_list[i].basic_info_placeholder + "</td>"
		+ "<td>" + datetime + urgent + "</td>"
		+ "<td>" + trf_list[i].event_location + "</td>"
		+ "<td>" + trf_list[i].event_description + "</td>"
		+ "<td>" + "$"+ event_cost + "</td>"
		+ "<td>" + trf_list[i].grading_format + "</td>"
		+ "<td>" + trf_list[i].passing_grade + "</td>"
		+ "<td>" + trf_list[i].event_type_id + "</td>"
		+ "<td>" + trf_list[i].justification + "</td>"
		+ "<td>" + trf_list[i].attachments_exist + "</td>"
		+ "<td>" + trf_list[i].work_missed + "</td>"
		+ "<td>" + "$"+ pr_re + "</td>"
		+ "<td>" + "<form action=\"DHApprove.do\" method=\"POST\"><input type=\"text\" name=\"TRF_ID\" style=\"display:none\" value=\""+ trf_list[i].trf_ID + "\"/><input type=\"submit\" value=\"Approve\"/></form><form action=\"DHDeny.do\" method=\"POST\"><input type=\"text\" name=\"TRF_ID\" style=\"display:none\" value=\""+ trf_list[i].trf_ID + "\"//>Deny Reason:<input type='text' name='denyreason' style='width:100px' required><input type=\"submit\" value=\"Deny\"/></form>"+ "</td>" //HTML JANK
		+ "<td>" + "<form action=\"Request.do\" method=\"POST\"><input type=\"text\" name=\"TRF_ID\" style=\"display:none\" value=\""+ trf_list[i].trf_ID + "\"/><select name=\"user_level\" required><option value=\"Employee\">Employee</option><option value=\"Direct Supervisor\">Direct Supervisor</option></select><input type=\"submit\" value=\"Request More Information\"/></form>" + "</td>" //HTML JANK
		+ "</tr>";
		document.getElementById("trfbody").innerHTML+=eachrow;
	}
}