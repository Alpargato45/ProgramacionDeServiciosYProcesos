
package actividadresuelta51;

import java.security.MessageDigest;
import java.security.Provider;
import java.security.Provider.Service;
import java.security.Security;
import java.util.Set;


public class ActividadResuelta51 {


    public static void main(String[] args) {
        
        // Se define el tipo de algoritmo como MessageDigest
        final String TIPO_MESSAGE_DIGEST = MessageDigest.class.getSimpleName();
        // Se obtiene la lista de los proveedores de seguridad instalados
        Provider[] proveedores = Security.getProviders();
        for (Provider proveedor: proveedores) {
            // Por cada proveedor se obtiene el conjunto de servicios
            Set<Service> servicios = proveedor.getServices();
            for (Service servicio: servicios) {
                // Se filtran los servicios por el tipo
                if (servicio.getType().equals(TIPO_MESSAGE_DIGEST)) {
                    System.out.println(servicio.getAlgorithm());
                }
            }
        }
        
    }
    
}
