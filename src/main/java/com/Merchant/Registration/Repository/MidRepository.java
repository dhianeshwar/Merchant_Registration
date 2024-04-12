package com.Merchant.Registration.Repository;

import com.Merchant.Registration.entity.MID;
import com.Merchant.Registration.entity.Merchant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface MidRepository extends JpaRepository<MID,Long> {
    Optional<MID> findByMid(String mid);
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO MID (VERSION, boost_mid, grab_mid, tng_mid, shoppy_mid, mid) " +
            "VALUES (0, :boostMid, :grabMid, :tngMid, :shoppyMid, :mid)",
            nativeQuery = true)
    int insertMID(@Param("boostMid") String boostMid,
                   @Param("grabMid") String grabMid,
                   @Param("tngMid") String tngMid,
                   @Param("shoppyMid") String shoppyMid,
                   @Param("mid") String mid);
    @Query(value = "SELECT m.MID FROM mobiversa.mid m;",nativeQuery = true)
    Set<String> findAllMid();
    @Query(value = "SELECT m.BOOST_MID FROM mobiversa.mid m;",nativeQuery = true)
    Set<String> findAllboostMidNotNull();
    @Query(value = "SELECT m.GRAB_MID FROM mobiversa.mid m;",nativeQuery = true)
    Set<String> findAllGrabMidNotNull();
    @Query(value = "SELECT m.TNG_MID FROM mobiversa.mid m;",nativeQuery = true)
    Set<String> findAllTngMidNotNull();
    @Query(value = "SELECT m.SHOPPY_MID FROM mobiversa.mid m;",nativeQuery = true)
    Set<String> findAllShoppyMidNotNull();
    @Query(value = "SELECT m.id FROM mobiversa.mid m WHERE m.SHOPPY_MID= :shoppyMid",nativeQuery = true)
    Long findID(@Param("shoppyMid") String shoppyMid);

    @Query(value =
            "SELECT m.mid AS value FROM MID m " +
                    "UNION ALL " +
                    "SELECT m.BOOST_MID AS value FROM MID m WHERE m.BOOST_MID IS NOT NULL " +
                    "UNION ALL " +
                    "SELECT m.GRAB_MID AS value FROM MID m WHERE m.GRAB_MID IS NOT NULL " +
                    "UNION ALL " +
                    "SELECT m.TNG_MID AS value FROM MID m WHERE m.TNG_MID IS NOT NULL " +
                    "UNION ALL " +
                    "SELECT m.SHOPPY_MID AS value FROM MID m WHERE m.SHOPPY_MID IS NOT NULL",
            nativeQuery = true)
    Set<String> findAllUniqueMIDs();

    @Query(value = "SELECT m.MERCHANT_FK FROM  MID m WHERE m.ID=:id ",nativeQuery = true)
    long findByMid(@Param("id") long id);

}
