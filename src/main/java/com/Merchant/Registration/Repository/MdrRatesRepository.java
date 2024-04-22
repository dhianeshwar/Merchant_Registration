package com.Merchant.Registration.Repository;

import com.Merchant.Registration.entity.MdrRates;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MdrRatesRepository extends JpaRepository<MdrRates,Long> {
}
