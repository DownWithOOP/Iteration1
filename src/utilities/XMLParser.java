package utilities;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by cduica on 2/2/17.
 */
public class XMLParser {

    private Document doc;

    public void loadDocument(String path) throws Exception{
        File xmlFile = new File(path);
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        doc = dBuilder.parse(xmlFile);
        doc.getDocumentElement().normalize();

    }

    public ArrayList<HashMap<String, String>> parseDocument(){
        ArrayList<HashMap<String, String>> tileList = new ArrayList<>();

        NodeList nodeList = doc.getElementsByTagName("Tile");
        for(int i = 0; i < nodeList.getLength(); i++){
            Node node = nodeList.item(i);
            if(node.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) node;
                HashMap<String, String> temp = new HashMap<>();
                temp.put("Terrain", element.getAttribute("Terrain"));
                temp.put("Resource", element.getAttribute("Resource"));
                temp.put("Decal", element.getAttribute("Decal"));
                temp.put("Item", element.getAttribute("Item"));
                temp.put("AreaEffect", element.getAttribute("AreaEffect"));
                tileList.add(temp);
            }
        }
        return tileList;
    }


}
