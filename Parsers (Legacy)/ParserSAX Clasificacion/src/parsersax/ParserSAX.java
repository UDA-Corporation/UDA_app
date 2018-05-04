/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsersax;

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

    List myNews;
    
    private int contTitle = 0;
    
    private String tempVal;

    //to maintain context
    private Noticia tempNew;

    public ParserSAX() {
        myNews = new ArrayList();
    }

    public void runExample() {
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
            sp.parse("noticia.xml", this);

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

        System.out.println("Número de noticias '" + myNews.size() + "'.");

        Iterator it = myNews.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    //Controladores de Eventos
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //reseteamos la variable temporal
        tempVal = "";
        if (qName.equalsIgnoreCase("item")) {
            //instanciamos una nueva Noticia
            tempNew = new Noticia();
            //si tuviera atributos obtendríamos su información en este punto.            
        }
    }

    public void characters(char[] ch, int start, int length) throws SAXException {
        tempVal = new String(ch, start, length);
    }

    public void endElement(String uri, String localName, String qName) throws SAXException {

        if (qName.equalsIgnoreCase("item")) {
            //la noticia ya está totalmente construida y la agregamos a la lista
            myNews.add(tempNew);

        } else if (qName.equalsIgnoreCase("title")) {
            if (contTitle < 2)
                    contTitle++;
            else{
                tempNew.setTitle(tempVal);
                contTitle++;
            }
        } else if (qName.equalsIgnoreCase("link")) {
            if (contTitle > 2)
                tempNew.setLink(tempVal);
        } else if (qName.equalsIgnoreCase("pubDate")) {
                tempNew.setPubDate(tempVal);
        } else if (qName.equalsIgnoreCase("guid")) {
                tempNew.setGuid(tempVal);
        } else if (qName.equalsIgnoreCase("creator")) {
                tempNew.setCreator(tempVal);
        } else if (qName.equalsIgnoreCase("date")) {
                tempNew.setDate(tempVal);
        } else if (qName.equalsIgnoreCase("source")) {
                tempNew.setSource(tempVal);
        }

    }

    public static void main(String[] args) {

        System.out.println("Parseando Noticias Con SAX");
        System.out.println("--------------------------");

        ParserSAX spe = new ParserSAX();
        spe.runExample();
    }

}
