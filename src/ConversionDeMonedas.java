import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionDeMonedas {

    public ResultadoApi conversion(String divisaBase,double cantidad, String divisaObjetivo){
        if(cantidad<=0) {
            throw new IllegalArgumentException("El monto debe ser mayor que 0");
        }
        try{

            URI direccion = URI.create("https://v6.exchangerate-api.com/v6/5219130255c29ae408eb24f5/pair/"
                    +divisaBase+"/"+divisaObjetivo+"/"+cantidad);

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(direccion).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            JsonElement jsonElement = JsonParser.parseString(json);
            JsonObject jsonObject = jsonElement.getAsJsonObject();

            if (!jsonObject.has("base_code") || !jsonObject.has("conversion_result")) {
                throw new RuntimeException("Respuesta inesperada de la API");
            }

            String baseCode = jsonObject.get("base_code").getAsString();
            String targetCode = jsonObject.get("target_code").getAsString();
            double conversionRate = jsonObject.get("conversion_rate").getAsDouble();
            double conversionResult = jsonObject.get("conversion_result").getAsDouble();

            return new ResultadoApi(baseCode, targetCode, conversionRate, conversionResult);

        } catch(InterruptedException e){
            throw new RuntimeException("Error, solicitud interrumpida" + e.getMessage());
        } catch(IOException e){
            throw new RuntimeException("Error : Problema al conectarse con la API" + e.getMessage());
        }
    }
}

