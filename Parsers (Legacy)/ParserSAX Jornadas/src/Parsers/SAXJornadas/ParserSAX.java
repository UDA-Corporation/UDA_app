/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers.SAXJornadas;

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

    List datosnuevos;
        
    private String tempVal;

    //to maintain context
    private Jornada tempNew;

    public ParserSAX() {
        datosnuevos = new ArrayList();
    }

    public void run() {
        parseDocument();
        printData();
    }

    private void parseDocument() {

		//get a factory
        SAXParserFactory spf = SAXParserFactory.newInstance();

        try {

            //get a new instance of parser
            SAXParser sp = spf.newSAXParser();

            //parse the file and also register this class for call backs
            sp.parse("BDD(Jornadas).xml", this);

        } catch (SAXException se) {
            se.printStackTrace();
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }

    /**
     * Iterate through the list and print the contents
     */
    private void printData() {

        Iterator it = datosnuevos.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    //Controladores de Eventos
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //Reseteamos la variable temporal
        tempVal = "";
        if (qName.equalsIgnoreCase("item")) {
            //instanciamos una nueva Jornada
            tempNew = new Jornada();
            //Si tuviera atributos obtendríamos su información en este punto.      
            
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {
            
            if (qName.equalsIgnoreCase("jornada")) tempNew.setJornada(tempVal);

    }

    public static void main(String[] args) {

        ParserSAX spe = new ParserSAX();
        spe.run();
    }

}
