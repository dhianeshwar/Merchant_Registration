package com.Merchant.Registration.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TERMINAL_DETAILS")
public class TerminalDetails {
    @Id
    @Column(
            name = "DEVICE_ID"
    )
    private String deviceId;
    private String tid;
    @Column(
            name = "DEVICE_NAME"
    )
    private String deviceName;
    @Column(
            name = "DEVICE_VERSION"
    )
    private String deviceVersion;
    @Column(
            name = "DEVICE_TYPE"
    )
    private String deviceType;
    @Column(
            name = "ACTIVE_STATUS"
    )
    private String activeStatus;
    @Column(
            name = "KEY_STATUS"
    )
    private String keyStatus;
    @Column(
            name = "BATCH_NO"
    )
    private String batchNo;
    @Column(
            name = "MERCHANT_ID"
    )
    private String merchantId;
    private Date activatedDate;
    private Date suspendedDate;
    @Column(
            name = "RENEWAL_DATE"
    )
    private Date renewalDate;
    @Column(
            name = "REMARKS"
    )
    private String remarks;
    @Column(
            name = "CONTACT_NAME"
    )
    private String contactName;
    @Column(
            name = "CONNECT_TYPE"
    )
    private String connectType;
    @Column(
            name = "ACTIVATION_CODE"
    )
    private String activationCode;
    @Column(
            name = "PRE_AUTH"
    )
    private String preAuth;
    @Column(
            name = "UM_TID"
    )
    private String umTid;
    @Column(
            name = "MOBI_ID"
    )
    public String mobiId;
    private String refNo;

}
