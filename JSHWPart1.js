var homework= {};

homework.fibonacci = function(n){
    var a = 1, b=0, fib;
    while (n >=0){
        fib = a;
        a= a +b;
        b = fib;
        n--;
    }
        return b;
};

homework.sort=function(array) {

};

homework.factorial = function(n){

    if (n==0 || n==1){
        return 1;
    }
        return factorial(n-1)*n;

};

homework.rotateLeft = function(array,n) {
    
};

homework.balancedBrackets = function(bracketsString){

};


