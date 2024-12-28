import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConversionDeMonedas {

    public String conversion(String divisaBase,double cantidad, String divisaObjetivo){
        if(cantidad<=0) {
            return ("El monto debe ser mayor que 0");
        }
        String resultadoConversion = "";
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

            resultadoConversion = jsonObject.get("conversion_result").getAsString();
            String respuestaUsuario = String.format("Usted ha convertido %.0f %s a %s y el resultado es %s",
                    cantidad, divisaBase, divisaObjetivo, resultadoConversion);
            System.out.println(respuestaUsuario);

        } catch(InterruptedException | IOException e){
            System.out.println("A ocurrido un error");
        } catch (RuntimeException e){
            System.out.println("Error");
        }
        return resultadoConversion;
    }

}

