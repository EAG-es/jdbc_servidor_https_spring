package inweb.spring.jdbc_servidor_https_spring.controlador;

import innui.modelos.jdbc.sql_comandos;
import static inweb.spring.jdbc_servidor_https_spring.controlador.Con_rest_jdbc_servidor_https_spring.k_path;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author emilio
 */
@RestController
@RequestMapping(k_path) 
public class Con_rest_jdbc_servidor_https_spring {
    public static final String k_path_base = "/jdbc"; 
    public static final String k_path = k_path_base; 
    /**
     * POST: Los campos de texto no se deben enviar en el Path debido a los caracteres especiales que pueden contener
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers 
     * @param jdbc_peticiones 
     */
    @PostMapping("/crear")
    public void crear(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos jdbc_peticiones) {
    }
    /**
     * POST: Los campos de texto no se deben enviar en el Path debido a los caracteres especiales que pueden contener
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers 
     * @param jdbc_peticiones 
     * @return Un texto con las nuevas claves generadas automáticamente. 
     */
    @PostMapping("/crear/auto")
    public String crear_auto(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos jdbc_peticiones) {
        String texto="";     
        return texto;
    }
    /**
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers 
     * @param jdbc_peticiones 
     * @return  
     */
    @GetMapping("/leer")
    public String leer(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos jdbc_peticiones) {
        String texto="";     
        return texto;
    }
    /**
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers 
     * @param jdbc_peticiones 
     */
    @PostMapping("/actualizar")
    public void actualizar(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos jdbc_peticiones) {
    }
    /**
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers
     */
    @PostMapping("/borrar")
    public void borrar(@RequestHeader(required = true) Map<String, String> headers) {
    }
}
