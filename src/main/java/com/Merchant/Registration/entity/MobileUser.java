package com.Merchant.Registration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "MOBILE_USER")
public class MobileUser implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(length = (int) 50, nullable = false)
    private String username;

    @Column(length = (int) 250, nullable = false)
    private String password;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "MERCHANT_FK")
    private Merchant merchant;

    @Column
    private int failedLoginAttempt;

    @Column
    private boolean permissionVoid;

    @Column
    private boolean permissionSettle;

    @Column(name = "DEVICE_TOKEN")
    private String deviceToken;

    @Column(name = "TID")
    private String tid;

    @Column(name = "DEVICE_TYPE")
    private String deviceType;

    @Column(name = "DEVICE_ID")
    private String deviceId;

    @Column(name = "CONNECT_TYPE")
    private String connectType;

    @Column(name = "ENBL_BOOST")
    private String enableBoost;

    @Column(name = "ENBL_MOTO")
    private String enableMoto;

    @Column(name = "ENBL_EZYPASS")
    private String enableEzpass;

    @Column(name = "MOTO_TID")
    private String motoTid;

    @Column(name = "EZYPASS_TID")
    private String ezypassTid;

    @Column(name = "EZYREC_TID")
    private String ezyrecTid;

    @Column(name = "EZYWAY_TID")
    private String ezywayTid;

    @Column(name = "MOTO_API_TOKEN")
    private String motoApiToken;

    @Column(name = "MOTO_API_KEY")
    private String motoApiKey;

    @Column(name = "GPAY_TID")
    private String gpayTid;

    @Column(name = "ONLINE_GPAY")
    private String onlineGpay;

    @Column(name = "ENBL_TKZ")
    private String enableTkz;

    @Column(name = "SPLIT_TID")
    private String splitTid;

    @Column(name = "LOGIN_CNT", columnDefinition = "int(11) default '0'")
    private int loginCnt;

    @Column(name = "PRE_AUTH")
    public String preAuth;

    @Column(name = "FB_LOGIN")
    public String fbLogin;

    @Column(name = "FACEBOOK_ID")
    public String facebookId;

    @Column(name = "G_LOGIN")
    public String gLogin;

    @Column(name = "GOOGLE_ID")
    public String googleId;

    @Column(name = "IOS_LOGIN")
    public String iosLogin;

    @Column(name = "IOS_ID")
    public String iosId;

    @Column(name = "DOB")
    public String dateOfBirth;

    @Column(name = "FPX_TID")
    private String fpxTid;

    @Column(name = "BOOST_TID")
    private String boostTid;

    @Column(name = "TNG_TID")
    private String tngTid;

    @Column(name = "SHOPPY_TID")
    private String shoppyTid;

    @Column(name = "BNPL_TID")
    private String bnplTid;

    @Column(name = "BNPL_USER_NAME")
    private String bnplUName;

    @Column(name = "BNPL_PASSWORD")
    private String bnplPwd;

    @Column(name = "ENABLE_SETTELEMENT_PAYOUT", nullable = false, columnDefinition = "varchar(255) default 'No'")
    public String enableSettelementPayout;

    @Column(name = "STATUS")
    private String status;
}
