/*
    Use the provided HTML page.
    Put your Javascript in the provided <script> element at the bottom of the page.
    Please put the question itself as a comment above each answer.
*/

/*
1. USA
    Define function getUSA()
    Find the html element that contains "USA".
    Print that element's contents.
*/
getUSA = function(){
    var usa = document.getElementsByTagName("span")[1];
    
    return usa.innerHTML;
};

/*
2. Sales
    Define function getPeopleInSales()
    Print the names of all the people in the sales department.
*/
getPeopleInSales = function(){
    var empNames = document.getElementsByClassName("empName");

    for (var i = 0; i < empNames.length; i++){
        if(empNames[i].nextElementSibling.innerHTML == "Sales")
            console.log(empNames[i].innerHTML);
    }
};

/*
3. Click Here
    Define function getAnchorChildren()
    Find all anchor elements with a <span> child.
    Print the contents of <span>
*/
getAnchorChildren = function() {
    var anc = document.getElementsByTagName("a");

    for (var i = 0; i < anc.length; i++){
        var span = anc[i].getElementsByTagName("span");
        for(var j= 0; j < span.length; j++){
            console.log(span[j].innerText);
        }
    }
};

/*
4. Hobbies
    Define function getSkills()
    Find all checked options in the 'skills' select element.
    Print the value and the contents.
*/
getSkills = function(){
    var skills = document.getElementsByName("skills");
    var option = skills[0].getElementsByTagName("option");

    for(var i =0; i < option.length; i++){
        //if(option[i].selected)    //this if statement gets only the selected option
            console.log(option[i].value + ", " + option[i].innerText); 
    }
};

/*
5. Custom Attribute
    Define function getCustomAttribute()
    Find all elements with "data-customAttr" attribute
    Print the value of the attribute.
    Print the element that has the attribute.
*/
getCustomAttribute = function(){
    var cus = document.getElementsByTagName("*");
    for(var i = 0; i < cus.length; i++){
        if(cus[i].getAttribute("data-customAttr"))
            console.log(cus[i].getAttribute("data-customAttr") + ", " + cus[i].tagName);
    }
};

/*
6. Sum Event
    NOTE: Write unobtrusive Javascript (ignore this part)
    Regarding these elements:
    <input id="num1" class="nums" type="text"/>
    <input id="num2" class="nums" type="text"/>
    <h3>Sum: span id="sum"></span></h3>
    Define onchange event handler.
    Add <input> element values.
    Put the sum in the <span> element.
    If values cannot be added, put "Cannot add" in the <span> element
*/
function addNums(){
    var num1 = document.getElementById("num1").value;
    var num2 = document.getElementById("num2").value;
    var sum = parseInt(num1) + parseInt(num2);

    if (sum != NaN)
        document.getElementById("sum").innerText = sum;
    else 
    document.getElementById("sum").innerText = "Cannot add";
}
//function is called in window.onload

/*
7. Skills Event
    NOTE: Write unobtrusive Javascript (ignore this part)
    When user selects a skill, create an alert with a message similar to:
    "Are you sure CSS is one of your skills?"
    NOTE: no alert should appear when user deselects a skill.
*/
function onSkillChange(event){
    let element = event.currentTarget;

    alert("Are you sure " + element.value + " is one of your skills?");
}
//function is called in window.onload


/*
8. Favorite Color Event
    NOTE: Write unobtrusive Javascript (ignore this part)
    NOTE: This is regarding the favoriteColor radio buttons.
    When a user selects a color, create an alert with a message similar to:
    "So you like green more than blue now?"
    In this example, green is the new value and blue is the old value.
    Make the background color (of all favoriteColor radio buttons)
    the newly selected favoriteColor
*/
function onColorChange(event){

    let element = event.currentTarget;
    var prev_color = element.style.backgroundColor;

    alert("So you like " + element.value + " more than " + prev_color + " now?");

    element.style.backgroundColor = element.value;
}
//function is called in window.onload

/*
9. Show/Hide Event
    NOTE: Write unobtrusive Javascript (ignore this part)
    When user hovers over an employees name:
    Hide the name if shown.
    Show the name if hidden.
*/
function hideEmpName(event) {
    event.stopPropagation();
    let element = event.currentTarget.firstElementChild;

    if (element.style.visibility == "hidden")
        element.style.visibility = "visible";
    else
        element.style.visibility = "hidden";

        
}
//function is called in window.onload

/*
10. Current Time
    Regarding this element:
    <h5 id="currentTime"></h5>
    Show the current time in this element in this format: 9:05:23 AM
    The time should be accurate to the second without having to reload the page.
*/
function showTime(){
    //get the date and parse its elements
    var time = new Date(); 
    var hrs = time.getHours(); 
    var min = time.getMinutes(); 
    var sec = time.getSeconds(); 
    var time_sig = "AM";

    //adjusting to our format of time
    if(hrs >= 12)
        time_sig = "PM";

    if(hrs == 0)
        hrs = 12;
    else if(hrs > 12)
        hrs -= 12;

    if(min < 10)
        min = "0" + min;
    if(sec < 10)
        sec = "0" + sec;
    
    var time_format = hrs + ":" + min + ":" + sec + " " + time_sig;

    //update the page
    document.getElementById("currentTime").innerHTML = time_format;

    //keep re-calling the function every second
    setTimeout(showTime, 1000);
}
//function is called in window.onload


/*
11. Delay
    Regarding this element:
    <p id="helloWorld">Hello, World!</p>
    Three seconds after a user clicks on this element, change the text to a random color.
*/
function changeColor(event){
    let element = event.currentTarget;
    var ran_col = "#" + Math.floor(Math.random()* 999999);

    setTimeout(function(){ element.style.color = ran_col; }, 3000);
    
}

window.onload = function(){

    //Question 6
    document.getElementById("num1").onchange = addNums;
    document.getElementById("num2").onchange = addNums;

    //Question 7
    var skils = document.getElementsByName("skills");
    skils[0].onchange = onSkillChange;

    //Question 8
    var cols = document.getElementsByName("colors");
    cols[0].onchange = onColorChange;
    cols[0].style.backgroundColor = cols[0].value;

    //Question 9
    var empNames = document.getElementsByClassName("empName");

    for (var i = 0; i < empNames.length; i++){
        //make new container
        var newDiv = document.createElement("DIV");
        empNames[i].parentNode.insertBefore(newDiv, empNames[i]);
        newDiv.appendChild(empNames[i]); //wrap the element in the div
        newDiv.addEventListener("mouseenter", hideEmpName, false); //attach the event to the wrapper
    }

    //Question 10
    showTime();

    //Question 11
    document.getElementById("helloWorld").addEventListener("click", changeColor, false);

    //q12 stuff?
    var currentNode,
    ni = document.createNodeIterator(document.documentElement, NodeFilter.SHOW_ELEMENT);

    while(currentNode = ni.nextNode()) {
        console.log(currentNode.nodeName);
    }
}

/*
12. Walk the DOM
    Define function walkTheDOM(node, func)
    This function should traverse every node in the DOM.
    Use recursion.
    On each node, call func(node).
*/
function displayTheElement(node){
    //log it
    console.log(node);

    //get each child
    var chi = node.firstChild;
    if(chi)
        displayTheElement(chi);
    
    //get each sibling
    var sib = node.nextSibling;
    if(sib)
        displayTheElement(sib);
}

function walkTheDOM(node, func) {
    func(node);
}
//call this in the console:
//  walkTheDOM(document.firstChild, displayTheElement)