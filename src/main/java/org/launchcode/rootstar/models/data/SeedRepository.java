package org.launchcode.rootstar.service.models.data;

import org.launchcode.rootstar.service.models.Seed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeedRepository extends JpaRepository<Seed, Integer> {
}
