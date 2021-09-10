import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ConfigParser {
    String path;

    public ConfigParser(String path) throws ParserConfigurationException,SAXException,IOException {
        this.path = path;
    }

    public void parseConfig(BasicConfig config) throws ParserConfigurationException,SAXException,IOException{
        try {
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document document = documentBuilder.parse(path);

            Node root = document.getDocumentElement();

            NodeList params = root.getChildNodes();
            for (int i = 0; i < params.getLength(); i++) {
                Node param = params.item(i);
                if (param.getNodeType() != Node.TEXT_NODE) {
                    NodeList paramsProps = param.getChildNodes();
                    for(int j = 0; j < paramsProps.getLength(); j++) {
                        Node paramProp = paramsProps.item(j);
                        if (paramProp.getNodeType() != Node.TEXT_NODE) {
                           config.setBinding(paramProp.getNodeName(),paramProp.getChildNodes().item(0).getTextContent());
                        }
                    }
                }
            }

        } catch (ParserConfigurationException | SAXException | IOException parseConfigException) {

            throw parseConfigException;

        }
    }

}
