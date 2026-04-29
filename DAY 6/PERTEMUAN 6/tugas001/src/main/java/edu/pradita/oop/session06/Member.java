package edu.pradita.oop.session06;

import java.time.LocalDate;

public class Member {

    private String username;
    private String password;
    private String namaLengkap;
    private LocalDate membershipAkhir;

    public Member(String username, String password, String namaLengkap, LocalDate membershipAkhir) {
        this.username = username;
        this.password = password;
        this.namaLengkap = namaLengkap;
        this.membershipAkhir = membershipAkhir;
    }

    public String getUsername() {
        return username;
    }

    public String getNamaLengkap() {
        return namaLengkap;
    }

    public LocalDate getMembershipAkhir() {
        return membershipAkhir;
    }

    public void setMembershipAkhir(LocalDate membershipAkhir) {
        this.membershipAkhir = membershipAkhir;
    }

    public boolean checkPassword(String inputPassword) {
        return this.password.equals(inputPassword);
    }

    public boolean isActive(LocalDate today) {
        return membershipAkhir != null && !membershipAkhir.isBefore(today);
    }

    @Override
    public String toString() {
        return "Member{username='" + username + "', nama='" + namaLengkap
                + "', membershipAkhir=" + membershipAkhir + "}";
    }
}
