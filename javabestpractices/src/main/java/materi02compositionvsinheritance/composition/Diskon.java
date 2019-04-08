package materi02compositionvsinheritance.composition;

import java.math.BigDecimal;

public interface Diskon {
  String getNama();

  BigDecimal hitungDiskon(Transaksi t);
}
