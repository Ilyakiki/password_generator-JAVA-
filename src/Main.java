import java.util.Date;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type show whitespaces,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static int set_length() {
        int length;
        Scanner in = new Scanner(System.in);
        try {
            length = in.nextInt();
        }
        catch (Exception e) {
            System.out.println("Введенное значение не int, будет подставлено значение 10000");
            length = 10000;
        }
        return length;
    }

    public static boolean set_bool() {
        boolean b;
        Scanner in = new Scanner(System.in);
        try {
            b = in.nextBoolean();
        } catch (Exception e) {
            System.out.println("Введенное значение не boolean, будет подставлено значение true");
            b = true;
        }
        return b;
    }

    public static void test_cases_pass(PasswordGenerator password) {
        System.out.println("Тесты");
        System.out.println("\nВо время тестов будет выведено время генерации и их длинна, сами пароли отображаться не будут\n");
        for (int i=0;i<3;i++){
            Date time1=new Date();
            int len = 10000*(int)Math.pow(10.0,i);
            password.pass_gen(len, true, true, true);
            Date time2=new Date();
            Long time_diff= time2.getTime()- time1.getTime();
            System.out.print("Длинна тестового пароля пароля ");
            System.out.printf(String.valueOf(len));
            String time_diff_str="\nЗатраченное время (в миллисекундах): ".concat(time_diff.toString()).concat("\n");
            System.out.println(time_diff_str);
        }
    }

    public static char[] gen_method_password(PasswordGenerator password) {
        System.out.println("Введите длинну желаемого пароля");
        int len = set_length();
        System.out.println("Хотите ли использовать спец символы? true - да, false - нет.");
        boolean using_symbols = set_bool();
        System.out.println("Хотите ли использовать цифры? true - да, false - нет.");
        boolean using_nums = set_bool();
        System.out.println("Хотите ли использовать верхний регистр? true - да, false - нет.");
        boolean using_big = set_bool();
        Date time1=new Date();
        char[] ready_password = password.pass_gen(len, using_symbols, using_nums, using_big);
        Date time2=new Date();
        Long time_diff= time2.getTime()- time1.getTime();
        String time_diff_str="Затраченное время (в миллисекундах): ".concat(time_diff.toString());
        System.out.println(time_diff_str);
        return ready_password;
    }

    public static void main(String[] args) {
        try {
            PasswordGenerator password_gen = new PasswordGenerator();
            test_cases_pass(password_gen);
            boolean choice = true;
            char[] pass;
            System.out.println("Генерация пароля по заданным параметрам");
            while (choice == true) {
                pass = gen_method_password(password_gen);
                System.out.println(pass);
                System.out.println("Хотите продолжить? true - да, false - нет.");
                choice = set_bool();
            }
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
    }
}