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
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

public class ParserDOM {
    List equipo;
    Document dom;
    Date date = new Date();
    
    //Constructor
    ParserDOM(){
    
        equipo = new ArrayList();
        //jornadasBD = conexion.getJornadaBD().findJornadasEntities();
        /*for (int i = 0; i < 3; i++) {
            
        }*/
        cargarDatos();        
    }
    
    /**
     * Se encarga de llamar a todos los elementos correspondientes del DOM
     */
    public void ejecutar() throws TransformerConfigurationException, ParserConfigurationException, TransformerException {
        System.out.println("Comenzando consulta a la BBDD");
        crearFicheroXML();
        //Volcamos el fichero xml en memoria como arbol de DOM
        parsearFicheroXML();
        //Creamos los elementos y los agregamos al arbol de DOM
        crearArbolDOM();
        //Escribimos el arbol DOM en el fichero XML
           
        escribirFicheroXML();
        System.out.println("Fichero actualizado correctamente");
    }
    
    private void crearFicheroXML() throws TransformerConfigurationException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        //Creamos la raiz
        Document XMLdoc = docBuilder.newDocument();
        Element rootEle = XMLdoc.createElement("liga");
        XMLdoc.appendChild(rootEle);
        rootEle.setTextContent(" ");
        //Creamos el documento
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(XMLdoc);
        StreamResult result = new StreamResult(new File("BDD(Clasificacion).xml"));
        transformer.transform(source, result);
    } 
    
    /**
     * Se encarga de editar el fichero XML
     */
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
    
    /**
     * Se encarga de crear los elementos, su contenido y sus atributos del XML
     */
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
    
    /**
     * Se encarga de crear el elemento clasificacion sin atributos como contenedor de elementos
     * @return devuelve el elemento clasificación creado
     */
    private Element crearElementoClasificacion(){
        Element clasificacionEle = dom.createElement("clasificacion");
        return clasificacionEle;
    }
    
    /**
     * Se encarga de crear el elemento equipo con sus atributos y texto
     * @param e le pasa el objeto e
     * @return devuelve el elemento equipo con todos sus atributos y texto
     */
    private Element crearElementoEquipo(Equipo e){
        //Crear elemento equipo dentro de clasificacion
        Element equipoEle = dom.createElement("equipo");
        //Indicamos el nombre del equipo en el elemento
        Text nombre = dom.createTextNode(e.getNombre());
        equipoEle.appendChild(nombre);
        //Atributo codigo de equipo
        equipoEle.setAttribute("codEquipo", e.getCodigoEquipo());
        //Atributo puntos
        equipoEle.setAttribute("puntos", e.getPuntos()); 
        //Atributo puesto
        equipoEle.setAttribute("puesto", e.getPuesto()); 
        return equipoEle;
    }
    
    /**
     * Se encarga de parsear el fichero XML con DOM
     */
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
    
    /**
     * Función que carga en el Array los objetos Equipo
     */
    private void cargarDatos() {
        equipo.add(new Equipo("12","30","2","Desttttttttttttttttttttttttttttttttttttroy3r"));
        equipo.add(new Equipo("12","30","2","Test2"));
        equipo.add(new Equipo("12","30","2","Test3"));
        equipo.add(new Equipo("12","30","2","Test4"));
        equipo.add(new Equipo("12","30","2","Test5"));
        equipo.add(new Equipo("12","30","2","Test6"));
    }
    
    public static void main(String args[]) throws TransformerConfigurationException, ParserConfigurationException, TransformerException {

        //Crea una nueva instancia
        ParserDOM datos = new ParserDOM();

        //Ejecutar el parser
        datos.ejecutar();
    }
    
}