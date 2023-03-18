package inweb.spring.jdbc_servidor_https_spring.controlador;

import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import static inweb.spring.servidor_https_spring.controlador.Pagina_inicio_factoria.k_mensaje_tex;
import java.util.ResourceBundle;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import static inweb.spring.servidor_https_spring.controlador.Pagina_inicio_factoria.k_ok_tex;
import static inweb.spring.servidor_https_spring.controlador.Pagina_inicio_factoria.k_titulo_tex;
import org.springframework.stereotype.Controller;

/**
 *
 * @author emilio
 */
@Controller
public class Con_jdbc_servidor_https_spring {
    public static String k_in_ruta = "in/inweb/spring/jdbc_servidor_https_spring/controlador/in";
    public static final String k_jdbc = "jdbc"; // Ruta Web desde la raiz del servidor HTTPS
    public static String k_index_html = k_jdbc + "/index.html"; // Ruta + Página Web de inicio
    public static String k_titulo = "JDBC con Servidor HTTPS Spring ";
    public static String k_mensaje = "Servidor iniciado. ";
    
    @GetMapping(k_jdbc)
    public String formulario_simple_get(Model model) throws Exception {
        oks ok = new oks();
        ResourceBundle in;
        try {
            in = ResourceBundles.getBundle(k_in_ruta);
            String texto = tr.in(in, k_titulo); // Traducible a otros lenguajes
            model.addAttribute(k_titulo_tex, texto);
            texto = tr.in(in, k_mensaje);
            model.addAttribute(k_mensaje_tex, texto);
        } catch (Exception e) {
            in = ResourceBundles.getBundle(k_in_ruta);
            ok.setTxt(tr.in(in, "Excepción inesperada "), e);
            model.addAttribute(k_ok_tex, ok.getTxt());
        }
        return k_index_html;
    }
    
}
