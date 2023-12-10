package org.launchcode.rootstar.models.data;

import org.launchcode.rootstar.models.Soil;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilRepository extends CrudRepository<Soil, Integer> {
}
