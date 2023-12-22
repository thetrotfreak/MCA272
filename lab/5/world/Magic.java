package world;

public class Magic
{
  protected String affinity;

  public Magic (String affinity) { this.affinity = affinity; }

  @Override
  public String
  toString ()
  {
    return "Magic affinity is " + this.affinity;
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
