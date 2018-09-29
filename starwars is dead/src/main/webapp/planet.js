var planet;
var movieList=[];
function hasClass(elem, className) {
    return elem.classList.contains(className);
}
function loadPlanet(planet){
    document.getElementById("name").innerHTML="Name: "+planet.name;
    document.getElementById("rotation_period").innerHTML="Rotation Period: " + planet.rotation_period;
    document.getElementById("orbital_period").innerHTML="Orbital Period: "+planet.orbital_period;
    document.getElementById("diameter").innerHTML="Diameter: "+planet.diameter;
    document.getElementById("climate").innerHTML="Climate: "+planet.climate;
    document.getElementById("gravity").innerHTML="Gravity: "+planet.gravity;
    document.getElementById("terrain").innerHTML="Terrain: "+planet.terrain;
    document.getElementById("surface_water").innerHTML="Surface Water: "+planet.surface_water;
    document.getElementById("population").innerHTML="Population: " +planet.population;
    document.getElementById("films").innerHTML="<b>Film List:</b>"+ "<ul>";
    for(i=0; i<planet.films.length; i++){
        getMovie(planet.films[i],i);
    }
    document.getElementById("films").innerHTML+="</ul>";
    
    document.addEventListener('click', function (e) {
        for (i=0;i<movieList.length;i++){
        if (hasClass(e.target, 'movie'+i)) {
            MovieInfo(i);
        } 
    }}, false);
}


function loadMovie(movie,id){
    document.getElementById("films").innerHTML += "<li class=\"movie"+id+"\">" + movie.title +"</li>";
    movieList[id]=movie;
}

function getPlanet(){
    document.getElementById("Film Info").innerHTML="";
    document.getElementById("episode_id").innerHTML="";
    document.getElementById("director").innerHTML="";
    document.getElementById("producer").innerHTML="";
    document.getElementById("release_date").innerHTML="";
    console.log("in getPlanet");
    var planetId = document.getElementById("swID").value;
    //Step 1
    var xhr = new XMLHttpRequest();
    //step 2 function to handle on readystatechange of response
    xhr.onreadystatechange=function(){
        
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var planet=JSON.parse(xhr.responseText);
            loadPlanet(planet);
        }
    }
    //Step 3 open the request/connection
    xhr.open("GET","https://swapi.co/api/planets/"+planetId,true);
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

function switchtoPerson(){
	console.log("inside testStuff2");
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange= function (){};
	xhr.open("POST","PersonSearch",true);
	xhr.send();
	}

window.onload=function(){
    console.log("in onload");
    document.getElementById("starwarssubmit").addEventListener("click",getPlanet,false);
   }