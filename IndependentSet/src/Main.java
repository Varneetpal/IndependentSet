import java.lang.reflect.Array;
import java.util.*;

public class Main {
    ArrayList<Integer> cost = new ArrayList<>();


    public int findMaximalSet(ArrayList<Integer> givenSet){
        if (givenSet.size() == 0){
            return 0;
        }
        if (givenSet.size()==1){
            return givenSet.get(0);
        }

        cost.add(givenSet.get(0));
        if (givenSet.get(0) < givenSet.get(1)){
            cost.add(givenSet.get(1));
        } else{
            cost.add(givenSet.get(0));
        }
        for (int i = 2; i < givenSet.size(); i++){
            if ((cost.get(i-2)+givenSet.get(i)) >= cost.get(i-1)){
                cost.add(cost.get(i-2)+givenSet.get(i));


            } else{
                cost.add(cost.get(i-1));

            }
        }



        return cost.get(cost.size()-1);
    }



    public String findSequence(ArrayList<Integer> cost, ArrayList<Integer> givenSet){
        String s = "";
        if (cost.get(0) == cost.get(1)){
            for (int i = 0; i<cost.size()-1; i+=2){
                if (cost.get(i+1) == cost.get(i)){
                    s = s + givenSet.get(i).toString()+'.';

                } else{
                    s = s+".";
                    s = s + givenSet.get(i+1).toString();
                }
            }
        }
        else{
            s +=givenSet.get(0).toString();
            for (int i = 1; i<cost.size()-1; i+=2){
                if (cost.get(i+1) == cost.get(i)){
                    s = s + givenSet.get(i).toString()+'.';

                } else{
                    s = s+".";
                    s = s + givenSet.get(i+1).toString();
                }
            }
        }
        s=s+'=';
        s=s+cost.get(cost.size()-1).toString();
        return s;
    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Integer> givenSet = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int weight = scanner.nextInt();
            givenSet.add(weight);
        }

        scanner.close();

        Main m = new Main();
        System.out.println(m.findMaximalSet(givenSet));
        System.out.println(m.findSequence(m.cost, givenSet));

    }



}