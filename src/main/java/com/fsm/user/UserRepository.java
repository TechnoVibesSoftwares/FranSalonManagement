package com.fsm.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>
{
	boolean existsByEmailId(String username);
	boolean existsByMobileNo(String mobileNo);
	UserEntity findByEmailId(String emailId);
	UserEntity findByMobileNo(String mobileNo);
}
