package datasourceManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.LinkedList;
import java.lang.reflect.Type;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import context.ContextBus;
import context.EtatArret;
import events.ControlesDuBus;
import modele.Bus;
import modele.Ligne;

public class JsonManager {
    private static JsonManager instance;
    private GsonBuilder builder = new GsonBuilder();
    private Gson gson = builder.create();
    private String json = "";
    private String fichierJson = ".\\reseau.json";

    private JsonManager() {
        
    }
    public static JsonManager getInstance() {
        if(instance == null) {
            instance = new JsonManager();
        }
        return instance;
    }
    
    public LinkedList<Ligne> getData() {
        LinkedList<Ligne> lesLignes;
        try{
            InputStream ips=new FileInputStream(fichierJson); 
            InputStreamReader ipsr=new InputStreamReader(ips);
            BufferedReader br=new BufferedReader(ipsr);
            String ligne;
            json = "";
            while ((ligne=br.readLine())!=null){
                //System.out.println(ligne);
                json+=ligne;
            }
            br.close(); 
        }  
        catch (Exception e){
            System.out.println(e.toString());
        }   

        /*
         * Etape 2
         * Remplissage des objets du mod�le � partir des donn�es r�cup�r�es
         * dans le fichier json
         */
        if (json.compareTo("")==0)
        {
            // Si le fichier est vide, on cr�e une liste vide
            lesLignes=new LinkedList<Ligne>();
        }
        else
        {
            // Le fichier n'est pas vide, on utilise la biblioth�que google
            // pour remplir les objets automatiquement
            Type type = new TypeToken<LinkedList<Ligne>>(){}.getType();
            lesLignes=gson.fromJson(json, type);
            
            for (Ligne ligne: lesLignes) {
                for (Bus bus : ligne.getBus()) {
                    
                    bus.setControleBus(new ControlesDuBus());
                    bus.setMonContext(new ContextBus(bus.getControleBus()));
                }
            }
        }
        
        /*for (Ligne ligne : lesLignes) {
            if (compte.getArret() == null) {
                compte.setLesOperation(new LinkedList<Operation>());
            }
     }*/
        
         return lesLignes;
    }
    
    public LinkedList<Ligne> setData(String json)
    {
        Writer writer = null ;
        try {

            // ouverture d'un flux de sortie sur un fichier
            // a pour effet de cr�er le fichier
            writer =  new FileWriter(new File(fichierJson)) ;
            writer.write(json) ;
        }  catch (IOException e) {
            System.out.println("Impossible d'�crire dans le fichier " + e.getMessage()) ;
            e.printStackTrace() ;

        }  finally {
            if (writer != null) {
                try {
                    writer.close() ;
                }  catch (IOException e) {
                    System.out.println("Erreur " + e.getMessage()) ;
                    e.printStackTrace() ;
                }
            }
        }
        
        return getData();
    }
}
