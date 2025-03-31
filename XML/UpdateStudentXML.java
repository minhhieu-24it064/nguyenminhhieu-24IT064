import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class UpdateStudentXML {
    private static final String FILE_NAME = "students.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student ID to update: ");
        String idToUpdate = scanner.nextLine();
        
        System.out.print("Enter new name: ");
        String newName = scanner.nextLine();
        
        System.out.print("Enter new age: ");
        String newAge = scanner.nextLine();
        
        System.out.print("Enter new major: ");
        String newMajor = scanner.nextLine();
        
        updateStudentInXML(idToUpdate, newName, newAge, newMajor);
    }

    public static void updateStudentInXML(String id, String newName, String newAge, String newMajor) {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                System.out.println("File not found: " + FILE_NAME);
                return;
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList studentList = document.getElementsByTagName("student");
            boolean found = false;

            for (int i = 0; i < studentList.getLength(); i++) {
                Node studentNode = studentList.item(i);
                if (studentNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element studentElement = (Element) studentNode;
                    if (studentElement.getAttribute("id").equals(id)) {
                        studentElement.getElementsByTagName("name").item(0).setTextContent(newName);
                        studentElement.getElementsByTagName("age").item(0).setTextContent(newAge);
                        studentElement.getElementsByTagName("major").item(0).setTextContent(newMajor);
                        found = true;
                        break;
                    }
                }
            }

            if (found) {
                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
                DOMSource source = new DOMSource(document);
                StreamResult result = new StreamResult(file);
                transformer.transform(source, result);
                System.out.println("Student with ID " + id + " updated successfully.");
            } else {
                System.out.println("Student ID not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
