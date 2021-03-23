package org.darkrpa.prog.pruebas.operaciones.tablas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

public class Prueba {
    public static void main(String[] args) {
        Random rnd = new Random(System.nanoTime());
        ArrayList<Integer> lista = new ArrayList<Integer>();
        
        for(int i = 0; i < 100; i++){
            lista.add(rnd.nextInt(100));
        }

        OperacionesArrays op = new OperacionesArrays();
        op.addAll(lista);
        op.sort(new Comparator<Integer>(){

            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1 > o2){
                    return -1;
                }else{
                    return 1;
                }
            }
            
        });

        op.add(5);

        for(int i=0; i < op.size(); i++){
            if(op.get(i) == 5){
                System.out.println("Index: "+(i-1)+" numero: "+op.get(i-1));
                System.out.println("Index: "+(i)+" numero: "+op.get(i));
                System.out.println("Index: "+(i+1)+" numero: "+op.get(i+1));
                break;
            }
        }
    }
}
