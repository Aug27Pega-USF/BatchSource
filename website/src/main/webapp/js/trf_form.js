let availablereimbursement=document.getElementsByTagName("body")[0].dataset.available_reimbursement;

function pr_calculation(){
    var cost;
    if(document.getElementById("cost").checkValidity()){
    cost=document.getElementById("cost").value;
    
    var reimbursement; 
    let event_type=document.getElementById("event_type").value;
    if(event_type=="university_courses"){
       reimbursement=Math.round(cost*80)/100;
    } else if(event_type=="seminars"){
        reimbursement=Math.round(cost*60)/100;
    } else if(event_type=="cp_classes"){
        reimbursement=Math.round(cost*75)/100;
    } else if(event_type=="certification"){
        reimbursement=Math.round(cost*100)/100;
    } else if(event_type=="technical_training"){
        reimbursement=Math.round(cost*90)/100;
    }else if(event_type=="other"){
        reimbursement=Math.round(cost*30)/100;
    }
    if(reimbursement>availablereimbursement){
        reimbursement=availablereimbursement;
    }
    var reimbursementnumber=Number.parseFloat(reimbursement).toFixed(2);
    document.getElementById("projected_reimbursement").value=reimbursementnumber;
    document.getElementById("")
    }else{
        document.getElementById("projected_reimbursement").value="";
    }
}

function default70(){
    if(document.getElementById("percentage_pass").value==70){
        document.getElementById("grade_default").innerHTML="(Default)";
    } else if(document.getElementById("percentage_pass").value==""){
        document.getElementById("percentage_pass").value=70;
        document.getElementById("grade_default").innerHTML="(Default)";
    }
    else{
        document.getElementById("grade_default").innerHTML="";
    }
}

function passing_grade(){
    let g_format = document.getElementById("grading_format").value;
    if(g_format=="Percentage"){
        document.getElementById("passing_grade").innerHTML="Passing Grade (%): <input type=\"number\"  id=\"percentage_pass\" name=\"percentage_pass\" min=\"0\" max=\"110\" step=\"1\" value = \"70\" required/> <div id= \"grade_default\" style=\"display: inline-block;\">(Default)</div>";
        document.getElementById("percentage_pass").setAttribute("onchange", "default70()"); 
        document.getElementById("passing_grade").style.display="block"
    }else if(g_format=="Letter Grade"){
        document.getElementById("passing_grade").innerHTML="Passing Grade: <select id=\"letter_pass\" name=\"letter_pass\" required><option value=\"A+\">A+</option><option value=\"A\">A</option><option value=\"A-\">A-</option><option value=\"B+\">B+</option><option value=\"B\">B</option><option value=\"B-\">B-</option><option value=\"C+\">C+</option><option value=\"C\">C</option><option value=\"C-\" selected=\"selected\">C- (default)</option><option value=\"D+\">D+</option><option value=\"D\">D</option><option value=\"D-\">D-</option></select>";
        document.getElementById("passing_grade").style.display="block"
    }else{
        document.getElementById("passing_grade").innerHTML="";
        document.getElementById("passing_grade").style.display="none"
    }
}

window.onload=function(){
    document.getElementById("cost").setAttribute("onchange", "pr_calculation()")
    document.getElementById("event_type").setAttribute("onchange", "pr_calculation()")
    var today = new Date();
    today.setDate(today.getDate()+7)
    var dd = today.getDate();
    var mm = today.getMonth()+1; //January is 0!
    var yyyy = today.getFullYear();
     if(dd<10){
            dd='0'+dd
        } 
        if(mm<10){
            mm='0'+mm
        } 
    
    today = yyyy+'-'+mm+'-'+dd;
    document.getElementById("date").setAttribute("min", today);
    document.getElementById("date").setAttribute("value", today);
    document.getElementById("grading_format").setAttribute("onchange", "passing_grade()");
    employeeAutoUpdate(document.getElementsByTagName("body")[0].dataset.isready);
}

function employeeAutoUpdate(x){
	if (!x){
		setTimeout(employeeAutoUpdate.bind(document.getElementsByTagName("body")[0].dataset.isready), 500);
	}
	document.getElementById("maxrei").textContent="Current Available Reimbursement: $"+document.getElementsByTagName("body")[0].dataset.available_reimbursement;
    document.getElementById("first_name").value=document.getElementsByTagName("body")[0].dataset.first_name;
    document.getElementById("last_name").value=document.getElementsByTagName("body")[0].dataset.last_name;
    document.getElementById("employee_info").value=document.getElementsByTagName("body")[0].dataset.basic_info_placeholder;
    availablereimbursement=document.getElementsByTagName("body")[0].dataset.available_reimbursement;
    if (document.getElementsByTagName("body")[0].dataset.user_type_id=="H"){
    	document.getElementById("supervisortext").textContent="Upload not necessary.";
    	document.getElementById("headtext").textContent="Upload not necessary.";
    	document.getElementById("dhapprovalfile").style.visibility="hidden";
    	document.getElementById("dsapprovalfile").style.visibility="hidden";
    }else if (document.getElementsByTagName("body")[0].dataset.user_type_id=="S"){
    	document.getElementById("supervisortext").textContent="Upload not necessary.";
    	document.getElementById("dsapprovalfile").style.visibility="hidden";
    };
}