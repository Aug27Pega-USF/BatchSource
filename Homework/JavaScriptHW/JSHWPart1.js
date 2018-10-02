//JS HW, part 1: 

//Fill in the functions and submit them to your branch in a file called JSHWPart1.js
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
/*Recursively find number at nth place in fib sequence*/
homework.fibonacci = function(n){
  if(n==0){
      return 0;
  } 
  if(n==1){
      return 1;
  }
  return this.fibonacci(n-1) + this.fibonacci(n-2);
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
//var arr = [3,4,1,6,2,7,9,8,10,5];

/*Pass array from console, does bubble sort and returns*/
homework.sort = function(array) {
     i = array.length;
     var temp=0;
    for( x=0;x<i;x++) {
      for( j=1;j<=(i-1);j++) {
        //swap element 
        if(array[j-1] > array[j]) {
          temp = array[j-1];
          array[j-1] = array[j];
          array[j]=temp;
        }
      }			
    }
    return array;
};

console.log()

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/

homework.factorial = function(n){
     var result=1;
    for( var factor=1;factor <= n; factor++) {
      result *= factor;
    }
    return result;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(arr, n) {
    var z = arr.length;
    return arr.slice(n-z).concat(arr.slice(0,n-z));
};

/*
 5. Balanced Brackets

 A bracket is any one of the following: (, ), {, }, [, or ]

 The following are balanced brackets:
    ()
    ()()
    (())
    ({[]})

 The following are NOT balanced brackets:
 (
 )
 (()
 ([)]

 Return true if balanced
 Return false if not balanced
*/

homework.balancedBrackets = function(bracketsString){

    if (bracketsString.length <= 1)
    return false

  let matchingOpeningBracket, ch
  let stack = []

  //open bracket possibilites
   openingBrackets = ['[', '{', '(']
  //closed bracket possibilites
   closingBrackets = [']', '}', ')']

   //scan string (array) left to right
  for (let i = 0; i < bracketsString.length; i++) {
    ch = bracketsString[i]

    //If element is a closing bracket — see if it matches last item in stack. If it does, pop off that last item & move onto the next element.
    //If element is an opening bracket — push onto stack
    if (closingBrackets.indexOf(ch) > -1) {
      matchingOpeningBracket = openingBrackets[closingBrackets.indexOf(ch)]
      if (stack.length == 0 || (stack.pop() != matchingOpeningBracket)) {
        return false
      }
    } else {
      stack.push(ch)
    }
  }
  //If at the end of the function the stack is empty return true!
  return (stack.length == 0)
};
