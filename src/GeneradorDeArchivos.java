import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class GeneradorDeArchivos {

    private static final String ARCHIVO = "conversion.txt";

    public void guardarConversion(ResultadoApi resultado, double monto){
        try(BufferedWriter escritura = new BufferedWriter(new FileWriter(ARCHIVO,true))) {
            String contenidoArchivo = String.format("Fecha: %s\nOrigen: %s\nDestino: %s\nMonto: %.2f\nConvertido: %.2f\n\n",
                    LocalDateTime.now(), resultado.base_code(),resultado.target_code(),monto,resultado.conversion_rate(),resultado.conversion_result());
            escritura.write(contenidoArchivo);
        } catch (IOException e){
            System.out.println("Error al guardar la conversión" +e.getMessage());
        }

        }
    public String getNombreArchivo(){
        return ARCHIVO;
    }
}


