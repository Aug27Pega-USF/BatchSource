var homework = {};
/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    var a = 1, b = 0, temp;

    while (num >= 0){
      temp = a;
      a = a + b;
      b = temp;
      num--;
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
         }
      }
    }
    return arr;
 }
 bubbleSort([2,4,5,1,3,1]);

/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    if (num === 0 || num === 1)
    return 1;
  for (var i = num - 1; i >= 1; i--) {
    num *= i;
  }
  return num;
}
factorialize(6);

/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    var arr = [1, 2, 3, 4, 5];
    var expected = [2, 3, 4, 5, 1];
    rotate(arr, 1);
    assertArrayEquals(expected, arr);
};

homework.rotateLeft = function(array, n) {
        var arr = [1, 2, 3, 4, 5];
        var expected = [2, 3, 4, 5, 1];
        rotate(arr, 6);
        assertArrayEquals(expected, arr);
}
homework.rotateLeft = function(array, n) {
    var arr = [1, 2, 3, 4, 5];
    var expected = [4, 5, 1, 2, 3];
    rotate(arr, 3);
    assertArrayEquals(expected, arr);
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
    def is_matched(expression):
    mapping = dict(zip('({[', ')}]'))
    queue = []
    for letter in expression:
        if letter in mapping:
            queue.append(mapping[letter])
        elif not (queue and letter == queue.pop()):
            return False
    return not queue
};