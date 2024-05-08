//unit1.hw
//Group Members:David Nguyen

import java.util.Scanner;
public class unit1hw {
    public static void main(String[] args) {
        //declare variables
        int class1,class2,credit1,credit2;
        String studentName,class1Info,class2Info,studentID;
        String[] class1Ints, class2Ints;
        //create scanner
        Scanner userInput;
        userInput = new Scanner(System.in);

        //scans user ID and stores string
        System.out.print("Enter the Student's  Id:");
        studentID = userInput.nextLine();
        
        //scans user name and stores string
        System.out.print("\nEnter the Student's  full name:");
        studentName = userInput.nextLine();

        //reads credit hours and class number and stores it as a string
             //use split to separate the two different numbers
             //use parse to convert string to int
        System.out.print("\nEnter crn/credit hours for the first class:");
        class1Info = userInput.nextLine();
        class1Ints = class1Info.split("/");
        class1 = Integer.parseInt(class1Ints[0]);
        credit1 = Integer.parseInt(class1Ints[1]);
        System.out.print("\nEnter crn/credit hours for the second class:");
        class2Info = userInput.nextLine();
        class2Ints = class2Info.split("/");
        class2 = Integer.parseInt(class2Ints[0]);
        credit2 = Integer.parseInt(class2Ints[1]);
        //close scanner
        userInput.close();
        //calculate cost of classes
        double class1Cost = credit1*120.25;
        double class2Cost = credit2*120.25;
        double total = (class1Cost+class2Cost)+35.00;
        
        //format the invoice with print statements
        System.out.print("\nThank you!"+"\nHERE IS THE FEE INVOICE...\n"+"\nSIMPLE COLLEGE"+"\nORLANDO FL 10101"+"\n***************************"+"\nFee Invoice Prepared for:"+"\n["+studentName+"]["+studentID+"]\n"+"\n1 Credit Hour = $120.25\n"+"\nCRN            Credit Hours"+"\n"+class1+"             "+credit1+"             "+"$");
        System.out.printf("%.2f",class1Cost);
        System.out.print("\n"+class2+"             "+credit2+"             "+"$");
        System.out.printf("%.2f\n",class2Cost);
        System.out.print("\nHealth & id fees $35.00\n"+"\n-------------------------------------------"+"\n             TOTAL: $");
        System.out.printf("%.2f",total);
        
        
    }
}
