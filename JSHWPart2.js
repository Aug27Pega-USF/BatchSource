/*1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.*/
function getUSA(){
    return document.evaluate("//*[contains(text(), 'USA')]",
     document, null, XPathResult.ANY_TYPE, null).iterateNext().innerText;
    }

// 2. Sales
// Define function getPeopleInSales()
// Print the names of all the people in the sales department.
function getPeopleInSales(){
    const saleEmployees = [];

    const rows = Array.from(document.getElementsByTagName('tr')).splice(1);
    for (const row of rows){
      if (row.children[1].textContent != 'Sales'){
        continue;
      }
      saleEmployees.push(row.children[0].textContent);
    }

    return saleEmployees;
  }
//   3. Click Here
//   Define function getAnchorChildren()
//   Find all anchor elements with a <span> child.
//   Print the contents of <span>

function getAnchorChildren() {
    const spanChild = [];

    const anchors = Array.from(document.getElementsByTagName('a'));
    for (const row of anchors) {
        let success = false;
        for (const child of row.children){
            if (child.tagName == 'SPAN'){
                success = true;
            }
        }
        if (success){
        spanChild.push(row);
        }
    }
    return spanChild;
}
// 4. Hobbies
// Define function getSkills()
// Find all checked options in the 'skills' select element.
// Print the value and the contents.

function getSkills(){
    const skillOptions = [];
    //const length = document.getElementById("num2").options.length;
    var skills = "";
    var element = document.getElementsByName("skills")[0];
    console.log(element.options);
    for(var i = 0; i < element.options.length; i++) {
        
        skills = element.options[i].value + " " + element.options[i].textContent + "<br>";
        skillOptions.push(skills);
        //var skills = document.getElementById("num2").options[i].text;
        //skillOptions.push(i);
    }
    return skillOptions;
}
// 5. Custom Attribute
// Define function getCustomAttribute()
// Find all elements with "data-customAttr" attribute
// Print the value of the attribute.
// Print the element that has the attribute.
function getCustomerAttribute() {
    const custAtt = document.getElementsByTagName('*');
    const result = [];
    for(var i = 0; i < custAtt.length; i++) {
        if(custAtt[i].hasAttribute('data-customAttr')) {
            result.push(custAtt[i]);
        }
    }
    return result;
}
function Person(name, age){
    this.name = name;
    this.age = age;
    function getAge1(){
        return this.age;
    }
    this.getAge2 = function(){
        return getAge1();
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

//attach the same function to the onchange event for both of the two num_ inputs,
// and have that update the textContent of the sum span
    