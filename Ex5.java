import java.util.*;

public class Ex5 {

    public static String inverter(String str) {
        String invertida = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            invertida = invertida + str.charAt(i);
        }
        return invertida;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Digite uma palavra: ");
        String str = in.nextLine();
        System.out.println("Palavra invertida: " + inverter(str));
        in.close();
    }
}
