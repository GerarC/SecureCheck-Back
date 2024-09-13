package co.edu.udea.securecheck.domain.model;

import co.edu.udea.securecheck.domain.utils.Generated;

import java.time.LocalDateTime;

@Generated
public class Company {
    private String id;
    private String nit;
    private String name;
    private String nick;
    private String address;
    private String contactEmail;
    private String contactPhone;
    private LocalDateTime createdAt;
    private User user;

    public Company(String id, String nit, String name, String nick, String address, String contactEmail, String contactPhone, LocalDateTime createdAt, User user) {
        this.id = id;
        this.nit = nit;
        this.name = name;
        this.nick = nick;
        this.address = address;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Company() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
