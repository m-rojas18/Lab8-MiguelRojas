package lab8_miguelrojas;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class Hilo_ProgressBarCrear_Mod_Guardar extends Thread {

    public JProgressBar barra;
    public JLabel etiqueta;
    public boolean empezar = true;
    public JDialog dialogo;
    public int identificador;
    public JFrame frame;

    //Constructor para caso crear, modificar y guardar
    public Hilo_ProgressBarCrear_Mod_Guardar(JProgressBar barra, JLabel etiqueta, JDialog dialogo, int identificador) {
        this.barra = barra;
        this.etiqueta = etiqueta;
        this.dialogo = dialogo;
        this.identificador = identificador;
    }

    public Hilo_ProgressBarCrear_Mod_Guardar(JProgressBar barra, JLabel etiqueta, JDialog dialogo, int identificador, JFrame frame) {
        this.barra = barra;
        this.etiqueta = etiqueta;
        this.dialogo = dialogo;
        this.identificador = identificador;
        this.frame = frame;
    }

    
    
    
    
    @Override
    public void run() {

        switch (identificador) {
            case 0:
                //Identificador de Crear
                while (empezar) {
                    if (barra.getValue() < barra.getMaximum()) {
                        barra.setValue(barra.getValue() + 10);
                        etiqueta.setText("Creando Ser Vivo...");
                    } else {
                        etiqueta.setText("Ser Vivo creado!!");
                        JOptionPane.showMessageDialog(dialogo, "Se creo exitosamente el ser vivo y se logro agregar al universo!!");
                        barra.setValue(0);
                        dialogo.dispose();
                        empezar = false;
                    }
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }   break;
            case 1:
                //Identificador de Modificar
                while (empezar) {
                    if (barra.getValue() < barra.getMaximum()) {
                        barra.setValue(barra.getValue() + 10);
                        etiqueta.setText("Modificando Ser Vivo...");
                    } else {
                        etiqueta.setText("Ser Vivo Modificado !!");
                        JOptionPane.showMessageDialog(dialogo, "Se modifico  exitosamente el ser vivo.");
                        barra.setValue(0);
                        dialogo.dispose();
                        empezar = false;
                    }
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }   break;
            default:
                while (empezar) {
                    if (barra.getValue() < barra.getMaximum()) {
                        barra.setValue(barra.getValue() + 15);
                        etiqueta.setText("Guardando Universo...");
                    } else {
                        etiqueta.setText("Se guardo el univeros!!");
                        dialogo.dispose();
                        barra.setValue(0);
                        JOptionPane.showMessageDialog(frame, "Se guardo el universo exitosamente.");
                        empezar = false;
                    }
                    
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                    }
                }   break;
        }

    }

}
