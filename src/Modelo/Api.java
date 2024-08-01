package Modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
public class Api {
    private static String bodyToString(HashMap<String, Object> body) {
        JSONObject bodyJson = new JSONObject(body);
        return bodyJson.toString();
}
    
private static String paramsToString(HashMap<String, Object> params) {
        String result = "?";

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            result = result.concat(key + "=" + value.toString() + "&");
        }

        return result.substring(0, result.length() - 1);
    }

    public static String fetch(String url) {
        String response = "asdas";
        //GET
        return response;
    }

    public static JSONObject fetch(String fetchUrl, HashMap<String, Object> options) {
        // Método de la petición
        String method = "GET";
        if (options.containsKey("method")) {
            method = (String) options.get("method");
        }

        // Body de la petición
        String fetchBody = null;
        if (options.containsKey("body")) {
         
            if(options.get("body") instanceof JSONArray){
                fetchBody = options.get("body").toString();
            }else{
                fetchBody = bodyToString((HashMap<String, Object>) options.get("body"));   
            }
        }

        try {
            // Url de la petición
            System.out.println(fetchUrl);
            if (options.containsKey("params")) {
                fetchUrl = fetchUrl.concat(paramsToString((HashMap<String, Object>) options.get("params")));
            }
            System.out.println(fetchUrl);
            
            URL url = new URL(fetchUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);

            if (options.containsKey("header")) {
                Map<String, String> header = (HashMap<String, String>) options.get("header");
                for (Map.Entry<String, String> property : header.entrySet()) {
                    connection.setRequestProperty(property.getKey(), property.getValue());
                }
            }

            connection.setDoOutput(true); // permite leer y modificar el body

            if (fetchBody != null) {
                connection.getOutputStream().write(fetchBody.getBytes()); // guardar información al body
            }

            // Lee la respuesta del servidor
            BufferedReader br;
            if (connection.getResponseCode() >= 200 && connection.getResponseCode() < 300) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);
            }

            String responseString = result.toString();
            System.out.println("Respuesta del servidor: " + responseString);

            JSONObject objectUser = new JSONObject(responseString);
            return objectUser;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            JSONObject error = new JSONObject();
            error.put("error", e.getMessage());
            return error;
        }
    }
    
    public static JSONArray fetch(String fetchUrl, HashMap<String, Object> options, Boolean isArray) {
        // Método de la petición
        String method = "GET";
        if (options.containsKey("method")) {
            method = (String) options.get("method");
        }

        // Body de la petición
        String fetchBody = null;
        if (options.containsKey("body")) {
         
            if(options.get("body") instanceof JSONArray){
                fetchBody = options.get("body").toString();
            }else{
                fetchBody = bodyToString((HashMap<String, Object>) options.get("body"));   
            }
        }

        try {
            // Url de la petición
            System.out.println(fetchUrl);
            if (options.containsKey("params")) {
                fetchUrl = fetchUrl.concat(paramsToString((HashMap<String, Object>) options.get("params")));
            }
            System.out.println(fetchUrl);
            
            URL url = new URL(fetchUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod(method);

            if (options.containsKey("header")) {
                Map<String, String> header = (HashMap<String, String>) options.get("header");
                for (Map.Entry<String, String> property : header.entrySet()) {
                    connection.setRequestProperty(property.getKey(), property.getValue());
                }
            }

            connection.setDoOutput(true); // permite leer y modificar el body

            if (fetchBody != null) {
                connection.getOutputStream().write(fetchBody.getBytes()); // guardar información al body
            }

            // Lee la respuesta del servidor
            BufferedReader br;
            if (connection.getResponseCode() >= 200 && connection.getResponseCode() < 300) {
                br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                br = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String line;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) {
                result.append(line);
            }

            String responseString = result.toString();
            System.out.println("Respuesta del servidor: " + responseString);

            JSONArray objectUser = new JSONArray(responseString);
            return objectUser;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            JSONArray error = new JSONArray();
            return error.put(e);
        }
    }
}
