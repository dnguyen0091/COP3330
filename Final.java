import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
// 04/03/2024
// COP 3330
public class Main {
    // function to process the input
    public static void main(String[] args) {
        // call the main menu
        mainMenu();

    }
    // function to split the input string
    public static String[] splitInput(String input) {
        // split the input string
        String[] splitInput = input.split(",");
        // return the split input
        return splitInput;
    }
    public static void mainMenu()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------");
        System.out.println("Main Menu");
        System.out.println("1. Student Management");
        System.out.println("2. Course Management");
        System.out.println("0: Exit");
        System.out.print("\n\t\tEnter your selection:");
        int in=input.nextInt();
        //System.out.print(in);
        System.out.println("---------------");
        switch(in)
        {
            case 1:
                studentManagement(new LinkedList());
                break;
            case 2:
                courseManagement();
                break;
            case 0:
                System.out.println("Take Care!");
                break;
            default:
                System.out.println("Invalid Selection");
                mainMenu();
        }
    }
    public static void studentManagement(LinkedList l)
    {
        LinkedList list = l;
//      declare a variable for the id
        String id = "";
        Scanner input = new Scanner(System.in);

        System.out.println("Student Management Menu:");
        System.out.println("Choose one of:");
        System.out.println("\tA - Search add a student");
        System.out.println("\tB - Delete a Student");
        System.out.println("\tC - Print Fee Invoice");
        System.out.println("\tD - Print List of Students");
        System.out.println("\tX - Back to Main Menu");
        System.out.print("Enter your selection:");
        String in=input.nextLine();
        switch(in.toUpperCase())
        {
            case "A":
//                System.out.print("\nEnter Student's ID:");
//                id = input.nextLine();
//                if (list.searchById(id))
//                {
//                    System.out.println("Invalid id format or ID already exists\n"
//                                        +"Try Again later");
//                    studentManagement();
//                    break;
//                }
//                System.out.print("\nStudent Type(PhD, MSm or UnderGrad):");
//                String type = input.nextLine();
//                System.out.println("Enter Remaining information");
//                // prompt user for user to enter the remaining information
//                String remainingInfo = input.nextLine();
//                // split the input
//                String[] splitInput = splitInput(remainingInfo);
//                // check if the type is PhD
//                if (type.equals("PhD")) {
//                    // create a new PhD student
//                    PhdStudent phdStudent = new PhdStudent(splitInput[0], splitInput[1], splitInput[2], id);
//                    // add the new PhD student to the list
//                    list.addNewPhdStudent(phdStudent);
//                } else if (type.equals("MSm")) {
//                    // create a new MS student
//                    MsStudent msStudent = new MsStudent(splitInput[0], id, new int[0], 0);
//                    // add the new MS student to the list
//                    list.addNewMsStudent(msStudent);
//                } else if (type.equals("UnderGrad")) {
//                    // create a new undergraduate student
//                    UndergraduateStudent undergraduateStudent = new UndergraduateStudent(splitInput[0], id, new int[0], 0, true);
//                    // add the new undergraduate student to the list
//                    list.addNewUnderGradStudent(undergraduateStudent);
//                } else {
//                    System.out.println("Invalid Student Type");
//                    studentManagement();
//                }
                // create a new linked list
                list = new LinkedList();
                // create some predefined students
                UndergraduateStudent u1 = new UndergraduateStudent("0", "Undergraduate", "David", new int[0], 3.5, true);
                UndergraduateStudent u2 = new UndergraduateStudent("1", "Undergraduate", "Tom", new int[0], 3.5, true);
                MsStudent m1 = new MsStudent("2", "MS", "Emily", new int[0], 0);
                MsStudent m2 = new MsStudent("3", "MS", "Joe", new int[0], 0);
                PhdStudent p1 = new PhdStudent("4", "PhD", "Jim", "Climate Change");
                PhdStudent p2 = new PhdStudent("5", "PhD", "Kim", "Climate Change");
                // add the students to the list
                list.addNewUnderGradStudent(u1);
                list.addNewUnderGradStudent(u2);
                list.addNewMsStudent(m1);
                list.addNewMsStudent(m2);
                list.addNewPhdStudent(p1);
                list.addNewPhdStudent(p2);
                // add the students to the list
                studentManagement(list);
                break;
            case "B":
                System.out.println("Delete a Student");
//                 delete student
                System.out.print("\nEnter Student's ID:");
                id = input.nextLine();
                list.deleteStudent(id);
                studentManagement(list);
                break;
            case "C":
                System.out.println("Print Fee Invoice");
                //search for student
                //student.printFeeInvoice();
                studentManagement(list);
                break;
            case "D":
                System.out.println("Print List of Students");
                // print the list of students
                list.printListOfStudents();
                studentManagement(list);
                break;
            case "X":
                mainMenu();
                break;
            default:
                System.out.println("Invalid Selection");
                studentManagement(list);
        }
    }
