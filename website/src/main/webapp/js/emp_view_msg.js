window.addEventListener("load", emp_view_msg());
function emp_view_msg() {

	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let msg_list = JSON.parse(xhttp.responseText);
			console.log(msg_list);
			setMessages(msg_list);
		}
	}
	xhttp.open("GET", 'http://localhost:8080/website/html/EMP_MSGviewJSON.do',
			true);
	xhttp.send();
}

function setMessages(msg_list) {
	for (i = 0; i < msg_list.length; i++) {
		var button = "";
		switch (msg_list[i].flag) {
		case "RI":
			button = "<form action='SubmitInfo.do' method='POST' accept= '.pdf, .png, .jpeg, .txt, .doc' required> <input type='text' name='TRF_ID' style='display:none' value='"
				+ msg_list[i].trfid
				+ "'//> <input type='file' name='filename'//><input type='submit' value='Submit' //> </form>";
			break;
		case "AA":
			button = "<form action='AcceptChanges.do' method='POST'><input type='text' name='TRF_ID' style='display:none' value='"
				+ msg_list[i].trfid
				+ "'//><input type='submit' value='Accept Changes'//></form><form action='WithdrawApplication.do' method='POST'><input type='text' name='TRF_ID' style='display:none' value='"
				+ msg_list[i].trfid
				+ "'//><input type='submit' value='Withdraw Application'//></form>"
		case "RE":
			button = "Additional Info Submitted";
			break;
		case "AC":
			button = "Changes Accepted";
			break;
		case "WA":
			button = "Application Withdrawn";
			break;
		}

		var eachrow = "<tr>"
				+ "<td>"
				+ msg_list[i].timestamp
				+ "</td>"
				+ "<td>"
				+ msg_list[i].trfid
				+ "</td>"
				+ "<td>"
				+ msg_list[i].msg
				+ "</td>"
				+ "<td>"
				+ button
				+ "</td>" // HTML JANK
				+ "</tr>";
		document.getElementById("trfbody").innerHTML += eachrow;
	}
}