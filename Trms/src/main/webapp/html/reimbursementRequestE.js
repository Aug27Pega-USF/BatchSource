window.onload = function() {
	getReimbursementInfo();
}
function getReimbursementInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let reimbursement = JSON.parse(xhttp.responseText);
			// var obj = JSON.parse(reimbursement);
			console.log(reimbursement);
			setValues(reimbursement);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/Trms/html/ReimbursementJSON.do',
			true);
	xhttp.send();

}

function setValues(reimbursement) {

	var leng = reimbursement.length;

	var tables_ref = document.getElementsByTagName("tbody");
	var tr = tables_ref[0];

	for (var i = 0; i < leng; i++) {
		// create the row
		var newRow = document.createElement("TR");
		tr.appendChild(newRow);
		// create each column
		//
		var newCol = document.createElement("TD");
		newCol.innerHTML = reimbursement[i].reimbursementId;
		newRow.appendChild(newCol);

		var newCol = document.createElement("TD");
		newCol.innerHTML = reimbursement[i].userId;
		newRow.appendChild(newCol);

		// course
		newCol = document.createElement("TD");
		newCol.innerHTML = reimbursement[i].jobType;
		newRow.appendChild(newCol);

		newCol = document.createElement("TD");
		newCol.innerHTML = reimbursement[i].status;
		newRow.appendChild(newCol);

		newCol = document.createElement("TD");
		newCol.innerHTML = reimbursement[i].availAmount;
		newRow.appendChild(newCol);

		newCol = document.createElement("TD");
		newCol.innerHTML = reimbursement[i].srtTime;
		newRow.appendChild(newCol);
		
		newCol = document.createElement("TD");
		newCol.innerHTML = reimbursement[i].endTime;
		newRow.appendChild(newCol);
		// form link
		/*newCol = document.createElement("TD");
		newCol.innerHTML = '<a href="View Form">Approve/Reject</a>';
		newRow.appendChild(newCol);
*/
	}

	// document.getElementById("reimbursement").innerHTML =
	// reimbursement.userId;

	/*
	 * $('#reimbursement').append( `<tr> <td>${reimbursement.userId}</td>
	 * <td>${reimbursement.transId}</td> <td>${reimbursement.amountReim}</td>
	 * <td>${reimbursement.remainingReim}</td> <td>${reimbursement.reimb_reset}</td>
	 * </tr>` );
	 */

	// var totalRows = 7;
	// var cellsInRow = 5;
	// get the reference for the body
	/*
	 * var div1 =
	 * document.getElementById("table1").getElementsByTagName('tbody')[0]; var
	 * newRow = div1.insertRow(div1.rows.length); console.log(div1.rows.length);
	 * console.log(reimbursement.length); result =
	 * JSON.stringify(reimbursement).match(/,/g).length+1; console.log(result); //
	 * creates a <table> element /* var tbl = document.createElement("table");
	 */// var a=0;
	// for(var r=0 ;r < reimbursement.length;r++){
	// creating rows
	// for (var e = a; e < 2; e++) {
	// var row = document.createElement("tr");
	// create cells in row

	/*
	 * var newCell1 = newRow.insertCell(1); var newText1 =
	 * document.createTextNode(reimbursement[r].userId);
	 * newCell1.appendChild(newText1);
	 * 
	 * var newCell2 = newRow.insertCell(2); var newText2 =
	 * document.createTextNode(reimbursement[r].jobType);
	 * newCell2.appendChild(newText2);
	 * 
	 * var newCell3 = newRow.insertCell(3); var newText3 =
	 * document.createTextNode(reimbursement[r].status);
	 * newCell3.appendChild(newText3);
	 * 
	 * var newCell4 = newRow.insertCell(4); var newText4 =
	 * document.createTextNode(reimbursement[r].availAmount);
	 * newCell4.appendChild(newText4);
	 * 
	 * var newCell5 = newRow.insertCell(5); var newText5 =
	 * document.createTextNode(reimbursement[r].srtTime);
	 * newCell5.appendChild(newText5);
	 * 
	 * var newCell6 = newRow.insertCell(6); var newText6 =
	 * document.createTextNode(reimbursement[r].endTime);
	 * newCell6.appendChild(newText6); }
	 */

	/*
	 * var cell = document.createElement("td");
	 * 
	 * var cellText1 = document.createTextNode(reimbursement.reimbursementId);
	 * cell.appendChild(cellText1); row.appendChild(cell);//this works
	 * 
	 * var cellText2 = document.createTextNode(reimbursement.userId);
	 * cell.appendChild(cellText2); // row.appendChild(cell);//this works
	 * 
	 * var cellText3 = document.createTextNode(reimbursement.jobType);
	 * cell.appendChild(cellText3); // row.appendChild(cell);//this works
	 * 
	 * var cellText4 = document.createTextNode(reimbursement.status);
	 * cell.appendChild(cellText4); // row.appendChild(cell);//this works
	 * 
	 * var cellText5 = document.createTextNode(reimbursement.availAmount);
	 * cell.appendChild(cellText5); //row.appendChild(cell);//this works
	 * 
	 * var cellText6 = document.createTextNode(reimbursement.srtTime);
	 * cell.appendChild(cellText6); //row.appendChild(cell);//this works
	 * 
	 * var cellText7 = document.createTextNode(reimbursement.endTime);
	 * cell.appendChild(cellText7); //row.appendChild(cell);//this works //} //
	 * row.appendChild(cell);
	 * 
	 * tbl.appendChild(row); // add the row to the end of the table body }
	 * 
	 * div1.appendChild(tbl); // appends <table> into <div1> }
	 */

	// }
}