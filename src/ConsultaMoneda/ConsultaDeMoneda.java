package ConsultaMoneda;

import com.google.gson.*;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDeMoneda {

        //Metodo para buscar moneda

    public double buscarMoneda (String base_code, String target_code){

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/f1f76b7d87bcdbf1b214ba59/pair/"+base_code+"/"+target_code);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            // Envía la solicitud HTTP y obtiene una respuesta como String

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            // Convierte el JSON recibido en un objeto
            // Configura Gson para manejar nombres de campos en formato "UpperCamelCase".

            Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();

            // Parsea el cuerpo de la respuesta (JSON) en un objeto JsonObject.

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();

            // Extrae el valor del campo "conversion_rate" del objeto JSON y lo convierte a double.
            // Este campo representa la tasa de cambio entre base_code y target_code.

            return jsonObject.get("conversion_rate").getAsDouble();

        }catch (Exception e){

            //En caso de error que no se encuentre la moneda
            throw new RuntimeException("No se encontro la Moneda");
        }
    }



}
