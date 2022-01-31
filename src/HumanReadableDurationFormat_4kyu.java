import javax.sound.midi.Soundbank;

public class HumanReadableDurationFormat_4kyu {
    // Your task in order to complete this Kata is to write a function which formats a duration, given as a number
    // of seconds, in a human-friendly way.
    //
    //The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration
    // is expressed as a combination of years, days, hours, minutes and seconds.
    //
    //It is much easier to understand with an example:
    //
    //TimeFormatter.formatDuration(62)   //returns "1 minute and 2 seconds"
    //TimeFormatter.formatDuration(3662) //returns "1 hour, 1 minute and 2 seconds"
    //For the purpose of this Kata, a year is 365 days and a day is 24 hours.
    //
    //Note that spaces are important.
    //
    //Detailed rules
    //The resulting expression is made of components like 4 seconds, 1 year, etc. In general, a positive integer and
    // one of the valid units of time, separated by a space. The unit of time is used in plural if the integer is greater than 1.
    //
    //The components are separated by a comma and a space (", "). Except the last component, which is separated by
    // " and ", just like it would be written in English.
    //
    //A more significant units of time will occur before than a least significant one. Therefore, 1 second and 1 year
    // is not correct, but 1 year and 1 second is.
    //
    //Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
    //
    //A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid,
    // but it should be just 1 minute.
    //
    //A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but
    // 1 minute and 1 second instead. Formally, the duration specified by of a component must not be greater than any
    // valid more significant unit of time.

    //******************************
    // year 31 556 926 seconds
    // day 86 400 seconds
    // hour 3600 seconds


    public static void main(String[] args) {
        System.out.println(formatDuration(1));
        System.out.println(formatDuration(62));
        System.out.println(formatDuration(120));
        System.out.println(formatDuration(3600));
        System.out.println(formatDuration(3662));
        System.out.println(formatDuration(132030240));
    }

    public static String formatDuration(int seconds) {

        if (seconds <= 0) {
            return "now";
        }
        int a = seconds;

        int[] timeFormat = new int[5];
        timeFormat[0] = seconds / 31536000;
        timeFormat[1] = (seconds / 86400) % 365;
        timeFormat[2] = (seconds / 3600) % 24;
        timeFormat[3] = (seconds / 60) % 60;
        timeFormat[4] = (seconds % 3600) % 60;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < timeFormat.length; i++) {
            switch (i) {
                case 0:
                    if (timeFormat[i] > 1) {
                        sb.append(timeFormat[i] + " years, ");
                    } else if (timeFormat[i] == 1) {
                        sb.append(timeFormat[i] + " year, ");
                    }
                    break;
                case 1:
                    if (timeFormat[i] > 1) {
                        sb.append(timeFormat[i] + " days, ");
                    } else if (timeFormat[i] == 1) {
                        sb.append(timeFormat[i] + " day, ");
                    }
                    break;
                case 2:
                    if (timeFormat[i] > 1) {
                        sb.append(timeFormat[i] + " hours, ");
                    } else if (timeFormat[i] == 1) {
                        sb.append(timeFormat[i] + " hour, ");
                    }
                    break;
                case 3:
                    if (timeFormat[i] > 1) {
                        sb.append(timeFormat[i] + " minutes, ");
                    } else if (timeFormat[i] == 1) {
                        sb.append(timeFormat[i] + " minute, ");
                    }
                    break;
                case 4:
                    if (timeFormat[i] > 1) {
                        sb.append(timeFormat[i] + " seconds");
                    } else if (timeFormat[i] == 1) {
                        sb.append(timeFormat[i] + " second");
                    }
                    break;
            }
        }

        String time = sb.toString();

        if (time.charAt(time.length() - 2) == ',') {
            time = time.substring(0, time.length() - 2);
        }

        if (time.length() > 13) {
            int lastSeparator = time.lastIndexOf(',', time.length() - 1);
            time = time.substring(0, lastSeparator) + " and" + time.substring(lastSeparator + 1);
        }

        return time;
    }
}
