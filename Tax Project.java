import java.util.Scanner;
//Devon Willis
//CS1400, Section 3
//Project 2 - Income Tax Program
//02-21-2021

class Main {
  
  public static void main(String[] args) 
  {
    final double SINGLE_BASE_TAX_GROUP1 = 0, SINGLE_BASE_TAX_GROUP2 = 800, SINGLE_BASE_TAX_GROUP3 = 4400;
    final double SINGLE_TAX_RATE_GROUP1 = .1, SINGLE_TAX_RATE_GROUP2 = .15,SINGLE_TAX_RATE_GROUP3 = .25;
    
    final double MARRIED_BASE_TAX_GROUP1 = 0, MARRIED_BASE_TAX_GROUP2 = 1600, MARRIED_BASE_TAX_GROUP3 = 8800;
    final double MARRIED_TAX_RATE_GROUP1 = .1, MARRIED_TAX_RATE_GROUP2 = .15, MARRIED_TAX_RATE_GROUP3 = .25;

    Scanner scan = new Scanner(System.in);
    System.out.print("Input marital status:");
    System.out.printf("%3s","");
    String maritalStatus = scan.next().toLowerCase();
    double taxableIncome,tax=0;
    switch(maritalStatus)
    {
      
      case "single":
        System.out.print("Input taxable income:");
        System.out.printf("%3s","");
        taxableIncome = scan.nextDouble();        
        if(taxableIncome < 0)
        {
          System.out.println("-- illegal income --");
          System.exit(0);
        }
        else if(taxableIncome < 8000 && taxableIncome >= 0)
        {
          tax = (taxableIncome) * SINGLE_TAX_RATE_GROUP1 + SINGLE_BASE_TAX_GROUP1; 
        }
        else if(taxableIncome < 32000 && taxableIncome >= 8000)
        {
          tax = (taxableIncome - 8000) * SINGLE_TAX_RATE_GROUP2 + SINGLE_BASE_TAX_GROUP2;
        }
        else
        {
          tax = (taxableIncome - 32000) * SINGLE_TAX_RATE_GROUP3 + SINGLE_BASE_TAX_GROUP3;
        }
        break;

      case "married":
        System.out.print("Input taxable income:");
        System.out.printf("%3s","");
        taxableIncome = scan.nextDouble(); 
        if(taxableIncome < 0)
        {
          System.out.println("-- illegal income --");
          System.exit(0);
        }
        else if(taxableIncome < 16000 && taxableIncome >= 0)
        {
          tax = (taxableIncome) * MARRIED_TAX_RATE_GROUP1 + MARRIED_BASE_TAX_GROUP1; 
        }
        else if(taxableIncome < 64000 && taxableIncome >= 16000)
        {
          tax = (taxableIncome - 16000) * MARRIED_TAX_RATE_GROUP2 + MARRIED_BASE_TAX_GROUP2;
        }
        else
        {
          tax = (taxableIncome - 64000) * MARRIED_TAX_RATE_GROUP3 + MARRIED_BASE_TAX_GROUP3;
        }
        break;

      default:
        System.out.println("-- illegal marital status --");
        System.exit(0);
        break;
    }
    System.out.printf("Your income tax is $%,.2f",tax);
  
  }
}
