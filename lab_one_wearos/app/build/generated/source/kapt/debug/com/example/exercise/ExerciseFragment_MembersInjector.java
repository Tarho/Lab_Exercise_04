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
public final class ExerciseFragment_MembersInjector implements MembersInjector<ExerciseFragment> {
  private final Provider<HealthServicesManager> healthServicesManagerProvider;

  public ExerciseFragment_MembersInjector(
      Provider<HealthServicesManager> healthServicesManagerProvider) {
    this.healthServicesManagerProvider = healthServicesManagerProvider;
  }

  public static MembersInjector<ExerciseFragment> create(
      Provider<HealthServicesManager> healthServicesManagerProvider) {
    return new ExerciseFragment_MembersInjector(healthServicesManagerProvider);
  }

  @Override
  public void injectMembers(ExerciseFragment instance) {
    injectHealthServicesManager(instance, healthServicesManagerProvider.get());
  }

  @InjectedFieldSignature("com.example.exercise.ExerciseFragment.healthServicesManager")
  public static void injectHealthServicesManager(ExerciseFragment instance,
      HealthServicesManager healthServicesManager) {
    instance.healthServicesManager = healthServicesManager;
  }
}
