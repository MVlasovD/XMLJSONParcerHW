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


    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder;
    dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(new File(fileName));
    DOMBuilder domBuilder = new DOMBuilder();
        return domBuilder.build(doc);

    private static List<Employee> parseXML(String fileNameXML) throws IOException, SAXException, ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new File(fileNameXML));
        Node root = doc.getDocumentElement();
        System.out.println("Корневой элемент: " + root.getNodeName());
        read(root);
        return new ArrayList<Employee>();
    }


    Element root = jdomDoc.getRootElement();
    List<Element> empListElements = root.getChildren("Employee");
    List<Employee> empList = new ArrayList<>();
            for (Element empElement : empListElements) {
        Employee emp = new Employee();
        emp.setId(Integer.parseInt(empElement.getAttributeValue("id")));
        emp.setAge(Integer.parseInt(empElement.getChildText("age")));
        emp.setName(empElement.getChildText("name"));
        emp.setRole(empElement.getChildText("role"));
        emp.setGender(empElement.getChildText("gender"));
        empList.add(emp);

    private static void read(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node_ = nodeList.item(i);
            if (Node.ELEMENT_NODE == node_.getNodeType()) {
                System.out.println("Текущий узел: " + node_.getNodeName());
                Element element = (Element) node_;
                NamedNodeMap map = element.getAttributes();
                System.out.println("ID сотрудника: " + element.getAttribute("id"));

//                Employee emp = new Employee();
//                emp.toString();
//                emp.setId(Long.parseLong(element.getAttribute("id")));

//                for (int a = 0; a < map.getLength(); a++) {
//                    String attrName = map.item(a).getNodeName();
//                    String attrValue = map.item(a).getNodeValue();
//                    System.out.println("Атрибут: " + attrName + "; значение: " + attrValue);
//
//                    Employee emp = new Employee();
//                    emp.setId(Integer.parseInt(attrValue));
//                    System.out.println(emp);
//            }
            read(node_);
        }
    }
    }

//        List<Element> empListElements = root.getChildsNodes("Employee");
//        List<Employee> empList = new ArrayList<>();
//        for (Element empElement : empListElements) {
//            Employee emp = new Employee();
//            emp.setId(Integer.parseInt(empElement.getAttributeValue("id")));
//            emp.setFirstName(empElement.getChildText("firstName"));
//            emp.setLastName(empElement.getChildText("lastName"));
//            emp.setCountry(empElement.getChildText("country"));
//            emp.setAge(Integer.parseInt(empElement.getChildText("age")));
//            empList.add(emp);
//        }


    public static void main(String[] args) throws IOException, CsvException, ParserConfigurationException, SAXException {

        List<Employee> listXML = parseXML("data.xml");

//        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
//        String fileName = "data.csv";
//        List<Employee> list = parseCSV(columnMapping, fileName);

        String fileNameJson = "data2.json";
//        String json = listToJson(listXML);
//        writeString(json, fileNameJson);
    }

}
