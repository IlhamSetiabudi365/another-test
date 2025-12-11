import java.util.Random;
import java.util.Scanner;

public class vivaq2 {
    public static void main(String[] args) {
        System.out.println("|=====Hello, World!=====|");
        Scanner input = new Scanner(System.in);

        System.out.println("enter message");
        String msg = input.nextLine();

        String step1 = InsertRandom(msg);
        String step2 = ShiftOrder(step1);
        String step3 = ShiftAscii(step2);

        System.out.println("Encoded message: " + step3);
    }

    public static String InsertRandom(String str){
        String symbols = "~!@#$%^&*?";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i < str.length(); i++){
            sb.append(str.charAt(i));
            sb.append(symbols.charAt(random.nextInt(symbols.length())));
        }
        return sb.toString();
    }

    public static String ShiftOrder(String str){
        int n = str.length();
        int mid = n/2;

        if(n % 2 == 0){
            String first = new StringBuilder(str.substring(0, mid)).reverse().toString();
            String second = new StringBuilder(str.substring(mid)).reverse().toString();
            return first + second;
        }
        else{
            String first = new StringBuilder(str.substring(0, mid)).reverse().toString();
            char second = str.charAt(mid);
            String third = new StringBuilder(str.substring(mid + 1)).reverse().toString();
            return first + second + third;
        }
    }

    public static String ShiftAscii(String str){
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i);

            if(Character.isUpperCase(c)){
                sb.append((char)(c + 3 + i));
            }
            else if(Character.isLowerCase(c)){
                sb.append((char)(c + 2 + i));
            }
            else if(Character.isDigit(c)){
                sb.append((char)(c + 10 + i));
            }
            else{
                sb.append(c);
            }
        }
        return sb.toString();
    }


}