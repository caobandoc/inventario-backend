package com.inventory.auth.infrastructure.drivenadapter.crud;

import com.inventory.auth.infrastructure.drivenadapter.entities.UserAuth;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IUserCrudRepository extends CrudRepository<UserAuth, Long> {
    Optional<UserAuth> findByEmail(String email);
}
