package proyectoTest;

import Blackjack.Carta;
import Blackjack.Mazo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazoTest { //Test para la clase mazo

    @Test
    public void testInicializacionMazo() {
        Mazo mazo = new Mazo();
        assertNotNull(mazo.getCartas());
        assertEquals(52, mazo.getCartas().size());
    }

    @Test
    public void testSolicitarCarta() {
        Mazo mazo = new Mazo();
        Carta carta = mazo.solicitarCarta();
        assertNotNull(carta);
        assertEquals(51, mazo.getCartas().size());
    }
}
