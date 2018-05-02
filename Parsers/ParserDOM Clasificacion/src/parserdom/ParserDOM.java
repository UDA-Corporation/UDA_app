/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parserdom;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import parserdom.Clasificacion.*;

public class ParserDOM {
    List equipo;
    List jornadasBD;
    Document dom;
    
    //Constructor
    ParserDOM(){
    
        equipo = new ArrayList();
        //jornadasBD = conexion.getJornadaBD().findJornadasEntities();
        /*for (int i = 0; i < 3; i++) {
            
        }*/
        cargarDatos();        
    }
    
    public void ejecutar() {
        System.out.println("Comenzando consulta a la BBDD");
        //Volcamos el fichero xml en memoria como arbol de DOM
        parsearFicheroXML();
        //Creamos los elementos y los agregamos al arbol de DOM
        crearArbolDOM();
        //Escribimos el arbol DOM en el fichero XML
        escribirFicheroXML();
        System.out.println("Fichero actualizado correctamente");
    }

    private void escribirFicheroXML() {

        try {
            //Configuramos el formato de salida del fichero
            OutputFormat format = new OutputFormat(dom);
            format.setIndenting(true);

            //to generate a file output use fileoutputstream instead of system.out
            XMLSerializer serializer = new XMLSerializer(
                    new FileOutputStream(new File("BDD(Clasificacion).xml")), format);

            serializer.serialize(dom);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
private void crearArbolDOM() {

        //Cogemos la referencia al elemento raiz liga
        Element raiz = dom.getDocumentElement();
        //ELIMINAR CLASIFICACION
        Node eliminar = raiz.getFirstChild();
        raiz.removeChild(eliminar);
        
        
        //DOM y los agregamos a la raiz
        Iterator it = equipo.iterator();
        Element clasificacionEle = crearElementoClasificacion();
        raiz.appendChild(clasificacionEle);
        while(it.hasNext()) {
            Equipo e = (Equipo) it.next();
            //Obtenemos la información
            Element equipoEle = crearElementoEquipo(e);
            clasificacionEle.appendChild(equipoEle);
        }

    }
    
    //Creamos clasificacion sin atributos como contenedor de elementos
    private Element crearElementoClasificacion(){
        Element clasificacionEle = dom.createElement("clasificacion");
        return clasificacionEle;
    }
    
    //Creamos el elemento equipo con sus atributos y texto
    private Element crearElementoEquipo(Equipo e){
        //Crear elemento equipo dentro de clasificacion
        Element equipoEle = dom.createElement("equipo");
        //Indicamos el nombre del equipo en el elemento
        Text nombre = dom.createTextNode(e.getNombre());
        equipoEle.appendChild(nombre);
        //Atributo codigo de equipo
        getAtributo(equipoEle, "codEquipo", "codigoequipo");
        equipoEle.setAttribute("codEquipo", e.getCodigoEquipo());
        //Atributo puntos
        getAtributo(equipoEle, "puntos", "puntos");
        equipoEle.setAttribute("puntos", e.getPuntos()); 
        //Atributo puesto
        getAtributo(equipoEle, "puesto", "puesto");
        equipoEle.setAttribute("puesto", e.getPuesto()); 
        return equipoEle;
    }
    
    //Localizamos el atributo del elemento
    private String getAtributo(Element empEl, String etiqueta, String att) {
        String atributo = "";
        NodeList nl = empEl.getElementsByTagName(etiqueta);
        if (nl != null && nl.getLength() > 0) {
            Element el = (Element) nl.item(0);
            atributo = el.getAttribute(att);
        }

        return atributo;
    }

    private void parsearFicheroXML() {
        //Creamos el DocumentBuilderFactory
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try {

            //Using factory get an instance of document builder
            DocumentBuilder db = dbf.newDocumentBuilder();

            //parse using builder to get DOM representation of the XML file
            dom = db.parse("BDD(Clasificacion).xml");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    private void cargarDatos() {
        equipo.add(new Equipo("12","30","2","Destroy3r"));
        equipo.add(new Equipo("12","30","2","Destroy3r"));
        equipo.add(new Equipo("12","30","2","Destroy3r"));
        equipo.add(new Equipo("12","30","2","Destroy3r"));
        equipo.add(new Equipo("12","30","2","Destroy3r"));
        equipo.add(new Equipo("12","30","2","Destroy3r"));
    }
    
    public static void main(String args[]) {

        //create an instance
        ParserDOM datos = new ParserDOM();

        //run the example
        datos.ejecutar();
    }
    
}