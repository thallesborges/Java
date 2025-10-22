import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // || \
        int opcao = 0;
        do {
            while (true) {
                System.out.println("\n📚 Sistema Bibliotecário 📚");
                System.out.println("1. Cadastrar livro");
                System.out.println("2. Listar livros");
                System.out.println("3. Emprestar livro");
                System.out.println("4. Devolver livro");
                System.out.println("5. Sair");
                System.out.print("🔰 Opção: ");
                try {
                    opcao = Integer.parseInt(sc.nextLine().trim());
                } catch (NumberFormatException e) {
                    opcao = -1;
                }
                if (opcao <= 0 || opcao > 5) {
                    System.out.println("❌ Opção inválida! Escolha uma opção válida (1-5).");
                    continue;
                }
                break;
            }
            switch (opcao) {
                case 1:
                    // 🚧 Aqui será o cadastro de livros, em construção...

                    // Se o título já existir na biblioteca, cancelar operação.
                    System.out.print("Título do Livro: ");
                    String titulo = sc.nextLine();

                    System.out.print("Autor do Livro: ");
                    String autor = sc.nextLine();

                    // Cadastro deverá ser true sempre;
                    boolean disponivel = true;

                    Livro livro1 = new Livro(titulo, autor, disponivel);
                    System.out.println("✅ Livro cadastrado com sucesso!");
                    break;

                case 2:
                    System.out.println("🚧 Aqui será a listagem de livros, em construção...");
                    break;
                case 3:
                    System.out.println("🚧 Aqui será o empréstimo de livros, em construção...");
                    break;
                case 4:
                    System.out.println("🚧 Aqui será a devolução de livros, em construção...");
                    break;
                case 5:
                    System.out.println("👋🏻 Você optou por sair, volte sempre!");
                    break;
                default:
                    System.out.println("❌ Opção inválida!");
            }
            if (opcao != 5) {
                String continuar;
                while (true) {
                    System.out.print("🔃 Deseja fazer outra operação? (S/N): ");
                    continuar = sc.nextLine().trim().toUpperCase();
                    if (continuar.equals("S") || continuar.equals("N")) {
                        if (continuar.equals("S")) {
                            opcao = 0;
                            break;
                        } else {
                            System.out.println("👋🏻 Obrigado por utilizar nosso sistema, até mais!");
                            opcao = 5;
                        }
                    } else {
                        System.out.println("❌ Opção inválida! Escolha 'S' para Sim ou 'N' para Não.");
                        continue;
                    }
                    break;
                }
            }
        } while (opcao != 5);
    }
}