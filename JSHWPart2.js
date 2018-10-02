<script>
{/* 1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents. */}

function getUSA() {
   var searchText = "USA";
   var aTags = document.body.getElementsByTagName("*");
   for (var i = 0; i < aTags.length; i++) {
       var n = aTags[i].textContent.search(searchText);
       if(n != -1){
          alert(aTags[i].textContent);
          break;
       }
    }  
}

{/* 2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department. */}

function getPeopleInSales() {
   var table = document.getElementsByTagName("table")[0];
   for (var i = 0; i <table.rows.length;i++){
    var cells = table.rows[i].cells;
        if(cells[1].textContent === "Sales"){
          alert(cells[0].textContent);
       }
   }
}

{/* 3. Click Here</span>
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span> */}

function get_Anchor_Children(){
var anchor = [];
var searchElement = document.getElementById("myDiv").children;
for(var i = 0; i < searchElement.length; i++) {
    if(searchElement[i].tagName == 'SELECT' || searchElement.tagName == 'INPUT') {
        if(searchElement[i].id.indexOf('q1_') == 0) {
            anchor.push(searchElement[i]);
        }
    }

// 4. Hobbies
// Define function getSkills()
// Find all checked options in the 'skills' select element.  
// Print the value and the contents.
    
function Hobies(){
    var hobbies = document.getElementsByName("hobbies")[0];
    var selectedFromHobbies = hobbies.options[hobbies.selectedIndex].value;
    var contentFromHobbies = hobbies.options[hobbies.selectedIndex].textContent;
        alert(contentFromHobbies + ":" + selectedFromHobbies);
    var skills = document.getElementsByName("skills")[0];
    var selectedFromSkills = skills.options[skills.selectedIndex].value;
    var contentFromSkills = skills.options[skills.selectedIndex].textContent;
alert(contentFromSkills + ":" + selectedFromSkills);
}

// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.

function getCustomAttribute(){
var elements = document.querySelectorAll('[data-customAttr]');
for (var i = 0; i <elements.length;i++){
    alert(elements[i].dataset.customattr);
   }
}

// 6. Sum Event
// NOTE: Write unobtrusive Javascript
// Regarding these elements:
// <input id="num1" class="nums" type="text"/>	
// <input id="num2" class="nums" type="text"/>
// <h3>Sum: span id="sum"></span></h3>

// Define onchange event handler.
// Add <input> element values.
// Put the sum in the <span> element.
// If values cannot be added, put "Cannot add" in the <span> element

<html>
    <head>
        <title>Sum two number</title>
            <script type="text/javascript" src="add.js"></script>
    </head>
        <body>
            <input id="num1" class="nums" type="text"/>
            <input id="num2" class="nums" type="text" onchange="add(this);"/><br>
                <h3>Sum: <span id="sum"></span></h3>
        </body>
</html>

function add(ele){
    var a,b,c;
        a=Number(document.getElementById("num1").value);
        b=Number(document.getElementById("num2").value);
        c= a + b;
    document.getElementById("sum").innerHTML= c;
}

// 7. Skills Event
// NOTE: Write unobtrusive Javascript
// When user selects a skill, create an alert with a message similar to:	
// "Are you sure CSS is one of your skills?"
// NOTE: no alert should appear when user deselects a skill.

document.addEventListener('DOMContentLoaded',load);
    var skills=" ";
        function load() {
            skills =firstForm.skills;
            skills.addEventListener('change',option_change);
}

function option_change() {
    alert("Are you sure "+skills.options[skills.selectedIndex].text+" is one of your skills?");
return false;
    }

// 8. Favorite Color Event
// NOTE: Write unobtrusive Javascript
// NOTE: This is regarding the favoriteColor radio buttons.
// When a user selects a color, create an alert with a message similar to:
// "So you like green more than blue now?"
// In this example, green is the new value and blue is the old value.
// Make the background color (of all favoriteColor radio buttons) 
// the newly selected favoriteColor 

function changeColor(){
    var i;
        for(i=0;i<colors.length;i++){
        alert("So you like "+ colors[i].value + " more than "+ old +" now?");
        old=colors[i].value;
    body[0].style.backgroundColor=old;
    }
}

// 9. Show/Hide Event
// NOTE: Write unobtrusive Javascript
// When user hovers over an employees name:	
// Hide the name if shown.
// Show the name if hidden.

9. this.onmouseover=function(e) {
if(e.target.className=="empName") {
if(e.target.style.fontSize=="") {
e.target.style.fontSize="0px";
        }
else if(e.target.style.fontSize=="0px"){
e.target.style.fontSize="16px";
    }
else if(e.target.style.fontSize=="16px"){
e.target.style.fontSize="0px";
        }
    }
}

// 10. Current Time
// Regarding this element:
// <h5 id="currentTime"></h5>
// Show the current time in this element in this format: 9:05:23 AM
// The time should be accurate to the second without having to reload the page.

<h5 id="currentTime"></h5>
<script language="javascript">
    function setTime() {
        var today = new Date();
        var hour = today.getHours();
        var minute = today.getMinutes();
        var second = today.getSeconds();
        var prepand = (hour >= 12)? " PM ":" AM ";
            document.getElementById("currentTime").innerHTML = (hour + ":" + minute + ":" + second + prepand);
                }
                    setTime();
                    window.setInterval(function(){
                                setTime();
                        }, 1000);
</script>


// 11. Delay
// Regarding this element:	
// <p id="helloWorld">Hello, World!</p>
// Three seconds after a user clicks on this element, change the text to a random color.

<p id="helloWorld" onclick="colorChange()">Hello, World!</p>
<script language="javascript">
function colorChange() {
    setTimeout(function() {
        document.getElementById("helloWorld").style.color = '#' + Math.floor(Math.random() * 16777215).toString(16);
                }, 3000);
                ``}
</script>

// 12. Walk the DOM
// Define function walkTheDOM(node, func)
// This function should traverse every node in the DOM. 
// Use recursion.
// On each node, call func(node).

<script language="javascript">
function walkTheDOM(node, func) {
    func(node);
    node = node.firstChild;
        while (node) {
            walkTheDOM(node, func);
                node = node.nextSibling;
    }
}
walkTheDOM(document.body, function (node) {
    if (node.nodeType === 3) { 
        var text = node.data.trim();
        if (text.length > 0) { 
            console.log(text);
        }
     }
});

</script>

</script>