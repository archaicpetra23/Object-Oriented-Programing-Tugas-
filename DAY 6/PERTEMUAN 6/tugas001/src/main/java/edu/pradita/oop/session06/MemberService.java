package edu.pradita.oop.session06;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MemberService {

    private final Map<String, Member> members = new HashMap<>();

    public MemberService() {
        members.put("budi",
                new Member("budi", "budi123", "Budi Santoso",
                        LocalDate.now().plusMonths(3)));
    }

    public Member register(String username, String password,
                           String namaLengkap, MembershipPlan plan) {
        if (members.containsKey(username)) {
            throw new IllegalArgumentException("Username sudah digunakan");
        }
        LocalDate akhir = LocalDate.now().plusMonths(plan.getMonths());
        Member m = new Member(username, password, namaLengkap, akhir);
        members.put(username, m);
        return m;
    }

    public Member login(String username, String password) {
        Member m = members.get(username);
        if (m == null || !m.checkPassword(password)) {
            throw new IllegalArgumentException("Username atau password salah");
        }
        return m;
    }

    public void extendMembership(Member member, MembershipPlan plan) {
        LocalDate start = member.getMembershipAkhir();
        if (start.isBefore(LocalDate.now())) {
            start = LocalDate.now();
        }
        member.setMembershipAkhir(start.plusMonths(plan.getMonths()));
    }

    public Map<String, Member> getMembers() {
        return members;
    }
}
