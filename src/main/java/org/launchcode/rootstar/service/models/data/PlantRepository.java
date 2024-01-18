package org.launchcode.rootstar.service.models.data;

import org.launchcode.rootstar.service.models.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Integer> {
}
