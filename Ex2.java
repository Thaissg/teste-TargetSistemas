import java.util.*;

public class Ex2 {
    public static String fibonacci(int n) {
        List<Integer> seqfibonacci = new ArrayList<Integer>();
        seqfibonacci.add(0);
        seqfibonacci.add(1);
        if (n == 0 || n == 1) {
            return "O número informado pertence a sequência de Fibonacci";
        }
        for (int i = 2; seqfibonacci.get(i - 1) <= n; i++) {
            seqfibonacci.add(seqfibonacci.get(i - 1) + seqfibonacci.get(i - 2));
            if (seqfibonacci.get(i) == n) {
                return "O número informado pertence a sequência de Fibonacci";
            }
        }
        return "O número informado NÃO pertence a sequência de Fibonacci";

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Informe o número: ");
        int n = in.nextInt();
        String resposta = fibonacci(n);
        in.close();
        System.out.println(resposta);
    }
}