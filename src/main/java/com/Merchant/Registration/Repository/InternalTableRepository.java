package com.Merchant.Registration.Repository;

import com.Merchant.Registration.entity.InternalTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternalTableRepository extends JpaRepository<InternalTable,String> {

}
