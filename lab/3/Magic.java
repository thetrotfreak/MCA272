public class Magic
{
  protected String affinity;

  Magic (String affinity) { this.affinity = affinity; }

  @Override
  public String
  toString ()
  {
    return "Magic affinity is " + this.affinity;
  }

  public class MagicDetails
  {
    private String details;

    MagicDetails (String details) { this.details = details; }

    @Override
    public String
    toString ()
    {
      return this.details;
    }
  }
}
