package com.allfiles.project_4pets.Repository;

import com.allfiles.project_4pets.Entity.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Integer> {
}
