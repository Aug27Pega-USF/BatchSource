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
		<th>Event Type</th><th>Grading Format</th><th>Passing Grade</th><th>Justification</th><th>Current Status</th></tr></thead>
		var eachrow= "<tr>" + "<td>" + trf_list[i].trf_id + "</td>"
		+ "<td>" + trf_list[i].trf_id + "</td>"
		+ "<td>" + trf_list[i].projected_reimbursement + "</td>"
		+ "<td>" + trf_list[i].datetime + "</td>"
		+ "<td>" + trf_list[i].location + "</td>"
		+ "<td>" + trf_list[i].event type  + "</td>"
		+ "<td>" + trf_list[i].trf_id + "</td>"
		+ "<td>" + trf_list[i].trf_id + "</td>"
		+ "</tr>";
		
		
		
	}
}