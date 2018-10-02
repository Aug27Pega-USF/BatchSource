// JS HW, part 1: 

// Fill in the functions and submit them to your branch in a file calle
// JSHWPart1.js
// gp
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    if (n > 2) {
        return this.fibonacci(n - 2) + this.fibonacci(n - 1);
    } else {             
        return 1;
    }
};// n = 0 spits out 1, not sure how to fix it without
// breaking the rest of the function

// var fib = function(n){ var x = 0; var y = 1; if(n<=2){ return n-1; } for(var i = 0; i < n; i++){ var tempY = y; y = tempY + x; x = tempY; } return y;
// }alternate version
// var fib = _.memoize(function(n){
//     return n < 2 ? n: fib(n-1) + fib(n-2);
// });//alternate version 2

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
    int n = length;
		for (int i = 0; i < n-1; i++)
			for (int j = 0; j < n-i-1; j++)
				if (arr[j] > arr[j+1]) {
	                    int temp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = temp;
	                }
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    if(n > 1) {
        return n * this.factorial(n - 1);
    }
    else {
        return n * 1;
    }
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    var temp = array[0];
    len = array.length;
    for(i = 0; i < n; i++) {
        
        // The code below is the easiest way to do it, but uses array methods
        // temp = array.shift();
        // array.push(temp);
    }
    return array;
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
    var countp = 0;
    var countbrace = 0;
    var countbrack = 0;
};


//YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)
//(you dont understand matt. I am stackoverflow)
