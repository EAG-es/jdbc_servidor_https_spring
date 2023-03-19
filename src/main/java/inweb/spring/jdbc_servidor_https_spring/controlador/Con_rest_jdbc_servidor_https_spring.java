package inweb.spring.jdbc_servidor_https_spring.controlador;

import innui.modelos.errores.oks;
import innui.modelos.jdbc.clabs;
import innui.modelos.jdbc.jdbcs;
import innui.modelos.jdbc.sql_comandos;
import static inweb.spring.jdbc_servidor_https_spring.controlador.Con_rest_jdbc_servidor_https_spring.k_path;
import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import static inweb.spring.servidor_https_spring.Configuracion_servidor_https.k_path_restful_sin_csrf;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author emilio
 */
@RestController
@RequestMapping(k_path) 
public class Con_rest_jdbc_servidor_https_spring {
    public static final String k_path = k_path_restful_sin_csrf + "/jdbc_servidor_https_spring"; 
    public static final String k_path_crear = "/crear"; 
    public static final String k_path_crear_auto = "/crear/auto"; 
    public static final String k_path_leer = "/leer"; 
    public static final String k_path_actualizar = "/actualizar"; 
    public static final String k_path_borrar = "/borrar"; 
    public static String jdbc_servidor_usuario_tex = "jdbc.usuario";
    public static String jdbc_servidor_clave_tex = "jdbc.clave";        

    @GetMapping("/prueba")
    public String prueba_get() throws Exception {
        String texto;
        texto = "Petición recibida";
        return texto;
    }
    @PostMapping("/prueba")
    public String prueba_post() throws Exception {
        String texto;
        texto = "Petición recibida";
        return texto;
    }

    /**
     * POST: Los campos de texto no se deben enviar en el Path debido a los caracteres especiales que pueden contener
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers 
     * @param sql_comando 
     * @return  
     * @throws java.lang.Exception 
     */
    @GetMapping(k_path_crear)
    public ResponseEntity<String> crear(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos sql_comando) throws Exception {
        clabs clab;
        jdbcs jdbc;
        oks ok = new oks();
        String usuario;
        String contraseña;
        try {
            usuario = headers.get(jdbc_servidor_usuario_tex);
            contraseña = headers.get(jdbc_servidor_clave_tex);
            jdbc = new jdbcs();
            while (true) {
                jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion, usuario, contraseña, ok);
                if (ok.es == false) { break;}
                clab = new clabs();
                clab.connection = jdbc.connection;
                clab.crear(sql_comando, ok);
                break;
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ok.getTxt());
        } else {
            return ResponseEntity.ok().build();
        }
    }
    /**
     * POST: Los campos de texto no se deben enviar en el Path debido a los caracteres especiales que pueden contener
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers 
     * @param sql_comando 
     * @return Un texto con las nuevas claves generadas automáticamente. 
     * @throws java.lang.Exception 
     */
    @PostMapping(k_path_crear_auto)
    @GetMapping(k_path_crear_auto)
    @ResponseBody  // devuelve JSON
    public ResponseEntity crear_auto(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos sql_comando) throws Exception {
        clabs clab;
        jdbcs jdbc;
        oks ok = new oks();
        String usuario;
        String contraseña;
        try {
            usuario = headers.get(jdbc_servidor_usuario_tex);
            contraseña = headers.get(jdbc_servidor_clave_tex);
            jdbc = new jdbcs();
            while (true) {
                jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion, usuario, contraseña, ok);
                if (ok.es == false) { break;}
                clab = new clabs();
                clab.connection = jdbc.connection;
                clab.crear_auto(sql_comando, ok);
                break;
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            return new ResponseEntity<>(ok.getTxt(), HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(sql_comando, HttpStatus.OK);
        }
    }
    /**
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers 
     * @param sql_comando 
     * @return  
     * @throws java.lang.Exception  
     */
    @PostMapping(k_path_leer)
    @GetMapping(k_path_leer)
    @ResponseBody  // devuelve JSON
    public ResponseEntity leer(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos sql_comando) throws Exception {
        clabs clab;
        jdbcs jdbc;
        oks ok = new oks();
        String usuario;
        String contraseña;
        try {
            usuario = headers.get(jdbc_servidor_usuario_tex);
            contraseña = headers.get(jdbc_servidor_clave_tex);
            jdbc = new jdbcs();
            while (true) {
                jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion, usuario, contraseña, ok);
                if (ok.es == false) { break;}
                clab = new clabs();
                clab.connection = jdbc.connection;
                clab.leer(sql_comando, ok);
                break;
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            return new ResponseEntity<>(ok.getTxt(), HttpStatus.CONFLICT);
        } else {
            return new ResponseEntity<>(sql_comando, HttpStatus.OK);
        }
    }
    /**
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers 
     * @param sql_comando 
     * @return  
     * @throws java.lang.Exception 
     */
    @PostMapping(k_path_actualizar)
    @GetMapping(k_path_actualizar)
    public ResponseEntity<String> actualizar(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos sql_comando) throws Exception {
        clabs clab;
        jdbcs jdbc;
        oks ok = new oks();
        String usuario;
        String contraseña;
        try {
            usuario = headers.get(jdbc_servidor_usuario_tex);
            contraseña = headers.get(jdbc_servidor_clave_tex);
            jdbc = new jdbcs();
            while (true) {
                jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion, usuario, contraseña, ok);
                if (ok.es == false) { break;}
                clab = new clabs();
                clab.connection = jdbc.connection;
                clab.actualizar(sql_comando, ok);
                break;
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ok.getTxt());
        } else {
            return ResponseEntity.ok().build();
        }
    }
    /**
     * Si la petición no tiene los datos requeridos (required) devuelve un error 405, 400, 4xx
     * @param headers
     * @param sql_comando
     * @return 
     * @throws java.lang.Exception
     */
    @PostMapping(k_path_borrar)
    @GetMapping(k_path_borrar)
    public ResponseEntity<String> borrar(@RequestHeader(required = true) Map<String, String> headers
            , @RequestBody(required = true) sql_comandos sql_comando) throws Exception {
        clabs clab;
        jdbcs jdbc;
        oks ok = new oks();
        String usuario;
        String contraseña;
        try {
            usuario = headers.get(jdbc_servidor_usuario_tex);
            contraseña = headers.get(jdbc_servidor_clave_tex);
            jdbc = new jdbcs();
            while (true) {
                jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion, usuario, contraseña, ok);
                if (ok.es == false) { break;}
                clab = new clabs();
                clab.connection = jdbc.connection;
                clab.borrar(sql_comando, ok);
                break;
            }
        } catch (Exception e) {
            ok.setTxt(e);
        }
        if (ok.es == false) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ok.getTxt());
        } else {
            return ResponseEntity.ok().build();
        }
    }
}
