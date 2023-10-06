package br.com.surb.sale.shared.Appconfig;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class AppExecutorsConfiguration {
  public Executor contollersExecutor(
    int corePoolSize, int maxPoolSize, int queueCapacity, int keepAliveSeconds){
    return new ThreadPoolExecutor(
      corePoolSize,
      maxPoolSize,
      keepAliveSeconds,
      TimeUnit.SECONDS,
      new ArrayBlockingQueue<>(queueCapacity, true));
  }
}
