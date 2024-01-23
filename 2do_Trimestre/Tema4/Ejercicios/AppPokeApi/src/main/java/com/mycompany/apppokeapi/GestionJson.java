package com.mycompany.apppokeapi;

import Pokemons.Habilidades.Ability;
import Pokemons.Pokemon;
import Pokemons.Sprites;
import Pokemons.Tipos.TypeInfo;
import Pokemons.Tipos.Types;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 *
 * @author Jorge del Cid Moreno
 */
public class GestionJson {

    final static String API_URL = "https://pokeapi.co/api/v2/pokemon/";
    private String pokemon;

    public GestionJson(String pokemon) {
        this.pokemon = pokemon;
    }

    public String llamarApi() throws IOException {
        String apiUrl = API_URL + pokemon;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if (comprobarApi(connection)) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            return response.toString();
        } else {
            return null;
        }
    }

    public boolean comprobarApi(HttpURLConnection connection) throws IOException {
        int codigoRespuesta = connection.getResponseCode();
        return codigoRespuesta == HttpURLConnection.HTTP_OK;
    }

    public float obtenerPesoPokemon(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Pokemon pokemon = gson.fromJson(apiResponse, Pokemon.class);
            return pokemon.getWeight();
        } else {
            return 0;
        }
    }

    public float obtenerAlturaPokemon(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Pokemon pokemon = gson.fromJson(apiResponse, Pokemon.class);
            return pokemon.getHeight();
        } else {
            return 0;
        }
    }

    public String obtenerHabilidadesPokemon(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            StringBuilder cadena = new StringBuilder();
            cadena.append("HABILIDADES: \n");
            Pokemon pokemon = gson.fromJson(apiResponse, Pokemon.class);
            ArrayList<Ability> listaHabilidades = pokemon.getAbilities();
            for (Ability a : listaHabilidades) {
                cadena.append("   ·").append(a.getAbility().getName()).append("\n");
            }
            return cadena.toString();
        } else {
            return null;
        }
    }

    public String obtenerUrlImagenPokemon(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Pokemon pokemon = gson.fromJson(apiResponse, Pokemon.class);
            Sprites sprites = pokemon.getSprites();
            if (sprites != null) {
                return sprites.getFrontDefault();
            }
        }
        return null;
    }

    public String obtenerTiposPokemon(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            StringBuilder cadena = new StringBuilder();
            cadena.append("TIPOS: \n");
            Pokemon pokemon = gson.fromJson(apiResponse, Pokemon.class);
            ArrayList<Types> listaTipos = pokemon.getTypes();
            for (Types t : listaTipos) {
                cadena.append("   ·").append(t.getType().getName()).append("\n");
            }
            return cadena.toString();
        } else {
            return null;
        }
    }

    public String obtenerPrimerTipoPokemon(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Pokemon pokemon = gson.fromJson(apiResponse, Pokemon.class);

            ArrayList<Types> types = pokemon.getTypes();
            if (!types.isEmpty()) {
                Types firstType = types.get(0);
                TypeInfo typeInfo = firstType.getType();
                return typeInfo.getName();
            }
        }
        return null;
    }
}
