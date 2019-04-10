package materi02compositionvsinheritance.composition;

import materi01equalshashcode.Product;

import java.math.BigDecimal;
import java.util.function.Function;

public class DemoComposition {
  public static void main(String... args) {

    Function<Transaksi, BigDecimal> hitungTotalPembayaran =
        transaksi -> {
          Product product = new Product();
          product.setCode("P001");
          product.setPrice(BigDecimal.TEN);

          transaksi.getDaftarPembelian().add(product);
          transaksi.getDaftarDiskon().add(new DiskonProduk());
          transaksi.getDaftarDiskon().add(new DiskonTotal());

          return transaksi.hitungTotalPembayaran2();
        };

    System.out.println(hitungTotalPembayaran.apply(new Transaksi()));
  }
}
