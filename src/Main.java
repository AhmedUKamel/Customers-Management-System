import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class Main {
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

                array.insert(new    Customer(splited[0],                // Name
                        Integer.parseInt(splited[1]),       // Contract ID
                        splited[2],                         // Nationality
                        splited[3],                         // Phone
                        Double.parseDouble(splited[4]),     // Current Bill
                        Double.parseDouble(splited[5]))     // Accumulated Bill
                );
            }

            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR READING FILE");
            return false;
        }
    }
    public static boolean read(String path, CustomerLinkedList array) {
        try {
            File file = new File(path);
            Scanner reader = new Scanner(file);

            while(reader.hasNextLine()) {
                String[] splited = reader.nextLine().split("-");

                array.insert(new    Customer(splited[0],                // Name
                        Integer.parseInt(splited[1]),       // Contract ID
                        splited[2],                         // Nationality
                        splited[3],                         // Phone
                        Double.parseDouble(splited[4]),     // Current Bill
                        Double.parseDouble(splited[5]))     // Accumulated Bill
                );
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
    public static boolean write(String path, CustomerLinkedList array) {
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
                sc.nextLine();
            }
        }
    }

    /////////////////////////////
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
                    read_file_array_list();
                else if(answer == 2)
                    write_file_array_list();
                else if(answer == 3)
                    return;
                else
                    System.out.println("INVALID RANGE");
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void read_file_array_list() {
        while(true) {
            try {
                System.out.print("Enter path: ");
                String path = sc.nextLine();

                ArrayCustomerList array = new ArrayCustomerList();

                if(read(path, array)) {
                    array_operation(path, array);
                }

                return;
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
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
                            "\n\t5.Search" +
                            "\n\t6.Save file" +
                            "\n\t7.Sort" +
                            "\n\t8.Back" +
                            "\n\tChoice: ");

            try {
                int answer = sc.nextInt();
                sc.nextLine();

                if(answer == 1) {
                    System.out.println(Customer.header());
                    array.display();
                }
                else if(answer == 2)
                    add_customer(array);
                else if(answer == 3)
                    delete_customer(array);
                else if(answer == 4)
                    update_customer(array);
                else if(answer == 5)
                    search_customer(array);
                else if(answer == 6)
                    save_read_file(path, array);
                else if(answer == 7)
                    sort_customer(array);
                else if(answer == 8)
                    return;
                else
                    System.out.println("INVALID RANGE");
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
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
                                    "\n\tChoice: ");

                    int answer = sc.nextInt();
                    sc.nextLine();

                    if(answer == 2)
                        return;
                    else if(answer != 1) {
                        System.out.println("INVALID RANGE");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
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
                sc.nextLine();
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
                                        "\n\tChoice: ");
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
                        System.out.println("Customer not found\n\tTry again ?");

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
                sc.nextLine();
            }
        }
    }

    public static void search_customer(ArrayCustomerList array) {
        while(true) {
            try {
                System.out.println("Search algorithm" +
                            "\n\t1.Customer name" +
                            "\n\t2.Customer contract ID" +
                            "\n\t3.Back" +
                            "\n\tChoice: ");
                int answer = sc.nextInt();
                sc.nextLine();

                String customer_name = "";
                int customer_id = 0;

                if(answer == 1) {
                    System.out.print("Enter customer name: ");
                    customer_name = sc.nextLine();
                } else if (answer == 2) {
                    System.out.print("Enter customer contract ID: ");
                    customer_id = sc.nextInt();
                    sc.nextLine();
                } else if (answer == 3)
                    return;
                else {
                    System.out.println("INVALID RANGE");
                    sc.nextLine();
                    search_customer(array);
                }

                System.out.println("Search algorithm" +
                            "\n\t1.Linear search" +
                            "\n\t2.Binary search (Must be sorted)" +
                            "\n\t3.Back" +
                            "\n\tChoice: ");

                int search = sc.nextInt();
                sc.nextLine();

                if(search == 1) {
                    if(answer == 1) {
                        Customer result = array.linear_search(customer_name);
                        if(result != null)
                            System.out.println(result.toString());
                        else
                            System.out.println("Customer not found");
                    } else if (answer == 2) {
                        Customer result = array.linear_search(customer_id);
                        if(result != null)
                            System.out.println(result.toString());
                        else
                            System.out.println("Customer not found");
                    }
                } else if (search == 2) {
                    if(answer == 1) {
                        Customer result = array.binary_search(customer_name);
                        if(result != null)
                            System.out.println(result.toString());
                        else
                            System.out.println("Customer not found");
                    } else if (answer == 2) {
                        Customer result = array.binary_search(customer_id);
                        if(result != null)
                            System.out.println(result.toString());
                        else
                            System.out.println("Customer not found");
                    }
                } else if (search == 3) {
                    return;
                } else {
                    System.out.println("INVALID RANGE");
                    sc.nextLine();
                    search_customer(array);
                }

            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
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
                    System.out.print("Enter new path: ");
                    path = sc.nextLine();
                }

                if(write(path, array))
                    System.out.println("File has been saved");
                else
                    System.out.println("File has not been saved");

                return;
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void sort_customer(ArrayCustomerList array) {
        while(true) {
            try {
                System.out.print("Sort algorithm" +
                                "\n\t1.Bubble sort (Name)" +
                                "\n\t2.Bubble sort (Contract ID)" +
                                "\n\t3.Insertion sort (Name)" +
                                "\n\t4.Selection sort (Name)" +
                                "\n\t5.Selection sort (Contract ID)" +
                                "\n\t6.Merge sort (Name)" +
                                "\n\t7.Heap sort (Name)" +
                                "\n\t8.Back"+
                                "\n\tChoice: ");
                int answer = sc.nextInt();
                sc.nextLine();

                if(answer == 1)
                    array.bubble_sort();
                else if(answer == 2)
                    array.bubble_sort_for_id();
                else if(answer == 3)
                    array.insertion_sort();
                else if(answer == 4)
                    array.selection_sort();
                else if(answer == 5)
                    array.selection_sort_for_id();
                else if(answer == 6)
                    array.merge_sort(0, array.capacity() - 1);
                else if(answer == 7)
                    array.heap_sort();
                else if(answer == 8)
                    return;
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void write_file_array_list() {
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
                            "\n\tChoice: ");

                    int answer = sc.nextInt();
                    sc.nextLine();

                    if(answer == 2) {
                        System.out.print("Enter path: ");
                        String path = sc.nextLine();

                        if(write(path, array)) {
                            System.out.println("File has been written");
                            return;
                        } else {
                            System.out.println("File has not been written");
                        }
                    } else if(answer != 1) {
                        System.out.println("INVALID RANGE");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }

    /////////////////////////////
    // Linked List Implementation
    public static void linked_list() {
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
                    read_file_linked_list();
                else if(answer == 2)
                    write_file_linked_list();
                else if(answer == 3)
                    return;
                else
                    System.out.println("INVALID RANGE");
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void read_file_linked_list() {
        while(true) {
            try {
                System.out.print("Enter path: ");
                String path = sc.nextLine();

                CustomerLinkedList array = new CustomerLinkedList();

                if(read(path, array)) {
                    linked_list_operation(path, array);
                }

                return;
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void linked_list_operation(String path, CustomerLinkedList array) {
        while(true) {
            System.out.print("Choose operation on Array List:" +
                    "\n\t1.Show" +
                    "\n\t2.Add customer" +
                    "\n\t3.Delete customer" +
                    "\n\t4.Update customer details" +
                    "\n\t5.Search" +
                    "\n\t6.Save file" +
                    "\n\t7.Sort" +
                    "\n\t8.Back" +
                    "\n\tChoice: ");

            try {
                int answer = sc.nextInt();
                sc.nextLine();

                if(answer == 1) {
                    System.out.println(Customer.header());
                    array.display();
                }
                else if(answer == 2)
                    add_customer(array);
                else if(answer == 3)
                    delete_customer(array);
                else if(answer == 4)
                    update_customer(array);
                else if(answer == 5)
                    search_customer(array);
                else if(answer == 6)
                    save_read_file(path, array);
                else if(answer == 7)
                    sort_customer(array);
                else if(answer == 8)
                    return;
                else
                    System.out.println("INVALID RANGE");
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void add_customer(CustomerLinkedList array) {
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
                            "\n\tChoice: ");

                    int answer = sc.nextInt();
                    sc.nextLine();

                    if(answer == 2)
                        return;
                    else if(answer != 1) {
                        System.out.println("INVALID RANGE");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void delete_customer(CustomerLinkedList array) {
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
                sc.nextLine();
            }
        }
    }

    public static void update_customer(CustomerLinkedList array) {
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
                                    "\n\tChoice: ");
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
                        System.out.println("Customer not found\n\tTry again ?");

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
                sc.nextLine();
            }
        }
    }

    public static void search_customer(CustomerLinkedList array) {
        while(true) {
            try {
                System.out.println("Search algorithm" +
                        "\n\t1.Customer name" +
                        "\n\t2.Customer contract ID" +
                        "\n\t3.Back"+
                        "\n\tChoice: ");
                int answer = sc.nextInt();
                sc.nextLine();

                String customer_name = "";
                int customer_id = 0;

                if(answer == 1) {
                    System.out.print("Enter customer name: ");
                    customer_name = sc.nextLine();
                } else if (answer == 2) {
                    System.out.print("Enter customer contract ID: ");
                    customer_id = sc.nextInt();
                    sc.nextLine();
                } else if (answer == 3)
                    return;
                else {
                    System.out.println("INVALID RANGE");
                    sc.nextLine();
                    search_customer(array);
                }

                System.out.println("Search algorithm" +
                        "\n\t1.Linear search" +
                        "\n\t2.Binary search (Must be sorted)" +
                        "\n\t3.Back" +
                        "\n\tChoice: ");

                int search = sc.nextInt();
                sc.nextLine();

                if(search == 1) {
                    if(answer == 1) {
                        Customer result = array.linear_search(customer_name);
                        if(result != null)
                            System.out.println(result.toString());
                        else
                            System.out.println("Customer not found");
                    } else if (answer == 2) {
                        Customer result = array.linear_search(customer_id);
                        if(result != null)
                            System.out.println(result.toString());
                        else
                            System.out.println("Customer not found");
                    }
                } else if (search == 2) {
                    if(answer == 1) {
                        Customer result = array.binary_search(customer_name);
                        if(result != null)
                            System.out.println(result.toString());
                        else
                            System.out.println("Customer not found");
                    } else if (answer == 2) {
                        Customer result = array.binary_search(customer_id);
                        if(result != null)
                            System.out.println(result.toString());
                        else
                            System.out.println("Customer not found");
                    }
                } else if (search == 3) {
                    return;
                } else {
                    System.out.println("INVALID RANGE");
                    sc.nextLine();
                    search_customer(array);
                }

            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void save_read_file(String path, CustomerLinkedList array) {
        while(true) {
            try {
                System.out.print("Save at the same path ?" +
                        "\n\t1.YES\n\t2.NO\n\tChoice: ");
                int answer = sc.nextInt();
                sc.nextLine();

                if (answer == 2) {
                    System.out.print("Enter new path: ");
                    path = sc.nextLine();
                }

                if(write(path, array))
                    System.out.println("File has been saved");
                else
                    System.out.println("File has not been saved");

                return;
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void sort_customer(CustomerLinkedList array) {
        while(true) {
            try {
                System.out.print("Sort algorithm" +
                        "\n\t1.Bubble sort (Name)" +
                        "\n\t2.Bubble sort (Contract ID)" +
                        "\n\t3.Insertion sort (Name)" +
                        "\n\t4.Selection sort (Name)" +
                        "\n\t5.Selection sort (Contract ID)" +
                        "\n\t6.Merge sort (Name)" +
                        "\n\t7.Heap sort (Name)" +
                        "\n\t8.Back"+
                        "\n\tChoice: ");
                int answer = sc.nextInt();
                sc.nextLine();

                if(answer == 1)
                    array.bubble_sort();
                else if(answer == 2)
                    array.bubble_sort_for_id();
                else if(answer == 3)
                    array.insertion_sort();
                else if(answer == 4)
                    array.selection_sort();
                else if(answer == 5)
                    array.selection_sort_for_id();
                else if(answer == 6)
                    array.merge_sort();
                else if(answer == 7)
                    array.heap_sort();
                else if(answer == 8)
                    return;
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
                sc.nextLine();
            }
        }
    }

    public static void write_file_linked_list() {
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
                            "\n\tChoice: ");

                    int answer = sc.nextInt();
                    sc.nextLine();

                    if(answer == 2) {
                        System.out.print("Enter path: ");
                        String path = sc.nextLine();

                        if(write(path, array)) {
                            System.out.println("File has been written");
                            return;
                        } else {
                            System.out.println("File has not been written");
                        }
                    } else if(answer != 1) {
                        System.out.println("INVALID RANGE");
                        return;
                    }
                }
            } catch (Exception e) {
                System.out.println("INVALID INPUT");
            }
        }
    }
}