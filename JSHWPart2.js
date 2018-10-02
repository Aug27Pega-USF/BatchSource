
/*
define function getUSA() 
find the html element that contains "USA"
print that element's content
*/

getUSA = function () {
    var span = document.getElementsByTagName("span");
    var val;
    for (var i = 0; i < span.length; i++) {
        if (span[i].textContent == "USA") {
            val = span[i];
        }
    }
    return val.textContent;
};
//2-Sales
/* define function getPeopleInSales()
print the names of all the people in the sales department
*/
getPeopleInSales = function () {//undefined
    var sales = document.getElementsByTagName("td");//all tds
    var rows = sales.length;//12
    var valNeeded = [];
    for (var i = 0; i < rows; i++) {
                if(sales[i].textContent == "Sales"){
                    valNeeded = sales[i].nextElementSibling.textContent;
                    console.log(valNeeded);
        }
        }
        return valNeeded;
    };

//3-click Here
/*
define function getAnchorChildren()
find all anchor elements with a <span> child
print the content of <span>
*/
function getAnchorChildren() {//undefined so far
    var anch = document.getElementsByTagName("a");
    for (var i = 0; i < anch.length; i++) {
        if(anch.childNodes[i] === "SPAN")
        console.log(anch.childNodes[i].innerHTML);
    }
}
//4-Hobbies
/*
define function getSkills()
find all checked options in the 'skill' select element
print the value and the contents
*/
function getSkills(){//undefined
    var whichSelect = document.getElementsByName("name");
    for(var i = 0; i < whichSelect.length; i++){
        if(whichSelect[i].name === "skills"){
                var skill = document.getElementsByTagName("select");
                for (var i = 0; i < skill.length; i++) {
                    console.log(skill[i].value + " " + skill[i].innerHTML);
                }
        }
    }
}
//5-custom Attribute
/*
define function getCustomAttribute()
find all elements with "data-customAttr" attribute
print the value of the attribute
print the element that has the attribute

*/
function getCustomAttribute(){//errors need to fix
    var attr = document.getElementsByName(getAttribute("data-customAttr"));
    for(var i = 0; i < attr.length; i++){
        console.log(attr[i].value + " " + attr[i].innerHTML);
    }
}

//6- sum Event
/*
Unobstructive javascript
<input id="num1", class="nums" type="text"/>
<input id="num2", class="nums" type="text"/>
<h3>Sum: <span id="sum"</span></h3>
define on change event handler
add < input > elemet values.prototype
put the sum in the < span > element
if values cannot be added, put "cannot add" in the < span > element
*/
//7-
//8-
//9-
//10-
//11-
//12- walk the DOM

function walkTheDOM(node, func) {
}