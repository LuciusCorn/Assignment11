package O_Exercise9;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class CloudService implements ICloudService {

    private String id;
    private double baseMonthlyFee;
    private Date startDate;
    private boolean isActive;
    private int monthsUsed;

    protected Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public CloudService() {
    }

    public CloudService(String id, double baseMonthlyFee, Date startDate, boolean isActive, int monthsUsed) {
        this.id = id;
        this.baseMonthlyFee = baseMonthlyFee;
        this.startDate = startDate;
        this.isActive = isActive;
        this.monthsUsed = monthsUsed;
    }

    public String getId() {
        return id;
    }

    public double getBaseMonthlyFee() {
        return baseMonthlyFee;
    }

    public Date getStartDate() {
        return startDate;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public int getMonthsUsed() {
        return monthsUsed;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBaseMonthlyFee(double baseMonthlyFee) {
        this.baseMonthlyFee = baseMonthlyFee;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setMonthsUsed(int monthsUsed) {
        this.monthsUsed = monthsUsed;
    }

    @Override
    public void addService() {
        System.out.print("Enter id:");
        setId(sc.nextLine());
        System.out.print("Enter base monthly fee: ");
        setBaseMonthlyFee(sc.nextDouble());
        sc.nextLine();
        System.out.print("Enter start date: ");
        String dateString = sc.nextLine();
        try {
            setStartDate(sdf.parse(dateString));
        } catch (ParseException ex) {
            System.out.println("Invalid date!");
        }
        System.out.print("Enter is active: ");
        setIsActive(sc.nextBoolean());
        sc.nextLine();
        System.out.print("Enter monthsUsed: ");
        setMonthsUsed(sc.nextInt());
    }

    @Override
    public void updateService() {
        System.out.print("Update base monthly fee: ");
        setBaseMonthlyFee(sc.nextDouble());
        sc.nextLine();
        System.out.print("Update start date: ");
        String dateString = sc.nextLine();
        try {
            setStartDate(sdf.parse(dateString));
        } catch (ParseException ex) {
            System.out.println("Invalid date!");
        }
        System.out.print("Update is active: ");
        setIsActive(sc.nextBoolean());
        sc.nextLine();
        System.out.print("Update monthsUsed: ");
        setMonthsUsed(sc.nextInt());
    }

    @Override
    public void displayDetails() {
        System.out.println("Id: " + getId());
        System.out.println("Base monthly fee: " + getBaseMonthlyFee());
        System.out.println("Startdate: " + sdf.format(startDate));
        System.out.println("Is active: " + isIsActive());
        System.out.println("MonthsUsed: " + getMonthsUsed());
    }
}
