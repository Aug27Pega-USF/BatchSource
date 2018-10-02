function loadCharacter(character){
    document.getElementById("name").innerHTML=character.name;
    document.getElementById("population").innerHTML=character.population;
    document.getElementById("gravity").innerHTML=character.gravity;
    document.getElementById("climate").innerHTML=character.climate;
    document.getElementById("surface_water").innerHTML=character.surface_water;
    document.getElementById("orbital_period").innerHTML=character.orbital_period;
    document.getElementById("terrain").innerHTML=character.terrain;
    document.getElementById("rotation_period").innerHTML=character.rotation_period;
}
function getCharacter(){
    console.log("in getCharacter");
    var characterId = document.getElementById("swID").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //Step 2 function to handle onreadystatechange of response
    xhr.onreadystatechange = function(){
        console.log("in onreadystatechange");
        //"200" from the http codes
        if(xhr.readyState==4 && xhr.status == 200){
            console.log(xhr.responseText);
            var character= JSON.parse(xhr.responseText);
            //swapi.co -> take url to Postman -> select get and hit send
            loadCharacter(character);
        }
    }
    //Step 3 open the request/conenction
    xhr.open("GET", "https://swapi.co/api/planets/" + characterId, true);
    //xhr.open("GET", "http://gateway.marvel.com/v1/public/comics/" + characterId, true);
    //
    //Step 4 SEND!
    xhr.send(); //we don't send anything cause we're not doing a post request. We're a doing a Get
}
window.onload = function(){
    console.log("in onload");
    document.getElementById("starwarssubmit").addEventListener("click", getCharacter, false);
}