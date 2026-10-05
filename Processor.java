package O_Exercise9;

import java.util.Scanner;

public class Processor {

    public static void main(String[] args) {
        CloudServiceArrayList serviceArrayList = new CloudServiceArrayList();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n =================MENU============");
            System.out.println("1- add a Cloud service");
            System.out.println("2- update a cloud service by id");
            System.out.println("3- delete a cloud service by id");
            System.out.println("4- display all");
            System.out.println("5- display active cloud service");
            System.out.println("6- display highest monthly cost");
            System.out.println("0- exit");
            System.out.print("Choose: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch (choose) {
                case 1:
                    System.out.print("Enter 1-add storageService/ 2- add ComputeService");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    if (choice == 1) {
                        StorageService ss = new StorageService();
                        ss.addService();
                        serviceArrayList.addServiceToArrayList(ss);
                    } else if (choice == 2) {
                        ComputeService cs = new ComputeService();
                        cs.addService();
                        serviceArrayList.addServiceToArrayList(cs);
                    }
                    break;
                case 2:
                    System.out.print("Enter id to update: ");
                    String idUpd = sc.nextLine();
                    serviceArrayList.updateServiceById(idUpd);
                    break;
                case 3:
                    System.out.print("Enter id to delete: ");
                    String idDel = sc.nextLine();
                    serviceArrayList.deleteServiceById(idDel);
                    break;
                case 4:
                    System.out.println("Display all:");
                    serviceArrayList.displayAllServices();
                    break;
                case 5:
                    serviceArrayList.displayActiveService();
                    break;
                case 6:
                    System.out.println("The highest monthlyCost: " + serviceArrayList.findHighestMonthlyCost());
                    break;
                case 0:
                    System.out.println("Exiting");
                    return;
                default:
                    System.out.println("Wrong choose!!");
            }
        }
    }
}
