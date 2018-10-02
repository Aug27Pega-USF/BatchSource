/*----------------------------------------------------------------------------------

PART II


Part II will focus on Javascript's ability to manipulate the DOM.

Use the provided HTML page.

Put your Javascript in the provided <script> element at the bottom of the page.

Please put the question itself as a comment above each answer.


-----------------------------------------------------------------------------------

1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.
*/

var getUSA = function(){
	for(let elem of document.getElementsByTagName("*")) {
		if(elem.innerHTML =="USA"){
			return elem.innerText;
		}	
	  }
};

/*
2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.
 */ 

var getPeopleInSales = function(){
	var emps = [];
	x=0;
	for(let elem of document.getElementsByTagName("table")){
		for ( var i = 0; row = elem.rows[i]; i++ ) {
			row = elem.rows[i];
			if(row.cells[1].innerHTML =="Sales"){
				emps[x] = row.cells[0].innerHTML;
				x++;
				
			}
		}
	}
	return emps;
};

/*
3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>
  */
var getAnchorChildren = function() {
    var spanTexts = [];
    for(let anchor of document.getElementsByTagName("a")){
        for(let span of anchor.getElementsByTagName("span")){
            spanTexts.push(span.innerHTML);
        }
    }
    return spanTexts;
};
/*
4. Hobbies

Define function getSkills()

Find all checked options in the 'skills' select element.

Print the value and the contents.
 */ 
/****
 * Wasn't sure what you meant by "checked" since its a select box 
 * so I logged each one in a nested-for
 * */
 var getSkills = function (){
	for(let skillSelect of document.getElementsByName("skills")[0]){
		console.log(skillSelect.innerText);
	}
};

/*
5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.
*/ 
function getCustomAttributes(){
	var x = document.querySelectorAll("*");
	//return x;
	for(let elem of document.querySelectorAll("*")){
		if(elem.hasAttribute("data-customAttr")){
			console.log(elem +" =  " +elem.getAttribute("data-customAttr"));
		}
	}
}
/*
6. Sum Event

NOTE: Write unobtrusive Javascript

Regarding these elements:
	
<input id="num1" class="nums" type="text"/>

<input id="num2" class="nums" type="text"/>
	
<h3>Sum: span id="sum"></span></h3>

Define onchange event handler.

Add <input> element values.

Put the sum in the <span> element.

If values cannot be added, put "Cannot add" in the <span> element
*/
document.getElementById("num1").addEventListener("change", calculateSum);
document.getElementById("num2").addEventListener("change", calculateSum);

/**Check for truthy, NaN is falsy **/
function calculateSum() {
	var elem = document.getElementById("sum");
	if(+this.value){
		var firstNum = document.getElementById("num1");
		 var secondNum = document.getElementById("num2");
	 	elem.innerHTML = ((+firstNum.value) + (+secondNum.value));
	} else {
		elem.innerHTML = "Cannot Add";
	}
}
/*
7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.
*/
document.getElementsByName("skills")[0].addEventListener("change", function() {
	var option = this.value;
	console.log(option.toUpperCase());
	alert("Easy now bud, you're kinda bad at "+option.toUpperCase());
}, false);

/*
8. Favorite Color Event

NOTE: Write unobtrusive Javascript

NOTE: This is regarding the favoriteColor radio buttons.

When a user selects a color, create an alert with a message similar to:
	
"So you like green more than blue now?"

In this example, green is the new value and blue is the old value.

Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor
*/
//was unable to change bg color of justt those radios*/
oldColors = [];
oldColors[0] = "";
for(let radio of document.getElementsByName("favoriteColor")){
	radio.addEventListener("click", function(){
		event.stopPropagation();
		oldColors.push(this.value);
		if(oldColors[oldColors.length-2] == ""){
			alert(this.value + " is a great color!");
		} else {
			alert("So you like "+this.value+" better than "+oldColors[oldColors.length-2]+"?")
		}
	})
}

/*
9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.
*/
var emps = document.getElementsByClassName("empName");
//console.log(emps);
for(let emp of emps){
	emp.addEventListener("mouseenter", function(event){
		event.stopPropagation();
		
		if(emp.style.opacity == '1'){
			emp.style.opacity = '0';
		} else {
			emp.style.opacity = '1';
		}
		event.stopPropagation();	   
	});
}
/*
10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/
// function display_c(){
// 	var refresh=1000; // Refresh rate in milli seconds
// 	//window.refresh;
// 	mytime=setTimeout('display_ct()',refresh)
// 	}
	
	function display_ct() {
	var x = new Date()
	var hours = (x.getHours()+24)%24;
	var ampm = "am";
	if(hours==0)
		hours=12;
	else if(hours > 12)
		hours =hours%12;
		ampm = "pm;"
	document.getElementById('currentTime').innerHTML = ""+hours+":"+x.getMinutes()+":"+x.getSeconds() +" "+ampm;
	var refresh=1000;
	mytime=setTimeout('display_ct()',refresh);
 }
 
 window.onload = display_ct(); 

/*
11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.
*/
setTimeout(delayedColorChange, 3000);

function delayedColorChange(){
	setTimeout(sendChange, 3000);
}
function sendChange(){
	document.getElementById("helloWorld").style.color = "green";
}
document.getElementById("helloWorld").addEventListener("click",delayedColorChange,false);

/*
12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/
//logs each element to console
var logIt = function(elem)
	{
		console.log('Element', elem);
	}

var walkTheDOM = function (node, func) {
    func(node); // Will be called on every DOM element 
    node = node.firstChild;
    while(node) {
        walkTheDOM(node,func);
        node = node.nextSibling;
    }
};


