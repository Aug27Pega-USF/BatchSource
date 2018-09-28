//JavaScript is NOT related to Java
//not compiled- interpreted
//Loosely typed- variable types are assigned at runtime
var a=10;
//console.log(a);
a="chaos";
//console.log(a);
var b,c,d,e,f,g,h,e;
b= "10";
c=true;
d= {};
e=null;
g=(0/0);
h=[];
i= function (){};
//Booleans-True&False|Truthy &Falsy
//Truthy- True, everything that isnt
//falsy,Can be an object

//Falsy- 0, Undefined,Null,False."",
//NaN

//Type Coercion
//== performs type coercion
//=== does not perform type coercion

// console.log("5==5");
// console.log(5==5);
// console.log(5===5);
// console.log(5=="5");
// console.log(5==="5");
// console.log("tests:");
// console.log("false==1");
// console.log(false==1);
// console.log(false==0);
// console.log(false===0);
// console.log(true==1);
// console.log(true===1);
// console.log(true==0);
// console.log("Tricky:");
// console.log(false==-100000);
// console.log(true==1000000);
// console.log(5!="5");
// console.log(5!=="5");
//Object

//Object literal
var person= {
    "name":"fred",
    "age":93
};
person.gender= "undefined";
//Constructor
function Person(name,age){
    this.name=name;
    this.age=age;
}

var bill= new Person("bill",42);

//Marker Functions
function MakePerson (name,age,gender){
    var p={};
    p.name=name;
    p.age=age;
    p.gender=gender;
    return p;
}
//Another Marker example
function MakePerson2(name,age){
    var p={
        "name":name,
        "age":age
    }
    return p;
}

//Arrays
var arr=[10,20,30];
arr[9]=5;
arr[1500]="bananas";

var divideByZero= function(kitty,cat){
    console.log("hey kitty kitty");
    return (kitty + cat);
}
divideByZero = function(at, least, three){
    console.log(at);
    console.log(least);
    console.log(three);
    console.log(arguments[3]);
    console.log(arguments[4]);
    console.log(arguments[5]);
    console.log(arguments[6]);
    console.log(arguments[7]);
    console.log(arguments[8]);
    if(typeof(at)=='string'){
        console.log("Your first param is a string")
    }else{
        console.log("it is not a string")
    } if(three){
        console.log("three param function");
    }else{
        console.log("hey kitty kitty");
    }
    return (at+least+three)/0;
}

//Closure- an inner function that has access to the outer function's variable(scope chain)
//has 3 scope chains:
//1. it has access to its own scope( variables defined between its curly braces)
//2. it has acess the outer function's varibles
//3. it has access to the global variables
// closure mimics encapsulation

//want to build a reusable counter. want the count variable to be accessible
// to other objects
// var count=0;
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
//     function plus(){
//         count +=1;
//     }
//     plus();
//     return count;
// }

var add = function(){
    var count=0;
    return function(){
        count+=1;
        return count;
    }
}();