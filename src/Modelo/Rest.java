package Modelo;

import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
public class Rest {
    String apiUrl;

    public Rest(String apiUrl) {
        this.apiUrl = apiUrl;
}
    
public JSONArray select(String colums){
        //Header fetch
        HashMap<String, String> header = new HashMap<>();
        header.put("apiKey", Supabase.getAnonKey());
        header.put("Content-Type", "application/json");
        //header.put("Authorization", "Bearer " + Supabase.getCurrentSession().getToken());
        
        //params
        HashMap<String, Object> params = new HashMap<>();
        params.put("select", colums);
        //Fetch options
        HashMap<String, Object> options = new HashMap<>();
        options.put("header", header);
        options.put("params", params);
        
        return Api.fetch(apiUrl, options, true);
    }
    
    public JSONArray selecteq(String colums, String key, Object value){
        //Header fetch
        HashMap<String, String> header = new HashMap<>();
        header.put("apiKey", Supabase.getAnonKey());
        header.put("Content-Type", "application/json");
        //header.put("Authorization", "Bearer " + Supabase.getCurrentSession().getToken());
        
        //params
        HashMap<String, Object> params = new HashMap<>();
        params.put("select", colums);
        params.put(key, "eq."+value); //formato de la API para asignar una condición de igualdad
        
        //Fetch options
        HashMap<String, Object> options = new HashMap<>();
        options.put("header", header);
        options.put("params", params);
        
        return Api.fetch(apiUrl, options, false);
    }
    public JSONArray insert(JSONArray body){
        //Header fetch
        HashMap<String, String> header = new HashMap<>();
        header.put("apiKey", Supabase.getAnonKey());
        header.put("Content-Type", "application/json");
        header.put("Prefer", "return=representation");
        //header.put("Authorization", "Bearer " + Supabase.getCurrentSession().getToken());
        
        HashMap<String, Object> options = new HashMap<>();
        
        options.put("method", "POST");
        options.put("body", body);
        options.put("header", header);
        
        return Api.fetch(apiUrl, options, true);
         
    }
}
