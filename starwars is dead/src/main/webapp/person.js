var planet;
var movieList=[];
function hasClass(elem, className) {
    return elem.classList.contains(className);
}
function loadCharacter(character){
    document.getElementById("name").innerHTML="Name: "+character.name;
    document.getElementById("height").innerHTML="Height: " + character.height;
    document.getElementById("mass").innerHTML="Mass: "+character.mass;
    document.getElementById("hair_color").innerHTML="Hair Color: "+character.hair_color;
    document.getElementById("skin_color").innerHTML="Skin Color: "+character.skin_color;
    document.getElementById("eye_color").innerHTML="Eye Color: "+character.eye_color;
    document.getElementById("birth_year").innerHTML="Birth Year: "+character.birth_year;
    document.getElementById("gender").innerHTML="Gender: "+character.gender;
    getHomeworld(character.homeworld);
    document.getElementById("films").innerHTML="<b>Film List:</b>"+ "<ul>";
    for(i=0; i<character.films.length; i++){
        getMovie(character.films[i],i);
    }
    document.getElementById("films").innerHTML+="</ul>";
    
    document.addEventListener('click', function (e) {
        for (i=0;i<movieList.length;i++){
        if (hasClass(e.target, 'movie'+i)) {
            MovieInfo(i);
        } 
    }}, false);
}

function loadPlanet(planet){
    document.getElementById("homeworld").innerHTML="Homeworld: " + planet.name;
}

function loadMovie(movie,id){
    document.getElementById("films").innerHTML += "<li class=\"movie"+id+"\">" + movie.title +"</li>";
    movieList[id]=movie;
}

function getCharacter(){
    document.getElementById("Film Info").innerHTML="";
    document.getElementById("episode_id").innerHTML="";
    document.getElementById("director").innerHTML="";
    document.getElementById("producer").innerHTML="";
    document.getElementById("release_date").innerHTML="";
    document.getElementById("Planet Info").innerHTML="";
    document.getElementById("climate").innerHTML="";
    document.getElementById("gravity").innerHTML="";
    document.getElementById("terrain").innerHTML="";
    console.log("in getCharacter");
    var characterId = document.getElementById("swID").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //step 2 function to handle on readystatechange of response
    xhr.onreadystatechange=function(){
        console.log("roll tide");
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var character=JSON.parse(xhr.responseText);
            loadCharacter(character);
        }
    }
    //Step 3 open the request/connection
    xhr.open("GET","https://swapi.co/api/people/"+characterId,true);
    //step4-send!
    xhr.send();
}

function getHomeworld(planetstring){
    //Step 1
    var xhr = new XMLHttpRequest();
    //step 2 function to handle on readystatechange of response
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            planet=JSON.parse(xhr.responseText);
            loadPlanet(planet)
        }
    }
    //Step 3 open the request/connection
    xhr.open("GET",planetstring,true);
    //step4-send!
    xhr.send();
}

function getMovie(moviestring,id){
    //Step 1
    var xhr = new XMLHttpRequest();
    //step 2 function to handle on readystatechange of response
    xhr.onreadystatechange=function(){
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var movie=JSON.parse(xhr.responseText);
            loadMovie(movie,id)
        }
    }
    //Step 3 open the request/connection
    xhr.open("GET",moviestring,true);
    //step4-send!
    xhr.send();
}

function PlanetInfo(){
    document.getElementById("Planet Info").innerHTML="Planet Info";
    document.getElementById("climate").innerHTML="Climate: "+planet.climate;
    document.getElementById("gravity").innerHTML="Gravity: "+planet.gravity;
    document.getElementById("terrain").innerHTML="Terrain: "+planet.terrain;
}

var MovieInfo= function(i){
    document.getElementById("Film Info").innerHTML="Film Info";
    document.getElementById("episode_id").innerHTML="Episode #: "+movieList[i].episode_id;
    document.getElementById("director").innerHTML="Director(s): "+movieList[i].director;
    document.getElementById("producer").innerHTML="Producer(s): "+movieList[i].producer;
    document.getElementById("release_date").innerHTML="Release Date: "+movieList[i].release_date;
}

window.onload=function(){
    console.log("in onload");
    document.getElementById("starwarssubmit").addEventListener("click",getCharacter,false);
    document.getElementById("homeworld").addEventListener("click",PlanetInfo,false);
}