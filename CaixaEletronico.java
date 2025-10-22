import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        int opcao;
        while (true) {
            try {
                System.out.println("🏧 Sistema 🏧");
                System.out.println("1. Login");
                System.out.println("2. Cadastro");
                System.out.println("3. Sair");

                System.out.print("🔸 Opção: ");
                opcao = Integer.parseInt(sc.nextLine().trim());
                if (opcao < 0 || opcao > 3) {
                    System.out.println("⚠ Erro! Por favor, escolha entre as opções: 1, 2 ou 3.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("⚠ Erro! Por favor, escolha entre as opções: 1, 2 ou 3.");
            }
        }

        if (opcao == 1) {
            long cpf;
            while (true) {
                try {
                    System.out.println("🏧 Tela de Login 🏧");
                    System.out.print("🔹 CPF: ");
                    cpf = Long.parseLong(sc.nextLine().replaceAll("[^0-9]", ""));
                    int tamanhoCPF = String.valueOf(cpf).length();
                    if (tamanhoCPF != 11) {
                        System.out.println("⚠ Erro! O CPF deve conter exatamente 11 dígitos válidos, tente novamente.");
                        continue;
                    }
                    boolean cpfValido = validarCPF(cpf);
                    if (!cpfValido) {
                        System.out.println("❌ CPF inválido! Tente novamente.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("⚠ Erro! O CPF deve conter somente 11 dígitos válidos, tente novamente.");
                }
            }
            while (true) {
                System.out.println("CPF Válido!");
                break;
            }
        } else if (opcao == 2) {
            System.out.println("Cadastrar");
        } else {
            System.out.println("👋🏻 Você optou por sair do sistema, até mais!");
            sair();
        }

    }
    public static boolean validarCPF(long cpf) {
        List<Integer> digitos = new ArrayList<>();
        boolean cpfValido;

        String digito = String.valueOf(cpf);
        for (char d : digito.toCharArray()) {
            digitos.add(Character.getNumericValue(d));
        }

        List<Integer> produtoDigitosUm = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            int produto = digitos.get(i) * (10-i);
            produtoDigitosUm.add(produto);
        }

        int somaUm = 0;
        for (int produto : produtoDigitosUm) {
            somaUm += produto;
        }

        int resultadoUm = 11 - (somaUm % 11);
        int digitoVerificadorUm;

        if (resultadoUm > 9) {
            digitoVerificadorUm = 0;
        } else {
            digitoVerificadorUm = resultadoUm;
        }

        System.out.println(digitos.get(digitos.size() - 2));
        if (digitos.get(digitos.size() - 2) != digitoVerificadorUm) {
            cpfValido = false;
        } else {
            List<Integer> produtoDigitoDois = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                int produto = digitos.get(i) * (11-i);
                produtoDigitoDois.add(produto);
            }

            int somaDois = 0;
            for (int produto : produtoDigitoDois) {
                somaDois += produto;
            }

            int resultadoDois = 11 - (somaDois % 11);
            int digitoVerificadorDois;

            if (resultadoDois > 9) {
                digitoVerificadorDois = 0;
            } else {
                digitoVerificadorDois = resultadoDois;
            }

            cpfValido = digitos.getLast() == digitoVerificadorDois;
        }
        return cpfValido;
    }
    public static void sair() {
        System.exit(0);
    }
}
