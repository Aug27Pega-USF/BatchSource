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
        reimbursement=cost;
    } else if(event_type=="technical_training"){
        reimbursement=Math.round(cost*90)/100;
    }else if(event_type=="other"){
        reimbursement=Math.round(cost*30)/100;
    }
    document.getElementById("projected_reimbursment").innerHTML="Projected Reimbursement: $"+reimbursement.toFixed(2);
    }else{
        document.getElementById("projected_reimbursment").innerHTML="Projected Reimbursement:";
    }
}

function passing_grade(){
    let g_format = document.getElementById("grading_format").value;
    if(g_format=="Percentage"){
        document.getElementById("passing_grade").innerHTML="Passing Grade (%): <input type=\"number\"  id=\"percentage_pass\" min=\"0\" step=\"1\" required/>";
        document.getElementById("passing_grade").style.display="block"
    }else if(g_format=="Letter Grade"){
        document.getElementById("passing_grade").innerHTML="Passing Grade: <select id=\"letter_pass\" required><option value=\"A+\">A+</option><option value=\"A\">A</option><option value=\"A-\">A-</option><option value=\"B+\">B+</option><option value=\"B\">B</option><option value=\"B-\">B-</option><option value=\"C+\">C+</option><option value=\"C\">C</option><option value=\"C-\">C-</option><option value=\"D+\">D+</option><option value=\"D\">D</option><option value=\"D-\">D-</option></select>";
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
    document.getElementById("grading_format").setAttribute("onchange", "passing_grade()")
}