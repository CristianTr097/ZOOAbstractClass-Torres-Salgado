package zoologico;

import Modelo.Supabase;
import zoologico.Animales;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;

public class Administrar_Zoo {
    
    
    public Administrar_Zoo(){
    }
    
    public JSONArray createAnimales(){
        String nombre, especie, size;
        Integer id;
        Scanner lector = new Scanner (System.in);
        System.out.println("Ingrese los datos del nuevo animal");
        System.out.println("Id");
        id=lector.nextInt();
        System.out.println("Nombre:");
        nombre=lector.next();
        System.out.println("Especie:");
        especie=lector.next();
        System.out.println("Tamaño: ");
        size=lector.next();

        JSONArray body = new JSONArray("[{ \"id\":\"" + id+ "\",\"nombre\":\"" + nombre + "\", \"especie\":\"" + especie+ "\", \"size\":\"" + size + "\"}]");
        JSONArray animalCreado = Supabase.from("animales").insert(body);
        return animalCreado;
    }
    
    public void managmentAnimales (){
        int x, CodAnimal;
        Scanner lector = new Scanner (System.in);
        String NomAnimal;
        
        do{
                        System.out.println("Usuarios");
                        System.out.println("Ingrese una de las opciones");
                        System.out.println("1.Buscar Animales");
                        System.out.println("2.Creacion de Animales");
                        System.out.println("3.Salir del menu");
                        x=lector.nextInt();
                        switch (x){
                            case 1:{
                                int y;
                                System.out.println("Ingrese su modo de busqueda");
                                System.out.println("1.Nombre");
                                System.out.println("2.Codigo");
                                y=lector.nextInt();
                                switch (y){
                                    case 1:{
                                        System.out.println("Ingresa el nombre del ususario a buscar: ");
                                        NomAnimal=lector.next();
                                        JSONArray findAnimal = Supabase.from("animales").selecteq("*", "nombre", NomAnimal);
                                        System.out.println(findAnimal.toString());
                                    }
                                        
                                    case 2:{
                                        System.out.println("Ingresa el numero de identificacion del ususario a buscar: ");
                                        CodAnimal=lector.nextInt();
                                        JSONArray findAnimal = Supabase.from("animales").selecteq("*", "id", CodAnimal);
                                        System.out.println(findAnimal.toString());
                                    }
                                     
                                        
                                    default :{
                                        System.out.println("Opcion no valida");
                                    }
                                }
                            }
                            
                            
                            case 2:{
                                JSONArray newUser = createAnimales();
                                System.out.println(newUser.toString());
                            }
                            
                            case 3:{
                                System.out.println("cerrando programa \n");
                            }
                               
                            default :{
                                System.out.println("Opcion no valida");
                            }
                        }
                    }while(x!=3);

    }
}
