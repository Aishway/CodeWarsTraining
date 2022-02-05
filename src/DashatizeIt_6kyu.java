public class DashatizeIt_6kyu {
    // Given a variable n,
    //
    //If n is an integer, Return a string with dash'-'marks before and after each odd integer, but do not begin or
    // end the string with a dash mark. If n is negative, then the negative sign should be removed.
    //
    //If n is not an integer, return an empty value.

    public static void main(String[] args) {
        System.out.println(dashatize(274));
        System.out.println(dashatize(5311));
        System.out.println(dashatize(86320));
        System.out.println(dashatize(974302));
    }

    public static String dashatize(int num) {
        String s = String.valueOf(num);
        s = s.replaceAll("([13579])", "-$1-").replaceAll("--","-");

        if (s.charAt(0) == '-'){
            s =s.substring(1);
        }

        if (s.charAt(s.length()-1) == '-'){
            s =s.substring(0,s.length()-1);
        }

        return s;
    }
}
