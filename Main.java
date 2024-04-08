import java.util.Random;
import java.util.Scanner;
import static java.lang.Math.*;

public class Main {

    private static final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!\"#$%&'";
    private static int A;

    public static void main(String[] args) {

        System.out.print("Введите мощность алфавита: ");
        Scanner in = new Scanner(System.in);
        A = in.nextInt();

        if (A >= 2 && A <= 69){
            double P = pow(10, -4);
            double V = 100;
            double T = 12;
            String new_alpha = alpha.substring(0, A);
            System.out.println("Ваш пароль: " + generateAlpha(P, V, T, new_alpha));
        } else System.out.println("Недопустимый размер");
    }

    public static String generateAlpha(double P, double V, double T, String new_alpha){

        double T_minutes = T * 24 * 60;
        double S = T_minutes * V;
        double S_low_border = (S * T_minutes) / P;
        int length = (int) ceil(log(S_low_border) / log(A));

        StringBuilder strBuilder = new StringBuilder();
        Random rnd = new Random();
        for (int i = 0; i < length; ++i){
            char randomChar = new_alpha.charAt(rnd.nextInt(new_alpha.length()));
            strBuilder.append(randomChar);
        }
        String str;
        return str = strBuilder.toString();
    }
}