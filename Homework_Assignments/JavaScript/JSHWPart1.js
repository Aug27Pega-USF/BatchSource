var homework = {}; 
 
/*  1. Return the nth fibonacci number 
 
 f(0) = 0  f(1) = 1  f(10) = 55 */ 
 
 homework.fibonacci = function(n){ 
    if (n == 0 || n == 1) 
        return n;
    else 
        return homework.fibonacci(n-1) + homework.fibonacci(n-2);
}; 
 
/*  2. Sort array of integers 
 
 f([2,4,5,1,3,1]) = [1,1,2,3,4,5] 
 
 Don't use the Array sort() method... that would be lame. */ 
 
 homework.sort = function(array) { 
     
    var arraySize = array.length;

		while(arraySize > 0) {
			for(var i = 0; i < arraySize-1; i++) {
				//if the left element is lower than the right
				if(array[i] > array[i+1]) {
					//swap them
					var temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
				}
			}
			//ignore last element by removing how many are left to check
			arraySize--;
        }
        
    return array;
}; 
 
/*  3. Return the factorial of n 
 
 f(0) = 1  f(1) = 1  f(3) = 6 */ 
 
 homework.factorial = function(n){ 
    //at the end, return the result
    if (n == 1) 
        return n;
    //recursive function to keep multiplying it
    else
        return homework.factorial(n-1) * n;
}; 
 
/*  4. Rotate left 
 
 Given array, rotate left n times and return array 

  f([1,2,3,4,5], 1) = [2,3,4,5,1]  f([1,2,3,4,5], 6) = [2,3,4,5,1]  f([1,2,3,4,5], 3) = [4,5,1,2,3] 
    homework.rotateLeft([1,2,3,4,5], 1)
    homework.rotateLeft([1,2,3,4,5], 6)
    homework.rotateLeft([1,2,3,4,5], 3)
*/ 

homework.rotateLeft = function(array, n) { 
    var arraySize = array.length;

    while(n > 0) {
        //for storing the first variable
        var temp = 0;
        
        for(var i = 0; i < arraySize-1; i++) {
            //store the first variable
            if(i == 0)
                temp = array[i];

            //swap numbers left-wise
            array[i] = array[i+1];
        }
        //swap the last with the first
        array[arraySize-1] = temp;
        //decrement total swaps
        n--;
    }
        
    return array;
}; 
 
/*  5. Balanced Brackets 
 
 A bracket is any one of the following: (, ), {, }, [, or ] 
 
 The following are balanced brackets:     ()     ()()     (())     ({[]}) 
                                        1   0     1 0 1 0      1 2 1 0   1 2 3 2 1 0
 The following are NOT balanced brackets:  (  )  (()  ([)] 

 homework.balancedBrackets("()     ()()     (())     ({[]})")
 homework.balancedBrackets("(  )  (()  ([)]")
 homework.balancedBrackets("( ( (  ))")
 Return true if balanced  Return false if not balanced */ 
 
 homework.balancedBrackets = function(bracketsString){ 
    
    var bracket_check = []; //used as a stack

    //what I would do is iterate through a string
    for(var i = 0; i < bracketsString.length; i++){

        //encounter an open bracket, add it to our stack
        if(bracketsString.charAt(i) == "(" || bracketsString.charAt(i) == "[" || bracketsString.charAt(i) == "{")
            bracket_check.push(bracketsString.charAt(i));

        //closed bracket
        else if(bracketsString.charAt(i) == ")" || bracketsString.charAt(i) == "]" || bracketsString.charAt(i) == "}"){
            //get the like type to compare
            var check_bracket = "";
            switch(bracketsString.charAt(i)){
                case ")":
                check_bracket = "(";
                    break;
                case "]":
                check_bracket = "[";
                    break;
                case "}":
                check_bracket = "{";
                    break;
            }

            //if it matches the last like type, pop it off and continue
            if (bracket_check[bracket_check.length-1] == check_bracket)
                bracket_check.pop();
            //uh oh unbalanced
            else
                return false;
        }
            
    }

    //make sure we have no open brackets left
    if(bracket_check.length > 0)
        return false;
    else
        return true;
};