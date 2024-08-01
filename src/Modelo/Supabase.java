package Modelo;

public class Supabase {
    static private final String SUPABASEURL = "https://fdluzlrlupynnycykfyf.supabase.co/";
    static private final String ANONKEY = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6ImZkbHV6bHJsdXB5bm55Y3lrZnlmIiwicm9sZSI6ImFub24iLCJpYXQiOjE3MjI0NzMxMjgsImV4cCI6MjAzODA0OTEyOH0.gwl3a89XNyzKCFJ1uQS1NTvi8ywef1IiW09gAA3pLBc";

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
