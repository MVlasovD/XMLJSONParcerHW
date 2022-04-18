import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Employee> parseCSV(String[] columnMapping, String fileName) throws IOException, CsvException {
        CSVReader csvReader = new CSVReader(new FileReader(fileName));
        ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
        strategy.setType(Employee.class);
        strategy.setColumnMapping(columnMapping);
        CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(csvReader)
                .withMappingStrategy(strategy)
                .build();
        List<Employee> staff = csv.parse();
        csvReader.close();
        return staff;
    }

    public static String listToJson(List<Employee> list) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        String json = gson.toJson(list, listType);
        return json;
    }

    public static void writeString(String json, String fileNameJson) throws IOException {
        FileWriter file = new FileWriter(fileNameJson);
        file.write(json);
        file.flush();
    }


    static List<Employee> employees = new ArrayList<>();

    private static List<Employee> parseXML(String fileNameXML)
            throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileNameXML));

        Node root = doc.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getNodeName());
        read(root);
        return null;
    }

    static StringBuilder sb = new StringBuilder();
    static String jj;

    private static void read(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node ele = nodeList.item(i);
            if (ele.getNodeType() != Node.TEXT_NODE) {
                NodeList props = ele.getChildNodes();
                for (int j = 0; j < props.getLength(); j++) {
                    Node prop = props.item(j);
                    if (prop.getNodeType() != Node.TEXT_NODE) {
                        System.out.println(prop.getNodeName() + ":" + prop.getChildNodes().item(0).getTextContent());
                        jj = String.valueOf(sb.append("\"" + prop.getNodeName() + "\"" + ":" +  "\"" + prop.getChildNodes().item(0).getTextContent() + "\""));
//                        Element element = (Element) prop;
//                        System.out.println(element.getAttribute(prop.getNodeName()));
//                        employees.add(new Employee(Long.parseLong(attributes.getNamedItem("id").getNodeValue()),
//                                attributes.getNamedItem("firstName").getNodeValue(), attributes.getNamedItem("lastName").getNodeValue(),
//                                attributes.getNamedItem("country").getNodeValue(),Integer.parseInt(attributes.getNamedItem("firstName").getNodeValue())));
                    }
                }
                System.out.println(jj);
            }
        }
    }


//        for (int i = 0; i < nodeList.getLength(); i++) {
//            Node node_ = nodeList.item(i);
//            if (Node.ELEMENT_NODE == node_.getNodeType()) {
//                System.out.println("Текущий узел: " + node_.getNodeName());
//                Element element = (Element) node_;
//                NamedNodeMap map = element.getAttributes();
//                for (int a = 0; a < map.getLength(); a++) {
//                    String attrName = map.item(a).getNodeName();
//                    String attrValue = map.item(a).getNodeValue();
//                    System.out.println("Атрибут: " + attrName + "; значение: " + attrValue);
//                }
////                    read(node_);
//            }
//        }
//    }


    public static void main(String[] args) throws
            IOException, ParserConfigurationException, SAXException {

        parseXML("data.xml");
//                List<Employee> listXML = parseXML("data.xml");


//                String fileNameJson = "data2.json";
//                String json = listToJson(listXML);
//                writeString(json, fileNameJson);
    }

}
