package lab6_miguelrojas;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.JTextArea;

public class Hilo_CargarArchivo extends Thread {

    public JProgressBar barra;
    public JTextArea text_area;
    public JLabel etiqueta;
    public Universo universo;
    public boolean empezar = true;
    public int contador = 0;
    public JFrame frame;

    public Hilo_CargarArchivo(JProgressBar barra, JTextArea text_area, JLabel etiqueta, Universo universo, JFrame frame) {
        this.barra = barra;
        this.text_area = text_area;
        this.etiqueta = etiqueta;
        this.universo = universo;
        this.frame = frame;
    }

    @Override
    public void run() {
        text_area.append("Universo: " + universo.getNombre() + "\n\n");
        while (empezar) {
            if (contador < universo.getLista_seresVivos().size()) {
                barra.setValue(barra.getValue() + 10);
                etiqueta.setText("Cargando Informacion...");
                int valor = contador + 1;
                Seres_Vivos sv = universo.getLista_seresVivos().get(contador);
                text_area.append("[" + valor +  "] " + "Nombre: " + sv.getNombre() + ", Poder: " + sv.getPoder()
                        + ", Años: " + sv.getYears() + ", Planeta: " + sv.getPlaneta_procedencia() + ", Raza: " + sv.getRaza() + "\n");
                contador++;
            } else {
                etiqueta.setText("Informacion Cargada");
                barra.setValue(0);
                JOptionPane.showMessageDialog(frame, "Se cargo el Archivo exitosamente");
                text_area.append("\n");
                empezar = false;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo_CargarArchivo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
