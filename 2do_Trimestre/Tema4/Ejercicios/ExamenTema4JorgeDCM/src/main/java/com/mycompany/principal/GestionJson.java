package com.mycompany.principal;

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

    final static String API_URL = "https://fakestoreapi.com/products/";
    private String producto;

    public GestionJson(String producto) {
        this.producto = producto;
    }

    public String llamarApi() throws IOException {
        String apiUrl = API_URL + producto;
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

    public String obtenerTituloProducto(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Producto producto = gson.fromJson(apiResponse, Producto.class);
            //Me confuncí y puse tittle con doble t por eso en los get sale asi pero esta cambiado en la clase
            return producto.getTittle();
        } else {
            return "";
        }
    }
    
    public float obtenerPrecioProducto(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Producto producto = gson.fromJson(apiResponse, Producto.class);
            return producto.getPrice();
        } else {
            return 0;
        }
    }
    
    public String obtenerDescripcionProducto(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Producto producto = gson.fromJson(apiResponse, Producto.class);
            return producto.getDescription();
        } else {
            return "";
        }
    }
    
    public String obtenerImagenProducto(String apiResponse) {
        if (apiResponse != null) {
            Gson gson = new Gson();
            Producto producto = gson.fromJson(apiResponse, Producto.class);
            return producto.getImage();
        } else {
            return "";
        }
    }
}
