package Blackjack;

import javax.swing.JOptionPane;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

@XmlRootElement // Indica que la clase Juego será raíz en el XML
public class Juego {
    private Mano mano;

    public Juego() {
        mano = new Mano();
    }

    public Mano getMano() {
        return mano;
    }

    public void setMano(Mano mano) {
        this.mano = mano;
    }
    // Aquí empieza el programa principal. Se crea un mazo y se baraja. Se crea un juego y se pide una carta al jugador.
    public static void main(String[] args) {
        Mazo mazo = new Mazo();
        mazo.barajar();

        Juego juego = new Juego();
        // Pedir carta al jugador. Bucle
        while (true) {
            String respuesta = JOptionPane.showInputDialog(null, "¿Quiere una carta? (s/n)");

            if (respuesta != null && respuesta.equalsIgnoreCase("s")) {
                juego.mano.pedirCarta(mazo);
                JOptionPane.showMessageDialog(null, "Tu mano:\n" + juego.mano);
                if (!juego.mano.finDeJuego()) { // Cambio aquí, verificamos si el jugador se ha pasado
                    JOptionPane.showMessageDialog(null, "OOHH ! Te has pasado de 21. Has perdido.");
                    break;
                } else if (juego.mano.valorMano() == 21) {
                JOptionPane.showMessageDialog(null, "¡Felicidades! ¡Has hecho Blackjack!");
                break;
            }
                

            } else if (respuesta != null && respuesta.equalsIgnoreCase("n")) {
                JOptionPane.showMessageDialog(null, "Te plantas con una puntuación de " + juego.mano.valorMano());
                break;
            } else {
                JOptionPane.showMessageDialog(null, "Respuesta no válida. Por favor, responda 's' o 'n'.");
            }
        }
        try { // TryCatch para que se genere el archivo XML
            JAXBContext jaxbContext = JAXBContext.newInstance(Juego.class);

            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            marshaller.marshal(juego, new File("resultadosblackjack.xml"));

            System.out.println("Archivo XML generado exitosamente.");
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
