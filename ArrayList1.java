import java.util.ArrayList;
import java.util.Collections;


public class ArrayList1 {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        //add element
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);

        //to get an element
        int element = list.get(3);
        System.out.println(element);

        //add element in between
        list.add(1,2); 
        System.out.println(list);

        //set element
        list.set(0, 0);
        System.out.println(list);

        //delete element
        list.remove(0); 
        System.out.println(list);

        //size of list
        int size = list.size();
        System.out.println(size);

        //loops on lists
        for(int i=0; i<list.size(); i++){
            System.out.print(list.get(i));
        }
        System.out.println();


        //sorting the list
        list.add(0);
        Collections.sort(list);
        System.out.println(list);
    }


}
