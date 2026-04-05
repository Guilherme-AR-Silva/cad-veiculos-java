import java.util.ArrayList;

public class CadVeiculos {

    static ArrayList<String> veiculos = new ArrayList<>();

    public static void main(String[] args) {

        int opcao;

        do {
            System.out.println("\n=== CAD VEÍCULOS ===");
            System.out.println("1 - Cadastrar veículo");
            System.out.println("2 - Listar veículos");
            System.out.println("3 - Remover por índice");
            System.out.println("4 - Buscar por nome");
            System.out.println("5 - Editar veículo");
            System.out.println("6 - Remover por nome");
            System.out.println("0 - Sair");

            opcao = Input.readInt("Escolha: ");

            switch (opcao) {
                case 1: cadastrar(); break;
                case 2: listar(); break;
                case 3: removerPorIndice(); break;
                case 4: buscar(); break;
                case 5: editar(); break;
                case 6: removerPorNome(); break;
                case 0: System.out.println("Saindo..."); break;
                default: System.out.println("Opção inválida!");
            }

        } while (opcao != 0);
    }

    public static void cadastrar() {
        String nome = Input.readString("Nome do veículo: ");

        if (nome.trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return;
        }

        for (String v : veiculos) {
            if (v.equalsIgnoreCase(nome)) {
                System.out.println("Veículo já cadastrado!");
                return;
            }
        }

        veiculos.add(nome);
        System.out.println("Cadastrado!");
    }

    public static void ordenar() {
        for (int i = 0; i < veiculos.size() - 1; i++) {
            for (int j = 0; j < veiculos.size() - 1 - i; j++) {
                if (veiculos.get(j).compareToIgnoreCase(veiculos.get(j + 1)) > 0) {
                    String temp = veiculos.get(j);
                    veiculos.set(j, veiculos.get(j + 1));
                    veiculos.set(j + 1, temp);
                }
            }
        }
    }

    public static void listar() {
        if (veiculos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        ordenar();

        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(i + " - " + veiculos.get(i));
        }

        System.out.println("Total: " + veiculos.size());
    }

    public static void removerPorIndice() {
        if (veiculos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        listar();

        int i = Input.readInt("Índice: ");

        if (i < 0 || i >= veiculos.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        veiculos.remove(i);
        System.out.println("Removido!");
    }

    public static void buscar() {
        if (veiculos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        String nome = Input.readString("Buscar: ");

        ordenar();

        boolean achou = false;

        for (String v : veiculos) {
            if (v.equalsIgnoreCase(nome)) {
                System.out.println("Encontrado: " + v);
                achou = true;
            }
        }

        if (!achou) {
            System.out.println("Não encontrado!");
        }

        System.out.println("Total: " + veiculos.size());
    }

    public static void editar() {
        if (veiculos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        listar();

        int i = Input.readInt("Índice: ");

        if (i < 0 || i >= veiculos.size()) {
            System.out.println("Índice inválido!");
            return;
        }

        String novo = Input.readString("Novo nome: ");

        if (novo.trim().isEmpty()) {
            System.out.println("Nome inválido!");
            return;
        }

        for (String v : veiculos) {
            if (v.equalsIgnoreCase(novo)) {
                System.out.println("Já existe!");
                return;
            }
        }

        veiculos.set(i, novo);
        System.out.println("Atualizado!");
    }

    public static void removerPorNome() {
        if (veiculos.isEmpty()) {
            System.out.println("Lista vazia!");
            return;
        }

        String nome = Input.readString("Nome: ");

        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).equalsIgnoreCase(nome)) {
                veiculos.remove(i);
                System.out.println("Removido!");
                return;
            }
        }

        System.out.println("Não encontrado!");
    }
}
