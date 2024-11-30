import ConsultaMoneda.ConsultaDeMoneda;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        //Entrada del usuario
        Scanner lectura = new Scanner(System.in);

        //ingreso de la ConsultaDeMoneda para utilizar metodo buscarMoneda
        ConsultaDeMoneda consultaDeMoneda = new ConsultaDeMoneda();

        //*************************************************************

        //Variables

        //Variable opciones
        int opcion = 0;

        //Varibles valor a convertir
        double valorIgresado ;

        //*************************************************************

        //Menu de opciones e ingreso de opciones y valor ingresado a convertir

        System.out.println("***********************************");
        System.out.println("Sean bienvenido/a al conversor de Moneda");

        //Bucle while para que se repita las opciones hasta informa opcion de  salida

        while (opcion !=11 ){
            System.out.println("""
            1.Dolar => Peso argentino
            2.Peso argentino => Dolar
            3.Dolar => Real brasileño
            4.Real brasileño => Dolar
            5.Dolar => Boliviano
            6.Boliviano => Dolar
            7.Dolar => Peso chileno
            8.Peso chileno => Dolar
            9.Dolar => Peso colombiano
            10.Peso colombiano => Dolar
            11.Salir""" );

            System.out.println("\nSeleciona una opcion valida. ");
            //Caotura el dato ingresado por el usuario
            opcion =lectura.nextInt();


            String base_code= null;
            String target_code=null;


            //Logica basada en la opcion que ingresa

            switch (opcion) {
                case 1:
                    base_code = "USD";
                    target_code = "ARS";
                    System.out.println("dolar a peso argentino");
                    break;
                case 2:
                    base_code = "ARS";
                    target_code = "USD";
                    System.out.println("peso argentino a dolar");
                    break;
                case 3:
                    base_code = "USD";
                    target_code = "BRL";
                    System.out.println("dolar a peso real brasileño");
                    break;
                case 4:
                    base_code = "BRL";
                    target_code = "USD";
                    break;
                case 5:
                    base_code = "USD";
                    target_code = "BOB";
                    break;
                case 6:
                    base_code = "BOB";
                    target_code = "USD";
                    break;
                case 7:
                    base_code = "USD";
                    target_code = "CLP";
                    break;
                case 8:
                    base_code = "CLP";
                    target_code = "USD";
                    break;
                case 9:
                    base_code = "USD";
                    target_code = "COP";
                    System.out.println("dolar a peso colombiano");
                    break;
                case 10:
                    base_code = "COP";
                    target_code = "USD";
                    break;

                //Salida del programa
                case 11:
                    System.out.println("Saliendo de la aplicación...");
                    continue;

                    //Cuando no utiliza ninguna de las opciones
                default:
                    System.out.println("Opción inválida. Intente de nuevo. \n");


            }


            //Ingreso de valor a convertir

            System.out.println("Ingresa el valor  a convertir ");

            valorIgresado =lectura.nextDouble();

            try {

                //Se lllama al metodo buscarMoneda , para poder tener lo valores a convertir

                double conversio = consultaDeMoneda.buscarMoneda(base_code, target_code);

                //Se calcula el valor convertido
                double valorConvertido = valorIgresado*conversio;

                System.out.println("\n");
                System.out.println("El valor de "+valorIgresado+"["+base_code+"]"+
                        " corresponde al valor final >>>>>  "+valorConvertido+"["+target_code+"]");
                System.out.println("\n");




            }catch (RuntimeException e){
                System.out.println(e.getMessage());
                System.out.println("Finalizando aplicacion.");
            }




        }
    }
}
