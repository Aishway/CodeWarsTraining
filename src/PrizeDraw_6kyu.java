import java.util.*;

public class PrizeDraw_6kyu {
    // To participate in a prize draw each one gives his/her firstname.
    //
    //Each letter of a firstname has a value which is its rank in the English alphabet. A and a have rank 1, B and b rank 2 and so on.
    //
    //The length of the firstname is added to the sum of these ranks hence a number som.
    //
    //An array of random weights is linked to the firstnames and each som is multiplied by its corresponding weight to get what they call a winning number.
    //
    //Example:
    //names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
    //weights: [1, 4, 4, 5, 2, 1]
    //
    //PauL -> som = length of firstname + 16 + 1 + 21 + 12 = 4 + 50 -> 54
    //The *weight* associated with PauL is 2 so PauL's *winning number* is 54 * 2 = 108.
    //Now one can sort the firstnames in decreasing order of the winning numbers. When two people have the same winning number sort them alphabetically by their firstnames.
    //
    //Task:
    //parameters: st a string of firstnames, we an array of weights, n a rank
    //
    //return: the firstname of the participant whose rank is n (ranks are numbered from 1)
    //
    //Example:
    //names: "COLIN,AMANDBA,AMANDAB,CAROL,PauL,JOSEPH"
    //weights: [1, 4, 4, 5, 2, 1]
    //n: 4
    //
    //The function should return: "PauL"
    //Notes:
    //The weight array is at least as long as the number of names, it may be longer.
    //
    //If st is empty return "No participants".
    //
    //If n is greater than the number of participants then return "Not enough participants".
    //
    //See Examples Test Cases for more examples.

    public static void main(String[] args) {
        System.out.println(nthRank("Addison,Jayden,Sofia,Michael,Andrew,Lily,Benjamin", new Integer[]{4, 2, 1, 4, 3, 1, 2}, 4));
        System.out.println(nthRank("Elijah,Chloe,Elizabeth,Matthew,Natalie,Jayden", new Integer[]{1, 3, 5, 5, 3, 6}, 2));
        System.out.println(nthRank("William, Willaim, Olivia, Olivai, Lily, Lyli", new Integer[]{1, 1, 1, 1, 1, 1}, 2));

    }

    public static String nthRank(String st, Integer[] we, int n) {

        if (st == "") {
            return "No participants";
        }

        String[] namesArray = st.replace(" ", "").split(",");

        if (n > we.length) {
            return "Not enough participants";
        }

        HashMap<String, Integer> namesToMap = new HashMap<>();

        for (int i = 0; i < namesArray.length; i++) {
            int count = 0;
            char[] charArray = namesArray[i].toCharArray();
            for (int j = 0; j < charArray.length; j++) {
                charArray[j] = Character.toLowerCase(charArray[j]);
                count += ((int) charArray[j] - 96);
            }
            count = (count + namesArray[i].length()) * we[i];
            namesToMap.put(namesArray[i], count);
            count = 0;
        }

        return (String) namesToMap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey)
                .toArray()[n - 1];
    }
}


