package control;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Alejandro Diaz de Otalora
 * @author Luis Daniel Barragues
 * @author Unai Puelles
 * @version %G%
 * @since 0.1 alpha
 */
public class controladorTest {
    
    public controladorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of findUsuLogin method, of class controlador.
     */
    @Test
    public void testFindUsuLogin() {
        System.out.println("findUsuLogin");
        String usuario = "unaipuelles";
        String pass = "12345Abcde";
        boolean expResult = true;
        boolean result = controlador.findUsuLogin(usuario, pass);
        assertEquals(expResult, result);
    }
}
