package edu.pradita.oop.session06;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    private MemberService service;

    @BeforeEach
    void setUp() {
        service = new MemberService();
    }

    @Test
    void testRegisterBerhasil() {
        Member m = service.register(
                "andi", "andi123", "Andi Wijaya", MembershipPlan.THREE_MONTHS);
        assertEquals("andi", m.getUsername());
        assertEquals("Andi Wijaya", m.getNamaLengkap());
        assertTrue(m.isActive(LocalDate.now()));
    }

    @Test
    void testRegisterUsernameDuplikat() {
        service.register("cici", "cici123", "Cici", MembershipPlan.THREE_MONTHS);
        assertThrows(IllegalArgumentException.class,
                () -> service.register("cici", "xxx", "Cici 2",
                        MembershipPlan.SIX_MONTHS));
    }

    @Test
    void testLoginBerhasil() {
        service.register("doni", "doni123", "Doni", MembershipPlan.THREE_MONTHS);
        Member m = service.login("doni", "doni123");
        assertEquals("Doni", m.getNamaLengkap());
    }

    @Test
    void testLoginPasswordSalah() {
        service.register("eka", "eka123", "Eka", MembershipPlan.THREE_MONTHS);
        assertThrows(IllegalArgumentException.class,
                () -> service.login("eka", "salah"));
    }

    @Test
    void testLoginUsernameTidakAda() {
        assertThrows(IllegalArgumentException.class,
                () -> service.login("gaada", "xxx"));
    }

    @Test
    void testPerpanjangMembership() {
        Member m = service.register(
                "fani", "fani123", "Fani", MembershipPlan.THREE_MONTHS);
        LocalDate oldEnd = m.getMembershipAkhir();
        service.extendMembership(m, MembershipPlan.THREE_MONTHS);
        assertEquals(oldEnd.plusMonths(3), m.getMembershipAkhir());
    }

    @Test
    void testMembershipPlanHarga() {
        assertEquals(300_000, MembershipPlan.THREE_MONTHS.getPriceIdr());
        assertEquals(550_000, MembershipPlan.SIX_MONTHS.getPriceIdr());
        assertEquals(750_000, MembershipPlan.NINE_MONTHS.getPriceIdr());
    }

    @Test
    void testMembershipPlanBulan() {
        assertEquals(3, MembershipPlan.THREE_MONTHS.getMonths());
        assertEquals(6, MembershipPlan.SIX_MONTHS.getMonths());
        assertEquals(9, MembershipPlan.NINE_MONTHS.getMonths());
    }
}
