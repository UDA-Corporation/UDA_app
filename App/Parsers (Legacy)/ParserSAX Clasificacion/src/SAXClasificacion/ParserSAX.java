/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SAXClasificacion;

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
    
    //to maintain context
    private Equipos equipo;

    public ParserSAX() {
        equiposClasificacion = new ArrayList();
    }

    public void runExample() {
        parseDocument();
        printData();
    }

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

        System.out.println("Número de equipos '" + equiposClasificacion.size() + "'.");
        //Reutilizable para imprimir los equipos
        Iterator it = equiposClasificacion.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    //Controladores de Eventos
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
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
    
    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("equipo")) {
            //la noticia ya está totalmente construida y la agregamos a la lista
            equiposClasificacion.add(equipo);
            equipo.setNombre(tempVal);
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public static void main(String[] args) {

        System.out.println("Comenzando lectura del XML con SAX");
        System.out.println("----------------------------------");

        ParserSAX spe = new ParserSAX();
        spe.runExample();
    }

}
