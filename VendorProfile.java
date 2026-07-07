package com.shopstack.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_profiles")
public class VendorProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Linking the vendor profile back to the core authenticated User
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private User user;

    @Column(name = "store_name", nullable = false, length = 100)
    private String storeName;

    @Column(name = "business_email", length = 100)
    private String businessEmail;

    @Column(name = "support_contact", length = 15)
    private String supportContact;

    @Column(name = "store_description", length = 1000)
    private String storeDescription;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VendorStatus status = VendorStatus.PENDING;

    // Constructors
    public VendorProfile() {}

    public VendorProfile(User user, String storeName, String businessEmail, String supportContact, String storeDescription) {
        this.user = user;
        this.storeName = storeName;
        this.businessEmail = businessEmail;
        this.supportContact = supportContact;
        this.storeDescription = storeDescription;
        this.status = VendorStatus.PENDING;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public String getStoreName() { return storeName; }
    public void setStoreName(String storeName) { this.storeName = storeName; }
    public String getBusinessEmail() { return businessEmail; }
    public void setBusinessEmail(String businessEmail) { this.businessEmail = businessEmail; }
    public String getSupportContact() { return supportContact; }
    public void setSupportContact(String supportContact) { this.supportContact = supportContact; }
    public String getStoreDescription() { return storeDescription; }
    public void setStoreDescription(String storeDescription) { this.storeDescription = storeDescription; }
    public VendorStatus getStatus() { return status; }
    public void setStatus(VendorStatus status) { this.status = status; }
}