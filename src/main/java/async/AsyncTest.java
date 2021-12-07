package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<Option<Ceo>> getCeoById(String ceo_id) {

    for (Ceo ceo: ceos)
    {
      if(ceo_id.equals(ceo.id))
      {
          return CompletableFuture.completedFuture(Option.some(ceo));
      }
    }
    return CompletableFuture.completedFuture(Option.none());
  }

  public static CompletableFuture<Option<Enterprise>> getEnterpriseByCeoId(String ceo_id) {

    for (Enterprise enterprise : enterprises)
    {
      if(enterprise.ceo_id.equals(ceo_id))
      {
        return CompletableFuture.completedFuture(Option.some(enterprise));
      }
    }
    return CompletableFuture.completedFuture(Option.none());
  }

  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id) throws ExecutionException, InterruptedException
  {
    Tuple2<Option<Ceo>, Option<Enterprise>> ceoAndEnterpriseByCeoId  = Tuple.of(getCeoById(ceo_id).get(), getEnterpriseByCeoId(ceo_id).get());

    return CompletableFuture.completedFuture(ceoAndEnterpriseByCeoId);

  }
}
