package O_Exercise9;

import java.util.ArrayList;

public class CloudServiceArrayList {

    ArrayList<CloudService> services = new ArrayList<>();

    public void addServiceToArrayList(CloudService service) {
        services.add(service);
    }

    public void updateServiceById(String id) {
        for (CloudService service : services) {
            if (service.getId().equals(id)) {
                service.updateService();
                return;
            }
        }
        System.out.println("Not found id!");
    }

    public void deleteServiceById(String id) {
        for (CloudService service : services) {
            if (service.getId().equals(id)) {
                services.remove(service);
                return;
            }
        }
        System.out.println("Not found id!");
    }

    public void displayAllServices() {
        for (CloudService service : services) {
            service.displayDetails();
        }
    }

    public void displayActiveService() {
        for (CloudService service : services) {
            if (service.isIsActive() == true) {
                service.displayDetails();
            }
        }
    }

    public double findHighestMonthlyCost() {
        double max = 0;
        for (CloudService service : services) {
            if (service.calculateMonthlyCost() > max) {
                max = service.calculateMonthlyCost();
            }
        }
        return max;
    }
}
