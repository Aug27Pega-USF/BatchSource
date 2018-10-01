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
}