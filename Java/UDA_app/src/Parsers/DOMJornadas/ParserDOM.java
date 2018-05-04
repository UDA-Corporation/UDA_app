/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Parsers.DOMJornadas;

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
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import Modelo.BD.*;
import Modelo.UML.*;
import org.eclipse.persistence.indirection.IndirectList;

public class ParserDOM {
    ConexionBD conexion;
    //Parser
    List <JornadaParsers> jornadas;
    List <PartidoParsers> partidos;
    List <Equipo> equipos;
    //BDD
    List <Jornadas> jornadasBD;
    List <Partido> partidosBD;
    List <Equipo> equiposBD;
    Document dom;
    
    //Constructor
    ParserDOM(){
        jornadas = new ArrayList();
        
        conexion = new ConexionBD();       
        jornadasBD = conexion.getJornadaBD().findJornadasEntities();
        
        partidosBD = (List) conexion.getPartidoBD().findPartidoEntities();
        
        for (Partido p : partidosBD){
            System.out.println("");
        }
        
        for (Jornadas j : jornadasBD) {
            jornadas.add(new JornadaParsers(Integer.toString(j.getCod()), j.getFechai().toString(), j.getFechaf().toString()));
            partidosBD = (ArrayList) j.getPartidoCollection();                        
            for (int x=0;x<partidosBD.size();x++){                 
            }
        }
        partidos.add(new PartidoParsers("1","2","10-20"));
        partidos.add(new PartidoParsers("3","4","30-20"));
        partidos.add(new PartidoParsers("3","4","30-20"));
        partidos.add(new PartidoParsers("3","4","30-20"));
        partidos.add(new PartidoParsers("3","4","30-20"));
        partidos.add(new PartidoParsers("3","4","30-20"));
        partidos.add(new PartidoParsers("3","4","30-20"));
        partidos.add(new PartidoParsers("3","4","30-20"));
        cargarDatos();
        
    }
    
    public void ejecutar() {
        System.out.println("Comenzando consulta");
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
                    new FileOutputStream(new File("BDD(Jornadas).xml")), format);

            serializer.serialize(dom);

        } catch (IOException ie) {
            ie.printStackTrace();
        }
    }
    
private void crearArbolDOM() {

        //Cogemos la referencia al elemento raiz liga
        Element raizLiga = dom.getDocumentElement();
        //ELIMINAR CONTENIDO ANTERIOR
        
        
        
        
        
        
        
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
    
    private Element crearElementoJornada(JornadaParsers j){
        Element jornadaEle = dom.createElement("jornada");
        //Atributo codigo jornada
        getAtributo(jornadaEle, "codigoJornada", "codigo");
        jornadaEle.setAttribute("codigoJornada", j.getcodigoJornada());
        //Atributo fecha inicio
        getAtributo(jornadaEle, "fechaInicio", "fechaI");
        jornadaEle.setAttribute("fechaInicio", j.getfechaInicio());
        //Atributo fecha final
        getAtributo(jornadaEle, "fechaFinal", "fechaF");
        jornadaEle.setAttribute("fechaFinal", j.getfechaFinal());
        return jornadaEle;
    }
    
    private Element crearElementoPartido(PartidoParsers p) {
        //Crear elemento partido dentro de jornada
        Element partidoEle = dom.createElement("partido");
        //Atributo equipo 1
        getAtributo(partidoEle, "equipo1", "codigoequipo");
        partidoEle.setAttribute("equipo1", p.getEquipo1());
        //Atributo equipo 2
        getAtributo(partidoEle, "equipo2", "codigoequipo");
        partidoEle.setAttribute("equipo2", p.getEquipo2());
        //Crear elemento resultado dentro de partido
        Element resultadoEle = dom.createElement("resultado");
        Text resultadoText = dom.createTextNode(p.getResultado());
        resultadoEle.appendChild(resultadoText);
        partidoEle.appendChild(resultadoEle);
        return partidoEle;

    }
    
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
            dom = db.parse("BDD(Jornadas).xml");

        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (SAXException se) {
            se.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
    
    private void cargarDatos() {
        jornadas.add(new JornadaParsers("1","10-10-2018","20-11-2018"));
        jornadas.add(new JornadaParsers("2","10-10-2018","20-11-2018"));
    }
    
    public static void main(String args[]) {

        //create an instance
        ParserDOM datos = new ParserDOM();

        //run the example
        datos.ejecutar();
    }
    
}