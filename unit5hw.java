//unit5.hw
//Group members:David Nguyen
//imports...



public class unit5hw {
    // DO NOT CHANGE ANYTHING IN THIS CLASS (DriverClass)
        public static void main(String[] args) {
            Student s;
            //***********
            s = new PhdStudent ("Zaydoun BenSellam",
                                "zb5954" ,
                                "Gary Richarson",
                                "Fuzzy Topology" ,
                                2599 );
            s.printInvoice();
            //***********
            int [] gradCrnsTaken = {7587,8997} ;
            s = new MsStudent ( "Emily Jones",
                            "em1254",
                                gradCrnsTaken,
                            1997);
            s.printInvoice();
            //***********
            //System.out.println("Undergraduate Student");
            int [] undergradCrnsTaken = {4587,2599};
            s = new UndergraduateStudent ("Jamila Jones" ,
                                            "ja5225" ,
                                            undergradCrnsTaken,
                                            3.0,
                                            false );
            s.printInvoice();
        }//end of main
    }
        //---------------------------
    abstract class Student
    {
        // . . .
        //declare constructor variables
        private String name;
        private String id;
        //constructor
        public Student(String name, String id)
        {
            // . . .
            this.name = name;
            this.id = id;
        }
        
        abstract public void printInvoice();
        //returns name
        public String getName()
        {
            return this.name;
        }
        //returns id
        public String getId()
        {
            return this.id;
        }
            
        public String returnCourseName(int crn)
        {
        // . . .
            //switch that returns course name based on crn
            switch(crn)
            {
                case 4587:
                    return "MAT 236";
                case 4599:
                    return "COP 220";
                case 4580:
                    return "MAT 136";
                case 2599:
                    return "COP 260";
                case 1997:
                    return "CAP 424";
                case 1599:
                    return "COP 111";
                case 2696:
                    return "COP 191";
                case 2099:
                    return "COP 268";
                case 4997:
                    return "CAP 427";
                case 3696:
                    return "KOL 910";
                default:
                    return "Unknown";
            }
        }
    
        public int returnCreditHours(int crn)
        {
            //switch that returns credit hours based on crn
            switch(crn)
            {
                case 4587:
                    return 4;
                case 4599:
                    return 3;
                case 4580:
                    return 1;
                case 2599:
                    return 3;
                case 1997:
                    return 1;
                case 1599:
                    return 3;
                case 2696:
                    return 3;
                case 2099:
                    return 3;
                case 4997:
                    return 1;
                case 3696:
                    return 2;
                default:
                    return 0;
                }
        }
        
    }
    
    class UndergraduateStudent extends Student{
        // . . .
        //declare variables
        private int [] undergradCrnsTaken;
        private boolean resident;
        private double gpa;
        
        //constructor
        public UndergraduateStudent ( String name , String id , int [] undergradCrnsTaken ,double gpa, boolean resident)
        {
            super (name , id );
            this.undergradCrnsTaken = undergradCrnsTaken;
            this.resident = resident;
            this.gpa = gpa;
        // . . .
        }
        //gets price of all classes
        public double totalPrice()
        {
            double totalPrice = 0;
            if(resident)
            {
                for(int i = 0; i < undergradCrnsTaken.length; i++)
            {
                totalPrice += returnCreditHours(undergradCrnsTaken[i])*120.25;
            }
            }
            else
            {
                for(int i = 0; i < undergradCrnsTaken.length; i++)
                {
                    totalPrice += returnCreditHours(undergradCrnsTaken[i])*240.5;
                }
            }
            return totalPrice;
        }
        //prints invoice
        @Override
        public void printInvoice()
        {
        // . . .
            System.out.println("\nVALENCE COLLEGE\n"+
                                "Orlando FL 10101\n"+
                                "-----------------------\n\n"+
                                "Fee Invoice Prepared for Student:\n"
                                +super.getId()+"-"+super.getName());
            //checks for resident status
            if(resident)
            {
                System.out.print("\n\n1 Credit Hour = $120.25\n\n");
            }
            else
            {
                System.out.print("\n\n1 Credit Hour = $240.50\n\n");
            }
            System.out.print("CRN\t\tCR_PREFIX\tCR_HOURS");
            //loop to print out all classes
            for(int i = 0; i < undergradCrnsTaken.length; i++)
            {
                //checks for residnet and adjusts pricing
                if(resident)
                {
                    System.out.print("\n"+undergradCrnsTaken[i]+"\t"+returnCourseName(undergradCrnsTaken[i])+"\t\t"+returnCreditHours(undergradCrnsTaken[i]));
                    System.out.printf("\t\t\t$%.2f",(returnCreditHours(undergradCrnsTaken[i])*120.25));
                }
                else
                {
                    System.out.print("\n"+undergradCrnsTaken[i]+"\t"+returnCourseName(undergradCrnsTaken[i])+"\t\t"+returnCreditHours(undergradCrnsTaken[i]));
                    System.out.printf("\t\t$%.2f",(returnCreditHours(undergradCrnsTaken[i])*240.50));
                }
            }
            System.out.println("\n\t\t\tHealth & id fees\t$35.00\n"+
                                "--------------------------------------------------------------------");
            //checks for if student qualifies for discount
            if(gpa>=3.5 && totalPrice()>500)
            {
                System.out.printf("\t\t\t\t\t\t\t\t$%.2f", totalPrice()+35);
                System.out.printf("\n\t\t\t\t\t\t\t\t-$%.2f", (totalPrice()+35)*0.25);
                System.out.printf("\n\t\t\t\t\t\t\t\t----------------\n\t\t\t\t\t\tTotal\t$%.2f", (totalPrice()+35)-((totalPrice()+35)*0.25));
            }
            else
            {
                System.out.printf("\t\t\t\t\tTotal\t$%.2f\n", totalPrice()+35);
            }
    
        }
        }
        //---------------------------
    
    abstract class GraduateStudent extends Student
    {
        // . . .
        //declare variables
        private int crn;
        //constructor
        public GraduateStudent ( String name , String id , int crn )
        {
        //crn is the crn that the grad student is a teaching assistant for
            super ( name , id );
            this.crn = crn;
        // . . .
        }

        public String returnCourseName(int classnum)
        {
            //switch for graduate level courses based on the crn
            switch(classnum)
            {
                case 8997:
                    return "GOL 124";
                case 9696:
                    return "COP 100";
                case 5696:
                    return "KOL 110";
                case 7587:
                    return "MAT 936";
                case 6997:
                    return "GOL 109";
                case 5580:
                    return "MAT 636";
                default:
                    return "Unknown";
            }
        }
        //returns credit hours based on crn
        public int returnCreditHours(int classnum)
        {
            switch(classnum)
            {
                case 8997:
                    return 1;
                case 9696:
                    return 3;
                case 5696:
                    return 2;
                case 7587:
                    return 5;
                case 6997:
                    return 1;
                case 5580:
                    return 2;
                default:
                    return 0;
            }
        }
    }
        //---------------------------
        class PhdStudent extends GraduateStudent
        {
        // . . .
            //declares variables
            private String advisor;
            private String researchSubject;
            public PhdStudent (String name, String id , String advisor, String researchSubject , int crn ) {
            //crn is the course number that the Phd student is a teaching assistant for
                super ( name , id , crn );
                this.advisor = advisor;
                this.researchSubject = researchSubject;
            // . . .
        }

            //prints invoice
            @Override
            public void printInvoice()
            {
            // . . .
                System.out.println("\nVALENCE COLLEGE\n"+
                                "Orlando FL 10101\n"+
                                "-----------------------\n\n"+
                                "Fee Invoice Prepared for Student:\n"
                                +super.getId()+"-"+super.getName()+
                                "\n\nRESEARCH\n"+
                                researchSubject+
                                "\t\t\t\t$700\n\n"+
                                "\t\tHealth & id fees\t$35.00\n"+
                                "---------------------------------------------------------------\n"+
                                "\t\t\tTotal\t\t\t$735.00");
            }
        }
        //---------------------------
        class MsStudent extends GraduateStudent
        {
        // . . .
            //declares variables
            private int [] gradCrnsTaken;

            //constructor
            public MsStudent (String name, String id , int [] gradCrnsTaken , int crn )
            {
            // gradCoursesTaken is the array of the crns that the Ms student is taking
            //crn is the course number that the Phd student is a teaching assistant for
                super ( name , id , crn );
                this.gradCrnsTaken = gradCrnsTaken;
            // . . .
            }
            //gets total price of all classes
            public double totalPrice()
            {
                double totalPrice = 0;
                for(int i = 0; i < gradCrnsTaken.length; i++)
                {
                    totalPrice += returnCreditHours(gradCrnsTaken[i])*300;
                }
                return totalPrice;
            }
            //prints invoice
            @Override
            public void printInvoice() {
                // . . .
                System.out.println("\nVALENCE COLLEGE\n"+
                                    "Orlando FL 10101\n"+
                                    "-----------------------\n\n"+
                                    "Fee Invoice Prepared for Student:\n"
                                    +super.getId()+"-"+super.getName()+
                                    "\n\n1 Credit Hour = $300.00\n\n"+
                                    "CRN\t\tCR_PREFIX\tCR_HOURS");
                //loop to print out all classes
                for(int i = 0; i < gradCrnsTaken.length; i++)
                {
                    System.out.println(gradCrnsTaken[i]+"\t"+returnCourseName(gradCrnsTaken[i])+"\t\t"+returnCreditHours(gradCrnsTaken[i])+"\t\t\t$"+(returnCreditHours(gradCrnsTaken[i])*300));
                }
                
                System.out.println("\t\t\tHealth & id fees\t$35.00\n"+"--------------------------------------------------------------------");
                System.out.printf("\t\t\tTotal\t\t\t\t$%.2f\n",(totalPrice()+35.00));
                }
        }
    