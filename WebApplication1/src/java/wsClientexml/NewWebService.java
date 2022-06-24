/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wsClientexml;

import java.io.IOException;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Dalto
 */
@WebService(serviceName = "NewWebService")
public class NewWebService {

    private final String base = "Personas";
    private final String usuario = "postgres";
    private final String clave = "25112011";
    private final String url = "jdbc:postgresql://localhost:5432/" + base;

//    
    private java.sql.Statement statement;
    private Connection connection;
    private ResultSet resultSet;


    /**
     * Web service operation
     *
     * @param File
     * @return
     */
    @WebMethod(operationName = "Insertar")
    public String operation(@WebParam(name = "File") String File) {
        //TODO write your implementation code here:
        String res = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new InputSource(new StringReader(File)));
            Element formato = document.getDocumentElement();

            String cedula = getValueTag("cedula", formato);
            String nombre = getValueTag("nombre", formato);
            String apellido = getValueTag("apellido", formato);
            
            try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, clave);
            statement = connection.createStatement();
            int resultado = statement.executeUpdate("INSERT INTO public.personas(cedula, nombre, apellido) VALUES ('" + cedula + "','" + nombre + "','" + apellido + "' )");
            connection.close();
            res= "Se ah guardado correctamente";
        } catch (ClassNotFoundException | SQLException exception) {
            res="No fue posible la operacion "+exception.getMessage();
        }
            
        } catch (IOException | ParserConfigurationException | SAXException e) {
            
        }
        return res;
    }

    private String getValueTag(String tagName, Element element) {
        String res = "";
        NodeList list = element.getElementsByTagName(tagName);
        if (list != null && list.getLength() > 0) {
            NodeList subList = list.item(0).getChildNodes();

            if (subList != null && subList.getLength() > 0) {
                res = subList.item(0).getNodeValue();
            }
        }

        if (res.equals("")) {
            res = "Etiqueta no encontrada";
        }

        return res;
    }

    
    @WebMethod(operationName = "consulta")
    public ArrayList<String> consulta(
            @WebParam(name = "cedula") String cedula) {
        //TODO write your implementation code here:
        ArrayList<String> datos=new ArrayList<>();
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(url, usuario, clave);
            statement = connection.createStatement();
            resultSet=statement.executeQuery("Select * from public.personas where cedula='"+cedula+"'");
            
            while(resultSet.next()){
                datos.add(resultSet.getString(2));
                datos.add(resultSet.getString(3));
                datos.add(resultSet.getString(4));
            }
            connection.close();
            
            return datos;
        } catch (ClassNotFoundException | SQLException exception) {
            datos.add(exception.getMessage());
            return datos;
        }
    }
    
    
}
