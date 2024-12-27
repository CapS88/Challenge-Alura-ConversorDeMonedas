import java.util.Scanner;

public class MenuUsuario {

    public MenuUsuario(){

    }
    Scanner entradaUsuario = new Scanner(System.in);


    public void mostrarMenu(){
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
        while (eleccion != 8){
            System.out.println(menu);
            System.out.println("Ingresé la opcion que desea convertir: ");
            eleccion = Integer.parseInt(entradaUsuario.nextLine());

            switch (eleccion) {

            }
        }
    }
}
