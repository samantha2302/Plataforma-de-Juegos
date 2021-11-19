package Archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import javax.swing.JLabel;

/**
 *
 * @author Sam
 */
public class DataImpicccato {
    
    // Atributos
    String nombre;
    int puntaje;
    
    // Archivo
    File PuntajeImpiccato = new File("impiccato.txt");
    DataImpicccato objeto = null;
    ArrayList<DataImpicccato> archivoData = new ArrayList<DataImpicccato>();
    
    int numeros[];
    
    public DataImpicccato(String n, int p){
        this.nombre = n;
        this.puntaje = p;
    }
    
    public DataImpicccato(){
    }
    
    
    // Get
    public String getNombre() {
        return this.nombre;
    }
    
    public int getPuntaje() {
        return this.puntaje;
    }
    
    // Set
    public String setNombre(String n) {
        return nombre = n;
    }
    public int setPuntaje(int p) {
        return puntaje = p;
    }
    
    // Metodo para comprobar el archivo
    public void comprobarArchivo(){
        try{
            if (!PuntajeImpiccato.exists()) {
                PuntajeImpiccato.createNewFile();
                //System.out.println("Base de datos de productos creada se insertara el producto");
            }else{
                //System.out.println("La base de datos de productos existe");
            }
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    // Metodo para insertar informacion en el archivo.
    public void usuario(String n, int p){
      try{
            this.nombre = n;
            this.puntaje = p;
            BufferedWriter escribirUsuario = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(PuntajeImpiccato, true), "utf-8"));
            escribirUsuario.write(getNombre() + "\t" + getPuntaje() + "\n");
            escribirUsuario.close();
            
            
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    public void txtAObjeto(){
        try{
            String linea;
            BufferedReader leerArchivo = new BufferedReader(new FileReader(PuntajeImpiccato));
            while((linea = leerArchivo.readLine()) != null){
                
                StringTokenizer mistokens = new StringTokenizer(linea, "\t");
                String nombreJugador = mistokens.nextToken().trim();
                String puntajeJugador = mistokens.nextToken().trim();
                
                
                int puntajeJ = Integer.parseInt(puntajeJugador);
                
                objeto = new DataImpicccato(nombreJugador, puntajeJ);
                boolean add = archivoData.add(objeto);
            }
            leerArchivo.close();
          
        }catch(Exception ex){
             System.out.println(ex.getMessage());
        }
    }
    
    public void MostrarObjetos(JLabel lbs) {
        if (archivoData.size() == 0) {
            txtAObjeto();
        }
        for (DataImpicccato n : archivoData) {
            if(n.getPuntaje() < 0 || n.getPuntaje() >= 0){
                lbs.setText("Nombre: " + n.getNombre() + " " + " " +" " +" " + " Puntaje: " + n.getPuntaje()); 
            }else{
                if(n.getPuntaje() >= 15){
                    lbs.setText("Nombre: " + n.getNombre() + " " + " " +" " +" " + " Puntaje: " + n.getPuntaje());
                }else{
                    if(n.getPuntaje() >= 25){
                        lbs.setText("Nombre: " + n.getNombre() + " " + " " +" " +" " + " Puntaje: " + n.getPuntaje());
                    }else{
                        if(n.getPuntaje() >= 35){
                            lbs.setText("Nombre: " + n.getNombre() + " " + " " +" " +" " + " Puntaje: " + n.getPuntaje());
                        }else{
                            if(n.getPuntaje() >= 50){
                                lbs.setText("Nombre: " + n.getNombre() + " " + " " +" " +" " + " Puntaje: " + n.getPuntaje());
                            }
                        }
                    }
                }
            }
        }
    }
}
