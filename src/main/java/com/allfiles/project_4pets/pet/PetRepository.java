package com.allfiles.project_4pets.pet;

import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Integer> {
}
