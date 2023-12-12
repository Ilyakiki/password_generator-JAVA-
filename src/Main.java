import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static char[] setup(boolean using_symbols, boolean using_nums, boolean using_big) {
        String USING_SYMBOLS = "";
        String ENG_MINI = "abcdefghijklmnopqrstuvwxyz";
        USING_SYMBOLS += ENG_MINI;
        if (using_symbols == true) {
            String SYMBOLS = "!@#$%^&*";
            USING_SYMBOLS += SYMBOLS;
        }
        if (using_nums==true){
            String NUMS="0123456789";
            USING_SYMBOLS += NUMS;
        }
        if (using_big==true) {
            String ENG_BIG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            USING_SYMBOLS += ENG_BIG;
        }
        return USING_SYMBOLS.toCharArray();
    }
    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public static void main(String[] args) {
        Date date1 = new Date();
        System.out.println(date1.getTime());
        int min = 10000;
        int max = 1000000;
        int symbols_num = rnd(min, max);
        char[] SYMBOLS = setup(true, true, true);
        char[] password = new char[symbols_num];
        char alfa;
        for (int i = 0; i < symbols_num; i++) {
            int n = rnd(0, SYMBOLS.length - 1);
            alfa = SYMBOLS[n];
            password[i] = alfa;
        }
        //System.out.println(password);
        Date date2 = new Date();
        System.out.println(date2.getTime());
        System.out.println(date2.getTime()-date1.getTime());
    }
}