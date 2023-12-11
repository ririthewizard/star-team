package org.launchcode.rootstar.models.data;

import org.launchcode.rootstar.models.Seed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedRepository extends CrudRepository<Seed, Integer> {
}
