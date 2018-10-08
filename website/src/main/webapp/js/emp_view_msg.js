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
			button = "<form action='SubmitInfo.do' method='POST'> <input type='text' name='TRF_ID' style='display:none' value='"
				+ msg_list[i].trfid
				+ "'//> <input type='file' name='filename' accept= '.pdf, .png, .jpeg, .txt, .doc' required//><input type='submit' value='Submit' //> </form>";
			break;
		case "AA":
			button = "<form action='AcceptChanges.do' method='POST'><input type='text' name='TRF_ID' style='display:none' value='"
				+ msg_list[i].trfid
				+ "'//><input type='submit' value='Accept Changes'//></form><form action='WithdrawApplication.do' method='POST'><input type='text' name='TRF_ID' style='display:none' value='"
				+ msg_list[i].trfid
				+ "'//><input type='submit' value='Withdraw Application'//></form>"
				break;
		case "RE":
			button = "Additional Info Submitted";
			break;
		case "AC":
			button = "Changes Accepted";
			break;
		case "WA":
			button = "Application Withdrawn";
			break;
		case "GD":
			button = "Grade Check Denied";
			break;
		case "GA":
			button = "Grade Check Accepted";
			break;
		case "PD":
			button = "Presentation Check Denied";
			break;
		case "PA":
			button = "Presentation Check Accepted";
			break;
		case "PR":
            button = button = "<form action='ApprovePresentation.do' method='POST'><input type='text' name='TRF_ID' style='display:none' value='"
                + msg_list[i].trfid
                + "'//><input type='submit' value='Approve'//></form><form action='DenyPresentation.do' method='POST'><input type='text' name='TRF_ID' style='display:none' value='"
                + msg_list[i].trfid
                + "'//><input type='submit' value='Deny'//></form>";
            break;
        case "GC":
            button = button = "<form action='ApproveGrade.do' method='POST'><input type='text' name='TRF_ID' style='display:none' value='"
                + msg_list[i].trfid
                + "'//><input type='submit' value='Approve'//></form><form action='DenyGrade.do' method='POST'><input type='text' name='TRF_ID' style='display:none' value='"
                + msg_list[i].trfid
                + "'//><input type='submit' value='Deny'//></form>";
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