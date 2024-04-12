package com.Merchant.Registration.Repository;

import com.Merchant.Registration.entity.Merchant;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant,Long> {
    @Query("SELECT m.businessShortName FROM Merchant m WHERE m.id = :id")
    String getBusinessShortName(@Param("id") Long id);

@Modifying
@Transactional
@Query(value = "INSERT INTO MERCHANT (VERSION, failedloginattempt, FAILED_LOGIN_ATTEMPT, MID_FK, ROLE, BUSINESS_ADDRESS2, BUSINESS_ADDRESS3, CONTACT_PERSON_PHONE_NUMBER, NATURE_OF_BUSINESS, REMARKS, SIGNED_PACKAGE, WEBSITE, BUSINESS_NAME, BUSINESS_REGISTRATION_NUMBER, BUSINESS_SHORTNAME, BUSINESS_ADDRESS1, SALUTATION, CITY, STATE, POSTCODE, BUSINESS_CONTACT_NUMBER, FIRST_NAME, LAST_NAME, USERNAME, EMAIL, PASSWORD, MAX_AMOUNT_PER_TRANSACTION, MAX_AMOUNT_PER_MONTH, TRADING_NAME, CONTACT_PERSON_NAME, OWNER_NAME, OWNER_PASSPORT_NO, OWNER_CONTACT_NUMBER, FAX_NO, COMPANY_TYPE, BUSINESS_TYPE, PERMISE_TYPE, READER_SERIAL_NUMBER, REFERRAL_ID, BANK_NAME, BANK_ACC, NRIC_ACCOUNT, WAIVER_MONTH, ENABLED, AGID_FK, SUBAGID_FK, YEAR_INCORPORTED, OWNER_SAL, OWNER_ADD, MDR, PRE_AUTH, AUTH_3DS, ALLOW_RECURRING, AUTO_SETTLED, DOB, COUNTRY, CURRENCY, MERCHANT_TYPE, APPROVED, EZYMOTO_VCC, ACC_TYPE, TYPE, MM_ID, LATITUDE, LONGITUDE, IP_ADDRESS, MAC_ADDRESS, CONTACT_NRIC, IC_PHOTO_PATH, MOBI_ID, ENABLE_FRAUD, FRAUD_CLIENT_ID, MERCHANT_SECTOR, MERCHANT_CATEGORY, ISWITCH, DISCOUNT_AMOUNT, ENBL_PAYOUT, JUSTSETTLE_SWTCOUNT, JS_CHECKBOX_COUNT, JS_WITHDRAW_COUNT, ISWITCH_DISCOUNT, PAYMENT_DATE, ENABLE_CARD, ENABLE_EWALLET, ENABLE_FPX, REACTIVATE_DATE, IS_COMBO, IS_EZYWIRE_PLUS, ENABLE_FOREIGN_CARD, INTEGRATION_PLATFORM, SETTLEMENT_EMAIL, ENABLE_BNPL, STATUS,   PAYOUTGRANDDETAIL_FK)" +
        " VALUES (0, 0, 0, :id, :#{#merchant.role}, :#{#merchant.businessAddress2}, :#{#merchant.businessAddress3}, :#{#merchant.contactPersonPhoneNo}, :#{#merchant.natureOfBusiness}, :#{#merchant.remarks}, :#{#merchant.signedPackage}, :#{#merchant.website}, :#{#merchant.businessName}, :#{#merchant.businessRegistrationNumber}, :#{#merchant.businessShortName}, :#{#merchant.businessAddress1}, :#{#merchant.salutation}, :#{#merchant.city}, :#{#merchant.state}, :#{#merchant.postcode}, :#{#merchant.businessContactNumber}, :#{#merchant.firstName}, :#{#merchant.lastName}, :#{#merchant.username}, :#{#merchant.email}, :#{#merchant.password}, :#{#merchant.maxAmountPerTransaction}, :#{#merchant.maxAmountPerMonth}, :#{#merchant.tradingName}, :#{#merchant.contactPersonName}, :#{#merchant.ownerName}, :#{#merchant.ownerPassportNo}, :#{#merchant.ownerContactNo}, :#{#merchant.faxNo}, :#{#merchant.companyType}, :#{#merchant.businessType}, :#{#merchant.PermiseType}, :#{#merchant.readerSerialNo}, :#{#merchant.referralId}, :#{#merchant.bankName}, :#{#merchant.bankAcc}, :#{#merchant.nricAcc}, :#{#merchant.waiverMonth}, :#{#merchant.enabled}, :#{#merchant.agID}, :#{#merchant.subAgID}, :#{#merchant.yearIncorporated}, :#{#merchant.ownerSalutation}, :#{#merchant.residentialAddress}, :#{#merchant.mdr}, :#{#merchant.preAuth}, :#{#merchant.auth3DS}, :#{#merchant.allowRecurring}, :#{#merchant.autoSettled}, :#{#merchant.dateOfBirth}, :#{#merchant.country}, :#{#merchant.currency}, :#{#merchant.merchantType}, :#{#merchant.approved}, :#{#merchant.ezyMotoVcc}, :#{#merchant.accType}, :#{#merchant.type}, :#{#merchant.mmId}, :#{#merchant.latitude}, :#{#merchant.longitude}, :#{#merchant.ipAddress}, :#{#merchant.macAddress}, :#{#merchant.contactIc}, :#{#merchant.icPhotoPath}, :#{#merchant.mobiId}, :#{#merchant.enableFraud}, :#{#merchant.fraudClientId}, :#{#merchant.merchantSector}, :#{#merchant.merchantCategory}, :#{#merchant.iSwitchEnable}, :#{#merchant.discountAmount}, :#{#merchant.enblPayout}, :#{#merchant.justsettle_swtcount}, :#{#merchant.jsCheckCount}, :#{#merchant.jsWithdrawCount}, :#{#merchant.iSwitchDiscount}, :#{#merchant.paymentDate}, :#{#merchant.enableCard}, :#{#merchant.enableEwallet}, :#{#merchant.enableFpx}, :#{#merchant.reActivateDate}, :#{#merchant.isCombo}, :#{#merchant.isEzywirePlus}, :#{#merchant.foreignCard}, :#{#merchant.integrationPlatform}, :#{#merchant.settlementEmail}, :#{#merchant.enableBnpl}, :#{#merchant.status},1)", nativeQuery = true)
void addMerchantNativeQuery(@Param("merchant") Merchant merchant,@Param("id") long id);
@Query(value = "SELECT mer.ID FROM  mobiversa.merchant mer WHERE mer.MID_FK=:midId ",nativeQuery = true)
long findIdByMid_fk(@Param("midId") long midId);
}
