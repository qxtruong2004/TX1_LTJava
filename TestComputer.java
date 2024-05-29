package KtraTX1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class TestComputer {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int n = 5;
        ComputerManagerIMPL computerManagerIMPL = new ComputerManagerIMPL(); //khởi tạo danh sách máy tính gồm 5 phần tử
        List<Computer> computerList = new ArrayList<>(); //dùng để lưu trữ máy  tính khi dùng hàm search
        computerManagerIMPL.generateList(n); //sinh ngẫu nhiên ds máy tính
        computerManagerIMPL.printList(); //in thông tin ds máy tính
        int choice;
        do {
            System.out.println("\nMENU Edit");
            System.out.println("Enter your choice: ");
            System.out.println("1. ADD.");
            System.out.println("2. EDIT.");
            System.out.println("3. Delete");
            System.out.println("4. Search");
            System.out.println("5. Sort");
            System.out.println("Please enter your choice: ");
            choice = sn.nextInt();
            switch (choice) {
                case 1:
                    Computer c = new Computer();
                    if (computerManagerIMPL.addComputer(c)) {
                        System.out.println("ADDED");
                        System.out.println("List after adding computer");
                        System.out.println("-----------------");
                        computerManagerIMPL.printList();
                    }
                    break;
                case 2:
                    System.out.println("Enter id of computer which you want to edit: ");
                    int edit_id = sn.nextInt();
                    boolean flag = false;
                    for(Computer c1 : ComputerManagerIMPL.list){
                        if(c1.getProduct_id() == edit_id){
                        		
                                System.out.println("Edit successful.");
                                System.out.println("List after editing computer:");
                                System.out.println("-----------------");
                                computerManagerIMPL.printList();
                                flag = true;
                            }
                    }
                    if(!flag){
                        System.out.println("Not edited.");
                    }

                    break;
                case 3:
                    System.out.println("Enter ID of the computer you want to delete: ");
                    int deleteId = sn.nextInt();
                    // Sử dụng ComputerManagerIMPL.list trực tiếp
                    for (Computer c2 : ComputerManagerIMPL.list) { //duyệt trong list
                        if (c2.getProduct_id() == deleteId) {
                            computerManagerIMPL.delComputer(c2);  // Sử dụng đối tượng đã khởi tạo
                            System.out.println("List after deleting computer");
                            System.out.println("-----------------");
                            computerManagerIMPL.printList();
                            break;  // Thoát vòng lặp sau khi tìm thấy và xóa
                        }
                    }

                    break;
                case 4:
                    System.out.println("Searching for the computer. " );
                    System.out.println("1. Name");
                    System.out.println("2. Price");
                    System.out.println("3. Total");
                    System.out.println("4. Color");
                    System.out.println("5. Material");
                    System.out.println("6. Style");
                    System.out.println("Enter your option: ");
                    int option = sn.nextInt();
                    sn.nextLine();
                    System.out.println(new ComputerManagerIMPL().searchComputers(String.valueOf(option)));
                    break;
                case 5:
                    System.out.println("0. Sort descending");
                    System.out.println("1. Sort ascending");
                    int option1 = sn.nextInt();
                    if(option1 != 0 && option1 != 1){
                        System.out.println("Invalid sort option");
                    }
                    else {
                        List<Computer> sortedList = computerManagerIMPL.sortedComputer(option1);
                        System.out.println("Sorted successfully");
                        sortedList.forEach(computer -> System.out.println(computer));
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            System.out.println("Enter number 0 if you want to exit: ");
            choice = sn.nextInt();
        }
        while (choice != 0);

    }
}
