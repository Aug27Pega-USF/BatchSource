function bubble(event) {
    event.stopPropagation();
    let element = event.currentTarget;
    element.style.backgroundColor = "green";
    alert(element.id);
    event.stopPropagation;
}
function myFunction() {
    var x = document.getElementById("C");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
}
window.onload = function() {
    //document.getElementById("P").addEventListener("click",bubble,false);
    //document.getElementById("C").addEventListener("click",function(){myFunction(this);},false);
    //document.getElementById("B").addEventListener("click",bubble,false);
}