//JavaScript is not related to Java
// not compiled- interperted 
//Loosely typed- variable type are assigned at runtime 
var a=10;
console.log(a);
a="chaos";
console.log(a);
var b, c, d, e, f, g, h, e;
b="10";
c=true;
d={};
e=null;
g=(0/0);
h=[];
i= function(){};

//Boolean- true&false|truthy&falsy
//Truthy- True,everything that isn't 
//falsy, can be an object

//Falsy-0, undefined,Null,False."",
//NaN

//Type Coercion
//== performs type coercion
//=== does not perform type coercion

// console.log("5==5");
// console.log(5==5);
// console.log(5===5);
// console.log(5=='5');
// console.log(5==='5');
// console.log("test:");
// console.log("false==1");
// console.log(false==1);
// console.log(false==0);
// console.log(false===0);
// console.log(true==1);
// console.log(true===1);
// console.log(true==0);
// console.log("Tricky:");
// console.log(false==-10000000);
// console.log(true==100000000);
// console.log(5!="5");
// console.log(5!=='5');

//Object 
//value pairs

//Object Literal
var person={
    "name":"fred",
    "age":93,   
};
person.gender= "undefined";

//Constructor
function Person(name, age)
{
    this.name= name;
    this.age= age;
}

var bill= new Person("bill",42);
//Marker Functions
function MakePerson(name,age){
    var p={};
    p.name= name;
    p.age=age;
    p.gender=gender;
    return p;
}

//Antoher Marker Example
function MakePerson2(name, age){
    var p={
        "name":name,
        "age":age
    }
    return p;
}
//Arrays
var arr= [10,20,30];
arr[9]=5;
arr[1500]="bannas";

var dividebyZero= function(kitty, cat)
{
    console.log("hey kitty kitty");
    return(kitty +cat)/0;
}
//Replace here

//Closure- an inner function that has access to outher function's variable(scope chain)
//has 3 scope chains: 
//1. it has access to its own scope(variables defined between its curly braces)
//2. it has access the outer function's variables
//3. it has access to global variables 
//closure mimics encapsulation

//want to build a reusable counter. want the count variable to be accessible 
//to other objects
// var count= 0;
// function add(){
//     return count++;
// }
// function add(){
//     var count=0;
//     count++;
//     return count;
// }

// function add(){
//     var count=0;
//     function plus()
//     {
//         count +=1;
//     }
//     return count;
// }

var add= (function(){
    var count=0;
    return function(){
        count+=1; 
        return count;
    }
}())