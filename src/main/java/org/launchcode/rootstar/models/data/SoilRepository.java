package org.launchcode.rootstar.data;

import org.launchcode.rootstar.models.Soil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoilRepository extends JpaRepository<Soil, Integer> {
}
