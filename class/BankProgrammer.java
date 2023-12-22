class Employee
{
  float salary = 40000;
}

class BankProgrammer extends Employee
{
  int increment = 10000;
  float updatedSalary = salary + increment;

  public static void
  main (String[] args)
  {
    BankProgrammer p = new BankProgrammer ();
    System.out.println ("Programmer salary is: " + p.salary);
    System.out.println ("Programmer increment is: " + p.increment);
    System.out.println ("Programmer new salary is: " + p.updatedSalary);
  }
}
