import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Yassen on 3/30/2016.
 */
public abstract class Institution implements Comparable<Institution> {

    private String SchoolName;
    private String CreateDate;
    public String StudentName;
    public String TeacherName;
    public ArrayList<String> teachers = new ArrayList<String>();
    public ArrayList<String> students = new ArrayList<String>();


    public abstract int CountStudents();

    public Institution() {
        this.SchoolName = "";
        this.CreateDate = "";
        this.StudentName = "";
        this.TeacherName = "";
        this.teachers.clear();
        this.students.clear();
    }

    public Institution(String schoolname, String createdate, String studentname, String teachername, ArrayList<String> teachers, ArrayList<String> students) {
        this.SchoolName = schoolname;
        this.CreateDate = createdate;
        this.StudentName = studentname;
        this.TeacherName = teachername;
        this.teachers = teachers;
        this.students = students;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public static ArrayList<Institution> getInstitutionFromXMLFile() {

        ArrayList<Institution> institutions = new ArrayList<Institution>();

        try {

            File inputFile = new File("school.xml");

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);


            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

            NodeList nList = doc.getElementsByTagName("Person");
            System.out.println("--------------------------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());


                String name = "";
                String title = "";
                int countTeachers = 0;
                int countStudent = 0;

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //eElement.

                    try {
                        name = eElement
                                .getElementsByTagName("name")
                                .item(0)
                                .getTextContent();
                    } catch (Exception ex) {
                        continue;
                    }

                    try {
                        title = eElement
                                .getElementsByTagName("title")
                                .item(0)
                                .getTextContent();
                    } catch (Exception ex) {
                        continue;
                    }
                }

                if(title.compareToIgnoreCase("Student")==0){
                        countStudent++;
                    institutions.add(new School());

                } else {
                    countTeachers++;
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return institutions;
    }

    public int compareTo(Institution inst){
        return inst.CountStudents() - this.CountStudents();
    }
}