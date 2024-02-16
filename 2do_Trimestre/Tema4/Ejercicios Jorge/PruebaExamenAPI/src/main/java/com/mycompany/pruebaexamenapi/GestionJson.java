package com.mycompany.pruebaexamenapi;

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

    final static String API_URL = "https://rickandmortyapi.com/api/character/";
    private String personaje;

    public GestionJson(String personaje) {
        this.personaje = personaje;
    }

    public String llamarApi() throws IOException {
        String apiUrl = API_URL + personaje;
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

    public String obtenerNombrePersonaje(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(apiResponse, Personaje.class);
            return personaje.getName();
        } else {
            return "";
        }
    }
    
    public String obtenerStatusPersonaje(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(apiResponse, Personaje.class);
            return personaje.getStatus();
        } else {
            return "";
        }
    }
    
    public String obtenerEspeciePersonaje(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(apiResponse, Personaje.class);
            return personaje.getSpecies();
        } else {
            return "";
        }
    }
    
    public String obtenerImagenPersonaje(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Personaje personaje = gson.fromJson(apiResponse, Personaje.class);
            return personaje.getImage();
        } else {
            return "";
        }
    }
}
