//1: Fibonacci
var homework = {
    fibonacci : function(start, nextNum, seq) {
        if(seq == 0) {
            return start;
        }
        return homework.fibonacci(nextNum, start + nextNum, seq - 1);
    },

    sort : function(arrayList){
        var arrayLength = arrayList.length;
        for(var x = 0; x < arrayLength; x++) {
            for(var y = 0; y < arrayLength - x - 1; y++) {
                if(arrayList[y] > arrayList[y+1]){
                    var tmp = arrayList[y];
                    arrayList[y] = arrayList[y+1];
                    arrayList[y+1] = tmp;
                } 
            }  
        }
        return arrayList;
    },

    factorial : function(x) {
        if(x == 0 || x == 1)
            return 1;
        else
            return x * this.factorial(x-1);
    },

    rotateLeft : function(array, n) {
        for(var x = 0; x < n; x++){
            var tmp = array.shift();
            array.push(tmp);
        }
        return array;
    },

    balancedBrackets : function(bracketString) {
        var bracketArray = "";
        while(bracketString.length > 0){
            if("({[".indexOf(bracketString[0]) != -1){
                bracketArray += bracketString[0];
            } else if(")}]".indexOf(bracketString[0] != -1)){
                switch(bracketString[0]){
                    case ")":
                        if(bracketArray[bracketArray.length - 1] == "("){
                            bracketArray = bracketArray.slice(0, bracketArray.length - 1);
                        } else {
                            return false;
                        }
                        break;
                    case "}":
                        if(bracketArray[bracketArray.length - 1] == "{"){
                            bracketArray = bracketArray.slice(0, bracketArray.length - 1);
                        } else {
                            return false;
                        }
                        break;
                    case "]":
                        if(bracketArray[bracketArray.length - 1] == "["){
                            bracketArray = bracketArray.slice(0, bracketArray.length - 1);
                        } else {
                            return false;
                        }
                        break;
                    default:
                        return false;
                }
            }
            bracketString = bracketString.slice(1);
        }
        return true;
    }
}

console.log(homework.fibonacci (0, 1, prompt("Enter a number for the fibonacci sequence")));
//console.log(homework.sort ([2,4,5,1,3,1]));
//console.log(homework.factorial (prompt("Enter a factorial number")));
//console.log(homework.rotateLeft ([1,2,3,4,5], prompt("Enter how many times to rotate left")))
//console.log(homework.balancedBrackets ("()({}[][{}]{(())})"))