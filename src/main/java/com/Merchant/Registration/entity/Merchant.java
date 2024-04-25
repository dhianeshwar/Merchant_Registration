package com.Merchant.Registration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MERCHANT")
public class Merchant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Version
    @Column(name="VERSION")
    private int version;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "MID_FK")
    private MID mid;

    @Enumerated(value=EnumType.STRING)
    private MerchantUserRole role;

    @Column(name="BUSINESS_ADDRESS2", length=100)
    private String businessAddress2;

    @Column(name="BUSINESS_ADDRESS3", length=100)
    private String businessAddress3;

    @Column(name="CONTACT_PERSON_PHONE_NUMBER", length=20)
    public String contactPersonPhoneNo;

    @Column(name="NATURE_OF_BUSINESS", length=100)
    public String natureOfBusiness;

    @Column(name="REMARKS", length=100)
    public String remarks;

    @Column(name="SIGNED_PACKAGE", length=100)
    public String signedPackage;

    @Column(name="WEBSITE", length=100)
    public String website;

    @Column(name="BUSINESS_NAME", nullable=false, length=(int) 250)
    private String businessName;

    @Column(name="BUSINESS_REGISTRATION_NUMBER", length=(int) 50)
    private String businessRegistrationNumber;

    @Column(name="BUSINESS_SHORTNAME", nullable=false, length=(int) 250)
    private String businessShortName;

    @Column(name="BUSINESS_ADDRESS1", length=(int) 200, nullable=false)
    private String businessAddress1;

    @Column(name="SALUTATION", length=(int) 50)
    private String salutation;

    @Column(length=(int) 30, nullable=false)
    private String city;

    @Column(length=(int) 30, nullable=false)
    private String state;

    @Column(length=(int) 10, nullable=false)
    private String postcode;

    @Column(name="BUSINESS_CONTACT_NUMBER", length=(int) 30, nullable=false)
    private String businessContactNumber;

    @Column(name="FIRST_NAME", length=(int) 100, nullable=false)
    private String firstName;

    @Column(name="LAST_NAME", length=(int) 100, nullable=false)
    private String lastName;

    @Column(length=(int) 50, nullable=false)
    private String username;

    @Column(length=(int) 50, nullable=false)
    private String email;

    @Column(length=(int) 250, nullable=false)
    private String password;

    @Column(name="failedLoginAttempt")
    private  int failedLoginAttempt=0;

    @Column(name="MAX_AMOUNT_PER_Transaction", length=(int) 100, nullable=false)
    private Integer maxAmountPerTransaction;

    @Column(name="MAX_AMOUNT_PER_MONTH", length=(int) 100, nullable=false)
    private Integer maxAmountPerMonth;

    @Column(name="TRADING_NAME", length=(int) 50)
    public String tradingName;

    @Column(name="CONTACT_PERSON_NAME", length=(int) 50, nullable=false)
    public String contactPersonName;

    @Column(name="OWNER_NAME")
    public String ownerName;

    @Column(name="OWNER_PASSPORT_NO")
    public String ownerPassportNo;

    @Column(name="OWNER_CONTACT_NUMBER")
    public String ownerContactNo;

    @Column(name="FAX_NO")
    public String faxNo;

    @Column(name="COMPANY_TYPE")
    public String companyType;

    @Column(name="BUSINESS_TYPE")
    public String businessType;

    @Column(name="PERMISE_TYPE")
    public String PermiseType;

    @Column(name="READER_SERIAL_NUMBER")
    public String readerSerialNo;

    @Column(name="REFERRAL_ID")
    public String referralId;

    @Column(name="BANK_NAME")
    public String bankName;

    @Column(name="BANK_ACC")
    public String bankAcc;

    @Column(name="NRIC_ACCOUNT")
    public String nricAcc;

    @Column(name="WAIVER_MONTH")
    public String waiverMonth;

    @Column(name="ENABLED")
    public boolean enabled;

    @Column(name="AGID_FK")
    public BigInteger agID;

    @Column(name="SUBAGID_FK")
    public BigInteger subAgID;

    @Column(name="YEAR_INCORPORTED")
    public String yearIncorporated;

    @Column(name="OWNER_SAL")
    public String ownerSalutation;

    @Column(name="OWNER_ADD")
    public String residentialAddress;

    @Column(name="MDR")
    public String mdr;

    @Column(name="PRE_AUTH")
    public String preAuth;

    @Column(name="AUTH_3DS")
    public  String auth3DS;

    @Column(name="ALLOW_RECURRING")
    public String allowRecurring;

    @Column(name="AUTO_SETTLED")
    public String autoSettled;

    @Column(name="DOB")
    public String dateOfBirth;

    @Column(name="COUNTRY")
    public String country;

    @Column(name="CURRENCY")
    public String currency;

    @Column(name="MERCHANT_TYPE")
    private String merchantType;

    @Column(name="APPROVED")
    private String approved;

    @Column(name="EZYMOTO_VCC")
    public String ezyMotoVcc;

    @Column(name="ACC_TYPE")
    public String accType;

    @Column(name="TYPE")
    public String type;

    @Column(name="MM_ID")
    public String mmId;

    @Column(name="LATITUDE")
    public String latitude;

    @Column(name="LONGITUDE")
    public String longitude;

    @Column(name="IP_ADDRESS")
    public String ipAddress;

    @Column(name="MAC_ADDRESS")
    public String macAddress;

    @Column(name="CONTACT_NRIC")
    public String contactIc;

    @Column(name="IC_PHOTO_PATH")
    public String icPhotoPath;

    @Column(name="MOBI_ID")
    public String mobiId;

    @Column(name="ENABLE_FRAUD")
    public String enableFraud;

    @Column(name="FRAUD_CLIENT_ID")
    public String fraudClientId;

    @Column(name="MERCHANT_SECTOR")
    public String merchantSector;

    @Column(name="MERCHANT_CATEGORY")
    public String merchantCategory;

    @Column(name="ISWITCH")
    public String iSwitchEnable;

    @Column(name="DISCOUNT_AMOUNT")
    public String discountAmount;

    @Column(name="ENBL_PAYOUT")
    public String enblPayout;

    @Column(name="JUSTSETTLE_SWTCOUNT")
    public String justsettle_swtcount;

    @Column(name="JS_CHECKBOX_COUNT", columnDefinition="varchar(255) default '0'")
    public String jsCheckCount;

    @Column(name="JS_WITHDRAW_COUNT", columnDefinition="varchar(255) default '0'")
    public String jsWithdrawCount;

    @Column(name="ISWITCH_DISCOUNT")
    public String iSwitchDiscount;

    @Column(name="PAYMENT_DATE")
    public String paymentDate;

    @Column(name="ENABLE_CARD")
    public String enableCard;

    @Column(name="ENABLE_EWALLET")
    public String enableEwallet;

    @Column(name="ENABLE_FPX")
    public String enableFpx;

    @Column(name="REACTIVATE_DATE")
    public String reActivateDate;

    @Column(name="IS_COMBO")
    public String isCombo;

    @Column(name="IS_EZYWIRE_PLUS")
    public String isEzywirePlus;

    @Column(name="ENABLE_FOREIGN_CARD")
    public String foreignCard;

    @Column(name="INTEGRATION_PLATFORM")
    public String integrationPlatform;

    @Column(name="SETTLEMENT_EMAIL")
    public String settlementEmail;

    @Column(name="ENABLE_BNPL")
    public String enableBnpl;

    @Column(name = "STATUS")
    private String status;

    @Column(name="PAYOUTGRANDDETAIL_FK")
    private Long payOutGrandDetailFk;

}