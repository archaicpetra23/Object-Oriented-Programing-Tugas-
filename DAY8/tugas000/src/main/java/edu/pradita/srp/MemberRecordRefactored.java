package edu.pradita.srp;

public class MemberRecordRefactored {
    private String name;
    private String email;
    private int durationMonths;

    public MemberRecordRefactored(String name, String email, int durationMonths) {
        this.name = name;
        this.email = email;
        this.durationMonths = durationMonths;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getDurationMonths() {
        return durationMonths;
    }
}