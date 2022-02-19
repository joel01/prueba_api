package dao;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Pokemon;

public class PokemonImpl extends Conexion{
// IDACTA LIBACTA  FECREGACTA  OBSACTA   ESTACTA  IDPER  IDINT

    public void buscarPOK(Pokemon per) throws Exception {
        String leerdnipok = per.getIDPOK();

        String enlace = "https://pokeapi.co/api/v2/pokemon/" + leerdnipok;
        try {
            URL url = new URL(enlace);
            URLConnection request = url.openConnection();
//            request.connect();
            request.addRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            if (root.isJsonObject()) {
                JsonObject rootobj = root.getAsJsonObject();
                String nombrepok = rootobj.get("name").getAsString();
                String experienciaBase = rootobj.get("base_experience").getAsString();
                String alturaBase = rootobj.get("height").getAsString();
                String pesoBase = rootobj.get("weight").getAsString();
                JsonObject stripe = rootobj.getAsJsonObject("sprites").getAsJsonObject();
                String imagenFrontal = stripe.get("front_default").getAsString();
                String imagenAtras = stripe.get("back_default").getAsString();
               
                System.out.println("Resultado\n");
                System.out.println(nombrepok);
                System.out.println("imagen frontal: " + imagenFrontal);
                System.out.println("imagen atras: " + imagenAtras);

                per.setNOMPOK(nombrepok);
                per.setAPEPOK(nombrepok);
                per.setEXPHABPOK(Double.parseDouble(experienciaBase));
                per.setALTPOK(Double.parseDouble(alturaBase)/10);
                per.setPESPOK(Double.parseDouble(pesoBase)/10);
                per.setIMGFROPOK(imagenFrontal);
                per.setIMGATRPOK(imagenAtras);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
           
        }
    }

    public void buscarPOKAletorio(Pokemon per) throws Exception {
        Random r = new Random();
        int idRandom = r.nextInt(500);

//        String enlace = "https://api.reniec.cloud/dni/" + leerdni;
        String enlace = "https://pokeapi.co/api/v2/pokemon/" + idRandom;
        try {
            URL url = new URL(enlace);
            URLConnection request = url.openConnection();
//            request.connect();
            request.addRequestProperty("User-Agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
            if (root.isJsonObject()) {
                JsonObject rootobj = root.getAsJsonObject();
                String nombrepok = rootobj.get("name").getAsString();
                String experienciaBase = rootobj.get("base_experience").getAsString();
                String alturaBase = rootobj.get("height").getAsString();
                String pesoBase = rootobj.get("weight").getAsString();
                JsonObject stripe = rootobj.getAsJsonObject("sprites").getAsJsonObject();
                String imagenFrontal = stripe.get("front_default").getAsString();
                String imagenAtras = stripe.get("back_default").getAsString();
               
                System.out.println("Resultado\n");
                System.out.println(nombrepok);
                System.out.println("imagen frontal: " + imagenFrontal);
                System.out.println("imagen atras: " + imagenAtras);

                per.setNOMPOK(nombrepok);
                per.setAPEPOK(nombrepok);
                per.setEXPHABPOK(Double.parseDouble(experienciaBase));
                per.setALTPOK(Double.parseDouble(alturaBase)/10);
                per.setPESPOK(Double.parseDouble(pesoBase)/10);
                per.setIMGFROPOK(imagenFrontal);
                per.setIMGATRPOK(imagenAtras);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            
        }
    }

    public void registrarPokemon(Pokemon modelo) {
        String sql1 = "insert into pokemon (NOMPOK,APOPOK,EXPBASPOK,ALTPOK,PESPOK,IMGFROPOK,IMGATRPOK)\n"
                + "values (?,?,?,?,?,?,?)";

        try {

            PreparedStatement ps = this.conectar().prepareStatement(sql1);
            ps.setString(1, modelo.getNOMPOK());
            ps.setString(2, modelo.getAPEPOK());
            ps.setDouble(3, modelo.getEXPHABPOK());
            ps.setDouble(4, modelo.getALTPOK());
            ps.setDouble(5, modelo.getPESPOK());
            ps.setString(6, modelo.getIMGFROPOK());
            ps.setString(7, modelo.getIMGATRPOK());
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
            System.out.println("Error al guardar Pokemon : " + e.getMessage());
        }

    }
    
    public List<Pokemon> contenidoPokedex(){
        List<Pokemon> pokedex = null;
        String sql = "select * from pokemon";
        try {
            PreparedStatement ps = this.conectar().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            pokedex = new ArrayList<>();
            while (rs.next()) {                
                Pokemon p = new Pokemon();
                p.setNOMPOK(rs.getString("NOMPOK"));
                p.setAPEPOK(rs.getString("APOPOK"));
                p.setEXPHABPOK(rs.getDouble("EXPBASPOK"));
                p.setALTPOK(rs.getDouble("ALTPOK"));
                p.setPESPOK(rs.getDouble("PESPOK"));
                p.setIMGFROPOK(rs.getString("IMGFROPOK"));
                p.setIMGATRPOK(rs.getString("IMGATRPOK"));
//                System.out.println("nombre: : " + p.getNOMPOK());
                pokedex.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error al ver contenido pokedex: " + e.getMessage());
        }
        return pokedex;
    }
}
