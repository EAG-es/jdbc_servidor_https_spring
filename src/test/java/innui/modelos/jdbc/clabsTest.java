package innui.modelos.jdbc;

import innui.modelos.errores.oks;
import java.util.Calendar;
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
    @Ignore
    public void testLeer() throws Exception {
        System.out.println("leer");
        sql_comandos sql_comando = new sql_comandos();
        oks ok = new oks();
        Object[] extra_array = null;
        clabs clab = new clabs();
        boolean expResult = true;
        sql_comando.clase_driver_jdbc = "com.mysql.cj.jdbc.Driver";
        sql_comando.clase_driver_jdbc_uri_conexion = "jdbc:mysql://localhost:3306/personas?zeroDateTimeBehavior=CONVERT_TO_NULL";
        jdbcs jdbc = new jdbcs();
        jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion
        , "personas", "sanosrep", ok);
        assertTrue(ok.es);
        clab.connection = jdbc.connection;
        sql_comando.leer_crear_lectura_columnas_lista(ok, "id_persona", "nombre", "apellidos"
        , "sexo", "fecha_nacimiento", "email", "telefono", "direccion_nombre"
        , "direccion_numero", "direccion_parte_extra_numero", "direccion_piso"
        , "direccion_puerta", "direccion_parte_extra_puerta", "ciudad", "codigo_postal"
        , "provincia_o_estado", "pais", "contraseña", "fecha_inicio_validez", "comentarios");
        String comando = "select <columnas> from personas order by apellidos limit ?, ?";
        sql_comando.leer_iniciar(comando, ok, extra_array);
        assertTrue(ok.es);
        int pagina_inicio_num = 0;
        sql_comando.leer_poner_valor(pagina_inicio_num, ok, extra_array);
        assertTrue(ok.es);
        int pagina_tam = 3;
        sql_comando.leer_poner_valor(pagina_tam, ok, extra_array);
        assertTrue(ok.es);
        boolean result = clab.leer(sql_comando, ok, extra_array);
        assertEquals(expResult, result);
    }

    /**
     * Test of borrar method, of class clabs.
     */
    @Test
    public void testBorrar() throws Exception {
        System.out.println("borrar");
        sql_comandos sql_comando = new sql_comandos();
        oks ok = new oks();
        Object[] extra_array = null;
        clabs clab = new clabs();
        boolean expResult = true;
        sql_comando.clase_driver_jdbc = "com.mysql.cj.jdbc.Driver";
        sql_comando.clase_driver_jdbc_uri_conexion = "jdbc:mysql://localhost:3306/personas?zeroDateTimeBehavior=CONVERT_TO_NULL";
        jdbcs jdbc = new jdbcs();
        jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion
        , "personas", "sanosrep", ok);
        assertTrue(ok.es);
        clab.connection = jdbc.connection;
        String comando = "delete from personas";
        sql_comando.borrar_iniciar(comando, ok, extra_array);
        assertTrue(ok.es);
        boolean result = clab.borrar(sql_comando, ok, extra_array);
        assertEquals(expResult, result);
    }

    /**
     * Test of crear method, of class clabs.
     */
    @Ignore
    public void testCrear_auto() throws Exception {
        System.out.println("crear_auto");
        sql_comandos sql_comando = new sql_comandos();
        oks ok = new oks();
        Object[] extra_array = null;
        clabs clab = new clabs();
        boolean expResult = true;
        sql_comando.clase_driver_jdbc = "com.mysql.cj.jdbc.Driver";
        sql_comando.clase_driver_jdbc_uri_conexion = "jdbc:mysql://localhost:3306/personas?zeroDateTimeBehavior=CONVERT_TO_NULL";
        jdbcs jdbc = new jdbcs();
        jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion
        , "personas", "sanosrep", ok);
        assertTrue(ok.es);
        clab.connection = jdbc.connection;
        String comando = "insert into personas (nombre, apellidos"
        + ", sexo, fecha_nacimiento, email, telefono, direccion_nombre"
        + ", direccion_numero, direccion_piso"
        + ", direccion_puerta, ciudad, codigo_postal"
        + ", provincia_o_estado, pais, contraseña, fecha_inicio_validez, comentarios"
        + ") values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ;
        sql_comando.crear_clave_nueva_columnas_lista(ok, "id_persona");
        assertTrue(ok.es);
        sql_comando.crear_iniciar(comando, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Pepe", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Pótamo Circense", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("XY", ok, extra_array);
        assertTrue(ok.es);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 10, 1);
        sql_comando.crear_poner_valor(calendar.getTime(), ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("email@email.com", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("555667788", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Calle Dirección", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(10, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(1, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("A", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Ciudad", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(10001, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Provincia", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("País", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("contraseña", ok, extra_array);
        assertTrue(ok.es);
        calendar.set(2023, 03, 20, 11, 23);
        sql_comando.crear_poner_valor(calendar.getTime(), ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Comentario\nmultilínea", ok, extra_array);
        assertTrue(ok.es);
        boolean result = clab.crear_auto(sql_comando, ok, extra_array);
        assertEquals(expResult, result);
        sql_comando.crear_iniciar(comando, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Julia", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Juila Juial", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("XX", ok, extra_array);
        assertTrue(ok.es);
        calendar.set(2000, 10, 2);
        sql_comando.crear_poner_valor(calendar.getTime(), ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("email_1@email.com", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("555778899", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Calle Dirección 1", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(11, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(2, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("B", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Ciudad 1", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(20002, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Provincia 1", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("País 1", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("contraseña 1", ok, extra_array);
        assertTrue(ok.es);
        calendar.set(2023, 03, 21, 12, 24);
        sql_comando.crear_poner_valor(calendar.getTime(), ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Comentario\nmultilínea\n1", ok, extra_array);
        assertTrue(ok.es);
        result = clab.crear_auto(sql_comando, ok, extra_array);
        assertEquals(expResult, result);
        sql_comando.crear_iniciar(comando, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Mairoa", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Yoieya Eyaiyo", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("..", ok, extra_array);
        assertTrue(ok.es);
        calendar.set(2000, 10, 3);
        sql_comando.crear_poner_valor(calendar.getTime(), ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("email_2@email.com", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("555889900", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Calle Dirección 2", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(11, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(2, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("C", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Ciudad 2", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(30003, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Provincia 2", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("País 2", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("contraseña 2", ok, extra_array);
        assertTrue(ok.es);
        calendar.set(2023, 03, 22, 13, 25);
        sql_comando.crear_poner_valor(calendar.getTime(), ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Comentario\nmultilínea\n2", ok, extra_array);
        assertTrue(ok.es);
        result = clab.crear_auto(sql_comando, ok, extra_array);
        assertEquals(expResult, result);
        sql_comando.crear_iniciar(comando, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Paco", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Mery Zenar", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("XY", ok, extra_array);
        assertTrue(ok.es);
        calendar.set(2000, 10, 4);
        sql_comando.crear_poner_valor(calendar.getTime(), ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("email_2@email.com", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("555990011", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Calle Dirección 3", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(12, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(3, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("D", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Ciudad 3", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor(40004, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Provincia 3", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("País 3", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("contraseña 3", ok, extra_array);
        assertTrue(ok.es);
        calendar.set(2023, 03, 22, 13, 25);
        sql_comando.crear_poner_valor(calendar.getTime(), ok, extra_array);
        assertTrue(ok.es);
        sql_comando.crear_poner_valor("Comentario\nmultilínea\n3", ok, extra_array);
        assertTrue(ok.es);
        result = clab.crear_auto(sql_comando, ok, extra_array);
        assertEquals(expResult, result);
    }

    /**
     * Test of crear_auto method, of class clabs.
     */
    @Ignore
    public void testCrear() throws Exception {
        System.out.println("crear");
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
        sql_comandos sql_comando = new sql_comandos();
        oks ok = new oks();
        Object[] extra_array = null;
        clabs clab = new clabs();
        boolean expResult = true;
        sql_comando.clase_driver_jdbc = "com.mysql.cj.jdbc.Driver";
        sql_comando.clase_driver_jdbc_uri_conexion = "jdbc:mysql://localhost:3306/personas?zeroDateTimeBehavior=CONVERT_TO_NULL";
        jdbcs jdbc = new jdbcs();
        jdbc.conectar(sql_comando.clase_driver_jdbc, sql_comando.clase_driver_jdbc_uri_conexion
        , "personas", "sanosrep", ok);
        assertTrue(ok.es);
        clab.connection = jdbc.connection;
        String comando = "update personas set nombre = ?, apellidos = ?,"
        + " email = ?, telefono = ?"
        + " where nombre = ?" ;
        sql_comando.actualizar_iniciar(comando, ok, extra_array);
        assertTrue(ok.es);
        sql_comando.actualizar_poner_valor("José", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.actualizar_poner_valor("Samo Rico", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.actualizar_poner_valor("josesamorico@email.es", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.actualizar_poner_valor("555000001", ok, extra_array);
        assertTrue(ok.es);
        sql_comando.actualizar_poner_valor("Pepe", ok, extra_array);
        assertTrue(ok.es);
        boolean result = clab.actualizar(sql_comando, ok, extra_array);
        assertEquals(expResult, result);
    }
    
}
