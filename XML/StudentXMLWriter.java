import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.Scanner;

public class StudentXMLWriter {
    private static final String FILE_NAME = "students.xml";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();
        
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter student age: ");
        String age = scanner.nextLine();
        
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

        addStudentToXML(id, name, age, major);
        System.out.println("Student data added successfully!");
    }

    public static void addStudentToXML(String id, String name, String age, String major) {
        try {
            File file = new File(FILE_NAME);
            Document document;
            Element root;
            
            if (file.exists()) {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                document = builder.parse(file);
                root = document.getDocumentElement();
            } else {
                DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                DocumentBuilder builder = factory.newDocumentBuilder();
                document = builder.newDocument();
                root = document.createElement("students");
                document.appendChild(root);
            }

            Element student = document.createElement("student");
            student.setAttribute("id", id);
            
            Element nameElement = document.createElement("name");
            nameElement.appendChild(document.createTextNode(name));
            student.appendChild(nameElement);

            Element ageElement = document.createElement("age");
            ageElement.appendChild(document.createTextNode(age));
            student.appendChild(ageElement);

            Element majorElement = document.createElement("major");
            majorElement.appendChild(document.createTextNode(major));
            student.appendChild(majorElement);
            
            root.appendChild(student);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
