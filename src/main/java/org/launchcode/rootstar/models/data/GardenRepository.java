package org.launchcode.rootstar.models.data;

import org.launchcode.rootstar.models.Garden;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GardenRepository extends CrudRepository <Garden, Integer> {
}
