/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;


import java.util.List;
import java.io.File;
import java.io.FileNotFoundException;
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
public class Jxml extends javax.swing.JFrame {

    public String documento;
    private String cedulas;
    private String retornoXML="";
    /**
     * Creates new form Jxml
     */
    public Jxml() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_cedula = new javax.swing.JTextField();
        txt_nombre = new javax.swing.JTextField();
        txt_apellido = new javax.swing.JTextField();
        txt_enlace = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("GENERAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("ABRIR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("SUBIR");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("REGISTRAR CLIENTES");

        jButton4.setText("Consultar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setText("Cedula:");

        jLabel3.setText("Nombre:");

        jLabel4.setText("Apellido:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(169, 169, 169)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_enlace)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                    .addGap(65, 65, 65)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txt_cedula)
                                        .addComponent(txt_nombre)
                                        .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton4)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addComponent(jLabel1)))
                .addContainerGap(205, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_cedula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_enlace, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(35, 35, 35)
                .addComponent(jButton3)
                .addContainerGap(112, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String nombres, apellidos;
        cedulas = txt_cedula.getText();
        nombres = txt_nombre.getText();
        apellidos = txt_apellido.getText();

        //Seguarda el numero de cedula para el nombre del archivo
        this.documento = cedulas + ".xml";

        //crear xml
        generarXML(cedulas, nombres, apellidos);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        retornoXML="";
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
            txt_enlace.setText(path);
            // Imprimiendo la cadena XML.
            System.out.println(retornoXML);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("No se ha seleccionado ningún fichero");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (entrada != null) {
            // Cerrando el objeto Escáner.
                entrada.close();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
       // Mostrando un mensaje de diálogo con el resultado del método insertar.
        JOptionPane.showMessageDialog(null, insertar(retornoXML));
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here: 
        List datos;
        datos=consulta(txt_cedula.getText());
        for (int i = 0; i < datos.size(); i++) {
            System.out.println(datos.get(i).toString());
        }

        // Obtener el primer elemento de la matriz y convertirlo en una cadena
        //para usarlo como el nombre del archivo xml
        this.documento = datos.get(0).toString() + ".xml";

        // Generamos xml
        generarXML(datos.get(0).toString(), datos.get(1).toString(), datos.get(2).toString());
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jxml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jxml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jxml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jxml.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Jxml().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_apellido;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_enlace;
    private javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables

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