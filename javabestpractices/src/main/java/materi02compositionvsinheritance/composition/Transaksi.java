package materi02compositionvsinheritance.composition;

import materi01equalshashcode.Product;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Transaksi {
  private String referensi = UUID.randomUUID().toString();
  private LocalDateTime waktuTransaksi = LocalDateTime.now();
  private BigDecimal nilai;

  private final List<Diskon> daftarDiskon = new ArrayList<>();

  private List<Product> daftarPembelian = new ArrayList<>();

  public List<Product> getDaftarPembelian() {
    return daftarPembelian;
  }

  public List<Diskon> getDaftarDiskon() {
    return daftarDiskon;
  }

  public BigDecimal hitungTotalNilai() {
    BigDecimal totalNilai = BigDecimal.ZERO;
    for (Product p : daftarPembelian) {
      totalNilai = totalNilai.add(p.getPrice());
    }
    return totalNilai;
  }

  public BigDecimal hitungTotalPembayaran() {

    BigDecimal totalDiskon = BigDecimal.ZERO;
    for (Diskon diskon : daftarDiskon) {
      totalDiskon = totalDiskon.add(diskon.hitungDiskon(this));
    }

    return hitungTotalNilai().subtract(totalDiskon);
  }

  public BigDecimal hitungTotalNilai2() {
    return daftarPembelian.stream()
        .map(Product::getPrice)
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
  }

  public BigDecimal hitungTotalPembayaran2() {
    return daftarDiskon.stream()
        .map(diskon -> diskon.hitungDiskon(this))
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
  }
}
