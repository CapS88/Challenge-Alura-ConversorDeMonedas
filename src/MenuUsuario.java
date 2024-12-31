import java.util.Scanner;

public class MenuUsuario {

    private final ConversionDeMonedas conversor;
    private final Scanner entradaUsuario;

    private GeneradorDeArchivos generadorDeArchivos = new GeneradorDeArchivos();

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
                        procesarConversion("USD", "CLP");
                        break;
                    case 2:
                        procesarConversion("CNY", "COP");
                        break;
                    case 3:
                        procesarConversion("ARS", "BRL");
                        break;
                    case 4:
                        procesarConversion("VES", "PEN");
                        break;
                    case 5:
                        procesarConversion("JPY", "EUR");
                        break;
                    case 6:
                        procesarConversion("RUB", "INR");
                        break;
                    case 7:
                        procesarConversion("GBP", "BOB");
                        break;
                    case 8:
                        System.out.println("Finalizando el programa, gracias por utilizar el conversor de Monedas!");
                        System.out.println("La conversion fue guardada exitosamente en " +generadorDeArchivos.getNombreArchivo());
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

    private void procesarConversion(String divisaBase, String divisaObjetivo) {
        System.out.println("Ingresé el monto que desea convertir: ");
        try {
            double monto = Double.parseDouble(entradaUsuario.nextLine());
            ResultadoApi resultado = conversor.conversion(divisaBase, monto, divisaObjetivo);
            generadorDeArchivos.guardarConversion(resultado, monto);
            System.out.println(String.format("La conversion de %.2f %s a %s es :  %.2f",
                    monto,
                    resultado.base_code(),
                    resultado.target_code(),
                    resultado.conversion_result()
            ));
        } catch (NumberFormatException e) {
            System.out.println("Por favor, ingrese una opcion valida. ");
        }
    }
}