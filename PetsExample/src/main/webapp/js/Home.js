window.onload = function() {
	getPetInfo();
}

function getPetInfo() {
	let xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function() {
		if (xhttp.readyState == 4 && xhttp.status == 200) {
			let pet = JSON.parse(xhttp.responseText);
			setValues(pet);
		}
	}

	xhttp.open("GET", 'http://localhost:8080/PetsExample/html/PetJSON.do',
					true);
	xhttp.send();
}
function setValues(pet) {
	document.getElementById("name").innerHTML = "The name of this pet is"
			+ pet.name;
	document.getElementById("type").innerHTML = "The type of this pet is"
			+ pet.type;
}