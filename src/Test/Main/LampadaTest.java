package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LampadaTest {

    @Test
    void lampON() {
        Lampada l = new Lampada(0, 0);
        l.lampON();
        assertEquals(1, l.getEstado(), "Estado errado!");
    }

    @Test
    void lampOFF() {
        Lampada l = new Lampada();
        l.setEstado(1);
        l.lampOFF();
        assertEquals(0, l.getEstado(), "Estado errado!");
    }

    @Test
    void lampECO() {
        Lampada l = new Lampada();
        l.setEstado(0);
        l.lampECO();
        assertEquals(2, l.getEstado(), "Estado errado!");
    }

    @Test
    void totalConsumo() {
        Lampada l = new Lampada();
        l.setEstado(2);
        System.out.println(l.totalConsumo());
    }

    @Test
    void periodoConsumo() {
        Lampada l = new Lampada();
        l.setEstado(1);
        System.out.println(l.periodoConsumo());
    }
}