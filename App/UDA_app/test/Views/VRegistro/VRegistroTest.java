/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views.VRegistro;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author unai-
 */
public class VRegistroTest {
    
    public VRegistroTest() {
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
     * Test of validar method, of class VRegistro.
     */
    @Test
    public void testValidar() {
        System.out.println("validar");
        String cadena = "12345Abcde!";
        String patt = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])([A-Za-z\\d$@$!%*?&]|[^ ]){8,15}$";
        VRegistro instance = new VRegistro();
        boolean expResult = true;
        boolean result = instance.validar(cadena, patt);
        assertEquals(expResult, result);
    }
}
