import org.w3c.dom.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class LibraryManagementGUI {
    private static final String FILE_NAME = "library.xml";
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;

    public LibraryManagementGUI() {
        frame = new JFrame("Library Management");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLayout(new BorderLayout());

        tableModel = new DefaultTableModel(new Object[]{"Book ID", "Title", "Author", "Year", "Publisher", "Pages", "Genre", "Price"}, 0);
        table = new JTable(tableModel);
        loadBooksFromXML();

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1, 4));
        JButton addButton = new JButton("Add");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");
        JButton refreshButton = new JButton("Refresh");

        panel.add(addButton);
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(refreshButton);

        frame.add(panel, BorderLayout.SOUTH);

        addButton.addActionListener(e -> addBook());
        updateButton.addActionListener(e -> updateBook());
        deleteButton.addActionListener(e -> deleteBook());
        refreshButton.addActionListener(e -> loadBooksFromXML());

        frame.setVisible(true);
    }

    private void loadBooksFromXML() {
        tableModel.setRowCount(0);
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) return;

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();

            NodeList bookList = document.getElementsByTagName("book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Element bookElement = (Element) bookList.item(i);
                String id = bookElement.getAttribute("id");
                String title = bookElement.getElementsByTagName("title").item(0).getTextContent();
                String author = bookElement.getElementsByTagName("author").item(0).getTextContent();
                String year = bookElement.getElementsByTagName("year").item(0).getTextContent();
                String publisher = bookElement.getElementsByTagName("publisher").item(0).getTextContent();
                String pages = bookElement.getElementsByTagName("pages").item(0).getTextContent();
                String genre = bookElement.getElementsByTagName("genre").item(0).getTextContent();
                String price = bookElement.getElementsByTagName("price").item(0).getTextContent();

                tableModel.addRow(new Object[]{id, title, author, year, publisher, pages, genre, price});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void addBook() {
        // Implement book addition logic
        JOptionPane.showMessageDialog(frame, "Feature not implemented yet");
    }

    private void updateBook() {
        // Implement book update logic
        JOptionPane.showMessageDialog(frame, "Feature not implemented yet");
    }

    private void deleteBook() {
        // Implement book deletion logic
        JOptionPane.showMessageDialog(frame, "Feature not implemented yet");
    }

    public static void main(String[] args) {
        new LibraryManagementGUI();
    }
}
