package com.Merchant.Registration.entity;

public enum ApplicationIdentifier {

    VISA_MASTER("VisaMaster"),
    AMERICAN_EXPRESS("American Express");
    private final String value;
    ApplicationIdentifier(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
    public static ApplicationIdentifier getStatus(String value) {
        for (ApplicationIdentifier identifier : values()) {
            if (identifier.getValue().equalsIgnoreCase(value)) {
                return identifier;
            }
        }
        return null;
    }
}