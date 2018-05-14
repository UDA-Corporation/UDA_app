/**
 * @author Unai Puelles
 * @author Daniel Barragues
 * @author Alejandro Diaz de Otalora
 * @version %G%
 * @since 0.4 alpha
 */
package Parsers.SAX;

import Parsers.DOMJornadas.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.TransformerException;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class ParserSAXJornadas extends DefaultHandler {

    public static Object[] Jornadas = new Object[210];
    int x = 0;
    public static boolean Jornadasexpirado = false;
        
    private String tempVal;
    Date fecha = new Date();
    
    /**
     * Ejecuta el SAX
     */
    public void ejecutar() {
        parseDocument();
    }
    
    /**
     * Parsea el documento creando una factoria SAX y le indicamos la ruta y nombre del documento a leer
     */
    private void parseDocument() {

        //Get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {

            //Get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            //Parse the file and also register this class for call backs
            sp.parse("BDD(Jornadas).xml", this);

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
    /* Usar si se necesita comprobar por consola el contenido
    private void printData() {

        System.out.println("Número de equipos '" + equiposClasificacion.size());
        //Reutilizable para imprimir los equipos
        Iterator it = equiposClasificacion.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }
    */
    
    /**
     * Controlador de eventos. Se encarga de buscar los elementos jornada y partido, una vez los localiza crea un array guarda los datos de los elementos en el array
     * @param uri El nombre del elemento a buscar (Namespaced URI)
     * @param localName El nombre local o el string vacío si el proceso del Namespace no se esta ejecutando
     * @param qName El "qualified name" o el String vacio si no esta disponible
     * @param attributes Los atributos presentes en el elemento
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {
        //Reseteamos la variable temporal
        tempVal = "";
        try {
            if (qName.equalsIgnoreCase("liga")){
                //Comprobamos si el documento está expirado
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                Date fechaEx = formatter.parse(attributes.getValue("fechaExpiracion"));
                System.out.println("Fecha de expiracion: " + fechaEx);
                if (fecha.after(fechaEx)){
                    Jornadasexpirado = true; //El SAX actual tiene el documento antiguo, el DOM se encargará de crear otro SAX que lea el nuevo, salimos de este SAX
                    System.out.println("Documento expirado, actualizando...");
                    ParserDOMJornadas JornadasDOM = new ParserDOMJornadas();
                    JornadasDOM.ejecutar();
                }
            } else if (qName.equalsIgnoreCase("jornada")) {
                //Si tuviera atributos obtendríamos su información en este punto.        
                Jornadas[x] = attributes.getValue("codigoJornada");
                x++;
                Jornadas[x] = attributes.getValue("fechaFinal");
                x++;
                Jornadas[x] = attributes.getValue("fechaInicio");
                x++;
            } else if (qName.equalsIgnoreCase("partido")) {
                //Si tuviera atributos obtendríamos su información en este punto.        
                Jornadas[x] = attributes.getValue("equipo1");
                x++;
                Jornadas[x] = attributes.getValue("equipo2");
                x++;
            }else if (qName.equalsIgnoreCase("resultado")) {
                //Si tuviera atributos obtendríamos su información en este punto.       
            } 
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ParserSAXClasificacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(ParserSAXClasificacion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ParserSAXClasificacion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Se encarga de recorrer los elementos resultados y agrega el texto del elemento al array
     * @param uri El nombre del elemento a buscar (Namespaced URI)
     * @param localName El nombre local o el string vacío si el proceso del Namespace no se esta ejecutando
     * @param qName El "qualified name" o el String vacio si no esta disponible
     * @throws SAXException Cualquier excepcion de SAX
     */
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("resultado")) {
            Jornadas[x] =tempVal;
            x++;
        }
    }
    
    /**
     * Recibe notificaciones de los caracteres dentro de un elemento
     * @param ch Los caracteres.
     * @param start La posicion de inicio del array de caracteres
     * @param length El numero de caracteres a usar del array de caracteres
     * @throws SAXException Cualquier excepcion de SAX
     */
    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }
}

