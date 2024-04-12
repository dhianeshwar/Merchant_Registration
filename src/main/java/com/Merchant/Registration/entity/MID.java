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
@Table (name = "MID")
public class MID implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "MERCHANT_FK")
    private Merchant merchant;

    @Column(length=(int) 20)
    private String mid;

    @Column(name="MOTO_MID")
    private String motoMid;

    @Column(name="EZYREC_MID")
    private String ezyrecMid;

    @Column(name="EZYWAY_MID")
    private String ezywayMid;

    @Column(name="EZYPASS_MID")
    private String ezypassMid;

    @Column(name="UM_MID")
    private String umMid;

    @Column(name="UM_MOTO_MID")
    private String umMotoMid;

    @Column(name="UM_EZYREC_MID")
    private String umEzyrecMid;

    @Column(name="UM_EZYWAY_MID")
    private String umEzywayMid;

    @Column(name="UM_EZYPASS_MID")
    private String umEzypassMid;

    @Column(name="GPAY_MID")
    private String gpayMid;

    @Column(name="SS_MOTO_MID")
    private String ssMotoMid;

    @Column(name="UM_SS_MOTO_MID")
    private String umSsMotoMid;

    @Column(name="LITE_MID")
    private String liteMid;

    @Column(name="SUB_MERCHANT_MID")
    private String subMerchantMID;

    @Column(name="SPLIT_MID")
    private String splitMid;

    @Column(name="SUB_GRAB_MID")
    private String subGrabMid;

    @Column(name="BOOST_MID")
    private String boostMid;

    @Column(name="FPX_MID")
    private String fpxMid;

    @Column(name="GRAB_MID")
    private String grabMid;

    @Column(name="TNG_MID")
    private String tngMid;

    @Column(name="SHOPPY_MID")
    private String shoppyMid;

    @Column(name="BNPL_MID")
    private String bnplMid;

    @Column
    @Enumerated(value=EnumType.STRING)
    private  ApplicationIdentifier applicationIdentifier;
}

