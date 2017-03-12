import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Juan Pablo Merck
 */
public class TiposDesarrolladores {
    //atributos
    //tipos de desarrolladores java, web, celulares
    private Set<String> Javas = null;
    private Set<String> webs = null;
    private Set<String> celu = null;
    private Set<String> conjunto1 = null;
    private Set<String> conjunto2 = null;
    private Set<String> conjunto3 = null;
    private Set<String> conjunto4 = null;
    private Set<String> conjunto5 = null;
    private Set<String> conjunto6 = null;
    private String ConjuntoNombre;
    private String categoria;
    private Factory miFac = new Factory();
    //tipo de implementacion y nombre de los deasorradores 
    private int resp;
    private String nombre;
    private String TodosNombre;
    private Boolean sub;
    private String contesta;
    private int id;
    private int veri;
    
    public TiposDesarrolladores(){
        //menu para escoger los tipos de implementacion
        do{
            resp = Integer.parseInt(JOptionPane.showInputDialog("Escoja el tipo de implementacion:\n1. Treeset\n2. LinkedHashSet\n3. HashSet"));
            veri = resp;
        }while(resp<0 && resp>4);
            Javas = miFac.miSet(resp);
            webs = miFac.miSet(resp);
            celu = miFac.miSet(resp);
            conjunto1 = miFac.miSet(resp);
            conjunto2 = miFac.miSet(resp);
            conjunto3 = miFac.miSet(resp);
            conjunto4 = miFac.miSet(resp);
            conjunto5 = miFac.miSet(resp);
            conjunto6 = miFac.miSet(resp);
        
    }
    
    public void registroDesa(){
        //ingreso a los tipos de listas donde iran almacenados los usuarios
        do{
            nombre = JOptionPane.showInputDialog("Nombre por favor:\n");
            //identificando a cada tipo de desarrollador
            //desarrollo de apps
            id = JOptionPane.showConfirmDialog(null, "Tiene experiencia en desarrolo de apps?\n");
            if(id==0){
                celu.add(nombre);
            }
            //desarrolladores java
            id =JOptionPane.showConfirmDialog(null, "Tiene experiencia en JAVA");
            if(id==0){
                Javas.add(nombre);
            }
            //dearrollador web
            id =JOptionPane.showConfirmDialog(null, "Tiene experiencia en desarrollo web");
            if(id==0){
                webs.add(nombre);
            }
            
            //agergar otro usuario
            resp=JOptionPane.showConfirmDialog(null, "Quiere agregar a otro?\n");
        }while(resp!=1);
    }
    //ordena y obtiene los resultados de como esta la destribucion de desarrolladores java, web y de apps
    public void ordenamiento(){
        //conjunto 1:conocen de los 3 ambitos
        conjunto1.addAll(celu);
        conjunto1.addAll(Javas);
        conjunto1.addAll(webs);
        System.out.print("La cantidad de desarrolladores que saben de las 3 son: "+conjunto1);
        
        //conocen de java y desarrollo de apps pero no web
        conjunto2.addAll(Javas);
        conjunto2.addAll(celu);
        conjunto2.removeAll(webs);
        System.out.println("la cantidad de desarrolladores que no saben web: "+conjunto2);
        
        //conocecen 2 ambitos web y apps pero no java
        conjunto3.addAll(webs);
        conjunto3.retainAll(celu);
        conjunto3.removeAll(Javas);
        System.out.println("la cantidad de desarrolladores que no saben java: "+conjunto3);
        
        //conocecen 1 ambitos java perp no apps y web
        conjunto4.addAll(Javas);
        conjunto4.removeAll(webs);
        conjunto4.removeAll(celu);
        System.out.println("la cantidad de desarrolladores que no saben web: "+conjunto2);
        
        sub = webs.containsAll(Javas);
        if(sub == true){
            contesta ="Si";
        }else{
            contesta="no";
        }
        
        if(celu.size()>Javas.size()&& celu.size()>webs.size()){
            TodosNombre = "los dearrolladores en apps sonson los mas grandes";
            conjunto6 = celu;
        }else if(Javas.size()>celu.size()&&Javas.size()>webs.size()){
            TodosNombre = "los dearrolladores en java sonson los mas grandes";
            conjunto6 = Javas;
        }else if(webs.size()>Javas.size()&& webs.size()>celu.size()){
            TodosNombre = "los dearrolladores en web son los mas grandes";
            conjunto6 = webs;
        }else{
            conjunto6=null;
            System.out.print("no hay un grupo mas grande que otro todo son de igual numero");
        }
        if(conjunto6!=null){
            System.out.println("el grupo mas agrande son"+TodosNombre+"\nY son\n"+conjunto6);   
        }
                    
        switch(veri){
            case 1:
                Set orden = new TreeSet(conjunto6);
                System.out.println("Lista ordenada:\n"+orden);
            break;
            case 2:
                Set orden2 = new LinkedHashSet (conjunto6);
                System.out.println("Lista ordenada:\n"+orden2);
            break;
            case 3:
                Set orden3 = new HashSet (conjunto6);
                System.out.println("Lista ordenada:\n"+orden3);
            break;
        }  
    }
}
