//unit4.hw
//Group Members: David Nguyen

//input required tools
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;


public class unit4hw
{
    //function meant to control add/delete process
    private static void subMenu(College valenceCollege,int studentId)
    {
        //create scanner and find student address
        Scanner input=new Scanner(System.in);
        Student student=valenceCollege.search(studentId);
        //prints out classes student has
        valenceCollege.printInvoice(studentId);
        //list options for user to take
        System.out.println("Choose from:\n"+
                        "A- Add a new course for ["+student.getName()+"]\n"+
                        "D- Delete a course from ["+student.getName()+"]'s schedule\n"+
                        "C- Cancel operation");
        
        System.out.println("Enter your selection:");
        String option=input.nextLine();
        int crn;

        //switch that handles the options listed above
        switch(option)
        {
            case "A":
                //gets crn
                System.out.println("Enter course number to add:");
                crn=input.nextInt();
                input.nextLine();
                //case checking to determine if the class exists and can be added
                if(valenceCollege.addCourse(studentId,crn))
                {
                    System.out.println("["+crn+"/"+student.getPrefix(crn)+"] is added successfully!");
                }
                else System.out.println("["+crn+"/"+student.getPrefix(crn)+"] could not be added.");
                //displays fee invoice if user desires
                System.out.println("Want to display a new invoice? Y/N:");
                option=input.nextLine();
                if(option.equals("Y") || option.equals("y"))
                {
                    student.printFeeInvoice();
                }
                break;
            case "D":
                //gets crn
                System.out.println("Enter course number to delete:");
                crn=input.nextInt();
                input.nextLine();
                //determine if the crn exist and can be deleted
                if(valenceCollege.deleteCourse(studentId, crn))
                {
                    System.out.println("["+crn+"/"+student.getPrefix(crn)+"] is deleted successfully!");
                }
                else System.out.println("["+crn+"/"+student.getPrefix(crn)+"] could not be deleted.");
                //Prints out student fee invoice if wanted
                System.out.println("Want to display a new invoice? Y/N:");
                option=input.nextLine();
                if(option.equals("Y") || option.equals("y"))
                {
                    student.printFeeInvoice();
                }
                break;
            //cancel case
            case "C":
                break;
        }
    }
    private static College valenceCollege;
    //meant to list options for the user
        //returns option selected by user
    private static String mainMenu()
    {
        String option;
        Scanner input=new Scanner(System.in);
        System.out.println("Choose from the following options:\n"
                        +"\t1- Add a new student\n"+"\t2- Add/Delete a course\n"
                        +"\t3- Search for a student\n"+"\t4- Print fee invoice\n"
                        +"\t5- Print fee invoice sorted by crn\n"+"\t0- Exit Program\n");
        System.out.print("Enter your selection:");
        option=input.nextLine();
        //returns the user’s choice of the menu (just like we did in class!)
        return option;
    }

