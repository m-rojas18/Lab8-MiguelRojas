package lab8_miguelrojas;

public class Seres_Vivos {

    private String nombre;
    private int poder;
    private int years;
    private String planeta_procedencia;
    private String raza;
    
    
    public Seres_Vivos(){
        
    }

    public Seres_Vivos(String nombre, int poder, int years, String planeta_procedencia, String raza) {
        this.nombre = nombre;
        this.poder = poder;
        this.years = years;
        this.planeta_procedencia = planeta_procedencia;
        this.raza = raza;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPoder() {
        return poder;
    }

    public void setPoder(int poder) {
        this.poder = poder;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public String getPlaneta_procedencia() {
        return planeta_procedencia;
    }

    public void setPlaneta_procedencia(String planeta_procedencia) {
        this.planeta_procedencia = planeta_procedencia;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    @Override
    public String toString() {
        return nombre;
    }
    
    
}
