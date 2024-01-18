package org.launchcode.rootstar.models.data;

import org.launchcode.rootstar.models.Garden;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GardenRepository extends JpaRepository<Garden, Integer> {
    Optional<Garden> findById(int id);
}
