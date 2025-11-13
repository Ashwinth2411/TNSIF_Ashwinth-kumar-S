package com.MallAdmin;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "mall_admin")
public class MallAdmin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mall_admin_id")
    private Integer mallAdminId;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private Integer loginAttempts = 0; // ✅ Default value

    @Column(nullable = false)
    private Boolean isActive = true; // ✅ Default value

    @Column(name = "last_login_time", nullable = false)
    private LocalDateTime lastLoginTime = LocalDateTime.now(); // ✅ Always non-null

    public MallAdmin() {
    }

    public MallAdmin(Integer mallAdminId, String username, String password, String email,
                     Integer loginAttempts, Boolean isActive, LocalDateTime lastLoginTime) {
        this.mallAdminId = mallAdminId;
        this.username = username;
        this.password = password;
        this.email = email;
        this.loginAttempts = loginAttempts != null ? loginAttempts : 0;
        this.isActive = isActive != null ? isActive : true;
        this.lastLoginTime = lastLoginTime != null ? lastLoginTime : LocalDateTime.now();
    }

    public Integer getMallAdminId() {
        return mallAdminId;
    }

    public void setMallAdminId(Integer mallAdminId) {
        this.mallAdminId = mallAdminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getLoginAttempts() {
        return loginAttempts;
    }

    public void setLoginAttempts(Integer loginAttempts) {
        this.loginAttempts = loginAttempts;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public LocalDateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(LocalDateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Override
    public String toString() {
        return "MallAdmin{" +
                "mallAdminId=" + mallAdminId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", loginAttempts=" + loginAttempts +
                ", isActive=" + isActive +
                ", lastLoginTime=" + lastLoginTime +
                '}';
    }
}
