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
public final class ExerciseService_MembersInjector implements MembersInjector<ExerciseService> {
  private final Provider<HealthServicesManager> healthServicesManagerProvider;

  public ExerciseService_MembersInjector(
      Provider<HealthServicesManager> healthServicesManagerProvider) {
    this.healthServicesManagerProvider = healthServicesManagerProvider;
  }

  public static MembersInjector<ExerciseService> create(
      Provider<HealthServicesManager> healthServicesManagerProvider) {
    return new ExerciseService_MembersInjector(healthServicesManagerProvider);
  }

  @Override
  public void injectMembers(ExerciseService instance) {
    injectHealthServicesManager(instance, healthServicesManagerProvider.get());
  }

  @InjectedFieldSignature("com.example.exercise.ExerciseService.healthServicesManager")
  public static void injectHealthServicesManager(ExerciseService instance,
      HealthServicesManager healthServicesManager) {
    instance.healthServicesManager = healthServicesManager;
  }
}
