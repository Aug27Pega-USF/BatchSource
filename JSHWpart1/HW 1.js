
var homework = {};

/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){

    var a = 1, b = 0, temp;

    while (n >= 0){
      temp = a;
      a = a + b;
      b = temp;
      n--;
    }
  
    return b;
  }


/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function(array) {
  var len = arr.length;
  for (var i = len-1; i>=0; i--){
    for(var j = 1; j<=i; j++){
      if(arr[j-1]>arr[j]){
          var temp = arr[j-1];
          arr[j-1] = arr[j];
          arr[j] = temp;
          bubbleSort([2,4,5,1,3,1]);
       }
    }
  }
  return arr;
}

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function factorial(n){

  if (n < 0) 
  return -1;
else if (n == 0) 
return 1;
else {
  return (n * factorial(n - 1));

};

}


/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
  if(isNaN(n) || n < 0) { 
  }
  if(arr.length == 0) { 
  }
  for (var i = 0; i < n; i++) {
      for (var j = array.length - 1; j > 0; j--) {
          var temp = array[j];
          array[j] = array[j - 1];
          array[j - 1] = temp;
      }
  }
console.log(array);
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

};



