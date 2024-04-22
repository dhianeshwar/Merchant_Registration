package com.Merchant.Registration.Repository;

import com.Merchant.Registration.entity.MdrRates;
import com.Merchant.Registration.entity.MobiMdr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobiMdrRepository extends JpaRepository<MobiMdr,Long> {

}
