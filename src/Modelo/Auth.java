package Modelo;

import java.util.HashMap;
import org.json.JSONObject;

/**
 *
 * @author User
 */
public class Auth {
    private String authURL;
    
    public Auth (){
        this.authURL =  Supabase.getSupabaseUrl().concat("auth/v1");
    }
    
}
