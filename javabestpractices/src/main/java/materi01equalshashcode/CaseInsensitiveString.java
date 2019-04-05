package materi01equalshashcode;

public class CaseInsensitiveString {
  private final String x;

  public CaseInsensitiveString(String x) {
    this.x = x;
  }

  public boolean equals(Object o) {
    if (o instanceof CaseInsensitiveString) {
      return x.equalsIgnoreCase(((CaseInsensitiveString) o).x);
    }

    return o instanceof String && x.equalsIgnoreCase((String) o);
  }
}
