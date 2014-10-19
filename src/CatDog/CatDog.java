package CatDog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

//Still needs work
public class CatDog {

    public static void main(String[] args) {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        try {

            int numberOfTestCases = Integer.parseInt(in.readLine());

            for (int i = 0; i < numberOfTestCases; i++) {

                Map<String, Integer> petToKeep = new HashMap<String, Integer>();
                Map<String, Integer> petToThrow = new HashMap<String, Integer>();
                st = new StringTokenizer(in.readLine());
                int cats = Integer.parseInt(st.nextToken());
                int dogs = Integer.parseInt(st.nextToken());
                int voters = Integer.parseInt(st.nextToken());

                for (int z = 0; z < voters; z++) {
                    st = new StringTokenizer(in.readLine());
                    String petToKeepToken = st.nextToken();
                    String petToThrowToken = st.nextToken();

                    if (petToKeep.containsKey(petToKeepToken)) {
                        petToKeep.put(petToKeepToken, petToKeep.get(petToKeepToken) + 1);
                    } else {
                        petToKeep.put(petToKeepToken, 1);
                    }

                    if (petToThrow.containsKey(petToThrowToken)) {
                        petToThrow.put(petToThrowToken, petToThrow.get(petToThrowToken) + 1);
                    } else {
                        petToThrow.put(petToThrowToken, 1);
                    }

//                    System.out.println(petToKeepToken+" "+petToKeep.get(petToKeepToken));
//                    System.out.println(petToThrowToken+" "+petToThrow.get(petToThrowToken));

                }

//                out.write(Math.max(Collections.max(petToKeep.values()),Collections.max(petToThrow.values())));
//                out.newLine();
//                out.flush();
                System.out.println(Math.max(Collections.max(petToKeep.values()),Collections.max(petToThrow.values())));
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
