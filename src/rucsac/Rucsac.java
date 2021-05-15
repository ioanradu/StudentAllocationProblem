package rucsac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Rucsac {
    private static int capacity = 5000;
    private static int totalWeight = 0;


    public static void main(String[] args) {

       /* Things telefon = new Telefon(100, 1000);
        Things apa = new Apa(2500, 10);*/
        /*Integer phoneWeight = telefon.getWeight();
        Integer waterWeight = apa.getWeight();
*/
        List<Things> rucsacThings = new ArrayList<>();

        if(addThings(new Telefon(100, 1000))){
            rucsacThings.add(new Telefon(100, 1000));

        }
        if(addThings(new Apa(2500, 1000))){
            rucsacThings.add(new Telefon(100, 1000));

        }
        if(addThings(new Apa(2500, 1000))){
            rucsacThings.add(new Telefon(100, 1000));

        }


        System.out.println(totalWeight);

        for(Things weigth: rucsacThings){
            System.out.println(weigth.getWeight());
        }
       // System.out.println(rucsacThings.get(0).getWeight());

        //System.out.println(telefon.getGreutate());
        //totalGreutate = telefon.getGreutate() + apa.getGreutate();
        //System.out.println(totalGreutate);

        //System.out.println(rucsacList.get(0).getGreutate());

    }
    public static boolean addThings(Things things){
       int weight = things.getWeight();
       totalWeight += weight;
       if(totalWeight <= capacity){
           return true;
       }
       return false;
    }

}
