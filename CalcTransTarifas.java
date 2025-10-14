import java.util.Scanner;
import java.util.List;

public class CalcTransTarifas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

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

                System.out.print("♠ Opção: ");
                transporte = scanner.nextLine().trim().toUpperCase();

                if (!Constantes.TRANSPORTES.contains(transporte)) {
                    System.out.println("❌ Tipo de transporte inválido! Por favor, insira: A, B, C ou D.");
                    continue;
                }
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

            while (true) {
                System.out.print("🔃 Deseja calcular outra viagem? (S/N): ");
                resposta = scanner.nextLine().trim().toUpperCase();
                if (!Constantes.RESPOSTAS.contains(resposta)) {
                    System.out.println("❌ Erro! Por favor, insira apenas 'S' para SIM ou 'N' para NÃO.");
                    continue;
                }
                break;
            }
        } while (!resposta.equals("N"));

        System.out.println("👋🏻 Encerrando o programa, até mais!");
        scanner.close();
    }

    public static double calculoTarifa(String transporte, double distancia) {
        return switch (transporte) {
            case "A" -> Constantes.TARIFA_ONIBUS * distancia;
            case "B" -> Constantes.TARIFA_TAXI * distancia;
            case "C" -> Constantes.TARIFA_APP * distancia;
            case "D" -> Constantes.TARIFA_EXECUTIVO * distancia;
            default -> throw new IllegalStateException("Transporte inválido: " + transporte);
        };
    }
}

class Constantes {
    public static final List<String> TRANSPORTES = List.of("A", "B", "C", "D");
    public static final List<String> RESPOSTAS = List.of("S", "N");

    public static final double TARIFA_ONIBUS = 0.5;
    public static final double TARIFA_TAXI = 2.0;
    public static final double TARIFA_APP = 1.2;
    public static final double TARIFA_EXECUTIVO = 3.0;
}