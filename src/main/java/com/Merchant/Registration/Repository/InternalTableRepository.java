package com.Merchant.Registration.Repository;

import com.Merchant.Registration.entity.InternalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalTableRepository extends JpaRepository<InternalTable,String> {
@Query(value = "SELECT it.STAN FROM mobiversa.internal_table it WHERE it.TID='MOTO_DEVICEID'",nativeQuery = true)
    String getStanByTid(String motoDeviceid);
    @Query(value = "update internal_table it set STAN=:stanLong where TID='MOTO_DEVICEID'",nativeQuery = true)
    @Modifying
    int updateStan(String stanLong);
}
