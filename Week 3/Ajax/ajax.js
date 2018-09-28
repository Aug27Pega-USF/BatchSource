function loadCharacter(character){
    document.getElementById("name").innerHTML=character.name;
}

function getCharacter(){
    console.log("in getCharacter");
    var characterId =  document.getElementById("swID").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //step 2 function to handle onreadystatechange of response
    xhr.onreadystatechange= function (){
        console.log("roll tide");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var character= JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
    }
    //Step 3 open the request/connection
    xhr.open("GET","https://swapi.co/api/people/"+characterId, true);
    //Step 4- SEND!
    xhr.send();
}

window.onload=function(){
    console.log("in onload");
    document.getElementById("starwarssubmit").addEventListener("click",getCharacter,false);
}