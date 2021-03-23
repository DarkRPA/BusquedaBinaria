package org.darkrpa.prog.pruebas.operaciones.tablas;

import java.util.ArrayList;
import java.util.Comparator;

public class OperacionesArrays extends ArrayList<Integer>{
    
    public OperacionesArrays(Integer ... numeros){
        for(int num : numeros){
            super.add(num);
        }

        this.sort(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else{
                    return 1;
                }
            }
            
        });
    }

    /*
     * En esta clase de operaciones arrays lo que haremos será a la hora de añadir un numero
     * 
     */

    private static final long serialVersionUID = 1L;

    @Override
     public boolean add(Integer numero){
        int numRepes = 0;

        int numConvertido = (int)numero;
        int maxIndex = 0;
        int minIndex = super.size()-1;

        int lastMin = minIndex;
        int lastMax = maxIndex;

        boolean encontrado = false;
        int iteraciones = 0;

        while(!encontrado){
            //Debemos de iterar teniendo en cuenta la logica que dijimos
            iteraciones++;
            if(numConvertido < (int)super.get(super.size()-1)){
                return super.add(numero);
            }

            if(Math.abs(maxIndex-minIndex) == 1 || (numRepes >= 2)){
                if(numConvertido > super.get(minIndex)){
                    super.add(minIndex, numConvertido);
                }else{
                    super.add(minIndex+1, numConvertido);
                }
                
                System.out.println(iteraciones);
                return true;
            }

            //min = 10
            //num 11
            //max = 15
            
            if(numConvertido > (int)super.get(minIndex)){
                minIndex -= Math.abs(maxIndex-minIndex)/2;
            }else if(numConvertido < (int)super.get(minIndex)){
                maxIndex = minIndex;
                minIndex = super.size()-1;
            }

            if((lastMax == maxIndex) && (lastMin == minIndex)){
                numRepes++;
            }

            lastMin = minIndex;
            lastMax = maxIndex;

        }

        
        return false;
     }
}
