package materi02compositionvsinheritance.composition;

import java.math.BigDecimal;

public class DiskonProduk implements Diskon {

  private static final double DEFAULT_DISKON = 0.1;

  @Override
  public String getNama() {
    return "Diskon Produk";
  }

  @Override
  public BigDecimal hitungDiskon(Transaksi t) {
    return t.getDaftarPembelian().stream()
        .filter(product -> "P001".equalsIgnoreCase(product.getCode()))
        .map(product -> product.getPrice().multiply(BigDecimal.valueOf(DEFAULT_DISKON)))
        .reduce(BigDecimal::add)
        .orElse(BigDecimal.ZERO);
  }
}
