import java.util.Scanner;

public class MenuUsuario {

    private final ConversionDeMonedas conversor;
    private final Scanner entradaUsuario;

    public MenuUsuario() {

        this.conversor = new ConversionDeMonedas();
        this.entradaUsuario = new Scanner(System.in);
    }

    public void mostrarMenu() {
        System.out.println("Sea bienvenido al conversor de Monedas");
        String menu = """
                ****************************************************
                Seleccione una opción :
                1) Dolar => Pesos Chilenos
                2) Yuan Chino => Peso Colombiano
                3) Peso Argentino => Real Brasileño
                4) Bolivar Venezolano => Sol Peruano
                5) Yen japones => Euro
                6) Rublo Ruso => Rupia India
                7) Libra Esterlina => Boliviano
                8) Salir
                ****************************************************
                """;

        int eleccion = 0;
        while (eleccion != 8) {
            try {
                System.out.println(menu);
                System.out.println("Ingresé la opcion que desea convertir: ");
                eleccion = Integer.parseInt(entradaUsuario.nextLine());

                switch (eleccion) {
                    case 1:
                        procesarConvercion("USD", "CLP");
                        break;
                    case 2:
                        procesarConvercion("CNY", "COP");
                        break;
                    case 3:
                        procesarConvercion("ARS", "BRL");
                        break;
                    case 4:
                        procesarConvercion("VES", "PEN");
                        break;
                    case 5:
                        procesarConvercion("JPY", "EUR");
                        break;
                    case 6:
                        procesarConvercion("RUB", "INR");
                        break;
                    case 7:
                        procesarConvercion("GPB", "BOB");
                        break;
                    case 8:
                        System.out.println("Finalizando el programa, gracias por utilizar el conversor de Monedas!");
                        break;
                    default:
                        System.out.println("Por favor, seleccione una opción valida (1-8).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese una opcion valida. ");
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                System.out.println("Ha ocurrido un error, finalizando programa.");
            }
        }
    }

    private void procesarConvercion(String divisaBase, String divisaObjetivo) {
        System.out.println("Ingresé el monto que desea convertir: ");
        try {
            double monto = Double.parseDouble(entradaUsuario.nextLine());
            String resultado = conversor.conversion(divisaBase, monto, divisaObjetivo);
            System.out.println("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese una opcion valida. ");
        }
    }
}