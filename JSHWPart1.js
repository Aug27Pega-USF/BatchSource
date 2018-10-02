
function fib (n){
    if (n == 0) return 0;
    if (n == 1) return 1;

    return fib(n - 1) + fib(n - 2);
};
//console.log(fib(0));
//console.log(fib(1));
//console.log(fib(55));

mySort = function(array) {
    var done = false;
    while (!done) { 
      done = true;
      for (var i = 1; i < array.length; i += 1) {
        if (array[i - 1] > array[i]) {
          done = false;
          var tmp = array[i - 1];
          array[i - 1] = array[i];
          array[i] = tmp;
        }
      }
    }
    return array;
};
console.log(mySort([2,4,5,1,3,1]));

factorial = function(n){
    if (n==0) return 1;
    else return (n*factorial(n-1));
};

rotateLeft = function(array, n) {
    var L = array.length;
    return array.slice(L - n).concat(array.slice(0, L - n));
};

balancedBrackets = function(bracketsString){
    var result = 'YES';
    var stack = [];
    var array = bracketsString.split('');
    print(array);
    bracketsString.split('').forEach(function(val) {
        switch(val) {
            case '{':
                stack.push('}');
                break;
            case '[':
                stack.push(']');
                break;
            case '(':
                stack.push(')');
                break;
            default:
                var test = stack.pop();
                if (val !== test) {
                    result = 'NO';
                }    
        }
    })
    if (stack.length) {
        result = 'NO';
    }
    return result;
};
