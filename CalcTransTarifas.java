import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class CalcTransTarifas {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner (System.in);
        List<String> transportes = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        String resposta;
        do {
            System.out.println("--- Calculadora de Tarifas de Transporte ---");
            String transporte;
            while (true) {
                System.out.println("♠ Tipo de Transporte: ");
                System.out.println("A. Ônibus urbano");
                System.out.println("B. Táxi comum");
                System.out.println("C. Aplicativo (carona)");
                System.out.println("D. Transporte executivo");

                String opcao;
                System.out.print("♠ Opção: ");
                opcao = scanner.nextLine().trim().toUpperCase();

                if (!transportes.contains(opcao)) {
                    System.out.println("❌ Tipo de transporte inválido! Por favor, insira: A, B, C ou D.");
                    Thread.sleep(1000);
                    continue;
                }

                transporte = opcao;
                break;
            }

            double distancia;
            while (true) {
                try {
                    System.out.print("♠ Distância percorrida (km): ");
                    distancia = Double.parseDouble(scanner.nextLine().replace(",", "."));
                    if (distancia <= 0) {
                        System.out.println("❌ Distância inválida! Por favor, insira uma distância maior que 0,0km.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("❌ Erro! Por favor, insira um valor numérico.");
                }
            }

            double valorTarifa = calculoTarifa(transporte, distancia);
            System.out.printf("💲 Valor total da viagem: R$ %.2f%n", valorTarifa);

            List<String> respostas = new ArrayList<>(Arrays.asList("S", "N"));
            while (true) {
                System.out.print("🔃 Deseja calcular outra viagem? (S/N): ");
                resposta = scanner.nextLine().trim().toUpperCase();
                if (!respostas.contains(resposta)) {
                    System.out.println("❌ Erro! Por favor, insira apenas 'S' para SIM ou 'N' para NÃO.");
                    continue;
                }
                break;
            }
        } while (!resposta.equals("N"));

        System.out.println("👋🏻 Desejamos uma boa viagem!");
        scanner.close();
    }
    static double calculoTarifa(String transporte, double distancia) {
        double tarifaOnibusA = 0.5;
        double tarifaTaxiB = 2;
        double tarifaAplicativoC = 1.2;
        double tarifaTransExecD = 3;

        return switch (transporte) {
            case "A" -> tarifaOnibusA * distancia;
            case "B" -> tarifaTaxiB * distancia;
            case "C" -> tarifaAplicativoC * distancia;
            case "D" -> tarifaTransExecD * distancia;
            default -> throw new IllegalStateException();
        };
    }
}
