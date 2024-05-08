package com.example.exercise;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class StartupFragment_MembersInjector implements MembersInjector<StartupFragment> {
  private final Provider<HealthServicesManager> healthServicesManagerProvider;

  public StartupFragment_MembersInjector(
      Provider<HealthServicesManager> healthServicesManagerProvider) {
    this.healthServicesManagerProvider = healthServicesManagerProvider;
  }

  public static MembersInjector<StartupFragment> create(
      Provider<HealthServicesManager> healthServicesManagerProvider) {
    return new StartupFragment_MembersInjector(healthServicesManagerProvider);
  }

  @Override
  public void injectMembers(StartupFragment instance) {
    injectHealthServicesManager(instance, healthServicesManagerProvider.get());
  }

  @InjectedFieldSignature("com.example.exercise.StartupFragment.healthServicesManager")
  public static void injectHealthServicesManager(StartupFragment instance,
      HealthServicesManager healthServicesManager) {
    instance.healthServicesManager = healthServicesManager;
  }
}
