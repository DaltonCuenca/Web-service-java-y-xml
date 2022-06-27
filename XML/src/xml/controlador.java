/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;

/**
 *
 * @author Dalto
 */
public class controlador implements ActionListener {

    private Jxml xml;
    public String documento;
    private String cedulas;
    private String retornoXML = "";

    public controlador(Jxml xml) {
        this.xml = xml;
        this.xml.setLocationRelativeTo(null);
        xml.btn_generar.addActionListener(this);
        xml.btn_abrir.addActionListener(this);
        xml.btn_subir.addActionListener(this);
        xml.btn_consulta.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //BOTON GENERAR
        if (e.getSource() == xml.btn_generar) {
            String nombres, apellidos;
            cedulas = xml.txt_cedula.getText();
            nombres = xml.txt_nombre.getText();
            apellidos = xml.txt_apellido.getText();

            //Seguarda el numero de cedula para el nombre del archivo
            this.documento = cedulas + ".xml";

            //crear xml
            generarXML(cedulas, nombres, apellidos);

        } else if (e.getSource() == xml.btn_abrir) {
            // BOTON ABRIR
            retornoXML = "";
            // Creando una variable llamada entrada que es de tipo Scanner.
            Scanner entrada = null;
            // Crear un objeto selector de archivos y luego abrirlo.
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(fileChooser);
            try {
                // Crear un objeto de archivo con la ruta del archivo que el usuario seleccionó.
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                File f = new File(path);
                // Leer el archivo y almacenarlo en una cadena.
                entrada = new Scanner(f);
                while (entrada.hasNext()) {
                    retornoXML += entrada.nextLine();
                }
                // Establecer el texto del campo de texto en la ruta del archivo.
                xml.txt_enlace.setText(path);
                // Imprimiendo la cadena XML.
                System.out.println(retornoXML);
            } catch (FileNotFoundException ex) {
                System.out.println(ex.getMessage());
            } catch (NullPointerException ex) {
                System.out.println("No se ha seleccionado ningún fichero");
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            } finally {
                if (entrada != null) {
                    // Cerrando el objeto Escáner.
                    entrada.close();
                }
            }
        } else if (e.getSource() == xml.btn_subir) {
            //SUBIR SUBIR
            JOptionPane.showMessageDialog(null, insertar(retornoXML));
            
        } else if (e.getSource() == xml.btn_consulta) {
            // BOTON CONSULTAR
            List datos;
            datos = consulta(xml.txt_cedula.getText());
            for (int i = 0; i < datos.size(); i++) {
                System.out.println(datos.get(i).toString());
            }

            // Obtener el primer elemento de la matriz y convertirlo en una cadena
            //para usarlo como el nombre del archivo xml
            this.documento = datos.get(0).toString() + ".xml";

            // Generamos xml
            generarXML(datos.get(0).toString(), datos.get(1).toString(), datos.get(2).toString());
        }
    }

    private void generarXML(String cedulas, String nombres, String apellidos) {
        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            DOMImplementation dOMImplementation = builder.getDOMImplementation();

            // Creación de un nuevo documento XML con el elemento raíz "Personas".
            Document document = dOMImplementation.createDocument(null, "Personas", null);
            document.setXmlVersion("1.0");
            // Resultado:
            /*
            * <?xml version="1.0" encoding="UTF-8"?>
            * <Personas>
            *           ---
            * <Personas>
             */

            // Creando un nuevo elemento llamado "persona"
            Element persona = document.createElement("persona");
            // Resultado:
            /*
            * <?xml version="1.0" encoding="UTF-8"?>
            * <Personas>
            *      <persona>
            *            -----
            *      </persona>
            * <Personas>
             */

            // Se crea un elemento llamado cedula
            Element cedula = document.createElement("cedula");
            // Se crea nodo texto llamado txtCedula y se guarda el valor de la variable cedulas
            Text txtCedula = document.createTextNode(cedulas);
            // El nodo de texto txtCedula se agrega al elemento cedula.
            cedula.appendChild(txtCedula);
            // El elemento cedula se agrega al elemento persona.
            persona.appendChild(cedula);
            // Resultado:
            /*
            * <?xml version="1.0" encoding="UTF-8"?>
            * <Personas>
            *      <persona>
            *            <cedula>Valor del nodo texto txtCedula</cedula>
            *      </persona>
            * <Personas>
             */

            // Agregamos mas elementos como sea necesario
            Element nombre = document.createElement("nombre");
            Text txtNombre = document.createTextNode(nombres);
            nombre.appendChild(txtNombre);
            persona.appendChild(nombre);

            Element apellido = document.createElement("apellido");
            Text txtApellido = document.createTextNode(apellidos);
            apellido.appendChild(txtApellido);
            persona.appendChild(apellido);

            // El elemento persona se agrega al elemento raiz.
            document.getDocumentElement().appendChild(persona);

            //Resultado:
            /*
            * <?xml version="1.0" encoding="UTF-8"?>
            * <Personas>
            *      <persona>
            *            <cedula>Valor del nodo texto txtCedula</cedula>
            *            <nombre>Valor del nodo texto txtNombre</nombre>
            *            <apellido>Valor del nodo texto txtApellido</apellido>
            *      </persona>
            * <Personas>
             */
            // Generamos el archivo xml con los datos anteriores
            // Se guarda en la carpeta del proyecto
            Source source = new DOMSource(document);
            // En la variable documento esta guardado el numero de cedula con la extencion xml
            Result result = new StreamResult(new File(documento));

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(source, result);

            JOptionPane.showMessageDialog(null, "Se ha generado con exito.");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static String insertar(java.lang.String file) {
        wsXML.NewWebService_Service service = new wsXML.NewWebService_Service();
        wsXML.NewWebService port = service.getNewWebServicePort();
        return port.insertar(file);
    }

    private static java.util.List<java.lang.String> consulta(java.lang.String cedula) {
        wsXML.NewWebService_Service service = new wsXML.NewWebService_Service();
        wsXML.NewWebService port = service.getNewWebServicePort();
        return port.consulta(cedula);
    }

}
