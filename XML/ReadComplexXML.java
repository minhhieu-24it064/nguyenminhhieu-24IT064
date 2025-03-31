import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class ReadComplexXML {
    private static final String FILE_NAME = "students.xml";

    public static void main(String[] args) {
        readXML(FILE_NAME);
    }

    public static void readXML(String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                System.out.println("File not found: " + fileName);
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            Element root = document.getDocumentElement();
            System.out.println("Root Element: " + root.getNodeName());

            NodeList studentList = root.getElementsByTagName("student");
            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;
                    
                    String id = studentElement.getAttribute("id");
                    String name = studentElement.getElementsByTagName("name").item(0).getTextContent();
                    String age = studentElement.getElementsByTagName("age").item(0).getTextContent();
                    String major = studentElement.getElementsByTagName("major").item(0).getTextContent();
                    
                    System.out.println("Student ID: " + id);
                    System.out.println("  Name: " + name);
                    System.out.println("  Age: " + age);
                    System.out.println("  Major: " + major);
                    System.out.println("-----------------------");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}