
/*1. USA
Define function getUSA()

Find the html element that contains "USA".

Print that element's contents.*/

function getUSA(){
    var aTags = document.getElementsByTagName("*");
    var found;
    for (var i = 0; i < aTags.length; i++) {
      if (aTags[i].textContent.match(/USA/)) {
        found = aTags[i];
      }
    }
    return found.textContent;
};

/*2. Sales

Define function getPeopleInSales()

Print the names of all the people in the sales department.*/

function getPeopleInSales(){
    var aTags = document.getElementsByClassName("empName");
    var found=[];
    var index=0;
    for (var i = 0; i < aTags.length; i++) {
      if (aTags[i].nextElementSibling.textContent=="Sales") {
        found[index]=aTags[i].textContent;
        index++;
      }
    }
    return found;
}

/*3. Click Here

Define function getAnchorChildren()

Find all anchor elements with a <span> child.

Print the contents of <span>*/
function getAnchorChildren(){
    var aTags = document.getElementsByTagName("a");
    var found=[];
    var index=0;
    for (var i = 0; i < aTags.length; i++) {
        for(var j=0;j < aTags[i].childNodes.length; j++){
            if(aTags[i].childNodes[j].nodeName=="SPAN"){
                found[index]=aTags[i].childNodes[j].textContent;
                index++;
            }
        }
    }
    return found;
}
/*4. Hobbies

Define function getSkills()

Find all checked options in the 'skills' select element.

Print the value and the contents.*/
function getSkills(){
    var aTags = document.getElementsByName("skills")[0];
    var found=[];
    var index=0;
    for (var i = 0; i < aTags.length; i++) {
        if(aTags[i].selected){
        found[index]=aTags[i].textContent;
        index++;
        }
    }
    return found;
}
/*5. Custom Attribute

Define function getCustomAttribute()

Find all elements with "data-customAttr" attribute

Print the value of the attribute.

Print the element that has the attribute.*/
function getCustomAttribute(){
    var aTags=$(document).children().filter(function(){
        return $(this).data('customAttr');
    })
    var found=[];
    var index=0;
    return aTags;
    for (var i = 0; i < aTags.length; i++) {
        found[index]=[aTags[i].customAttr];
        index++;
    }
    return found;
}
/*6. Sum Event

NOTE: Write unobtrusive Javascript

Regarding these elements:
	
<input id="num1" class="nums" type="text"/>
	
<input id="num2" class="nums" type="text"/>
	
<h3>Sum: span id="sum"></span></h3>

Define onchange event handler.

Add <input> element values.

Put the sum in the <span> element.

If values cannot be added, put "Cannot add" in the <span> element*/
function addnums(){
    let sum="";
    let var1= document.getElementsByClassName("nums")[0].value;
    let var2= document.getElementsByClassName("nums")[1].value;
    if (!isNaN(var1) && var1!=""){
        if(!isNaN(var2) && var2!=""){
            sum =parseInt(var1)+parseInt(var2);
            if(isNaN(sum)){
                sum="Cannot Add.";
            }
        }
        else{
            sum="";
        }
    }else{
        sum="";
    }
    document.getElementById("sum").innerHTML=sum;
}

/*7. Skills Event

NOTE: Write unobtrusive Javascript

When user selects a skill, create an alert with a message similar to:
	
"Are you sure CSS is one of your skills?"

NOTE: no alert should appear when user deselects a skill.*/
function skillsalert(){
    for(i=0; i<skillalert.length;i++){
        if(skillalert[i].selected){
            if(!selectedskills.includes(skillalert[i])){
                if(confirm("You are selecting " + skillalert[i].textContent + " as one of your skills.")){
                    
                }
                else{
                    skillalert[i].selected=false;
                }
            }
        }
    }
    selectedskills=[];
    for(i=0; i<skillalert.length;i++){
        if(skillalert[i].selected){
            selectedskills.push(skillalert[i]);
        }
    }
}
/*8. Favorite Color Event

NOTE: Write unobtrusive Javascript

NOTE: This is regarding the favoriteColor radio buttons.

When a user selects a color, create an alert with a message similar to:
	
"So you like green more than blue now?"

In this example, green is the new value and blue is the old value.

Make the background color (of all favoriteColor radio buttons) 
the newly selected favoriteColor*/
function coloralert(){
    let newcolor=document.querySelector("input[name=favoriteColor]:checked");
    if (!selectedcolor){
        selectedcolor=newcolor;
    }
    else if(selectedcolor!=newcolor){
        alert("So you like " + newcolor.value + " more than " + selectedcolor.value + " now?")
        selectedcolor=newcolor;
    }
    document.getElementById("firstForm").style.backgroundColor=newcolor.value;
}
/*9. Show/Hide Event

NOTE: Write unobtrusive Javascript

When user hovers over an employees name:
	
Hide the name if shown.
	Show the name if hidden.
*/
function hideshowEmp(index){
    var x = document.getElementsByClassName("empName")[index];
    if (x.style.opacity == "0"){
        x.style.opacity = "1";
    } else {
        x.style.opacity= "0";
    }
}
/*10. Current Time

Regarding this element:
	<h5 id="currentTime"></h5>

Show the current time in this element in this format: 9:05:23 AM

The time should be accurate to the second without having to reload the page.
*/
function updateClock(){
    var d = new Date();
    document.getElementById("currentTime").textContent=d.toLocaleTimeString();
    setTimeout(updateClock, 1000);
}
/*11. Delay
Regarding this element:
	
<p id="helloWorld">Hello, World!</p>

Three seconds after a user clicks on this element, change the text to a random color.*/
function changeColor(){
    setTimeout(function curriedColor(){
        document.getElementById("helloWorld").style.color='#'+Math.random().toString(16).substr(-6);},3000);
}

window.onload=function(){
    document.getElementsByClassName("nums")[0].setAttribute("onchange","addnums()");
    document.getElementsByClassName("nums")[1].setAttribute("onchange","addnums()");
    document.getElementsByName("skills")[0].setAttribute("onchange","skillsalert()");
    for(i=0; i<skillalert.length;i++){
        if(skillalert[i].selected){
            selectedskills.push(skillalert[i]);
        }
    }
    for(i=0; i<colors.length;i++){
        colors[i].setAttribute("onchange","coloralert()");
    }
    for(i=0;i<document.getElementsByClassName("empName").length;i++){
        document.getElementsByClassName("empName")[i].setAttribute("onmouseover","hideshowEmp("+i+")");
    }
    updateClock();
    document.getElementById("helloWorld").addEventListener("click",changeColor);
}

var skillalert= document.getElementsByName("skills")[0];
var selectedskills=[];
var colors=document.getElementsByName("favoriteColor");
var selectedcolor;
/*12. Walk the DOM

Define function walkTheDOM(node, func)

This function should traverse every node in the DOM. 
Use recursion.

On each node, call func(node).
*/
function walkTheDOM(node, func){
    func(node)
    node = node.firstChild;
      while(node)
      {
          walkTheDOM(node, func);
        node = node.nextSibling;
      }
}