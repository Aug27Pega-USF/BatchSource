
var homework = {

     fibonacci = function (n) {
        // f(n) = f(n-1)+f(n-2)
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2)
        }
    },

    sort = function (array) {
        //sort an array without using sort methods
        var len = array.length;
        var temp;
        for (var i = 0; i < len; i++) {
            for (var j = 0; j < len; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;

    },

       factorial = function(n){
        if(n == 1 || n == 0){
            return 1;
        }else {
            return n * (n-1) * factorial(n-2);
        }
    },
    
    /* // given an array, rotate left n times and return array
    //f([1,2,3,4,5]), rotate left 1 times return [2,3,4,,5,1]
    //f([1,2,3,4,5]), rotate left 6 times return [2,3,4,5,1]
    //f([1,2,3,4,5]), rotate left 3 times return [4,5,1,2,3]
    rotateLeft = function (array, n) {

    } */


balancedBrackets = function(bracketString){

    if(bracketString.length <= 1){
        return false;
    }

    let matchingBracket, ch;
    let stack = [];

    let opens = ['[', '{', '('];
    let closes = [']', '}', ')'];

    for(let i = 0; i < bracketString.length; i++){
        ch = bracketString[i];
    }
    if(closes.indexOf(ch) > -1){
        matchingBracket = opens[closes.indexOf[ch]]
        if(stack.length == 0 || (stack.pop() != matchingBracket)){
            return false;
        }
    }else{
        stack.push(ch);
    }
    return (stack.length == 0);
}
}




