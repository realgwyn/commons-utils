package org.rafcio.commons.io.file;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFile {

   /**
    * Loads XML document
    * 
    * @param path
    * @return
    */
   public static Document loadXmlFile(String path) {
      try {
         File fXmlFile = new File(path);
         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
         Document doc = dBuilder.parse(fXmlFile);
         doc.getDocumentElement().normalize();
         return doc;
      } catch (Exception e) {
         e.printStackTrace();
      }
      return null;
   }

   /**
    * Loops node one by one and print out the node name and value and also
    * attribute if any
    * 
    * @param nodeList
    */
   public static void printNode(NodeList nodeList) {
      for (int count = 0; count < nodeList.getLength(); count++) {
         Node tempNode = nodeList.item(count);
         // make sure it's element node.
         if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
            // get node name and value
            System.out.println("\nNode Name =" + tempNode.getNodeName() + " [OPEN]");
            System.out.println("Node Value =" + tempNode.getTextContent());
            if (tempNode.hasAttributes()) {
               // get attributes names and values
               NamedNodeMap nodeMap = tempNode.getAttributes();
               for (int i = 0; i < nodeMap.getLength(); i++) {
                  Node node = nodeMap.item(i);
                  System.out.println("attr name : " + node.getNodeName());
                  System.out.println("attr value : " + node.getNodeValue());
               }
            }
            if (tempNode.hasChildNodes()) {
               // loop again if has child nodes
               printNode(tempNode.getChildNodes());
            }
            System.out.println("Node Name =" + tempNode.getNodeName() + " [CLOSE]");
         }
      }
   }


}
