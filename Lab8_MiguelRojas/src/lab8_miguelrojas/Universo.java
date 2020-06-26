package lab8_miguelrojas;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Universo {

    private String nombre;
    private ArrayList<Seres_Vivos> lista_seresVivos = new ArrayList();
    private File archivo = null;

    public Universo() {

    }

    public Universo(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public Seres_Vivos getSerVivo(int p) {
        return this.lista_seresVivos.get(p);
    }

    public ArrayList<Seres_Vivos> getLista_seresVivos() {
        return lista_seresVivos;
    }

    public void setSerVivo(Seres_Vivos sv) {
        this.lista_seresVivos.add(sv);
    }

    public void setLista_seresVivos(ArrayList<Seres_Vivos> lista_seresVivos) {
        this.lista_seresVivos = lista_seresVivos;
    }

    @Override
    public String toString() {
        return nombre;
    }

    //Metodos Administrativos
    public void escribirArchivo(String url) throws IOException {

        FileWriter fw = null;
        BufferedWriter bw = null;

        try {
            fw = new FileWriter(url);
            bw = new BufferedWriter(fw);

            for (Seres_Vivos sv : lista_seresVivos) {
                bw.write(sv.getNombre() + "|");
                bw.write(sv.getPoder() + "|");
                bw.write(sv.getYears() + "|");
                bw.write(sv.getPlaneta_procedencia() + "|");
                bw.write(sv.getRaza() + "|");
            }
            bw.flush();
        } catch (Exception e) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo2(String ubicacion) {
        
        Scanner sc1 = null;
        lista_seresVivos = new ArrayList();
        // Scanner sc2 = null;
        try {
            archivo = new File(ubicacion);
            sc1 = new Scanner(archivo);
            sc1.useDelimiter("\\|");
            while (sc1.hasNext()) {
                String name = sc1.next();
                //System.out.println("name: " + name);
                
                int poder = sc1.nextInt();
                //System.out.println("poder: " + poder);
                
                int edad = sc1.nextInt();
                //System.out.println("edad: " + edad);
                
                String planeta = sc1.next();
                //System.out.println("planeta: " + planeta);
                
                String raza = sc1.next();
                //System.out.println("raza: " + raza);
                
                // crear la instancia de la clase
                Seres_Vivos sv = new Seres_Vivos(name, poder, edad, planeta, raza);
                lista_seresVivos.add(sv);

            }
        } catch (Exception e) {
        } finally {
            sc1.close();
            // sc2.close();
        }
        
    }
}
