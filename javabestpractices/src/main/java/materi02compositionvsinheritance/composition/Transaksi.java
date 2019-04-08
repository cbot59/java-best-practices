package materi02compositionvsinheritance.composition;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Transaksi {
  private String referensi;
  private LocalDateTime waktuTransaksi;
  private BigDecimal nilai;

  private final List<Diskon> daftarDiskon = new ArrayList<>();

  public BigDecimal hitungTotalPembayaran() {

    BigDecimal totalDiskon = BigDecimal.ZERO;
    for (Diskon diskon : daftarDiskon) {
      totalDiskon = totalDiskon.add(diskon.hitungDiskon(this));
    }

    return nilai.subtract(totalDiskon);
  }
}
