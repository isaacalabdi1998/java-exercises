/*
    ---------- Rental Contract 🏠 ----------
      - A simple Java example of an immutable rental contract.
      - The contract can't be changed after it's created. Instead, methods like `withMonthlyRent()` return a new contract with the updated value.
      - Just a small exercise to practice immutability in a real-world example.
*/


import java.time.LocalDate;
public class RentalContract
{
    // 1 - Create private final fields
    private final String tenantName;
    private final String propertyAddress;
    private final LocalDate startDate;
    private final int durationMonths;
    private final double monthlyRent;


  
    // 2 - Constructor
    public RentalContract(String tenantName, String propertyAddress, LocalDate startDate,
                          int durationMonths, double monthlyRent) {
        this.tenantName = tenantName;
        this.propertyAddress = propertyAddress;
        this.startDate = startDate;
        this.durationMonths = durationMonths;
        this.monthlyRent = monthlyRent;
    }


  
    // 3 - Getters
    public String getTenantName() {
        return tenantName;
    }
    public String getPropertyAddress() {
        return propertyAddress;
    }
    public LocalDate getStartDate() {
        return startDate;
    }
    public int getDurationMonths() {
        return durationMonths;
    }
    public double getMonthlyRent() {
        return monthlyRent;
    }


  
    // 4 - Return a new contract with the same details but with a new rent.
    public RentalContract withMonthlyRent(double newMonthlyRent)
    {
        return new RentalContract(tenantName, propertyAddress, startDate, durationMonths, newMonthlyRent);
    }

    // 5 - Return a new contract with the same details but with a new rent duration.
    public RentalContract withDuration(int newDuration)
    {
        return new RentalContract(tenantName, propertyAddress, startDate, newDuration, monthlyRent);
    }

    // 6 - Calculate monthlyRent * durationMonths
    public double getTotalRent()
    {
        return monthlyRent * durationMonths;
    }


  
    // 7 - toString formatted
    @Override
    public String toString()
    {
        return """ 
                ===== Rental Contract =====
                Tenant          : %s
                Property        : %s
                Start Date      : %s
                Duration        : %d months
                Monthly Rent    : %.2f
                Total Rent      : %.2f
                ===========================
                """.formatted(
                tenantName,
                propertyAddress,
                startDate,
                durationMonths,
                monthlyRent,
                getTotalRent()
                );
    }







    ///  -------------- Main Method --------------
    public static void main(String[] args)
    {

        RentalContract contract = new RentalContract(
                "Isaac",
                "Helsinki Street 10",
                LocalDate.of(2026, 9, 1),
                12,
                1000
        );
        System.out.println(contract);

        /* */
        RentalContract newContract = contract.withMonthlyRent(606);

        System.out.println("Original: \n" + contract);
        System.out.println("New:      \n" + newContract);
        System.out.println("New total rent: " + newContract.getTotalRent());

    }
}

/*
  --------------- Output ---------------

      ===== Rental Contract =====
      Tenant          : Isaac
      Property        : Helsinki Street 10
      Start Date      : 2026-09-01
      Duration        : 12 months
      Monthly Rent    : 1000.00
      Total Rent      : 12000.00
      ===========================
      
      Original: 
      ===== Rental Contract =====
      Tenant          : Isaac
      Property        : Helsinki Street 10
      Start Date      : 2026-09-01
      Duration        : 12 months
      Monthly Rent    : 1000.00
      Total Rent      : 12000.00
      ===========================
      
      New:      
      ===== Rental Contract =====
      Tenant          : Isaac
      Property        : Helsinki Street 10
      Start Date      : 2026-09-01
      Duration        : 12 months
      Monthly Rent    : 606.00
      Total Rent      : 7272.00
      ===========================
      
      New total rent: 7272.0

*/
