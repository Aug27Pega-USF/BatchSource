/*
1. USA
Define function getUSA()
Find the html element that contains "USA".
Print that element's contents.
*/

function USA()
{
    var seartext = "USA";

    var tagval = document.body.getElementsByTagName("*");

     for (var i = 0; i < tagval.length; i++) 
     {

        var n1 = tagval[i].textContent.search(seartext);
     }

        if(n1 != -1)
           return(tagval[i].textContent);

};

/*
2. Sales
Define function getPeopleInSales()
Print the names of all the people in the sales department.
*/

function getPeopleInSales()
{
        var table1 = document.getElementsByTagName("table")[0];
            for (var i = 0; i <table1.rows.length;i++){
            var cells1 = table1.rows[i].cells1;
         if(cells1[1].textContent === "Sales"){
           return(cells1[0].textContent);
};

/* 
3. Click Here
Define function getAnchorChildren()
Find all anchor elements with a <span> child.
Print the contents of <span>
*/

var getAnchorChildern = function()
{
  
};

/*
4. Hobbies
Define function getSkills()
Find all checked options in the 'skills' select element.
Print the value and the contents.
*/

var getSkills = function()
{

  
};
