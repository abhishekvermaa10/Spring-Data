package com.abhishekvermaa10.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhishekvermaa10.entity.Pet;

/**
 * @author abhishekvermaa10
 */
public interface PetRepository extends JpaRepository<Pet, Integer> {

	@Query("SELECT p FROM Pet p JOIN FETCH p.owner WHERE p.id = :petId")
	Optional<Pet> findPetById(int petId);

	@Query("SELECT AVG(YEAR(CURRENT_DATE()) - YEAR(p.birthDate)) FROM Pet p")
	Optional<Double> findAverageAgeOfPet();

}
