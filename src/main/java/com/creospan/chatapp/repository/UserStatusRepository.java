package com.creospan.chatapp.repository;

import com.creospan.chatapp.dto.UserStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStatusRepository extends CrudRepository<UserStatus, String> {
}
