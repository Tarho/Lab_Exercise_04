package com.example.exercise;

import androidx.health.services.client.HealthServicesClient;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class HealthServicesManager_Factory implements Factory<HealthServicesManager> {
  private final Provider<HealthServicesClient> healthServicesClientProvider;

  private final Provider<CoroutineScope> coroutineScopeProvider;

  public HealthServicesManager_Factory(Provider<HealthServicesClient> healthServicesClientProvider,
      Provider<CoroutineScope> coroutineScopeProvider) {
    this.healthServicesClientProvider = healthServicesClientProvider;
    this.coroutineScopeProvider = coroutineScopeProvider;
  }

  @Override
  public HealthServicesManager get() {
    return newInstance(healthServicesClientProvider.get(), coroutineScopeProvider.get());
  }

  public static HealthServicesManager_Factory create(
      Provider<HealthServicesClient> healthServicesClientProvider,
      Provider<CoroutineScope> coroutineScopeProvider) {
    return new HealthServicesManager_Factory(healthServicesClientProvider, coroutineScopeProvider);
  }

  public static HealthServicesManager newInstance(HealthServicesClient healthServicesClient,
      CoroutineScope coroutineScope) {
    return new HealthServicesManager(healthServicesClient, coroutineScope);
  }
}
