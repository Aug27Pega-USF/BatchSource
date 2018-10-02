// JS HW, part 1: 

// Fill in the functions and submit them to your branch in a file called JSHWPart1.js
//gp
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    var value = [1, 1];

	for (var i = 2; i < n; i++) {
		value[i] = value[i-1]+ value[i-2];
	}

	return value[n-1];
};

/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {

    var l = array.length;
		for(var i =0; i < l-1; i++) {
			for(var j =0;j < l-i-1;j++) {
				if(array[j] > array[j+1]) {
					var temp = array[j];
					array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
};

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    var i,f=1;  
		  var num=n;   
		  for(i=1;i<=num;i++){    
		      f=f*i;    
          } 
          return f;
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    var l = array.length;
    var j = array.length-1;
		for(var i =0; i < n; i++) {
			{
                    var temp = array[0];
                    for(x =0;x<l-1;x++){
                        array[x] = array[x+1];
                    }
                    j=array.length-1;
                    array[j]=temp;
            }
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
    for(x=0;x<bracketsString.length;x++){
        
    }
};


// YOUR SOLUTIONS, NOT STACKOVERFLOW’S  ;)
//(you dont understand matt. I am stackoverflow)
