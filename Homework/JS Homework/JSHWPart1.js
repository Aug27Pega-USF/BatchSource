var homework={};
/*
1. Return the nth fibonacci number

f(0)=0
f(1)=1
f(10)=55
*/
homework.fibonacci = function(n){
    if ( n === 0) return 0;
    else if (n===1) return 1;
    else return fibonacci(n - 1) + fibonacci(n - 2);
};
/*
2.Sirt array of integers
f([2,4,5,1,3,1])=[1,1,2,3,4,5]
Don't use the Array sort()method... that would be lame.
*/
//homework.sort()
/*
3. Return the factorial of n
f(0)=1
f(1)=1
f(3)=6
*/
homework.factorial=function(n){
    var f=1;
    for (i=1;i<(n+1);i++) {
        f*=i;
    }
    return f;
};
/*
4. Rotate left
Given array, rotate left n times and return array.
f([1,2,3,4,5],1)=[2,3,4,5,1]
f([1,2,3,4,5],6)=[2,3,4,5,1]
f([1,2,3,4,5],3)=[4,5,1,2,3]
*/
homework.rotateLeft=function(array,n){
    for (var i = 0; i<n; i++) {
        var temp = array[0];
        for (j = 1; j<array.length; j++) {
            array[j-1] = array[j];
        }
        array[array.length-1] = temp;
      }
    return array;
};
/*
5.Balanced Brackets
A bracket is any one of the following:(,),{,},[,or]
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
homework.balancedBrackets=function(bracketsString){
    for (var i=0;i<bracketsString.length;i++) {
        if (bracketsString.charAt(i)==='('||bracketsString.charAt(i)==='['||bracketsString.charAt(i)==='{'){
            stack.push(bracketsString.charAt(i));
        }else if(bracketsString.charAt(i)===')'||bracketsString.charAt(i)===']'||bracketsString.charAt(i)==='}'){
            var leftBracket=stack.pop();
            if (!((leftBracket==='('&&bracketString.charAt(i)===')')||
                (leftBracket==='('&&bracketString.charAt(i)===')')||
                (leftBracket==='('&&bracketString.charAt(i)===')'))){
                return false;
                }
        }
    }
    if (stack.length!==0) return false;

    return true;
};

