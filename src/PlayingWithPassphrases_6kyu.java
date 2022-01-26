public class PlayingWithPassphrases_6kyu {
    // Everyone knows passphrases. One can choose passphrases from poems, songs, movies names and so on but frequently they can be guessed due to common cultural references. You can get your passphrases stronger by different means. One is the following:
    //
    //choose a text in capital letters including or not digits and non alphabetic characters,
    //
    //shift each letter by a given number but the transformed letter must be a letter (circular shift),
    //replace each digit by its complement to 9,
    //keep such as non alphabetic and non digit characters,
    //downcase each letter in odd position, upcase each letter in even position (the first character is in position 0),
    //reverse the whole result.
    //Example:
    //your text: "BORN IN 2015!", shift 1
    //
    //1 + 2 + 3 -> "CPSO JO 7984!"
    //
    //4 "CpSo jO 7984!"
    //
    //5 "!4897 Oj oSpC"
    //
    //With longer passphrases it's better to have a small and easy program. Would you write it?

    public static void main(String[] args) {
        System.out.println(playPass("I LOVE YOU!!!", 1));
        System.out.println(playPass("MY GRANMA CAME FROM NY ON THE 23RD OF APRIL 2015", 2));
    }

    public static String playPass(String s, int n) {
        String[] arr = s.split("");
        String alphabeth = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].matches("^[a-zA-Z]")) {
                int alphabethMatch = alphabeth.indexOf(arr[i]) + n;
                if (alphabeth.length() <= alphabethMatch) {
                    char ch = alphabeth.charAt(alphabethMatch - alphabeth.length());
                    arr[i] = String.valueOf(ch);
                } else {
                    char ch = alphabeth.charAt(alphabethMatch);
                    arr[i] = String.valueOf(ch);
                }
            } else if (arr[i].matches("^[0-9]")) {
                int count = Integer.parseInt(arr[i]);
                int temporal = 9 - count;
                arr[i] = String.valueOf(temporal);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            char ch = arr[i].charAt(0);
            if (i % 2 == 0) {
                ch = Character.toUpperCase(ch);
                arr[i] = String.valueOf(ch);
            } else {
                ch = Character.toLowerCase(ch);
                arr[i] = String.valueOf(ch);
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

}
