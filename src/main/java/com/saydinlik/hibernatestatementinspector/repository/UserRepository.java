package com.saydinlik.hibernatestatementinspector.repository;

import com.saydinlik.hibernatestatementinspector.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
