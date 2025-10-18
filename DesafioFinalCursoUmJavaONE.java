import java.util.Scanner;

public class DesafioFinalCursoUmJavaONE {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        String nomeCliente = "Jacqueline Oliveira";
        String tipoConta = "Corrente";
        double saldo = 2500;

        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    System.out.println("\n====== Dados do Cliente ======");
                    System.out.println("🔰 Nome: " + nomeCliente);
                    System.out.println("💱 Conta: " + tipoConta);
                    System.out.printf("💰 Saldo: R$%.2f%n", saldo);
                    System.out.println("==============================");
                    break;

                case 2:
                    System.out.println("=== 💲 Sacar 💲 ===");
                    System.out.println("💡 Dica: você pode cancelar a operação inserindo 0.");
                    double valorSaque;
                    while (true) {
                        try {
                            System.out.print("💲 Valor a ser sacado: R$ ");
                            valorSaque = Double.parseDouble(sc.nextLine().trim().replaceAll("[^0-9.]", ""));
                            if (valorSaque == 0) {
                                System.out.println("🔃 Operação cancelada!");
                                Thread.sleep(1000);
                                break;
                            }
                            if (valorSaque < 0) {
                                System.out.println("❌ Valor inválido!");
                                continue;
                            }
                            if (valorSaque > saldo) {
                                System.out.println("❌ Saldo insuficiente!");
                                System.out.printf("💰 Saldo: %.2f%n", saldo);
                                continue;
                            }
                            saldo -= valorSaque;
                            System.out.println("✅ Saque realizado com sucesso!");
                            System.out.printf("💰 Saldo atual: R$%.2f%n", saldo);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Digite um número válido!");
                        }
                    }
                    break;

                case 3:
                    System.out.println("💡 Dica: você pode cancelar a operação inserindo 0.");
                    double valorDeposito;
                    while (true) {
                        try {
                            System.out.print("💹 Valor a ser depositado: R$ ");
                            valorDeposito = Double.parseDouble(sc.nextLine().trim().replaceAll("[^0-9.]", ""));
                            if (valorDeposito == 0) {
                                System.out.println("🔃 Operação cancelada!");
                                Thread.sleep(1000);
                                break;
                            }
                            if (valorDeposito < 0) {
                                System.out.println("❌ Valor inválido!");
                                continue;
                            }
                            saldo += valorDeposito;
                            System.out.println("✅ Depósito realizado com sucesso!");
                            System.out.printf("💰 Saldo atual: R$%.2f%n", saldo);
                            break;
                        } catch (NumberFormatException e) {
                            System.out.println("❌ Digite um número válido!");
                        }
                    }
                    break;

                case 0:
                    System.out.println("👋🏻 Você optou por sair, volte sempre!");
                    break;

                default:
                    System.out.println("❌ Opção inválida!");
            }

            if (opcao != 0) {
                System.out.print("\n🔃 Deseja fazer outra operação? (S/N): ");
                String continuar = sc.nextLine().trim().toUpperCase();
                if (!continuar.equals("S")) {
                    opcao = 0;
                }
            }

        } while (opcao != 0);

        sc.close();
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int opcao = -1;
        while (opcao < 0 || opcao > 4) {
            System.out.println("\n🏧 Operações 🏧");
            System.out.println("1. Consultar");
            System.out.println("2. Sacar");
            System.out.println("3. Depositar");;
            System.out.println("0. Sair");
            System.out.print("🔹 Opção: ");
            try {
                opcao = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                opcao = -1;
            }
            if (opcao < 0 || opcao > 3) {
                System.out.println("❌ Escolha uma opção válida!");
            }
        }
        return opcao;
    }
}
