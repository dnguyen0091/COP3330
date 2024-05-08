// David Nguyen, Tom Nguyen
// 04/03/2024
// COP 3330
public class DriverClass {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        // hard code user input
        list.addNewEmployee(new Employee ("Kim Oz", 1235.3, 3));
        list.addNewEmployee(new Employee("Rim Oz", 8235.5, 1));
        list.addNewEmployee(new Employee("Dane Ali", 3235.5, 0));
        list.addNewEmployee(new Employee("Aidan Jones", 2035.5, 2));
        list.addNewEmployee(new Employee("Nadia Jones", 5035.5, 3));
        list.addNewEmployee(new Employee("Ed Renu", 6035, 2));
        list.addNewEmployee(new Employee("Naadi Jones", 36035.75, 5));
        // print the list
        list.printAllEmployees();
        // print the highest salary employee
        System.out.println("The highest net salary = " + list.highestNetSalary());
        // delete employee by name
        list.deleteEmployeeByName("Rim Oz");
        list.deleteEmployeeByName("Nadia Jones");
        // print the result of search by name
        System.out.println(list.searchByName("Gary D. Richardson"));
        // print all fo the employees
        list.printAllEmployees();
    }
}
    // provided code for node class
    class LinkedList {
        // declare a reference for the head of the list
        Node company;
        // declare a constructor for linkedlist class
        public LinkedList() {
            company = null;
        }
        // function to calculate the net salary
        public double netSalary(double s, int d) {
            // declare a net salary variable to store
            double netSalary = 0;
            // equation for net salary
            netSalary = (s * 0.91) + (d * 0.01 * s);
            // return the net salary
            return netSalary;
        }
        // function to print all the employees info
        public void printAllEmployees() {
            // create a temp node
            Node temp = company;
            // loop through the list
            while (temp != null) {
                // declare a temp node to traverse the below nodes
                Node tempBelow = temp;
                // print the employee info
                System.out.println("[" + temp.getE().getId() +
                                    ", " + temp.getE().getName() +
                                    ", " + String.format("%.02f", netSalary(temp.getE().getSalary(), temp.getE().getNumberOfDependent())) +
                                    "]"
                                    );

                // condition to check for the sub group
                if (tempBelow.getBelow() != null) {
                    // inner while loop to print the sub group
                    while (tempBelow.getBelow() != null) {
                        // print the employee info
                        System.out.println("[" + tempBelow.getBelow().getE().getId() +
                                            ", " + tempBelow.getBelow().getE().getName() +
                                            ", " + String.format("%.02f", netSalary(tempBelow.getBelow().getE().getSalary(), tempBelow.getBelow().getE().getNumberOfDependent())) +
                                            "]"
                                            );
                        // go to the next node in the sub group
                        tempBelow = tempBelow.getBelow();
                    }
                }
                // go to the next node
                temp = temp.getNext();
            }
        }
        // function to calculate the ascii value of the employee full name and return it
        public int asciiValue(String name) {
            // declare a variable to store the ascii value
            int asciiValue = 0;
            // loop through the name
            for (int i = 0; i < name.length(); i++) {
                // add the ascii value of the character to the ascii value
                asciiValue += name.toUpperCase().charAt(i);
            }
            // return the ascii value
            return asciiValue;
        }
        // function to add new employee
        public void addNewEmployee(Employee e) {
            // create a new node
            Node newNode = new Node();
            // set the employee to the node
            newNode.setE(e);
            // set the id of the employee
            e.setId(asciiValue(e.getName()));
            // check if the list is empty
            if (company == null) {
                // set the new node to the head
                company = newNode;
            }
            // if the list is not empty
            else {
                // create a temp node
                Node temp = company;
                // loop through the list to add the new node
                while (temp.getNext() != null || temp.getE().getId() == e.getId()) {
                    // condition to check if the last name is equal to the last name in the list
                    if (temp.getE().getId() == e.getId()) {
                        // declare a temp node to traverse the below nodes
                        Node tempBelow = temp;
                        // traverse the below nodes
                        while (tempBelow.getBelow() != null) {
                            // go to the next node
                            tempBelow = tempBelow.getBelow();
                        }
                        // set the new node to the below node
                        tempBelow.setBelow(newNode);
                        // return
                        return;
                    }
                    // go to the next node
                    temp = temp.getNext();
                }
                // set the new node to the next node
                temp.setNext(newNode);
                // return
                return;
            }
        }
//      function to search for employee by name
        public boolean searchByName(String name) {
            // create a temp node
            Node temp = company;
            // loop through the list
            while (temp != null) {
                // check if the last name is equal to any of the names in the list
                if (temp.getE().getName().equals(name)) {
                    // return true
                    return true;
                }
                // check if the sub group is not null
                if (temp.getBelow() != null) {
                    // temp node to traverse the sub group
                    Node tempBelow = temp.getBelow();
                    // loop through the sub group
                    while (tempBelow != null) {
                        // check if the last name is equal to any of the names in the sub group
                        if (tempBelow.getE().getName().equals(name)) {
                            // return true
                            return true;
                        }
                        // go to the next node
                        tempBelow = tempBelow.getBelow();
                    }
                }
                // go to the next node
                temp = temp.getNext();
            }
            // return false
            return false;
        }
        // function to find the highest net salary
        public double highestNetSalary() {
            // declare a variable to store the highest salary
            double highestSalary = 0;
            // create a temp node
            Node temp = company;
            // loop through the list
            while (temp != null) {
                // check if the salary is higher than the highest salary
                if (netSalary(temp.getE().getSalary(), temp.getE().getNumberOfDependent())
                        > highestSalary) {
                    // set the highest salary to the salary
                    highestSalary = netSalary(temp.getE().getSalary(), temp.getE().getNumberOfDependent());
                }
                // check if any of the sub group salary is higher than the highest salary
                if (temp.getBelow() != null) {
                    // temp node to traverse the sub group
                    Node tempBelow = temp.getBelow();
                    // loop through the sub group
                    while (tempBelow != null) {
                        // check if the salary is higher than the highest salary
                        if (netSalary(tempBelow.getE().getSalary(), tempBelow.getE().getNumberOfDependent())
                                > highestSalary) {
                            // set the highest salary to the salary
                            highestSalary = netSalary(tempBelow.getE().getSalary(), tempBelow.getE().getNumberOfDependent());
                        }
                        // go to the next node
                        tempBelow = tempBelow.getBelow();
                    }
                }
                // go to the next node
                temp = temp.getNext();
            }
            return highestSalary;
        }

        // function to delete employee by name
        public void deleteEmployeeByName(String name) {
            // create a temp node for traverse the list
            Node temp = company;
            // loop through the list
            while (temp.getNext() != null) {
                // check if the last name is equal to the name
                if (temp.getNext().getE().getName().equals(name)) {
                    // create a temp to save the next node
                    Node tempNext = temp.getNext().getNext();
                    // set the next node to the current node
                    temp.setNext(tempNext);
                    // return
                    return;
                }
                // check if the sub group of the current node is not null
                if (temp.getBelow() != null) {
                    // loop through the sub group
                    while (temp.getBelow() != null) {
                        // check if the last name is equal to the name
                        if (temp.getBelow().getE().getName().equals(name)) {
                            // create a temp to save the next node
                            Node tempBelow = temp.getBelow().getBelow();
                            // set the next node to the current node
                            temp.setBelow(tempBelow);
                            // return
                            return;
                        }
                        // go to the next node
                        temp = temp.getBelow();
                    }
                }
                // go to the next node
                temp = temp.getNext();
            }
        }
    }
        // declare a class for employee
        class Employee {
            private String name;
            private int id;
            private int numberOfDependent;
            private double salary;

            // constructor for employee class
            public Employee(String name, double salary, int numberOfDependent) {
                this.name = name;
                this.salary = salary;
                this.numberOfDependent = numberOfDependent;
            }

            // getter for name
            public String getName() {
                return name;
            }

            // getter for salary
            public double getSalary() {
                return salary;
            }

            // getter for number of dependent
            public int getNumberOfDependent() {
                return numberOfDependent;
            }

            // getter for id
            public int getId() {
                return id;
            }

            // setter for name
            public void setName(String name) {
                this.name = name;
            }

            // setter for salary
            public void setSalary(double salary) {
                this.salary = salary;
            }

            // setter for number of dependent
            public void setNumberOfDependent(int numberOfDependent) {
                this.numberOfDependent = numberOfDependent;
            }

            // setter for id
            public void setId(int id) {
                this.id = id;
            }
        }
        // node class for employee
        class Node {
            // declare private vars
            private Employee e;
            private Node next;
            private Node below;

            // constructor for node class
            public Node() {
                e = null;
                next = null;
                below = null;
            }

            // getter and setter for private vars
            // getter for employee
            public Employee getE() {
                return e;
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
            public void setE(Employee e) {
                this.e = e;
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
