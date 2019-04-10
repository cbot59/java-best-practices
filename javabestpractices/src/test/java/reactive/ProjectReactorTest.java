package reactive;

import org.junit.Test;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ProjectReactorTest {

  @Test
  public void reactorTest() {
    Publisher<String> stringFlux = Flux.just("1", "2", "3");
    Publisher<String> stringMono = Mono.just("foo");

    List<Integer> elements = new ArrayList<>();
    Flux.just(1, 2, 3, 4)
        .log()
        .map(integer -> integer * 3)
        .zipWith(
            Flux.range(0, Integer.MAX_VALUE),
            Integer::sum
        )
        .subscribe(elements::add);

    assertEquals(4, elements.size());
  }
}
