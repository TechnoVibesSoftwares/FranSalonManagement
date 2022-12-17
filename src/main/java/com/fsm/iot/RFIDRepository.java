package com.fsm.iot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RFIDRepository extends JpaRepository<RFIDEntity, Long> {

}
