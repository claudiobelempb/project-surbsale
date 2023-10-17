package br.com.surb.sale.shared.Appconfig;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
public class AppExecutorsConfiguration {
  @Bean
  public Executor contollersExecutor(
    @Value("${surbsale.taskExecutor.pool.corePoolSize:10}")
    int corePoolSize,
    @Value("${surbsale.taskExecutor.pool.maxPoolSize:20}")
    int maxPoolSize,
    @Value("${surbsale.taskExecutor.pool.queueCapacity:50}")
    int queueCapacity,
    @Value("${surbsale.taskExecutor.pool.keepAliveSeconds:60}")
    int keepAliveSeconds
  ){
    return new ThreadPoolExecutor(
      corePoolSize,
      maxPoolSize,
      keepAliveSeconds,
      TimeUnit.SECONDS,
      new ArrayBlockingQueue<>(queueCapacity, true));
  }
}
