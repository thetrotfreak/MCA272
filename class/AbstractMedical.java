abstract class Patient{
  abstract void patientInfo1 ();
}

class PatientDetails extends Patient{
  String
  patientInfo1 ()
  {
    String pName = "John Doe";
    int age = 43;
    String pLocation = "Idaho";
    return pName + " aged " + age + " from " + pLocation;
  }
}

public class AbstractMedical
{
  public static void
  main (String[] args)
  {
      Patient p = new PatientDetails();
      System.out.println (p.patientInfo1 ());
  }
}

