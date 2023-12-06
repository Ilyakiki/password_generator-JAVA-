// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static String[] setup(boolean using_symbols,boolean using_english,boolean using_deutch){
        String[] USING_SYMBOLS=new String[3];
        String SYMBOLS = "!@#$%^&*";
        String ENG_BIG = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String ENG_MINI="abcdefghijklmnopqrstuvwxyz";
        USING_SYMBOLS[0]=SYMBOLS;
        USING_SYMBOLS[1]=ENG_BIG;
        USING_SYMBOLS[2]=ENG_MINI;
        return USING_SYMBOLS;
    }
    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public static void main(String[] args) {
        int min=10000;
        int max=1000000;
        int symbols_num=rnd(min,max);
        String[] SYMBOLS=setup(true,true,true);
        char[] password=new char[symbols_num];
        char[] alfa;
        char letter;
        for (int i=0;i<symbols_num;i++){
            alfa=SYMBOLS[rnd(0,SYMBOLS.length-1)].toCharArray();
            letter=alfa[rnd(0,alfa.length-1)];
            password[i]=letter;
        }
        System.out.print(password);

    }
}