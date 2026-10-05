package O_Exercise9;

import java.util.Date;

public class StorageService extends CloudService {

    private int storageGB;
    private boolean encryptionEnabled;

    public StorageService() {
    }

    public StorageService(int storageGB, boolean encryptionEnabled, String id, double baseMonthlyFee, Date startDate, boolean isActive, int monthsUsed) {
        super(id, baseMonthlyFee, startDate, isActive, monthsUsed);
        this.storageGB = storageGB;
        this.encryptionEnabled = encryptionEnabled;
    }

    public int getStorageGB() {
        return storageGB;
    }

    public boolean isEncryptionEnabled() {
        return encryptionEnabled;
    }

    public void setStorageGB(int storageGB) {
        this.storageGB = storageGB;
    }

    public void setEncryptionEnabled(boolean encryptionEnabled) {
        this.encryptionEnabled = encryptionEnabled;
    }

    @Override
    public void addService() {
        super.addService();
        System.out.print("Enter storageGB: ");
        setStorageGB(sc.nextInt());
        sc.nextLine();
        System.out.print("Enter EncryptionEnabled: ");
        setEncryptionEnabled(sc.nextBoolean());
        sc.nextLine();
    }

    @Override
    public void updateService() {
        super.updateService();
        System.out.print("Update storageGB: ");
        setStorageGB(sc.nextInt());
        sc.nextLine();
        System.out.print("Update EncryptionEnabled: ");
        setEncryptionEnabled(sc.nextBoolean());
        sc.nextLine();
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Storage GB: " + getStorageGB());
        System.out.println("EncryptionEnabled: " + isEncryptionEnabled());
        System.out.println("MonthlyCost: " + calculateMonthlyCost());
    }

    @Override
    public double calculateMonthlyCost() {
        double baseCost = getBaseMonthlyFee() * getMonthsUsed();
        if (isEncryptionEnabled() == true) {
            baseCost *= 1.05;
        }
        if (getStorageGB() >= 1000) {
            baseCost *= 1.2;
        } else if (getStorageGB() >= 500) {
            baseCost *= 1.1;
        } else {
            baseCost *= 1.05;
        }
        return baseCost;
    }
}
