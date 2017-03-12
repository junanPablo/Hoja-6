/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Juan Pablo Merck
 */
import java.util.*;
public class Factory<E> {
    public Set<E> miSet(int TipoImp){
        
        //devuelve el TreeSet
        if(TipoImp == 1){
            return new TreeSet<E>();
        //devuelve el LinkedHashSet
        }else if(TipoImp == 2){
            return new LinkedHashSet<E>();
        //devuelve el HashSet
        }else if(TipoImp == 3){
            return new HashSet<E>();
        }else{
            //devuelve nulo si ninguna de las tres tipos de opciones fueron escogidas
            return null;
        }
    }
}
