package edu.pradita.srp;

public class GymManager {
    private String memberName;
    private String memberEmail;
    private int durationMonths;

    public void registerMember(String name, String email, int months) {
        this.memberName = name;
        this.memberEmail = email;
        this.durationMonths = months;
        System.out.println("Member registered: " + name);
    }

    public void printMemberInfo(String name) {
        System.out.println("[PRINT] Member: " + memberName + " | Email: " + memberEmail + " | Duration: " + durationMonths + " months");
    }

    public void saveMemberToFile(String name) {
        System.out.println("[SAVE] Saving member " + memberName + " to file...");
    }
}
