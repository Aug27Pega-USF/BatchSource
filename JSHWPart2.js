function getUSA() {
    var h = document.getElementsByTagName("h1")[0];
    console.log(h.textContent);
};

function getPeopleInSales() {
    var p = document.getElementsByClassName("empName");
    for (var i = 0; i < p.length; i++) {
        var check = p[i].nextElementSibling.textContent;
        if (check == "Sales") {
            console.log(p[i].textContent);
        }
    }
}

function getAnchorChildren() {
    var a = document.getElementsByTagName("a");
    for (var i = 0; i < a.length; i++) {
        var s = a[i].getElementsByTagName("span");
        console.log(s.textContent);
    }
}