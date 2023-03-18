package inweb.spring.jdbc_servidor_https_spring.controlador;

import innui.modelos.configuraciones.ResourceBundles;
import innui.modelos.errores.oks;
import innui.modelos.internacionalizacion.tr;
import static inweb.spring.servidor_https_spring.controlador.Pagina_inicio_factoria.k_titulo_tex;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;
import java.util.ResourceBundle;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.BINDING_ERRORS;
import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.MESSAGE;
import static org.springframework.boot.web.error.ErrorAttributeOptions.Include.STACK_TRACE;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import static inweb.spring.jdbc_servidor_https_spring.controlador.Con_jdbc_servidor_https_spring.k_jdbc;

/**
 * Basic Controller which is called for unhandled errors
 */
@Controller
public class Con_error implements ErrorController{
    public static String k_in_ruta = "in/inweb/spring/jdbc_servidor_https_spring/controlador/in";
    public static final String k_error_ruta = "/error";
    public static String k_marca_de_tiempo_tex = "marca_de_tiempo_tex";
    public static String k_status_tex = "status_tex";
    public static String k_error_tex = "error_tex";
    public static String k_ruta_tex = "ruta_tex";
    
    public static String k_error_html = k_jdbc + "/error.html"; // Ruta + Página Web de inicio
    public ErrorAttributes errorAttributes;

    public Con_error(ErrorAttributes errorAttributes) {
        this.errorAttributes = errorAttributes;
    }

    @RequestMapping(value = k_error_ruta, produces = "text/html")
    public ModelAndView errorHtml(HttpServletRequest request) {
        ResourceBundle in;
        oks ok = new oks();
        Map<String, Object> model_mapa = _getErrorAttributes(request, true);
        try {
            in = ResourceBundles.getBundle(k_in_ruta);
            model_mapa.put(k_titulo_tex, tr.in(in, "Error o Prohibición de Thymeleaf (comprobar el uso de th:action) "));
            model_mapa.put(k_marca_de_tiempo_tex, tr.in(in, "Marca de tiempo: "));
            model_mapa.put(k_status_tex, tr.in(in, "Status: "));
            model_mapa.put(k_error_tex, tr.in(in, "Error: "));
            model_mapa.put(k_ruta_tex, tr.in(in, "Ruta: "));
        } catch (Exception e) {
            ok.setTxt(e);
            try { model_mapa.put(k_error_tex, ok.getTxt()); } catch (Exception e_ignorada) {};
        }
        return new ModelAndView(k_error_html, model_mapa);
    }

    /**
     * Supports other formats like JSON, XML
     * @param request
     * @return
     */
//    @RequestMapping(value = k_error_ruta)
//    @ResponseBody
//    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
//        Map<String, Object> body = _getErrorAttributes(request, _getTraceParameter(request));
//        HttpStatus status = _getStatus(request);
//        return new ResponseEntity<Map<String, Object>>(body, status);
//    }

    /**
     * Returns the path of the error page.
     *
     * @return the error path
     */
    public String getErrorPath() {
        return k_error_ruta;
    }


    public boolean _getTraceParameter(HttpServletRequest request) {
        String parameter = request.getParameter("trace");
        if (parameter == null) {
            return false;
        }
        return !"false".equals(parameter.toLowerCase());
    }

    public Map<String, Object> _getErrorAttributes(HttpServletRequest request
            , boolean es_extras_incluidos) {
        Map<String, Object> retorno;
        WebRequest requestAttributes = new ServletWebRequest(request);
        ErrorAttributeOptions errorAttributeOptions = ErrorAttributeOptions.defaults();
        if (es_extras_incluidos) {
            errorAttributeOptions = errorAttributeOptions.including(STACK_TRACE);
            errorAttributeOptions = errorAttributeOptions.including(MESSAGE);
            errorAttributeOptions = errorAttributeOptions.including(BINDING_ERRORS);
        }
        retorno = this.errorAttributes.getErrorAttributes(requestAttributes,
                errorAttributeOptions);
        return retorno;
    }

    public HttpStatus _getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        if (statusCode != null) {
            try {
                return HttpStatus.valueOf(statusCode);
            }
            catch (Exception ex) {
            }
        }
        return HttpStatus.INTERNAL_SERVER_ERROR;
    }
}