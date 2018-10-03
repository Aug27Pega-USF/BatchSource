/*
1. Retunr the nth fibonacci number
f(0) = 0
f(1) = 1
f(10) = 55
*/

homework.fibonacci = function(n)
{
    var result = 0 
    if(n<=2){
    return n-1;
    }
    result = fib(n-1) + fib(n-2) 
    return result;
};

/*
2. Sort array of integers
f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

Don't use the Array sort() method.
*/

homework.sort = function(array)
{
    var swapped;
    do {
        swapped = false;
        for (var i=0; i < array.length-1; i++) {
            if (array[i] > array[i+1]) {
                var temp = a[i];
                array[i] = array[i+1];
                array[i+1] = temp;
                swapped = true;
            }
        }
    } while (swapped);
    return array;
};


/*
3. Return the factorl of n

f(0) = 1
f(1) = 1
f(3) = 6
*/
homework.factorial = function(n)
{
    if (num < 0) 
    return -1;
else if (num == 0) 
  return 1;
else 
  return (num * factorial(num - 1)); 
  
};

//4. Rotate Left
homework.rotateLeft = function(array, n)
{
    var z = array.length;
    return array.slice(n- z).concat(array.slice(0, n-z);
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
()
(()
([)]

Return true if balanced
Return false if not balanced
*/

/*
did refernce some code online becuase I couldnt recall the stack info*/

homework.balancedBrackets = function(bracketsString)
{
    if (bracketsString.length <= 1)
    return false

  let matchingOpeningBracket, z
  let stack = []

  let openingBrackets = ['[', '{', '(']
  let closingBrackets = [']', '}', ')']

  for (let i = 0; i < bracketsString.length; i++) {
    z = bracketsString[i]

    if (closingBrackets.indexOf(z) > -1) {
      matchingOpeningBracket = openingBrackets[closingBrackets.indexOf(z)]
      if (stack.length == 0 || (stack.pop() != matchingOpeningBracket)) {
        return false
      }
    } else {
      stack.push(z)
    }
  }

  return (stack.length == 0)
};
