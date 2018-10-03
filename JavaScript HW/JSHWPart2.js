/* 1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents. */

function getUSA(){
    for(let element of document.getElementsByTagName("*")) {
        if(element.innerHTML == "USA"){
            return element.innerHTML;
        }
    }
}
console.log("Question 1: ")
console.log(getUSA());

/* 2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department. */

function getPeopleInSales(){
    let salesDepList = [];
    for(let element of document.getElementsByClassName("empName")) {
        if(element.nextElementSibling.innerHTML == "Sales") {
            salesDepList.push(element.innerHTML);
        }
    }
    return salesDepList;
}
console.log("Question 2: ")
for(let person of getPeopleInSales()){
    console.log(person);
}
/* 3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span> */

function getAnchorChildren() {
    let anchorChildrens = [];
    for(let element of document.getElementsByTagName("a")){
        for(let child of element.getElementsByTagName("span")){
            anchorChildrens.push(child.innerHTML);
        }
    }
    return anchorChildrens;
}
console.log("Question 3: ")
for(let anchorChildren of getAnchorChildren()){
    console.log(anchorChildren);
}

/* 4. Hobbies
Define function getSkills()
Find all checked options in the 'skills' select element.
Print the value and the contents. */
function getSkills(){
    let skillList = [];
    for(let element of document.getElementsByName("skills")){
        if(element.options){
            return element.options;
        }
    }
}
console.log("Question 4: ")
for(let skill of getSkills()){
    console.log(skill.value + " " + skill.innerHTML);
}

/* 5. Custom Attribute
Define function getCustomAttribute()
Find all elements with "data-customAttr" attribute
Print the value of the attribute.
Print the element that has the attribute. */
function getCustomAttribute() {
    let customList = []
    for(let element of document.getElementsByTagName("*")){
        if(element.hasAttribute("data-customAttr")){
            customList.push(element + " " + element.getAttribute("data-customAttr"));
        }
    }
    return customList;
}
console.log("Question 5: ")
for(let attribute of getCustomAttribute()){
    console.log(attribute);
}

/* 6. Sum Event
NOTE: Write unobtrusive Javascript
Regarding these elements:
<input id="num1" class="nums" type="text"/>
<input id="num2" class="nums" type="text"/>
<h3>Sum: span id="sum"></span></h3> 

Define onchange event handler.
Add <input> element values.
Put the sum in the <span> element.
If values cannot be added, put "Cannot add" in the <span> element */
function sum() {
    let num1 = Number(document.getElementById("num1").value);
    let num2 = Number(document.getElementById("num2").value);
    if(!(isNaN(num1 + num2))){
        document.getElementById("sum").innerHTML = num1 + num2;
    } else {
        document.getElementById("sum").innerHTML = "Cannot add"
    }
}
document.getElementById("num1").addEventListener("change", sum);
document.getElementById("num2").addEventListener("change", sum);

/* 7. Skills Event
NOTE: Write unobtrusive Javascript
When user selects a skill, create an alert with a message similar to:
"Are you sure CSS is one of your skills?"
NOTE: no alert should appear when user deselects a skill. */
document.getElementsByName("skills")[0].addEventListener("change", function(){
    alert("Are you sure " + this.options[this.selectedIndex].innerHTML + " is one of your skills");
});

/*
8. Favorite Color Even
NOTE: Write unobtrusive Javascript
NOTE: This is regarding the favoriteColor radio buttons.
When a user selects a color, create an alert with a message similar to:
"So you like green more than blue now?"
In this example, green is the new value and blue is the old value.
Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor
*/
let colorHolder = new Array;
for(let element of document.getElementsByName("favoriteColor")) {
    function changeBgColors(newColor){
        for(let bgElement of document.getElementsByName("favoriteColor")){
            bgElement.style.backgroundColor = newColor;
        }
    }

    element.addEventListener("click", function(){
        colorHolder.push(element.nextSibling.textContent);
        if(colorHolder.length > 2){
            colorHolder.shift();
        }
        changeBgColors(element.value);
        
        console.log(element.innerHTML);
        alert("So you like " + (colorHolder[1] == undefined ? colorHolder[0] : colorHolder[1] + " more than " + colorHolder[0] + " now"));
    });
}
/*
9. Show/Hide Event
NOTE: Write unobtrusive Javascript
When user hovers over an employees name:
Hide the name if shown.
    Show the name if hidden.
*/
for(let element of document.getElementsByClassName("empName")) {
    element.addEventListener('mouseenter', function(){
        if(element.style.opacity == 1){
            element.style.opacity = 0;
        } else {
            element.style.opacity = 1;
        }
    });
}

/*
10. Current Time
Regarding this element:
    <h5 id="currentTime"></h5>
Show the current time in this element in this format: 9:05:23 AM
The time should be accurate to the second without having to reload the page.
*/
setInterval(function(){ document.getElementById("currentTime").innerHTML = new Date().toLocaleTimeString();}, 1000);

/*
11. Delay
Regarding this element:
<p id="helloWorld">Hello, World!</p>
Three seconds after a user clicks on this element, change the text to a random color.
*/
document.getElementById("helloWorld").addEventListener("click", function(){
    function setColor (element){
        let letters = "0123456789abcdef";
        let color = "#";
        for (var i = 0; i < 6; i++) {
            color += letters[Math.floor(Math.random() * 16)];
        };
        element.style.color = color;
    };

        setInterval(setColor, 3000, this);
});
/*
12. Walk the DOM
Define function walkTheDOM(node, func)
This function should traverse every node in the DOM. 
Use recursion.
On each node, call func(node).
*/
function walkTheDOM(node, func){
    func(node);
    node = node.firstChild;
    while(node){
        walkTheDOM(node, func);
        node = node.nextSibling;
    }
}
walkTheDOM(document.body, function(node) { 
    console.log(node.textContent);
});