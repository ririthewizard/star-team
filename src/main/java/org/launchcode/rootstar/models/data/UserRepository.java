package org.launchcode.rootstar.models.data;

import org.launchcode.rootstar.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface git statusUserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);
}
