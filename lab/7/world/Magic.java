package world;

public class Magic
{
  protected String affinity;
  public MagicDetails info;

  public Magic (String affinity, String spell)
  {
    this.affinity = affinity;
    this.info = new MagicDetails (spell);
  }

  @Override
  public String
  toString ()
  {
    // return "Magic affinity is " + this.affinity;
    return "Spell: " + this.info + "\nAffinity: " + this.affinity;
  }

  public class MagicDetails
  {
    private String details;

    public MagicDetails (String details) { this.details = details; }

    @Override
    public String
    toString ()
    {
      return this.details;
    }
  }
}
