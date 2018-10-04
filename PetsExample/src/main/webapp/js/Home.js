/**
 * 
 */
window.onload = function() {
	getPetInfo();
}

function getPetInfo() {
	
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if(xhttp.readyState == 4 && xhttp.status==200) {
			let pet = JSON.parse(xhttp.responseText);
			console.log(pet);
			setValues(pet);
		}
	}
	
	xhttp.open("GET", 'http://localhost:9005/PetsExample/html/PetJSON.do', true); 
	xhttp.send();
	
}

function setValues(pet){
	document.getElementById("name").innerHTML="Pet's name: " + pet.name;
	document.getElementById("type").innerHTML="Pet's type: " + pet.type;

}