    public static void main(String[] args)
    {
        //declare local variables
        valenceCollege = new College();
        Scanner input2=new Scanner(System.in);
        int studentId,numCrn;
        String studentName;
        double gpa;
        ArrayList<Integer> listOfCrns;
        int option=99999;
        
        //loop to take user input til option 0
        while(option!=0)
        {
            //turns string to an integer while calling the mainMenu for user
            option=Integer.parseInt(mainMenu());
            //makes a new list for crns each loop
            //listOfCrns=new ArrayList<Integer>();
            

            switch(option)
            {
                case 1:
                    //enrolls student
                    valenceCollege.enrollStudent();
                    break;
                case 2:
                    //gets id and determines if the student exists
                    System.out.print("Enter students's id:");
                    studentId=input2.nextInt();
                    if(valenceCollege.searchById(studentId)!=true)
                    {
                        System.out.println("No student found!");
                        break;
                    }
                    //sends to menu for adding/deleting
                    subMenu(valenceCollege,studentId);
                    
                    break;
                case 3:
                    //determine if the student exists before printing out an invoice
                    System.out.print("Enter students's id:");
                    studentId=input2.nextInt();
                    if(valenceCollege.searchById(studentId)!=true)
                        {
                            System.out.println("No student found!");
                            break;
                        }
                        valenceCollege.printInvoice(studentId);
                    break;
                case 4:
                    //checks for student then prints out an invoice
                    System.out.print("Enter students's id:");
                    studentId=input2.nextInt();
                    if(valenceCollege.searchById(studentId)!=true)
                    {
                        System.out.println("No student found!");
                        break;
                    }
                    Student student=valenceCollege.search(studentId);
                    student.printFeeInvoice();
                    break;
                case 5:
                    //checks for student then prints out fee invoice
                    System.out.print("Enter students's id:");
                    studentId=input2.nextInt();
                    if(valenceCollege.searchById(studentId)!=true)
                    {
                        System.out.println("No student found!");
                        break;
                    }
                    valenceCollege.printSortedInvoice(studentId);
                    break;
                case 0:
                    //goodbye case
                    System.out.println("Goodbye!");
                    break;
            }
        }
    }
}

    
    class Student
    {
        //declare variables
        private int studentId;
        private double gpa;
        private String studentName;
        private ArrayList <Integer> listOfCrns;
        //constructor
        public Student(String studentName,int studentId,double gpa,ArrayList<Integer> listOfCrns)
        {
            this.studentId=studentId;
            this.gpa=gpa;
            this.studentName=studentName;
            this.listOfCrns= new ArrayList<>(listOfCrns);
        }
        //returns id
        public int getID()
        {
            return this.studentId;
        }
        //printsCrns with a for loop
        public void printCrns()
        {
            System.out.print("Here are the courses["+studentName+"] is taking:\n"
                            +"\t\t\t\tCRN\tPREFIX\t\t\tCR. HOURS\n");
            for(int i=0; i<listOfCrns.size();i++)
            {
                int crn=listOfCrns.get(i);
                String Prefix=getPrefix(crn);
                int hours=getHours(crn);
                System.out.print("\t\t\t\t"+crn+"\t"+Prefix+"\t\t\t"+hours+"\n");
            }
                            
        }
        //returns name
        public String getName()
        {
            return this.studentName;
        }
        //returns crn list
        public ArrayList<Integer> getListOfCrns()
        {
            return this.listOfCrns;
        }
        //returns hours
        public int getHours(int crn)
        {
            //switch that uses crn to return the right hours
            switch(crn)
            {
                case 4587:
                    return 4;
                case 4599:
                    return 3;
                case 8997:
                    return 1;
                case 9696:
                    return 3;
                case 4580:
                    return 1;
                case 2599:
                    return 3;
                case 1997:
                    return 1;
                default:
                    return 2;
            }
        }
        public String getPrefix(int crn)
        {
            //switch that uses crn to return proper class prefixx
            switch(crn)
            {
                case 4587:
                    return "MAT 236";
                case 4599:
                    return "COP 220";
                case 8997:
                    return "GOL 124";
                case 9696:
                    return "COP 100";
                case 4580:
                    return "MAT 136";
                case 2599:
                    return "COP 260";
                case 1997:
                    return "CAP 424";
                default:
                    return "KOL 110";
                
            }
        }
        //just meant to return the cost of classes to determine if eligible for discount
        public double tuitionCheck()
        {
            double totalPayment=0;
            for(int i=0;i<this.listOfCrns.size();i++)
                {
                    totalPayment+=(getHours(listOfCrns.get(i))*(double)120.25);
                }
            totalPayment+=35;
            return totalPayment;
        }
        //meant for the same thing basically just a private field meant for printing
        private double calculateTotalPayment()
        {
            double totalPayment=0;
            for(int i=0;i<this.listOfCrns.size();i++)
                {
                    totalPayment+=(getHours(listOfCrns.get(i))*(double)120.25);
                }
            totalPayment+=35;
            return totalPayment;
        }
        //formats invoice like previous runs
        public void printFeeInvoice()
        {
            
            System.out.println("VALENCE COLLEGE\nORLANDO FL 10101\n------------------------\n\nFee Invoice Prepared for Student:\n"
                            +this.studentId+"-"+this.studentName+"\n\n1 Credit Hour= $120.25\n\nCRN\tCR_PREFIX\tCR_HOURS");
            //loop to print out the crn,hours,prefix
            for(int i=0;i<listOfCrns.size();i++)
            {
                int crn=listOfCrns.get(i);
                String Prefix=getPrefix(crn);
                int hours=getHours(crn);
                System.out.printf("%d\t%s\t\t\t%d\t$%.2f\n", crn, Prefix, hours, hours * 120.25);
            }
            System.out.println("\n\t\tHealth & id fees   $35.00\n\n-----------------------------------------------");
            //checks for if the student is eligible for discount and formats it based on the requirements
            if(calculateTotalPayment()>700 & this.gpa>=3.5)
            {
                System.out.printf("\t\t\t\t\t$%.2f\n", calculateTotalPayment());
                System.out.printf("\t\t\t\t\t-$%.2f\n", (calculateTotalPayment() * 0.25));
                System.out.println("\t\t\t\t\t----------");
                System.out.printf("\t\t\tTOTAL PAYMENTS\t$%.2f\n", (calculateTotalPayment() - (calculateTotalPayment() * 0.25)));
            }
            else
            {
                System.out.printf("\n\t\t\tTOTAL PAYMENTS\t$%.2f\n",calculateTotalPayment());
            }
        }
    }
    

    class College
    {
        //declares list of students
        private ArrayList<Student> list;
        //constructor
        public College()
        {
            list = new ArrayList<>();
        }
        //enrolls to college
        public void enrollStudent ()
        {
            //declare local variables
            Scanner input2=new Scanner(System.in);
            int studentId,numCrn;
            String studentName;
            double gpa;
            ArrayList<Integer> listOfCrns=new ArrayList<Integer>();

            //while loop meant to iterate til a id that is not taken is ended
            while(true)
            {
                System.out.print("Enter students's id:");
                studentId=input2.nextInt();
                input2.nextLine();
                //searches to see if id exists
                if(searchById(studentId))
                {
                    System.out.println("Sorry, "+studentId+" is already assigned to another student.\n");
                    
                }
                else break;
            }
            //handles all the input that will be sent to the constructor
            System.out.print("Enter students's name:");
            studentName=input2.nextLine();
            System.out.print("How many courses "+studentName+" is taking:\n\t");
            numCrn=input2.nextInt();
            System.out.print("Enter the "+numCrn+" course numbers\n\t");
            for(int i=0;i<numCrn;i++)
            {
                listOfCrns.add(input2.nextInt());
            }
            System.out.print("Enter "+studentName+"'s current GPA:\n\t");
            gpa=input2.nextDouble();

            //constructor/adds student to college
            list.add(new Student(studentName,studentId,gpa,listOfCrns));
            Student student1=search(studentId);
            //checks to see if student is eligible for a discount
            if(gpa>=3.5 & student1.tuitionCheck()>700)
            {
                System.out.print("("+studentName+" is eligible for the 25% discount)\n");
            }
            else
            {
                System.out.print("("+studentName+" is not eligible for the 25% discount)\n");
            }
            System.out.println("Student added successfully!");
        }
        public boolean searchById(int studentId) {
            //iterates through list to find if student exists
                //returns proper boolean values depending on the case
            for(int i=0;i<list.size();i++)
            {
                if(list.get(i).getID()==studentId)
                {
                    return true;
                }
            }
            return false;
        }
        //searches for student by id but returns the address rather than a bool
        public Student search(int studentId)
        {
            for(int i=0;i<list.size();i++)
            {
                
                if(list.get(i).getID()==studentId)
                {
                    return list.get(i);
                }
            }
            return null;
        }
        
        public boolean addCourse(int studentId,int crn)
        {
            //gets student address and determines if the class can be added based on if the student has the class already
            Student student = search(studentId);
            if (!student.getListOfCrns().contains(crn))
            {
                // Add crn to the listOfCrns
                student.getListOfCrns().add(crn);
                return true; // Course added successfully
            }
            else
            {
                // crn is already in the listOfCrns
                return false; // Course already exists
            }
        }


        public boolean deleteCourse(int studentId,int crn)
        {
            //gets student address and deletes based on if the class is being taken
            Student student = search(studentId);
            if(!student.getListOfCrns().contains(crn))
            {
                return false;
            }
            else
            {
                //iterates through the list to find the index then removes it
                for(int i=0;i<student.getListOfCrns().size();i++)
                {
                    if(student.getListOfCrns().get(i)==crn)
                    {
                        student.getListOfCrns().remove(i);
                        break;
                    }
                }
                return true;
            }
                
        }
        

        public void printInvoice(int studentId)
        {
            //gets the student address
            Student student = search(studentId);
            //finds student in list then sends to function to print out invoice without fees
            for (int i=0;i<list.size();i++)
            {
                if (student.getID() == studentId)
                {
                    student.printCrns();
                    break;
                }
            }
        }
        //sorts the list then prints it out
        public void printSortedInvoice(int studentId)
        {
            Student student=search(studentId);
            Collections.sort(student.getListOfCrns());
            student.printFeeInvoice();
        }
    }