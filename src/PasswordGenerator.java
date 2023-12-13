public class PasswordGenerator {
    public static char[] setup(boolean using_symbols, boolean using_nums, boolean using_big) {
        String USING_SYMBOLS = "";
        String ENG = "abcdefghijklmnopqrstuvwxyz";
        USING_SYMBOLS += ENG;
        if (using_symbols == true) {
            String SYMBOLS = "!@#$%^&*";
            USING_SYMBOLS += SYMBOLS;
        }
        if (using_nums == true) {
            String NUMS = "0123456789";
            USING_SYMBOLS += NUMS;
        }
        if (using_big == true) {
            USING_SYMBOLS += ENG.toUpperCase();
        }
        return USING_SYMBOLS.toCharArray();
    }

    public static char[] pass_gen(int length, boolean using_symbols, boolean using_nums, boolean using_big) {
        length = validation_int(length);
        char[] password = new char[length];
        char[] SYMBOLS = setup(using_symbols, using_nums, using_big);
        char alfa;
        for (int i = 0; i < length; i++) {
            int n = rnd(0, SYMBOLS.length - 1);
            alfa = SYMBOLS[n];
            password[i] = alfa;
        }
        return password;
    }

    public static int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static int validation_int(int value) {
        int min = 10000;
        int max = 1000000;
        if (value < min) {
            value = min;
            System.out.println("Ваше введенное значение меньше минимального, оно будет заменено на минимальное");
        } else if (value > max) {
            value = max;
            System.out.println("Ваше введенное значение больше максимального, оно будет заменено на максимальное");
        }
        return value;
    }
}
