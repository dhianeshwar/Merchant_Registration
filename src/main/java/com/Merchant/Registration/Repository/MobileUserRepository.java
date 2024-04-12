package com.Merchant.Registration.Repository;

import com.Merchant.Registration.entity.MobileUser;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MobileUserRepository extends JpaRepository<MobileUser,Long> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO MOBILE_USER (VERSION,   FAILED_LOGIN_ATTEMPT,   TID, BOOST_TID, GPAY_TID, TNG_TID, SHOPPY_TID,  MERCHANT_FK,    merchant_id,permissionSettle,   PERMISSION_SETTLE,  PERMISSION_VOID, permissionVoid,  USERNAME,   PASSWORD,  failedLoginAttempt ) " +
                                    "VALUES (0, 0,  :tid,   :boostTid, :grabTid, :tngTid, :shoppyTid,   :merchantId,    :merchantId,    :permissionSettle,  false,  :permissionVoid,  false,    :userName,  :password,    0 )",
            nativeQuery = true)
    int insertMobileUser(@Param("tid") String tid,
                  @Param("boostTid") String boostTid,
                  @Param("grabTid") String grabTid,
                  @Param("tngTid") String tngTid,
                  @Param("shoppyTid") String shoppyTid,
                  @Param("merchantId") long merchantId,
                  @Param("permissionSettle") boolean permissionSettle,
                  @Param("permissionVoid") boolean permissionVoid,
                         @Param("userName") String userName,
                         @Param("password") String password


                         );
@Query("SELECT DISTINCT CASE  " +
        "       WHEN m.tid = :tid THEN 'tid'  " +
        "       WHEN m.boostTid = :boostTid THEN 'boostTid'  " +
        "       WHEN m.gpayTid = :grabTid THEN 'grabTid'  " +
        "       WHEN m.tngTid = :tngTid THEN 'tngTid'  " +
        "       WHEN m.shoppyTid = :shoppyTid THEN 'shoppyTid'  " +
        "       ELSE NULL END  " +
        "       FROM MobileUser m  " +
        "       WHERE m.tid = :tid OR m.boostTid = :boostTid OR m.gpayTid = :grabTid OR m.tngTid = :tngTid OR m.shoppyTid = :shoppyTid ")
    List<String> existsBYAnyTids(
            @Param("tid") String tid,
            @Param("boostTid") String boostTid,
            @Param("grabTid") String grabTid,
            @Param("tngTid") String tngTid,
            @Param("shoppyTid") String shoppyTid

);

}
