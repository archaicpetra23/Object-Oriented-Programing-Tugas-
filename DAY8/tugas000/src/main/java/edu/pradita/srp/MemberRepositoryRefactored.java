package edu.pradita.srp;

public class MemberRepositoryRefactored {
    public void save(MemberRecordRefactored member) {
        System.out.println("[SRP] Saving member: " + member.getName());
    }
}