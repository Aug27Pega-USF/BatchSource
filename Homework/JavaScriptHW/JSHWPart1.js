       /*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fib = function(n){
var fib = _.memoize(function(n){ return n < 2 ? n: fib(n-1) + fib(n-2);
    //console.log()
});


/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
function Sort(array) {
  var finished = false;
  while (!finished) {
    finished = true;
    for (var i = 1; i < array.length; i += 1) {
      if (array[i - 1] > array[i]) {
        finished = false;
        var total = array[i - 1];
        array[i - 1] = array[i];
        array[i] = total;
      }
    }
  }

  return array;
}

var numbers = [2, 4, 5, 1, 3, 1];
Sort(numbers);
console.log(numbers);

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    var inputNumber = prompt("Pleasse enter in a number");
    var toatl = 1;
    for(i=0; i< inputNumber; i++){
        total = total * (inputNumber - i);
    }
    console.log(inputNumber + "! = "+total);
};

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.p.rotateLeft = function(array, n) {
    var unshift = Array.p.unshift,
        splice = Array.p.splice;

    return function(count) {
        var len = this.length >>> 0,
            count = count >> 0;

        unshift.apply(this, splice.call(this, count % len, len));
        return this;
    };
}();

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
    if (str.length<=1)
        return false
        let matchBracket, ch
  let bracket = []

  let openBrackets = ['[', '{', '(']
  let closeBrackets = [']', '}', ')']

  for (let i = 0; i < str.length; i++) {
    ch = str[i]

    if (closingBrackets.indexOf(ch) > -1) {
      matchingBracket = openBrackets[closeBrackets.indexOf(ch)]
      if (bracket.length == 0 || (bracket.pop() != matchBracket)) {
        return false
      }
    } else {
        bracket.push(ch)
    }
  }

  return (bracket.length == 0)
};
    
//     (c == '{') s.push('}');
//     else if (c == '[') s.push(']');
//     else if (c == '(') s.push(')');
//     else {
//       if (s.empty() || c != s.top())
//         return false;
//       s.pop();
//     }
//   }
//   return s.empty();
// }
// };
