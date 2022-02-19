package controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dao.PokemonImpl;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import lombok.Data;
import model.Pokemon;
import org.primefaces.event.DragDropEvent;

@Named(value = "pokemonC")
@SessionScoped
public class PokemoncitoC implements Serializable {

    private PokemonImpl dao;
    private Pokemon pokemon;
    private List<Pokemon> pokemonesObtenidos = new ArrayList<>();
    private List<Pokemon> pokemonSeleccionado = new ArrayList<>();

    public PokemoncitoC() {
        pokemon = new Pokemon();
        dao = new PokemonImpl();
    }

    public void buscarPOK() {
        try {
            System.out.println("tengo miedo pokemon");
//            JsonArray habilidades = null;
            dao.buscarPOK(pokemon);
//            pokemon.setAPEPOK(pokemon.getNOMPOK());
//            for (String string : habilidadesObtenida) {
//                System.out.println("StringC: " +string);
//            }
//            for (JsonElement habilidade : habilidades) {
//                JsonObject element = habilidade.getAsJsonObject();
//                JsonObject ability = element.getAsJsonObject("ability").getAsJsonObject();
//                String habilidadObtenida = ability.get("name").getAsString();
//                System.out.println("Habilidad: " + habilidadObtenida);
////                habilidadesObtenida.add(habilidadObtenida);
//            }
//            dao.buscarHabilidades(pokemon.getIDPOK(),habilidadesObtenida);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Busqueda", "Pokemon encontrado con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "Pokemon no encontrado"));
            System.out.println("error en Busqueda Pokemon" + e.getMessage());
        }
    }

    public void buscarPOKAletatorio() {
        try {
//            System.out.println("tengo miedo pokemon");
//            JsonArray habilidades = null;
            dao.buscarPOKAletorio(pokemon); 
//            pokemon.setAPEPOK(pokemon.getNOMPOK());
//            for (String string : habilidadesObtenida) {
//                System.out.println("StringC: " +string);
//            }
//            for (JsonElement habilidade : habilidades) {
//                JsonObject element = habilidade.getAsJsonObject();
//                JsonObject ability = element.getAsJsonObject("ability").getAsJsonObject();
//                String habilidadObtenida = ability.get("name").getAsString();
//                System.out.println("Habilidad: " + habilidadObtenida);
////                habilidadesObtenida.add(habilidadObtenida);
//            }
//            dao.buscarHabilidades(pokemon.getIDPOK(),habilidadesObtenida);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Busqueda", "Pokemon encontrado con éxito"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL, "Busqueda", "Pokemon no encontrado"));
            System.out.println("error en Busqueda Pokemon" + e.getMessage());
        }
    }

    public void capturarPokemon() {
        try {
            dao.registrarPokemon(pokemon);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Captura", "Felicidades por capturar a: " + pokemon.getAPEPOK()));
            pokemon = new Pokemon();
        } catch (Exception e) {
            System.out.println("Error al capturarC: " + e.getMessage());
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Captura", "Fallaste con la pokebola"));
        }
    }

    public void obtenerPokedex() {
        try {
            
            pokemonesObtenidos = dao.contenidoPokedex();
        } catch (Exception e) {
            System.out.println("Error al obtener PokemonC: " + e.getMessage());

        }
    }
    
    public void limpiarPokemonSeleccioado(){
        try {
            pokemonSeleccionado = new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Error al limpiar Pokemon Seleccionado: " + e.getMessage());
        }
    }

    /**
     *
     * @param ddEvent
     */
    public void onProductDrop(DragDropEvent<Pokemon> ddEvent) {
        Pokemon product = ddEvent.getData();

        pokemonSeleccionado.add(product);
        pokemonesObtenidos.remove(product);
    }
    
    public void quitarPokemonLista(){
        try {
            pokemonSeleccionado.remove(pokemon);
        } catch (Exception e) {
            System.out.println("No se pudo eliminar: " + e.getMessage());
        }
    }

    public PokemonImpl getDao() {
        return dao;
    }

    public void setDao(PokemonImpl dao) {
        this.dao = dao;
    }

    public Pokemon getPokemon() {
        return pokemon;
    }

    public void setPokemon(Pokemon pokemon) {
        this.pokemon = pokemon;
    }

   

    public List<Pokemon> getPokemonesObtenidos() {
        return pokemonesObtenidos;
    }

    public void setPokemonesObtenidos(List<Pokemon> pokemonesObtenidos) {
        this.pokemonesObtenidos = pokemonesObtenidos;
    }

    public List<Pokemon> getPokemonSeleccionado() {
        return pokemonSeleccionado;
    }

    public void setPokemonSeleccionado(List<Pokemon> pokemonSeleccionado) {
        this.pokemonSeleccionado = pokemonSeleccionado;
    }

}
