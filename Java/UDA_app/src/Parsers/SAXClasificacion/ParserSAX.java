/**
 * @author Unai Puelles
 * @author Daniel Barragues
 * @author Alejandro Diaz de Otalora
 * @version %G%
 * @since 0.1 alpha
 */
package Parsers.SAXClasificacion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import org.xml.sax.helpers.DefaultHandler;

public class ParserSAX extends DefaultHandler {

    List equiposClasificacion;
        
    private String tempVal;
    
    //To maintain context
    private Equipos equipo;

    public ParserSAX() {
        equiposClasificacion = new ArrayList();
    }
    
    /**
     * Ejecuta el SAX
     */
    public void run() {
        parseDocument();
        printData();
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
            sp.parse("BDD(Clasificacion).xml", this);

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Iteramos la lista e imprimimos el contenido
     */
    private void printData() {

        System.out.println("Número de equipos '" + equiposClasificacion.size());
        //Reutilizable para imprimir los equipos
        Iterator it = equiposClasificacion.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    /**
     * Controlador de eventos. Se encarga de buscar los elementos equipo y una vez los localiza crea un objeto equipo y guarda los datos del elemento en el objeto.
     * @param uri 
     * @param localName 
     * @param qName 
     * @param attributes 
     * @throws SAXException 
     */
    public void startElement(String uri, String localName, String qName, Attributes attributes)  {
        //reseteamos la variable temporal
        tempVal = "";
        if (qName.equalsIgnoreCase("equipo")) {
            //instanciamos un nuevo Equipo
            equipo = new Equipos();
            //si tuviera atributos obtendríamos su información en este punto.        
            equipo.setCodEquipo(attributes.getValue("codEquipo"));
            equipo.setPuntos(attributes.getValue("puntos"));
            equipo.setPuesto(attributes.getValue("puesto"));
        }
    }
    
    /**
     * Se encarga de recorrer los elementos equipo y agregarlo a la lista
     * @param uri La URI Namespace o el String vacio si no la tiene
     * @param localName El nombre local o el string vacío si el proceso del Namespace no se esta ejecutando
     * @param qName El "qualified name" o el String vacio si no esta disponible
     * @throws SAXException Cualquier excepcion de SAX
     */
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("equipo")) {
            //la noticia ya está totalmente construida y la agregamos a la lista
            equiposClasificacion.add(equipo);
            equipo.setNombre(tempVal);
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

    public static void main(String[] args) {

        System.out.println("Comenzando lectura del XML con SAX");
        System.out.println("----------------------------------");

        ParserSAX spe = new ParserSAX();
        spe.run();
    }

}
