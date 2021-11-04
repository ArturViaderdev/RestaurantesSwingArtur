/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Code;

import com.arturviader.restaurantesswingartur.Data.Memoria;
import com.arturviader.restaurantesswingartur.Data.Plato;
import com.arturviader.restaurantesswingartur.Data.Restaurante;
import com.arturviader.restaurantesswingartur.Data.User;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Clase que almacena métodos
 * @author arturviadermataix
 */
public class Metodos {
    /**
     * Añade un restaurante al archivo de restaurantes
     * @param restauranteanade 
     */
    public static void anadeaarchivoRestaurante(Restaurante restauranteanade) {
        BufferedWriter writer = null;
        try {
            //Se configura la ruta del archivo dependiendo del deporte
            File archivo = new File("datos" + File.separator + Memoria.getInstance().getUsuario() + File.separator + "restaurantes.txt");
            writer = new BufferedWriter(new FileWriter(archivo, true));
            //se escribe el alumno en el archivo
            writer.write(crealineaRestaurante(restauranteanade));

        } catch (IOException ex) {
            //Poner mensaje
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Añade un usuario al archivo de usuarios
     * @param useranade 
     */
    public static void anadeaarchivoUsuario(User useranade) {
        BufferedWriter writer = null;
        try {
            //Se configura la ruta del archivo dependiendo del deporte
            File archivo = new File("datos" + File.separator + File.separator + "usuarios.txt");
            writer = new BufferedWriter(new FileWriter(archivo, true));
            //se escribe el alumno en el archivo
            writer.write(crealineaUser(useranade));

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Obtiene los platos que son de un restaurante concreto
     * @param platos
     * @param restaurante
     * @return 
     */
    public static ArrayList<Plato> filtraPlatosRestaurante(ArrayList<Plato> platos, String restaurante)
    {
        ArrayList<Plato> resultado = new ArrayList<>();
        for(Plato elplato:platos)
        {
            if(elplato.getRestaurante().equals(restaurante))
            {
                resultado.add(elplato);
            }
        }
        return resultado;
    }
    
    /**
     * Cambia el nombre del restaurante a todos los platos de un restaurante en cascada
     * @param nombreantiguo
     * @param nombrenuevo 
     */
    public static void actualizaRestauranteCascada(String nombreantiguo, String nombrenuevo)
    {
        ArrayList<Plato> platos = leePlatos();
        Boolean modificado = false;
        for(Plato elplato:platos)
        {
            if(elplato.getRestaurante().equals(nombreantiguo))
            {
                elplato.setRestaurante(nombrenuevo);
                modificado = true;
            }
        }
        if(modificado)
        {
            regrabaFicheroPlatos(platos);
        }   
    }
    
    /**
     * Borra todos los platos de un restaurante
     * @param restaurante 
     */
    public static void borraPlatosCascada(String restaurante)
    {
        ArrayList<Plato> platos = leePlatos();
        int cont =0;
        boolean borrado = false;
        while(cont<platos.size())
        {
              if(platos.get(cont).getRestaurante().equals(restaurante))
              {
                  platos.remove(cont);
                  borrado = true;
              }
              else
              {
                  cont++;
              }
        }
        if(borrado)
        {
            regrabaFicheroPlatos(platos);
        }
    }
    
    /**
     * Crea una linea de archivo de restaurante a partir de un restaurante
     * @param elrestaurante
     * @return 
     */
    public static String crealineaRestaurante(Restaurante elrestaurante) {
        String linea;
       
        linea = elrestaurante.getNombre() + "*" + elrestaurante.getDireccion() + "*" + elrestaurante.getPoblacion() + "*" + elrestaurante.getTelefono() + System.lineSeparator();
        return linea;
    }
    
    /**
     * Convierte usuario a linea de archivo
     * @param elusuario
     * @return 
     */
    public static String crealineaUser(User elusuario) {
        String linea;
       
        linea = elusuario.getUserName() + "*" + elusuario.getPassword() + System.lineSeparator();
        return linea;
    }

    /**
     * Añade plato a archivo de platos
     * @param platoanade 
     */
    public static void anadeaarchivoPlato(Plato platoanade) {
        BufferedWriter writer = null;
        try {
            //Se configura la ruta del archivo dependiendo del deporte
            File archivo = new File("datos" + File.separator + Memoria.getInstance().getUsuario() + File.separator + "platos.txt");
            writer = new BufferedWriter(new FileWriter(archivo, true));
            //se escribe el alumno en el archivo
            writer.write(crealineaPlato(platoanade));

        } catch (IOException ex) {
            //Poner mensaje
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Convierte una fecha a string
     * @param fecha
     * @return 
     */
    public static String fechaaString(Date fecha)
    {
        String isoDatePattern = "dd/MM/yyyy";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(isoDatePattern);
        String salida = simpleDateFormat.format(fecha);
        return salida;
    }
    
    /**
     * Crea linea de plato
     * @param elplato
     * @return 
     */
    public static String crealineaPlato(Plato elplato) {
        String linea;
        
        String dateString = fechaaString(elplato.getFecha());
        linea = elplato.getNombre() + "*" + elplato.getRestaurante() + "*" + Integer.toString(elplato.getTipo()) + "*" + Integer.toString(elplato.getPrecio()) + "*" + Integer.toString(elplato.getNota()) + "*" + dateString + System.lineSeparator();
        return linea;
    }
    
    
    /**
     * Convierte linea a restaurante
     * @param linea
     * @return 
     */
     private static Restaurante interpretaLineaRestaurante(String linea) {
        String[] datos;
        datos = linea.split("\\*");
        //Divide los campos en un array de string
      
        //Crea el objeto alumno con los datos y lo añade a la lista en memoria.
        Restaurante restaurante = new Restaurante(datos[0],datos[1],datos[2],datos[3]);
        return restaurante;
    }

    /**
     * Lee todos los restaurantes
     * @return 
     */
    public static ArrayList<Restaurante> leeRestaurantes() {
        File archivo;
        BufferedReader lector;
        String linea;
        ArrayList<Restaurante> resultado = new ArrayList<>();
                 
            archivo = new File("datos" + File.separator + Memoria.getInstance().getUsuario() + File.separator + "restaurantes.txt");
            try {
                lector = new BufferedReader(new FileReader(archivo));
                try {
                    do {
                        linea = lector.readLine();
                        if (linea != null) {
                           resultado.add(interpretaLineaRestaurante(linea));
                        }
                    } while (linea != null);
                    
                } catch (IOException ex) {
               
                }
                finally
                {
                    try
                    {
                        lector.close();                    
                    }
                    catch(IOException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Error leyendo archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            } catch (FileNotFoundException ex) {
               
            }
            return resultado;
    }

    /**
     * Muestra el tipo según su número
     * @param tipo
     * @return 
     */
    public static String dimetipo(int tipo)
    {
        if(tipo==0)
        {
            return "ENTRANTE";
        }
        else if(tipo==1)
        {
            return"SEGUNDO";
        }
        else if(tipo==2)
        {
            return"POSTRE";
        }
        else
        {
            return"";
            //POdria lanzar excepcion        
        }
        //Pendiente probar enum
    }
    
    /**
     * Lee una linea del archivo platos y la convierte en plato
     * @param linea
     * @return
     * @throws ParseException 
     */
    private static Plato interpretaLineaPlato(String linea) throws ParseException {
        String[] datos;
        datos = linea.split("\\*");
        //Divide los campos en un array de string
      
        //Crea el objeto alumno con los datos y lo añade a la lista en memoria.
    
        Plato plato = new Plato(datos[0],datos[1],Integer.parseInt(datos[2]),Integer.parseInt(datos[3]), Integer.parseInt(datos[4]), new SimpleDateFormat("dd/MM/yyyy").parse(datos[5]));
        return plato;
    }

    /**
     * Lee todos los platos
     * @return 
     */
    public static ArrayList<Plato> leePlatos() {
        File archivo;
        BufferedReader lector;
        String linea;
        ArrayList<Plato> resultado = new ArrayList<>();
                 
            archivo = new File("datos" + File.separator + Memoria.getInstance().getUsuario() + File.separator + "platos.txt");
            try {
                lector = new BufferedReader(new FileReader(archivo));
                try {
                    do {
                        linea = lector.readLine();
                        if (linea != null) {
                            try
                            {
                                resultado.add(interpretaLineaPlato(linea));
                            }
                            catch(ParseException ex)
                            {
                                 JOptionPane.showMessageDialog(null, "Error en el archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
                            }             
                        }
                    } while (linea != null);
                    
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error leyendo archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                    try
                    {
                        lector.close();                    
                    }
                    catch(IOException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Error leyendo archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
                    }
                    
                }
            } catch (FileNotFoundException ex) {
               
            }
            return resultado;
    }

    /**
     * Borra carpeta de usuario
     */
    public static void borraCarpetaUsuario(String usuario)
    {
        deleteDir(new File("datos" +  File.separator + usuario));
        
    }
    private static void deleteDir(File file) {
    File[] contents = file.listFiles();
    if (contents != null) {
        for (File f : contents) {
            deleteDir(f);
        }
    }
    file.delete();
    }
    
    /**
     * Regraba el fichero de platos desde una lista
     * @param platos 
     */
    public static void regrabaFicheroPlatos(ArrayList<Plato> platos) {
        BufferedWriter writer = null;
        boolean primero = true;
        try {
            File archivo = new File("datos" + File.separator + Memoria.getInstance().getUsuario() + File.separator + "platos.txt");
            writer = new BufferedWriter(new FileWriter(archivo, false));
            for (Plato elplato : platos) { 
                //Para cada plato se crea y escribe en el fichero una linea
                writer.write(crealineaPlato(elplato));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Regraba el fichero de usuarios
     * @param usuarios Lista de usuarios
     */
    public static void regrabaFicheroUsuarios(ArrayList<User> usuarios) {
        BufferedWriter writer = null;
        boolean primero = true;
        try {
            File archivo = new File("datos" + File.separator + "usuarios.txt");
            writer = new BufferedWriter(new FileWriter(archivo, false));
            for (User elusuario : usuarios) {         
                writer.write(crealineaUser(elusuario));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    /**
     * Regraba el fichero de restaurantes
     * @param restaurantes Los restaurantes
     */
    public static void regrabaFicheroRestaurantes(ArrayList<Restaurante> restaurantes) {
        BufferedWriter writer = null;
        boolean primero = true;
        try {
            File archivo = new File("datos" + File.separator + Memoria.getInstance().getUsuario() + File.separator + "restaurantes.txt");
            writer = new BufferedWriter(new FileWriter(archivo, false));
            for (Restaurante restaurante : restaurantes) {         
                writer.write(crealineaRestaurante(restaurante));
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                writer.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error grabando archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    /**
     * Busca un plato en una lista de platos
     * @param platos Lista
     * @param nombre Nombre del plato a buscar
     * @return Devuelve true si se encuentra
     */
    public static boolean buscaPlato(ArrayList<Plato> platos, String nombre)
    {
        boolean sal = false;
        boolean encontrado = false;
        int cont=0;
        while(!sal)
        {
            if(cont<platos.size())
            {
                if(platos.get(cont).getNombre().equals(nombre))
                {
                    encontrado = true;
                    sal = true;
                }
                else
                {
                    cont++;
                }
            }
            else
            {
                sal = true;
            }
        }
        return encontrado;
    }
    
    /**
     * Busca un restaurante en una lista
     * @param restaurantes Lista de restaurantes
     * @param nombre Nombre del restaurante a buscar
     * @return 
     */
    public static boolean buscaRestaurante(ArrayList<Restaurante> restaurantes, String nombre)
    {
        boolean sal = false;
        boolean encontrado = false;
        int cont=0;
        while(!sal)
        {
            if(cont<restaurantes.size())
            {
                if(restaurantes.get(cont).getNombre().equals(nombre))
                {
                    encontrado = true;
                    sal = true;
                }
                else
                {
                    cont++;
                }
            }
            else
            {
                sal = true;
            }
        }
        return encontrado;
    }
    
    /**
     * Busca un usuario en una lista
     * @param usuarios Lista
     * @param nombre Nombre del usuario a buscar
     * @return 
     */
    public static boolean buscaUsuario(ArrayList<User> usuarios, String nombre)
    {
        boolean sal = false;
        boolean encontrado = false;
        int cont=0;
        while(!sal)
        {
            if(cont<usuarios.size())
            {
                if(usuarios.get(cont).getUserName().equals(nombre))
                {
                    encontrado = true;
                    sal = true;
                }
                else
                {
                    cont++;
                }
            }
            else
            {
                sal = true;
            }
        }
        return encontrado;
    }
    
    /**
     * Lee lista de usuarios del archivo
     * @return Lista
     */
    public static ArrayList<User> leeUsuarios()
    {
        BufferedReader lector;
        File archivo = new File("datos" + File.separator + "usuarios.txt");
        ArrayList<User> salida = new ArrayList<>();
        String linea;
        
      
            try {
                lector = new BufferedReader(new FileReader(archivo));
                try
                {
                    do {
                    
                        linea = lector.readLine();
                        if (linea != null) {
                            salida.add(interpretalineauser(linea));
                        }
                    } while (linea != null);
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error leyendo archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
                }
                finally
                {
                    try
                    {
                        lector.close();
                    }
                    catch(IOException ex)
                    {
                        JOptionPane.showMessageDialog(null, "Error leyendo archivo.", "cuidado", JOptionPane.ERROR_MESSAGE);
                    }    
                }
         } catch (FileNotFoundException ex) {
                //Mostrar error
         }
        
         return salida;
    }
     
    /**
     * Devuelve un usuario a partir de una linea del archivo
     * @param linea
     * @return 
     */
    private static User interpretalineauser(String linea) {
        String[] datos;
        datos = linea.split("\\*");
        //Divide los campos en un array de string
      
        //Crea el objeto alumno con los datos y lo añade a la lista en memoria.
        User useranade = new User(datos[0], datos[1]);
        return useranade;
    }
}
