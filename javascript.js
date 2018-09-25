//Javascript is NOT related to Java
//Not compiled but rather interpreted
//Loosely Typed - Variable Types are assigned at runtime
//object value pairs
var a=10;
console.log(a);
a="chaos";
console.log(a);
var b,c,d,e,f,g,h,e;
b="10";
c=true;
d= {};
e= null;
g=(0/0);
h=[];
i= function(){};
//Booleans - True and False | Turthy and Falsy
//Truthy - True, everything that isnt falsy
//falsy, Can be an object as well
//Falsy- 0, undefined, Null, false, "", NaN
//Type Coercion
//== performs type coersion
//=== does not perform coercion
console.log("5==5");
console.log(5==5);
console.log(5===5);
console.log(5=="5");

var person= {
    "name":"fred",
    "age":"93"
};

person.gender= "undefined";
//Constructor
function Person(name,age) {
    this.name=name;
    this.age=age;
}
var bill = new Person("bill", 42);

//Marker Functions
function MakePerson (name,age,gender) {
    var p={};
    p.name = name;
    p.age = age;
    p.gender = gender;
}
//Another Marker example
function MakePerson2 (name,age) {
    var p={
        "name":name,
        "age":age
    }
    return p;
}

//Arrays
var arr = [10,20,30];
arr[9]=5;

var dividByZero = function(kitty, cat) {
    console.log("hey kitty kitty");
    return (kitty + cat) / 0;
}
//CLOSURE - Building a resuable counter visible to other obj
// var count = 0;
// function add(){
//     return count++;
// }
// function add() {
//     var count = 0;
//     function plus() {
//         count += 1;
//     }
//     return count;
//
var add = function() {
    var count = 0;
    return function () {
        count += 1;
        return count;
    }
}();