//    public static void checkForLab() {
//        try {
//            File file = new File("lect.txt");
//            Scanner scanner = new Scanner(file);
//            while (scanner.hasNextLine()) {
//                String data = scanner.nextLine();
//                // split the data
//                String[] splitData = splitInput(data);
//                // check if the split data contains the word YES
//                if (data.contains("YES") && data.contains("12658")) {
//                    while (scanner.hasNextLine()) {
//                        String labData = scanner.nextLine();
//                        // split the lab data
//                        String[] splitLabData = splitInput(labData);
//                        // check if the lab data do not contain yes
//                        if (!labData.contains("YES")) {
//                            // print the lab data
//                            System.out.println(labData);
//                            break;
//                        }
//                    }
//                }
//            }
//            scanner.close();
//        } catch (FileNotFoundException e) {
//            System.out.println("An error occurred.");
//            e.printStackTrace();
//        }
//    }
    // function to search for a course or lab using the user input
    public static void checkForLab(String crnOrLab) {
        try {
            File file = new File("lect.txt");
            Scanner scanner = new Scanner(file);
            String tempData = "";
            // loop through the file data
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                // split the data
                String[] splitData = splitInput(data);
                // check if the current index has a lab or it is a lecture class
                if (splitData.length == 8 && data.contains("Yes") || data.contains("YES") ) {
                    tempData = data;
                    // check if the crn is equal to the current course
                    if (splitData[0].equals(crnOrLab)) {
                        System.out.println("[" + splitData[0] + ", " +
                                splitData[1] + ", " +
                                splitData[2] + "]\n" +
                                "\n");
                        break;
                    }
                }
                // check if the current lab match with the user input
                if (splitData.length == 2 && data.contains(crnOrLab)) {
                    // split the data from the temp data
                    String[] splitTempData = splitInput(tempData);
                    System.out.println("[" + splitTempData[0] + ", " +
                            splitTempData[1] + ", " +
                            splitTempData[2] + "]\n" +
                            "\n" +
                            "Lab Room " + splitData[1] +
                            "\n");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    // function to delete a class from the file
    public static void deleteClass(String crnOrLab) {
        try {
            File file = new File("lect.txt");
            Scanner scanner = new Scanner(file);

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    public static void courseManagement()
    {

        Scanner input = new Scanner(System.in);


        System.out.println("Course Management:");
        System.out.println("Choose one of:");
        System.out.println("\tA - Search for a class or lab using the class/lab number");
        System.out.println("\tB - delete a class");
        System.out.println("\tC - Back to main menu");
        System.out.print("Enter your selection:");
        String in=input.nextLine();
        switch(in.toUpperCase())
        {
            case "A":
                System.out.println("Search for a class or lab using the class/lab number\n" +
                                    "Enter the Class/Lab Number: ");
                // read user input
                String classLabNumber = input.nextLine();
                // call readDataFromFile
                checkForLab(classLabNumber);
                courseManagement();
                break;
            case "B":
                System.out.println("delete a class");
                //deleteClass();
                courseManagement();
                break;
            case "C":
                mainMenu();
                break;
            default:
                System.out.println("Invalid Selection");
                courseManagement();
        }
    }
}
// provided code for node class
class LinkedList {
    // declare a reference for the head of the list
    Node school;
    // declare a constructor for linkedlist class
    public LinkedList() {
        school = null;
    }
    // function to print the list
    public void printListOfStudents() {
        // create a temp node
        Node tempUnderGrad = school;
        Node tempMs = school;
        Node tempPhd = school;
        System.out.println("PhD Students\n" + "---------------------");
        // loop through the list
        while (tempPhd != null) {
            // print graduate student info
            if (tempPhd.getP() != null) {
                System.out.println(tempPhd.getP().printListOfPhd());
            }
            // go to the next node
            tempPhd = tempPhd.getNext();
        }
        System.out.println("MS Students\n" + "---------------------");
        // loop through the list
        while (tempMs != null) {
            // print graduate student info
            if (tempMs.getM() != null) {
                System.out.println(tempMs.getM().printListOfMs());
            }
            // go to the next node
            tempMs = tempMs.getNext();
        }
        System.out.println("Undergraduate Students\n" + "---------------------");
        // loop through the list
        while (tempUnderGrad != null) {
            // print undergraduate student info
            if (tempUnderGrad.getU() != null) {
                System.out.println(tempUnderGrad.getU().printListOfUnderGrad());
            }
            // go to the next node
            tempUnderGrad = tempUnderGrad.getNext();
        }
    }
//    // function to calculate the net salary
//    public double netSalary(double s, int d) {
//        // declare a net salary variable to store
//        double netSalary = 0;
//        // equation for net salary
//        netSalary = (s * 0.91) + (d * 0.01 * s);
//        // return the net salary
//        return netSalary;
//    }
//    // function to calculate the ascii value of the employee full name and return it
//    public int asciiValue(String name) {
//        // declare a variable to store the ascii value
//        int asciiValue = 0;
//        // loop through the name
//        for (int i = 0; i < name.length(); i++) {
//            // add the ascii value of the character to the ascii value
//            asciiValue += name.toUpperCase().charAt(i);
//        }
//        // return the ascii value
//        return asciiValue;
//    }
    // function to add new undergraduate student
    public void addNewUnderGradStudent(UndergraduateStudent u) {
        // create a new node
        Node newNode = new Node();
        // set the employee to the new node
        newNode.setU(u);
        // check if the list is empty
        if (school == null) {
            // set the new node to the head of the list
            school = newNode;
        } else {
            // create a temp node
            Node temp = school;
            // loop through the list
            while (temp.getNext() != null) {
                // go to the next node
                temp = temp.getNext();
            }
            // set the new node to the next node
            temp.setNext(newNode);
        }
        // print the student name
        System.out.println("[ " + u.getName() + " ] added!");
    }
    // function to add new undergraduate student
    public void addNewMsStudent(MsStudent m) {
        // create a new node
        Node newNode = new Node();
        // set the employee to the new node
        newNode.setM(m);
        // check if the list is empty
        if (school == null) {
            // set the new node to the head of the list
            school = newNode;
        } else {
            // create a temp node
            Node temp = school;
            // loop through the list
            while (temp.getNext() != null) {
                // go to the next node
                temp = temp.getNext();
            }
            // set the new node to the next node
            temp.setNext(newNode);
        }
        // print the student name
        System.out.println("[ " + m.getName() + " ] added!");
    }
    // function to add new undergraduate student
    public void addNewPhdStudent(PhdStudent p) {
        // create a new node
        Node newNode = new Node();
        // set the employee to the new node
        newNode.setP(p);
        // check if the list is empty
        if (school == null) {
            // set the new node to the head of the list
            school = newNode;
        } else {
            // create a temp node
            Node temp = school;
            // loop through the list
            while (temp.getNext() != null) {
                // go to the next node
                temp = temp.getNext();
            }
            // set the new node to the next node
            temp.setNext(newNode);
        }
        // print the student name
        System.out.println("[ " + p.getName() + " ] added!");
    }
    //      function to search for employee by name
    public boolean searchById(String name) {
        // create a temp node
        Node temp = school;
        // loop through the list
        while (temp != null) {
            // check if the last name is equal to any of the names in the list
            if (temp.getU().getName().equals(name) ||
                    temp.getM().getName().equals(name) ||
                    temp.getP().getName().equals(name)) {
                // return true
                return true;
            }
//            // check if the sub group is not null
//            if (temp.getBelow() != null) {
//                // temp node to traverse the sub group
//                Node tempBelow = temp.getBelow();
//                // loop through the sub group
//                while (tempBelow != null) {
//                    // check if the last name is equal to any of the names in the sub group
//                    if (tempBelow.getE().getName().equals(name)) {
//                        // return true
//                        return true;
//                    }
//                    // go to the next node
//                    tempBelow = tempBelow.getBelow();
//                }
//            }
            // go to the next node
            temp = temp.getNext();
        }
        // return false
        return false;
    }
//    // function to find the highest net salary
//    public double highestNetSalary() {
//        // declare a variable to store the highest salary
//        double highestSalary = 0;
//        // create a temp node
//        Node temp = company;
//        // loop through the list
//        while (temp != null) {
//            // check if the salary is higher than the highest salary
//            if (netSalary(temp.getE().getSalary(), temp.getE().getNumberOfDependent())
//                    > highestSalary) {
//                // set the highest salary to the salary
//                highestSalary = netSalary(temp.getE().getSalary(), temp.getE().getNumberOfDependent());
//            }
//            // check if any of the sub group salary is higher than the highest salary
//            if (temp.getBelow() != null) {
//                // temp node to traverse the sub group
//                Node tempBelow = temp.getBelow();
//                // loop through the sub group
//                while (tempBelow != null) {
//                    // check if the salary is higher than the highest salary
//                    if (netSalary(tempBelow.getE().getSalary(), tempBelow.getE().getNumberOfDependent())
//                            > highestSalary) {
//                        // set the highest salary to the salary
//                        highestSalary = netSalary(tempBelow.getE().getSalary(), tempBelow.getE().getNumberOfDependent());
//                    }
//                    // go to the next node
//                    tempBelow = tempBelow.getBelow();
//                }
//            }
//            // go to the next node
//            temp = temp.getNext();
//        }
//        return highestSalary;
//    }

    // function to delete employee by name
    public void deleteStudent(String id) {
        // create a temp node for traverse the list
        Node temp = school;
        // loop through the list
        while (temp != null) {
            // check if the last name is equal to the name
            if (temp.getNext().getU() != null && temp.getNext().getU().getId().equals(id) ||
                    temp.getNext().getM() != null && temp.getNext().getM().getId().equals(id)  ||
                    temp.getNext().getP() != null && temp.getNext().getP().getId().equals(id)) {
                    // create a temp to save the next node
                    Node tempNext = temp.getNext().getNext();
                    // set the next node to the current node
                    temp.setNext(tempNext);
                    // return
                    return;
                }
//            // check if the sub group of the current node is not null
//            if (temp.getBelow() != null) {
//                // loop through the sub group
//                while (temp.getBelow() != null) {
//                    // check if the last name is equal to the name
//                    if (temp.getBelow().getE().getName().equals(name)) {
//                        // create a temp to save the next node
//                        Node tempBelow = temp.getBelow().getBelow();
//                        // set the next node to the current node
//                        temp.setBelow(tempBelow);
//                        // return
//                        return;
//                    }
//                    // go to the next node
//                    temp = temp.getBelow();
//                }
//            }
            // go to the next node
            temp = temp.getNext();
        }
    }

//    public void addCourse(Course course) {
//    }
}
// structure of the data
class Student {
    // declare private type vars for storing student name and id
    private String id;
    private String studentType;
    private String name;
    private int[] crnsTaken;
    // declare var for fix base fee
    double miscellaneousFee = 35.00;
    // declare var for string courses info
    String courseInfo;
    // declare getters and setters for student name and id
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getStudentType() {
        return studentType;
    }
    public void setStudentType(String studentType) {
        this.studentType = studentType;
    }
    public int[] getCrnsTaken() {
        return crnsTaken;
    }
    public void setCrnsTaken(int[] crnsTaken) {
        this.crnsTaken = crnsTaken;
    }
    // declare constructor for student
    public Student(String id, String studentType, String name, int[] crnsTaken) {
        this.id = id;
        this.studentType = studentType;
        this.name = name;
        this.crnsTaken = crnsTaken;
    }
//    // method to split hours from the matchingCrnsVar method
//    public String extractCourseHours(String crn) {
//        // split the crn
//        String[] splitCrn = crn.split("\t\t\t\t");
//        return splitCrn[1];
//    }
//    // method to calculate the total payment from each crn
//    public double calculateTotalPaymentCrn(int crnHours, double baseFee) {
//        return baseFee * crnHours;
//    }
//    // method to calculate the total payment from all the crns
//    public double calculateTotalPayment(int [] inputCrnsList, double baseFee) {
//        // store the size of the array list
//        int size = inputCrnsList.length;
//        // declare vars to calculate payment
//        double totalPayment = 0;
//        // for loop to calculate the total payment
//        for (int i = 0; i < size; i++) {
//            // multiply the base fee by the value of the array list
//            totalPayment += baseFee * Integer.parseInt(extractCourseHours(matchingCrnsVar(inputCrnsList[i])));
//        }
//        return totalPayment + miscellaneousFee;
//    }
}
////--------------------------------
class UndergraduateStudent extends Student {
    private boolean resident;
    // declare private type var for storing gpa
    private double gpa;
    // double var for base fee
    double baseFee = 0;
    // constructor for undergraduate student
    public UndergraduateStudent(String id, String studentType, String name, int[] undergradCrnsTaken, double gpa, boolean resident) {
        // use super to call the constructor from the student class
        super(id, "Undergraduate", name, undergradCrnsTaken);
        // set the gpa
        this.gpa = gpa;
        // set the resident status
        this.resident = resident;
    }
    // declare setters and getters for undergradCrnsTaken and resident
    public int[] getUndergradCrnsTaken() {
        return getCrnsTaken();
    }
    public void setUndergradCrnsTaken(int[] undergradCrnsTaken) {
        this.setCrnsTaken(undergradCrnsTaken);
    }
    public boolean isResident() {
        return resident;
    }
    public void setResident(boolean resident) {
        this.resident = resident;
    }
    // function to print the list of students name
    public String printListOfUnderGrad() {
        return "\t- " + super.getName();
    }

//    // method to calculate the total payment with discount
//    public double calculateTotalPaymentWithDiscount() {
//        // calculate the total payment
//        double totalPayment = calculateTotalPayment(undergradCrnsTaken, baseFee);
//        // if statement to check for gpa
//        if (gpa >= 3.5 && totalPayment >= 500) {
//            return (totalPayment - ((totalPayment) * 0.25));
//        }
//        return totalPayment;
//    }
//    @Override
//    public void printInvoice() {
//        // store the size of the array list
//        int crnSize = undergradCrnsTaken.length;
//        // conditional statement to determine the base fee based on the resident status
//        if (resident) {
//            // set base fee 120.25 for resident
//            baseFee = 120.25;
//        } else {
//            // set base fee 240.50 for non-resident
//            baseFee = 240.50;
//        }
//        // formatting for printing undergraduate student invoice
//        // print the student info format
//        System.out.println("VALENCE COLLEGE\n" +
//                "ORLANDO FL 10101\n" +
//                "---------------------\n" +
//                "\n" +
//                "Fee Invoice Prepared for Student:\n" +
//                getId().toUpperCase() + "-" + getName().toUpperCase() + "\n" +
//                "\n" +
//                "1 Credit Hour = " + String.format("%.02f", baseFee)
//                +
//                "\n" +
//                "CRN\t\t\tCR_PREFIX\t\t\tCR_HOURS");
//        // loop to print the crns and the associated fees
//        for (int i = 0; i < crnSize; i++) {
//            // print split crn
//            System.out.println(matchingCrnsVar(undergradCrnsTaken[i]) + "\t\t\t\t" + " $ " + String.format("%.02f", calculateTotalPaymentCrn(Integer.parseInt(extractCourseHours(matchingCrnsVar(undergradCrnsTaken[i]))), baseFee)));
//        }
//        // print the associated fees
//        System.out.println("\n" +
//                "\t\t\t\t\t\t\tHealth & id fees\t $ " + String.format("%.02f", miscellaneousFee) + "\n" +
//                "\n" +
//                "----------------------------------------------------------\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t $ " + String.format("%.02f", calculateTotalPayment(undergradCrnsTaken, baseFee)) + "\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t\t-$ " + String.format("%.02f", calculateTotalPayment(undergradCrnsTaken, baseFee) - calculateTotalPaymentWithDiscount()) + "\n" +
//                "\t\t\t\t\t\t\t\t\t\t\t ------------\n" +
//                "\t\t\t\t\t\t\tTOTAL PAYMENTS\t\t $ " + String.format("%.02f", (calculateTotalPaymentWithDiscount())) + "\n");
//    }
}
////--------------------------------
/// class for graduate students
abstract class GraduateStudent extends Student {
    // declare private type var for storing resident status
    private boolean gradResident;
    // declare private type var for storing gpa
    private double gpa;
    // double var for base fee
    double baseFee = 0;
    // constructor for undergraduate student
    public GraduateStudent(String id, String studentType, String name, int[] gradCrnsTaken, double gpa, boolean gradResident) {
        // use super to call the constructor from the student class
        super(id, "Graduate", name, gradCrnsTaken);
        // set private type vars to undergradCrnsTaken and resident
        // set the gpa
        this.gpa = gpa;
        // set the resident status
        this.gradResident = gradResident;
    }

    public double getGpa() {
        return gpa;
    }

    public boolean isGradResident() {
        return gradResident;
    }

    public void setGradResident(boolean gradResident) {
        this.gradResident = gradResident;
    }
    // getters and setters for gradCrnsTaken and gradResident
    public int[] getGradCrnsTaken() {
        return getCrnsTaken();
    }
    public void setGradCrnsTaken(int[] gradCrnsTaken) {
        this.setCrnsTaken(gradCrnsTaken);
    }
    // getters and setters for id
    public String getId() {
        return super.getId();
    }
    public void setId(String id) {
        this.setId(id);
    }
//    // method to validate the crn
//    public void validateCrn(int crn) {
//        // if statement to check for crn
//        if (super.matchingCrnsVar(crn).equals("Invalid crn")) {
//            // throw an exception
//            throw new IllegalArgumentException("Invalid crn");
//        }
//    }
}
//--------------------------------
class PhdStudent extends GraduateStudent {
    // declare private type vars for storing advisor and research subject
    private String advisor;
    private String researchSubject;
    // declare var for base fee/research fee
    double baseFee = 700.00;
    public PhdStudent(String id, String studentType, String name, String researchSubject) {
        super(id, "PhD", name, new int[0], 0, true);
        // set private type vars to advisor and researchSubject
        this.advisor = advisor;
        this.researchSubject = researchSubject;
    }
    // declare setters and getters for advisor and researchSubject
    public String getAdvisor() {
        return advisor;
    }
    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }
    public String getResearchSubject() {
        return researchSubject;
    }
    public void setResearchSubject(String researchSubject) {
        this.researchSubject = researchSubject;
    }
    // function to print the list of students name
    public String printListOfPhd() {
        return "\t- " + super.getName();
    }

//    @Override
//    public void printInvoice() {
//        // formatting for printing Phd student invoice
//        // print the Phd student info format
//        System.out.println("VALENCE COLLEGE\n" +
//                "ORLANDO FL 10101\n" +
//                "---------------------\n" +
//                "\n" +
//                "Fee Invoice Prepared for Student:\n" +
//                getId().toUpperCase() + "-" + getName().toUpperCase() + "\n" +
//                "\n" +
//                "RESEARCH " + "\n" +
//                "Climate Change\t\t\t\t\t\t\t\t\t" + " $ " + String.format("%.02f", baseFee) +
//                "\n" +
//                "\t\t\t\t\t\t\tHealth & id fees\t $ " + String.format("%.02f", miscellaneousFee) + "\n" +
//                "\n" +
//                "----------------------------------------------------------\n" +
//                "\t\t\t\t\t\t\tTOTAL PAYMENTS\t\t $ " + String.format("%.02f", (baseFee + miscellaneousFee)) + "\n");
//    }
}
//--------------------------------
class MsStudent extends GraduateStudent {
    // declare private type vars for storing grad courses
    private int [] gradCrnsTaken;
    // declare var for base fee
    double baseFee = 300.00;
    public MsStudent(String id, String studentType, String name, int [] gradCrnsTaken, int crn) {
        super(id, "MS", name, gradCrnsTaken, 0, true);
        // set private type vars to gradCrnsTaken
        this.gradCrnsTaken = gradCrnsTaken;
    }
    // declare setters and getters for gradCrnsTaken
    public int[] getGradCrnsTaken() {
        return gradCrnsTaken;
    }
    public void setGradCrnsTaken(int[] gradCrnsTaken) {
        this.gradCrnsTaken = gradCrnsTaken;
    }
    // function to print the list of students name
    public String printListOfMs() {
        return "\t- " + super.getName();
    }
//    // method to replace any crn with the course number < 5000
//    public void replaceCrn(int [] gradCrnsTaken) {
//        // for loop to replace the crn
//        for (int i = 0; i < gradCrnsTaken.length; i++) {
//            // if statement to check for crn < 5000
//            if (gradCrnsTaken[i] < 5000) {
//                // throw an exception
//                throw new IllegalArgumentException("Invalid crn");
//            }
//        }
//    }
//    @Override
//    public void printInvoice() {
//        // store the size of the array list
//        int crnSize = gradCrnsTaken.length;
//        // formatting for printing undergraduate student invoice
//        // print the student info format
//        System.out.println("VALENCE COLLEGE\n" +
//                "ORLANDO FL 10101\n" +
//                "---------------------\n" +
//                "\n" +
//                "Fee Invoice Prepared for Student:\n" +
//                getId().toUpperCase() + "-" + getName().toUpperCase() + "\n" +
//                "\n" +
//                "1 Credit Hour = " + String.format("%.02f", baseFee) + "\n" +
//                "\n" +
//                "CRN\t\t\tCR_PREFIX\t\t\tCR_HOURS");
//        // loop to print the crns and the associated fees
//        for (int i = 0; i < crnSize; i++) {
//            // print split crn
//            System.out.println(matchingCrnsVar(gradCrnsTaken[i]) + "\t\t\t\t" + " $ " + String.format("%.02f", calculateTotalPaymentCrn(Integer.parseInt(extractCourseHours(matchingCrnsVar(gradCrnsTaken[i]))), baseFee)));
//        }
//        // print the associated fees
//        System.out.println("\n" +
//                "\t\t\t\t\t\t\tHealth & id fees\t $ " + String.format("%.02f", miscellaneousFee) + "\n" +
//                "\n" +
//                "----------------------------------------------------------\n" +
//                "\t\t\t\t\t\t\tTOTAL PAYMENTS\t\t $ " + String.format("%.02f", calculateTotalPayment(gradCrnsTaken, baseFee)) + "\n");
//    }
}
// node class for employee
class Node {
    // declare private vars
    private UndergraduateStudent u;
    private MsStudent m;
    private PhdStudent p;
    private Node next;
    private Node below;

    // constructor for node class
    public Node() {
        u = null;
        m = null;
        p = null;
        next = null;
        below = null;
    }

    // getter and setter for private vars
    // getter for employee
    public UndergraduateStudent getU() {
        return u;
    }
    // getter for employee
    public MsStudent getM() {
        return m;
    }
    // getter for employee
    public PhdStudent getP() {
        return p;
    }
    // getter for next node
    public Node getNext() {
        return next;
    }

    // getter for below node
    public Node getBelow() {
        return below;
    }

    // setter for employee
    public void setU(UndergraduateStudent u) {
        this.u = u;
    }
    // setter for employee
    public void setM(MsStudent m) {
        this.m = m;
    }
    // setter for employee
    public void setP(PhdStudent p) {
        this.p = p;
    }

    // setter for next node
    public void setNext(Node next) {
        this.next = next;
    }

    // setter for below node
    public void setBelow(Node below) {
        this.below = below;
    }
}