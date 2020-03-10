package fastmoveV0_7_8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.time.LocalTime;
import java.util.Scanner;

public class FastMove {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LocalTime lt = LocalTime.of(10, 20, 8);
        System.out.println(lt.getMinute());
        
        LocalTime lt2 = LocalTime.now();
        System.out.println(lt2.getMinute());
        long lt3 = lt2.getMinute();
        System.out.println(lt.minusMinutes(lt3));
//        Vehicle vehicle =new Vehicle(1,"John");
//        Job job001=new Job(vehicle);
//        Parcel parcel01=new Parcel(0, 13.662348, 100.502370,Status.PACKED);
//        Parcel parcel02=new Parcel(1, 13.658739, 100.494089,Status.PACKED);
//        job001.add(parcel01);
//        job001.add(parcel02);
//        System.out.println(job001);
//        
//        GenericBag<Parcel> bag = new GenericBag<>(10);
//        bag.add(parcel01);
//        bag.add(parcel02);
//        
//        Iterator<Parcel> itemIter = bag.iterator();
//        while(itemIter.hasNext()) {
//            System.out.println(itemIter.next().toString());
//        }

//        Parcel[] p = new Parcel[3];
//        p[0] = new Parcel(0, 13.662348, 100.502370,Status.PACKED);
//        p[1] = new Parcel(1, 13.658739, 100.494089,Status.PACKED);
//        p[2] = new Parcel(2, 13.953593, 100.725426,Status.PACKED);
//        
//        p[0].setWeight(12.5);
//        p[1].setWeight(18.75);
//        p[2].setWeight(11);
//        
//        for (Parcel temp : p) {
//            System.out.println(temp);
//        }
//        
//        System.out.println("-----");
//        Arrays.sort(p);
//        for (Parcel temp : p) {
//            System.out.println(temp);
//        }
//        
//        System.out.println("-----");
//        Comparator weightComp = new WeightComparator();
//        Arrays.sort(p, weightComp);
//        for (Parcel temp : p) {
//            System.out.println(temp);
//        }
    }
    
}
