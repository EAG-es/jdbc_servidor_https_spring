package innui.modelos.jdbc;

import innui.modelos.errores.oks;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Ignore;
import org.junit.Test;

/**
 *
 * @author emilio
 */
public class clabsTest {
    
    public clabsTest() {
    }

    /**
     * Test of leer method, of class clabs.
     */
    @Test
    public void testLeer() throws Exception {
        System.out.println("leer");
        sql_comandos sql_comando = new sql_comandos();
        oks ok = new oks();
        Object[] extra_array = null;
        clabs clab = new clabs();
        boolean expResult = true;
        sql_comando.clase_driver_jdbc = "com.mysql.cj.jdbc.Driver";
        sql_comando.clase_driver_jdbc_uri_conexion = "jdbc:mysql://localhost:3306/elecciones?zeroDateTimeBehavior=CONVERT_TO_NULL";
        jdbcs jdbc = new jdbcs();
        jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion
        , "root", "oilime", ok);
        assertTrue(ok.es);
        clab.connection = jdbc.connection;
        sql_comando.crear_columnas_leer_lista(ok, "id_circunscripcion"
        , "nombre_circunscripcion", "tipo_division", "ref_circunscripcion");
        sql_comando.leer_sql = "select <columnas> from circunscripciones";
        sql_comando.iniciar(ok, extra_array);
        boolean result = clab.leer(sql_comando, ok, extra_array);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrar method, of class clabs.
     */
    @Ignore
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        sql_comandos jdbc_peticion = null;
        oks ok = null;
        Object[] extra_array = null;
        clabs instance = new clabs();
        boolean expResult = false;
        boolean result = instance.borrar(jdbc_peticion, ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crear method, of class clabs.
     */
    @Ignore
    public void testCrear() throws Exception {
        System.out.println("crear");
        sql_comandos jdbc_peticion = null;
        oks ok = null;
        Object[] extra_array = null;
        clabs instance = new clabs();
        boolean expResult = false;
        boolean result = instance.crear(jdbc_peticion, ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of crear_auto method, of class clabs.
     */
    @Ignore
    public void testCrear_auto() throws Exception {
        System.out.println("crear_auto");
        sql_comandos jdbc_peticion = null;
        oks ok = null;
        Object[] extra_array = null;
        clabs instance = new clabs();
        boolean expResult = false;
        boolean result = instance.crear_auto(jdbc_peticion, ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of actualizar method, of class clabs.
     */
    @Ignore
    public void testActualizar() throws Exception {
        System.out.println("actualizar");
        sql_comandos jdbc_peticion = null;
        oks ok = null;
        Object[] extra_array = null;
        clabs instance = new clabs();
        boolean expResult = false;
        boolean result = instance.actualizar(jdbc_peticion, ok, extra_array);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
