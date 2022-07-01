package Main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinhaEcomendaTest {

    @Test
    void calculaValorLinhaEnc() {
        LinhaEcomenda l = new LinhaEcomenda();
        l.setPrecoAImp(20);
        l.setDescontoAImp(20);
        l.setImposto(23);
        l.setQuantidadeEnc(3);
        assertEquals(59.04, l.calculaValorLinhaEnc(), "Valor de encomenda errado!");
    }

    @Test
    void calculaValorDesconto() {
        LinhaEcomenda l = new LinhaEcomenda();
        l.setPrecoAImp(20);
        l.setDescontoAImp(20);
        l.setQuantidadeEnc(3);
        assertEquals(12, l.calculaValorDesconto(), "Valor de encomenda errado!");
    }
}