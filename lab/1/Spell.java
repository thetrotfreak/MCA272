public class Spell extends Magic
{
  protected String name;
  protected int level;

  Spell ()
  {
    super ();
    this.name = "Basic " + this.affinity + " magic spell";
    this.level = 1;
  }
}
