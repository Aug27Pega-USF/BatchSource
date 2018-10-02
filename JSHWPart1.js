var homework = {};
homework.fibonacci = function (n) {
    if (n <= 1) {
        return n;
    } else {
        return this.fibonacci(n - 1) + this.fibonacci(n - 2);
    }
};

console.log(homework.fibonacci(21));
/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function (array) {
    var len = array.length;
    for (var i = 0; i < len; i++) {
        for (var j = 0; j < len - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                var temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
};

var a = [3, 4, 7, 1, 3, 7, 9, 2];
homework.sort(a);
for (var i = 0; i < a.length; i++) {
    console.log(a[i]);
}
/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function (n) {
    var i = 1;
    var p = 1;
    for (i = 1; i <= n; i++) {
        p = p * i;
    }
    return p;
};

console.log(homework.factorial(1));
console.log(homework.factorial(3));
console.log(homework.factorial(5));
console.log(homework.factorial(7));
/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function (array, n) {
    for (var i = n; i > 0; i--) {
        array.push(array.shift());
    }
};
var b = [1, 2, 3, 4, 5];
homework.rotateLeft(b, 2);
for (var i = 0; i < a.length; i++) {
    console.log(b[i]);
}
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
homework.balancedBrackets = function (bracketsString) {
    if (bracketsString.length <= 1) {
        return false;
    }
    var open, c;
    var st = [];
    var openBrackets = ['[', '{', '('];
    var closedBrackets = [']', '}', ')'];

    for (var i = 0; i < bracketsString.length; i++) {
        c = bracketsString[i];

        if (closedBrackets.indexOf(c) > -1) {
            open = openBrackets[closedBrackets.indexOf(c)];
            if (st.length == 0 || (st.pop() != open)) {
                return false;
            }
        } else {
            st.push(c)
        }
    }
    return (st.length == 0)
};

console.log(homework.balancedBrackets("()"));
console.log(homework.balancedBrackets("{()}"));
console.log(homework.balancedBrackets("[{()}]"));
console.log(homework.balancedBrackets("()}"));