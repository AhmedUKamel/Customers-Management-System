import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
    // D:\\Github clones\\Customers-Management-System\\src\\Data.txt
    // Data Fields
    public static final Scanner sc = new Scanner(System.in);

    // Main Function
    public static void main(String [] args) {
        run();
    }

    // Read File Method (Array List, Linked List)
    public static boolean read(String path, ArrayCustomerList array) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {
                String[] splited = reader.nextLine().split("-");

                for(int i =0; i <splited.length;i++)System.out.print(splited[i]+">");

                array.insert(new    Customer(splited[0],                // Name
                                    Integer.parseInt(splited[1]),       // Contract ID
                                    splited[2],                         // Nationality
                                    splited[3],                         // Phone
                                    Double.parseDouble(splited[4]),     // Current Bill
                                    Double.parseDouble(splited[5]))     // Accumulated Bill
                );
                System.out.println("Finish insertion");
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR READING FILE");
            return false;
        }
    }

    public static boolean write(String path, ArrayCustomerList array) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file);

            for(int index = 0; index < array.capacity(); index++)
                writer.write(array.get(index).line() + "\n");

            writer.close();
            return true;
        } catch (Exception e) {
            System.out.println("ERROR WRITING FILE");
            return false;
        }
    }

    // Run Method
    public static void run() {
        while(true) {
            System.out.print( "Which implementation:" +
                                "\n\t1.Array List" +
                                "\n\t2.Linked List" +
                                "\n\t3.Exit program" +
                                "\n\tChoice: ");

            try {
                int answer = sc.nextInt();
                sc.nextLine();                  // Clear the Scanner

                if(answer == 1)
                    array_list();
                else if(answer == 2)
                    linked_list();
                else if(answer == 3)
                    return;
                else
                    System.out.println("INVALID RANGE");
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }

    // Array List Implementation
    public static void array_list() {
        while(true) {
            System.out.print("Choose file option:" +
                                "\n\t1.Read file" +
                                "\n\t2.Write file" +
                                "\n\t3.Back" +
                                "\n\tChoice: ");

            try {
                int answer = sc.nextInt();
                sc.nextLine();

                if(answer == 1)
                    read_file();
                else if(answer == 2)
                    write_file();
                else if(answer == 3)
                    return;
                else
                    System.out.println("INVALID RANGE");
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }

    public static void read_file() {
        while(true) {
            try {
                System.out.print("Enter path (Enter '\\\\' instead of '\\'): ");
                String path = sc.nextLine();

                ArrayCustomerList array = new ArrayCustomerList();

                if(read(path, array)) {
                    array_operation(path, array);
                }

                return;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                System.out.println("INVALID INPUT");
            }
        }
    }

    public static void array_operation(String path, ArrayCustomerList array) {
        while(true) {
            System.out.print("Choose operation on Array List:" +
                            "\n\t1.Show" +
                            "\n\t2.Add customer" +
                            "\n\t3.Delete customer" +
                            "\n\t4.Update customer details" +
                            "\n\t5.Save file" +
                            "\n\t6.Back" +
                            "\n\tChoice: ");

            try {
                int answer = sc.nextInt();
                sc.nextLine();

                if(answer == 1)
                    array.display();
                else if(answer == 2)
                    add_customer(array);
                else if(answer == 3)
                    delete_customer(array);
                else if(answer == 4)
                    update_customer(array);
                else if(answer == 5)
                    save_read_file(path, array);
                else if(answer == 6)
                    return;
                else
                    System.out.println("INVALID RANGE");
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }

    public static void add_customer(ArrayCustomerList array) {
        while(true) {
            try {
                System.out.print("Enter customer contract ID: ");
                int contract_id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter customer name: ");
                String name = sc.nextLine();

                System.out.print("Enter customer nationality: ");
                String nationality = sc.nextLine();

                System.out.print("Enter customer phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter customer current bill amount: ");
                double current_bill = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter customer accumulated bill amount: ");
                double accumulated_bill = sc.nextDouble();
                sc.nextLine();

                if(array.insert(new Customer(name, contract_id, nationality, phone, current_bill, accumulated_bill))) {
                    System.out.print("Customer has been added" +
                                    "\nAdd another customer ?" +
                                    "\n\t1.YES" +
                                    "\n\t2.No" +
                                    "Choice: ");

                    int answer = sc.nextInt();
                    sc.nextLine();

                    if(answer == 2)
                        return;
                    else if(answer != 1)
                        System.out.println("INVALID RANGE");
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }

    public static void delete_customer(ArrayCustomerList array) {
        while(true) {
            try {
                System.out.print("Delete using:" +
                                "\n\t1.Name" +
                                "\n\t2.Contract ID" +
                                "\n\tChoice: ");

                int answer = sc.nextInt();
                sc.nextLine();

                if(answer == 1) {
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    if(array.delete(name))
                        System.out.println("Customer has been deleted" +
                                "\n\tDelete another customer ?");
                    else
                        System.out.println("Customer has not been deleted" +
                                "\n\tTry again ?");

                    System.out.print("\t1.YES\n\t2.NO\n\tChoice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    if(choice == 2)
                        return;
                    else if(choice != 1)
                        System.out.println("INVALID RANGE");
                } else if (answer == 2) {
                    System.out.print("Enter customer contract ID: ");
                    int contract_id = sc.nextInt();
                    sc.nextLine();

                    if(array.delete(contract_id))
                        System.out.println("Customer has been deleted" +
                                "\n\tDelete another customer ?");
                    else
                        System.out.println("Customer has not been deleted" +
                                "\n\tTry again ?");

                    System.out.print("\t1.YES\n\t2.NO\n\tChoice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    if(choice == 2)
                        return;
                    else if(choice != 1)
                        System.out.println("INVALID RANGE");
                } else {
                    System.out.println("INVALID RANGE");
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }

    public static void update_customer(ArrayCustomerList array) {
        while(true) {
            try {
                System.out.print("Update using:" +
                        "\n\t1.Name" +
                        "\n\t2.Contract ID" +
                        "\n\tChoice: ");

                int answer = sc.nextInt();
                sc.nextLine();

                if(answer == 1) {
                    System.out.print("Enter customer name: ");
                    String name = sc.nextLine();

                    Customer result = array.linear_search(name);
                    if (result != null) {
                        while(true) {
                            System.out.print("Update:" +
                                        "\n\t1.Name" +
                                        "\n\t2.Contract ID" +
                                        "\n\t3.Nationality" +
                                        "\n\t4.Phone" +
                                        "\n\t5.Current bill" +
                                        "\n\t6.Back" +
                                        "Choice: ");
                            int code = sc.nextInt();
                            sc.nextLine();

                            if(code == 1) {
                                System.out.print("Enter new name: ");
                                String new_name = sc.nextLine();
                                result.set_name(new_name);
                                System.out.println("Name has been updated");
                            } else if(code == 2) {
                                System.out.print("Enter new contract ID: ");
                                int new_contract_id = sc.nextInt();
                                result.set_contract_id(new_contract_id);
                                System.out.println("Contract ID has been updated");
                            } else if(code == 3) {
                                System.out.print("Enter new nationality: ");
                                String new_nationality = sc.nextLine();
                                result.set_nationality(new_nationality);
                                System.out.println("Nationality has been updated");
                            } else if(code == 4) {
                                System.out.print("Enter new phone: ");
                                String new_phone = sc.nextLine();
                                result.set_phone(new_phone);
                                System.out.println("Phone has been updated");
                            } else if(code == 5) {
                                System.out.print("Enter new bill: ");
                                double new_current_bill = sc.nextDouble();
                                result.set_current_bill(new_current_bill);
                                System.out.println("Bill has been updated");
                            } else if(code == 6) {
                                return;
                            } else {
                                System.out.println("INVALID RANGE");
                            }
                        }
                    }  else
                        System.out.println("Customer not found");

                    System.out.print("\t1.YES\n\t2.NO\n\tChoice: ");
                    int choice = sc.nextInt();
                    sc.nextLine();

                    if (choice == 2)
                        return;
                    else if (choice != 1)
                        System.out.println("INVALID RANGE");
                } else if(answer == 2) {
                    System.out.print("Enter customer contract ID: ");
                    int contract_id = sc.nextInt();
                    sc.nextLine();

                    Customer result = array.linear_search(contract_id);
                    if (result != null) {
                        while (true) {
                            System.out.print("Update:" +
                                    "\n\t1.Name" +
                                    "\n\t2.Contract ID" +
                                    "\n\t3.Nationality" +
                                    "\n\t4.Phone" +
                                    "\n\t5.Current bill" +
                                    "\n\t6.Back" +
                                    "Choice: ");
                            int code = sc.nextInt();
                            sc.nextLine();

                            if (code == 1) {
                                System.out.print("Enter new name: ");
                                String new_name = sc.nextLine();
                                result.set_name(new_name);
                                System.out.println("Name has been updated");
                            } else if (code == 2) {
                                System.out.print("Enter new contract ID: ");
                                int new_contract_id = sc.nextInt();
                                result.set_contract_id(new_contract_id);
                                System.out.println("Contract ID has been updated");
                            } else if (code == 3) {
                                System.out.print("Enter new nationality: ");
                                String new_nationality = sc.nextLine();
                                result.set_nationality(new_nationality);
                                System.out.println("Nationality has been updated");
                            } else if (code == 4) {
                                System.out.print("Enter new phone: ");
                                String new_phone = sc.nextLine();
                                result.set_phone(new_phone);
                                System.out.println("Phone has been updated");
                            } else if (code == 5) {
                                System.out.print("Enter new bill: ");
                                double new_current_bill = sc.nextDouble();
                                result.set_current_bill(new_current_bill);
                                System.out.println("Bill has been updated");
                            } else if (code == 6) {
                                return;
                            } else {
                                System.out.println("INVALID RANGE");
                            }
                        }
                    }
                } else {
                    System.out.println("INVALID RANGE");
                }
            } catch (Exception e) {
                    System.out.println("INVALID INPUT");
                }
        }
    }

    public static void save_read_file(String path, ArrayCustomerList array) {
        while(true) {
            try {
                System.out.print("Save at the same path ?" +
                                "\n\t1.YES\n\t2.NO\n\tChoice: ");
                int answer = sc.nextInt();
                sc.nextLine();

                if (answer == 2) {
                    System.out.print("Enter new path (Enter '\\\\' instead of '\\'): ");
                    path = sc.nextLine();
                }

                if(write(path, array))
                    System.out.println("File has been saved");
                else
                    System.out.println("File has not been saved");

                return;
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }

    public static void write_file() {
        ArrayCustomerList array = new ArrayCustomerList();

        while(true) {
            try {
                System.out.print("Enter customer contract ID: ");
                int contract_id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter customer name: ");
                String name = sc.nextLine();

                System.out.print("Enter customer nationality: ");
                String nationality = sc.nextLine();

                System.out.print("Enter customer phone: ");
                String phone = sc.nextLine();

                System.out.print("Enter customer current bill amount: ");
                double current_bill = sc.nextDouble();
                sc.nextLine();

                System.out.print("Enter customer accumulated bill amount: ");
                double accumulated_bill = sc.nextDouble();
                sc.nextLine();

                if(array.insert(new Customer(name, contract_id, nationality, phone, current_bill, accumulated_bill))) {
                    System.out.print("Customer has been added" +
                            "\nAdd another customer ?" +
                            "\n\t1.YES" +
                            "\n\t2.No" +
                            "Choice: ");

                    int answer = sc.nextInt();
                    sc.nextLine();

                    if(answer == 2) {
                        System.out.print("Enter path (Enter '\\\\' instead of '\\'): ");
                        String path = sc.nextLine();

                        if(write(path, array)) {
                            System.out.println("File has been written");
                            return;
                        } else {
                            System.out.println("File has not been written");
                        }
                    } else if(answer != 1)
                        System.out.println("INVALID RANGE");
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }

    public static void linked_list() {
        System.out.println("Linked List is not implemented yet");
    }
}