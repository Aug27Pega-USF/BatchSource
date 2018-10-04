package com.example.dao;

import com.example.model.Pet;

public interface PetDao {

	//CREATE
	public int insertPet(Pet p);
	//READ
	public Pet selectPetByName(String name);
/*	//UPDATE
	public int updatePet(Pet p);
	//DELETE
	public int deletePet(Pet p);*/

}
