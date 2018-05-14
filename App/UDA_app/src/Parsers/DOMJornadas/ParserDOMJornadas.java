/**
 * @author Unai Puelles
 * @author Daniel Barragues
 * @author Alejandro Diaz de Otalora
 * @version %G%
 * @since 0.1 alpha
 */
package Parsers.DOMJornadas;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import Modelo.BD.*;
import Modelo.UML.*;
import Parsers.SAX.ParserSAXJornadas;
import static Parsers.SAX.ParserSAXJornadas.Jornadasexpirado;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.util.ArrayList;

public class ParserDOMJornadas {
    ConexionBD conexion;
    Calendar c = Calendar.getInstance();
    Calendar c1 = Calendar.getInstance();
    //Parser
    List <JornadaParsers> jornadas;
    List <PartidoParsers> partidos;
    //BDD
    List <Jornadas> jornadasBD;
    Collection <Partido> CollectionpartidosBD;
    ArrayList <Partido> partidosBD;
    Collection <Equipo> CollectionequiposBD;
    ArrayList <Equipo> equiposBD;
    Document dom;
    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
    
    //Constructor
    public ParserDOMJornadas(){
        PartidoParsers p;
        jornadas = new ArrayList();  
        partidos = new ArrayList();
        conexion = new ConexionBD();       
        jornadasBD = conexion.getJornadaBD().findJornadasEntities();
        for (Jornadas j : jornadasBD) {
            jornadas.add(new JornadaParsers(Integer.toString(j.getCod()), formatter.format(j.getFechai()), formatter.format(j.getFechaf())));
            CollectionpartidosBD = j.getPartidoCollection();   
            partidosBD = new ArrayList(CollectionpartidosBD);
            for (Partido par : partidosBD){
                p = new PartidoParsers();
                p.setResultado(par.getResultado());
                partidos.add(p);
                CollectionequiposBD = par.getEquipoCollection();
                equiposBD = new ArrayList (CollectionequiposBD);
                p.setEquipo1(equiposBD.get(0).getNombre());
                p.setEquipo2(equiposBD.get(1).getNombre());
            }
        }
    }
    
    /**
     * Se encarga de llamar a todos los elementos correspondientes del DOM
     * @throws ParserConfigurationException Excepcion en la configuracion del parser
     * @throws TransformerException Excepcion en la creacion del fichero XML
     */
    public void ejecutar() throws ParserConfigurationException, TransformerException {
        System.out.println("Comenzando consulta");
        //Creamos el fichero XML
        crearFicheroXML();
        //Volcamos el fichero xml en memoria como arbol de DOM
        parsearFicheroXML();
        //Creamos los elementos y los agregamos al arbol de DOM
        crearArbolDOM();
        //Escribimos el arbol DOM en el fichero XML
        escribirFicheroXML();
        System.out.println("Fichero actualizado correctamente");
        if (Jornadasexpirado == false){
            ParserSAXJornadas JornadasSAX = new ParserSAXJornadas();
            JornadasSAX.ejecutar();
        }
    }
    
    /**
     * Crea el fichero XML con una raiz liga
     * @throws TransformerConfigurationException Excepcion en la creacion del fichero XML
     * @throws ParserConfigurationException Excepcion en la configuracion del parser
     * @throws TransformerException Excepcion en la creacion del fichero XML
     */
    private void crearFicheroXML() throws TransformerConfigurationException, ParserConfigurationException, TransformerException {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        //Creamos la raiz
        Document XMLdoc = docBuilder.newDocument();
        Element raizLiga = XMLdoc.createElement("liga");
        XMLdoc.appendChild(raizLiga);
        raizLiga.setTextContent("");
        DateFormat format = new SimpleDateFormat("EEEE");
        String fecha2 = format.format(new Date());
        switch (fecha2.toLowerCase()){
            case "monday":
            case "lunes":
                c.add(Calendar.DATE, 7);
            break;
            case "tuesday":
            case "martes":
                c.add(Calendar.DATE, 6);
            break;
            case "wednesday":
            case "miercoles":
            case "miércoles":
                c.add(Calendar.DATE, 5);
            break;
            case "thursday":
            case "jueves":
                c.add(Calendar.DATE, 4);
            break;
            case "friday":
            case "viernes":
                c.add(Calendar.DATE, 3);
            break;
            case "saturday":
            case "sabado":
            case "sábado":
                c.add(Calendar.DATE, 2);
            break;
            case "sunday":
            case "domingo":
                c.add(Calendar.DATE, 1);
            break;
        }
        Date fecha = new Date();
        fecha = c.getTime();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
        raizLiga.setAttribute("fechaExpiracion", formatter.format(fecha));
        //Creamos el documento
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(XMLdoc);
        StreamResult result = new StreamResult(new File("BDD(Jornadas).xml"));
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
            new FileOutputStream(new File("BDD(Jornadas).xml")), format);

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
        Element raizLiga = dom.getDocumentElement();
        //DOM y los agregamos a la raiz <agenda>
        Iterator it = jornadas.iterator();
        Iterator it2 = partidos.iterator();
        while(it.hasNext()) {
            JornadaParsers j = (JornadaParsers) it.next();
            //Obtenemos la información
            Element jornadaEle = crearElementoJornada(j);
            raizLiga.appendChild(jornadaEle);
            for (int i = 0;i<4;i++){
                PartidoParsers p = (PartidoParsers) it2.next();
                Element partidoEle = crearElementoPartido(p);
                jornadaEle.appendChild(partidoEle);
            }
        }

    }
    
    /**
     * Se encarga de crear el elemento jornada con sus atributos codigo, fecha inicio y final
     * @return devuelve el elemento jornada creado
     */
    private Element crearElementoJornada(JornadaParsers j){
        Element jornadaEle = dom.createElement("jornada");
        //Atributo codigo jornada
        jornadaEle.setAttribute("codigoJornada", j.getcodigoJornada());
        //Atributo fecha inicio
        jornadaEle.setAttribute("fechaInicio", j.getfechaInicio());
        //Atributo fecha final
        jornadaEle.setAttribute("fechaFinal", j.getfechaFinal());
        return jornadaEle;
    }
    
    /**
     * Se encarga de crear el elemento partido con sus atributos equipo1 y equipo 2
     * @return devuelve el elemento clasificación creado
     */
    private Element crearElementoPartido(PartidoParsers p) {
        //Crear elemento partido dentro de jornada
        Element partidoEle = dom.createElement("partido");
        //Atributo equipo 1
        partidoEle.setAttribute("equipo1", p.getEquipo1());
        //Atributo equipo 2
        partidoEle.setAttribute("equipo2", p.getEquipo2());
        //Crear elemento resultado dentro de partido
        Element resultadoEle = dom.createElement("resultado");
        Text resultadoText = dom.createTextNode(p.getResultado());
        resultadoEle.appendChild(resultadoText);
        partidoEle.appendChild(resultadoEle);
        return partidoEle;

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
            dom = db.parse("BDD(Jornadas).xml");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }   
}