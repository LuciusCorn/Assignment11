package O_Exercise9;

import java.util.Date;

public class ComputeService extends CloudService {

    private int cpuCores;
    private double runtimeHours;

    public ComputeService() {
    }

    public ComputeService(int cpuCores, double runtimeHours, String id, double baseMonthlyFee, Date startDate, boolean isActive, int monthsUsed) {
        super(id, baseMonthlyFee, startDate, isActive, monthsUsed);
        this.cpuCores = cpuCores;
        this.runtimeHours = runtimeHours;
    }

    public int getCpuCores() {
        return cpuCores;
    }

    public double getRuntimeHours() {
        return runtimeHours;
    }

    public void setCpuCores(int cpuCores) {
        this.cpuCores = cpuCores;
    }

    public void setRuntimeHours(double runtimeHours) {
        this.runtimeHours = runtimeHours;
    }

    @Override
    public void addService() {
        super.addService();
        System.out.print("Enter cpucores: ");
        setCpuCores(sc.nextInt());
        System.out.print("Enter runtimeHours: ");
        setRuntimeHours(sc.nextDouble());
    }

    @Override
    public void updateService() {
        super.updateService();
        System.out.print("Update cpucores: ");
        setCpuCores(sc.nextInt());
        System.out.print("Update runtimeHours: ");
        setRuntimeHours(sc.nextDouble());
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("CpuCores: " + getCpuCores());
        System.out.println("RuntimeHours: " + getRuntimeHours());
        System.out.println("MonthlyCost: " + calculateMonthlyCost());
    }

    @Override
    public double calculateMonthlyCost() {
        double baseCost = getBaseMonthlyFee() * getMonthsUsed();
        if (getRuntimeHours() > 200) {
            baseCost *= (getRuntimeHours() - 200) * 0.5;
        }
        if (getCpuCores() >= 16) {
            baseCost *= 1.25;
        } else if (getCpuCores() >= 8) {
            baseCost *= 1.15;
        } else {
            baseCost *= 1.05;
        }
        return baseCost;
    }
}
