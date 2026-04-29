package edu.pradita.srp;

public class MemberPrinterRefactored {
    public void print(MemberRecordRefactored member) {
        System.out.println("[SRP] Printing member: " + member.getName());
    }
}