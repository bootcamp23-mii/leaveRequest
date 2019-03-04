/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainTools;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import views.HomeUser;
import views.Landing;

/**
 *
 * @author Panji Sadewo
 */
public class checkSession {

    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        File data = new File(System.getProperty("user.dir") + "/session.xml");
        if (data.exists()) {

            try {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = (Document) dBuilder.parse(data);
                String id = doc.getElementsByTagName("id").item(0).getTextContent();

                CreateXML.set_userId(id);

//                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                    if ("GTK+".equals(info.getName())) {
//                        try {
//                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                            break;
//                        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                            Logger.getLogger(checkSession.class.getName()).log(Level.SEVERE, null, ex);
//                        }
//                    }
//                }
                HomeUser hF = new HomeUser();
                hF.setVisible(true);
            } catch (IOException | ParserConfigurationException | SAXException e) {
                JOptionPane.showMessageDialog(null, e);
            }
        } else {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("GTK+".equals(info.getName())) {
//                    try {
//                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                        break;
//                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
//                        Logger.getLogger(checkSession.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                }
//            }
            Landing lF = new Landing();
            lF.setVisible(true);
        }
    }
}
