package com.Merchant.Registration.Repository;

import com.Merchant.Registration.entity.TerminalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalDetailsRepository extends JpaRepository<TerminalDetails,String> {

}
