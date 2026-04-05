import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);

    public static String readString(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine();
    }

    public static int readInt(String mensagem) {
        System.out.print(mensagem);
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }

    public static double readDouble(String mensagem) {
        System.out.print(mensagem);
        double valor = scanner.nextDouble();
        scanner.nextLine();
        return valor;
    }

    public static char readChar(String mensagem) {
        System.out.print(mensagem);
        return scanner.nextLine().charAt(0);
    }
}
