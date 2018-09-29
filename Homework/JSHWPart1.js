var homework = {};
/*
 1. Return the nth fibonacci number

 f(0) = 0
 f(1) = 1
 f(10) = 55
*/
homework.fibonacci = function(n){
    var current=0;
    var next = 1;
    for (i=0; i<n;i++){
        temp=current+next;
        current=next;
        next=temp;
    }
    return current;
};
/*
 2. Sort array of integers

 f([2,4,5,1,3,1]) = [1,1,2,3,4,5]

 Don't use the Array sort() method... that would be lame.
*/
homework.sort = function mergeSort(array) {
    if(array.length === 1){
        return array;
    }
    const middle = Math.floor(array.length / 2);
    const left = array.slice(0,middle);
    const right = array.slice(middle);
    return merge( mergeSort(left), mergeSort(right)
    );

    function merge(left,right){
        let result=[];
        let indexLeft=0;
        let indexRight=0;
        while(indexLeft < left.length && indexRight < right.length){
            if(left[indexLeft]<right[indexRight]){
                result.push(left[indexLeft]);
                indexLeft++;
            }else{
                result.push(right[indexRight]);
                indexRight++;
            }
        }
        return result.concat(left.slice(indexLeft)).concat(right.slice(indexRight));
    }
};
/*
 3. Return the factorial of n

 f(0) = 1
 f(1) = 1
 f(3) = 6
*/
homework.factorial = function(n){
    var current=1;
    for (i=1; i<n;i++){
        current=current*(i+1);
    }
    return current;
};
/*
 4. Rotate left

 Given array, rotate left n times and return array

 f([1,2,3,4,5], 1) = [2,3,4,5,1]
 f([1,2,3,4,5], 6) = [2,3,4,5,1]
 f([1,2,3,4,5], 3) = [4,5,1,2,3]

*/
homework.rotateLeft = function(array, n) {
    let rotate=(n % array.length);
    let left= array.slice(0,rotate);
    let right=array.slice(rotate);
    return right.concat(left);
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
homework.balancedBrackets = function (bracketsString){
    let boolcheck=false;
    function recursivebalance(bracketsString){
    for(i=0;i<bracketsString.length-1;i++){
        var temp=bracketsString[i];
        var temp2=bracketsString[i+1];
        if (temp=="(" && temp2 == ")"){
            bracketsString=recursivebalance(bracketsString.slice(0,i).concat(bracketsString.slice(i+2)));
            break;
        }
        if (temp=="{" && temp2 == "}"){
            bracketsString=recursivebalance(bracketsString.slice(0,i).concat(bracketsString.slice(i+2)));
            break;
        }
        if (temp=="[" && temp2 == "]"){
            bracketsString=recursivebalance(bracketsString.slice(0,i).concat(bracketsString.slice(i+2)));
            break;
        }
    }
    return bracketsString;
    }
    if (recursivebalance(bracketsString)==""){
        return true;
    }
    return false;
};

