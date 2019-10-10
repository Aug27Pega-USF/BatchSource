package com.example.dao;

import com.example.model.Pet;

public interface PetDAO {
	//create
	public int insertPet(Pet p);
	// read
	public Pet selectPetByName(String name);
	//public List<Pet> selectAllPets();
	// update
	//public int updatePet(Pet p);
	// delete
	//public int deletePet(Pet p);
}
