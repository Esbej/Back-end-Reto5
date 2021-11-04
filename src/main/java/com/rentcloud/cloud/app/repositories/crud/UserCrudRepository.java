package com.rentcloud.cloud.app.repositories.crud;

import com.rentcloud.cloud.app.entities.user;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<user,Integer> {
}
