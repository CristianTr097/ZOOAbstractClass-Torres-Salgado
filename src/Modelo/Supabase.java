package Modelo;

public class Supabase {
    static private final String SUPABASEURL = "";
    static private final String ANONKEY = "";

    public Supabase(){
    }

    static public String getSupabaseUrl() {
        return SUPABASEURL;
    }
    static public String getAnonKey(){
        return ANONKEY;
    }
    
    public static Rest from(String tabla){
    String tablaURL = SUPABASEURL.concat("rest/v1/" + tabla);
    return new Rest(tablaURL);
}
}
