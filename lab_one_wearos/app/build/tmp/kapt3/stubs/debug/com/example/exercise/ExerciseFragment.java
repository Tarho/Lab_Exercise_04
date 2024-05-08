package com.example.exercise;

/**
 * Fragment showing the exercise controls and current exercise metrics.
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 E2\u00020\u0001:\u0002DEB\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\"\u001a\u00020#H\u0002J$\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010,\u001a\u00020#H\u0016J\u001a\u0010-\u001a\u00020#2\u0006\u0010.\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\b\u0010/\u001a\u00020#H\u0002J\b\u00100\u001a\u00020#H\u0002J\b\u00101\u001a\u00020#H\u0002J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u000204H\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00106\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\u0010\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020\u0010H\u0002J\b\u0010<\u001a\u00020#H\u0002J\u0010\u0010=\u001a\u00020#2\u0006\u0010;\u001a\u00020\u0010H\u0002J\u0010\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020@H\u0002J\u0010\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020CH\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\bR\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00060\u000bR\u00020\u0000X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006F"}, d2 = {"Lcom/example/exercise/ExerciseFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "Lcom/example/exercise/databinding/FragmentExerciseBinding;", "activeDurationCheckpoint", "Landroidx/health/services/client/data/ExerciseUpdate$ActiveDurationCheckpoint;", "ambientController", "Landroidx/wear/ambient/AmbientModeSupport$AmbientController;", "Landroidx/wear/ambient/AmbientModeSupport;", "ambientModeHandler", "Lcom/example/exercise/ExerciseFragment$AmbientModeHandler;", "binding", "getBinding", "()Lcom/example/exercise/databinding/FragmentExerciseBinding;", "cachedExerciseState", "Landroidx/health/services/client/data/ExerciseState;", "chronoTickJob", "Lkotlinx/coroutines/Job;", "healthServicesManager", "Lcom/example/exercise/HealthServicesManager;", "getHealthServicesManager", "()Lcom/example/exercise/HealthServicesManager;", "setHealthServicesManager", "(Lcom/example/exercise/HealthServicesManager;)V", "serviceConnection", "Lcom/example/exercise/ExerciseServiceConnection;", "uiBindingJob", "viewModel", "Lcom/example/exercise/MainViewModel;", "getViewModel", "()Lcom/example/exercise/MainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "bindViewsToService", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "pauseResumeExercise", "performOneTimeUiUpdate", "resetDisplayedFields", "setAmbientUiState", "isAmbient", "", "startChronometer", "startEndExercise", "stopChronometer", "tryStartExercise", "unbindViewsFromService", "updateButtons", "state", "updateChronometer", "updateExerciseStatus", "updateLaps", "laps", "", "updateMetrics", "latestMetrics", "Landroidx/health/services/client/data/DataPointContainer;", "AmbientModeHandler", "Companion", "app_debug"})
public final class ExerciseFragment extends androidx.fragment.app.Fragment {
    @javax.inject.Inject()
    public com.example.exercise.HealthServicesManager healthServicesManager;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private com.example.exercise.databinding.FragmentExerciseBinding _binding;
    @org.jetbrains.annotations.NotNull()
    private com.example.exercise.ExerciseServiceConnection serviceConnection;
    @org.jetbrains.annotations.NotNull()
    private androidx.health.services.client.data.ExerciseState cachedExerciseState;
    @org.jetbrains.annotations.NotNull()
    private androidx.health.services.client.data.ExerciseUpdate.ActiveDurationCheckpoint activeDurationCheckpoint;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job chronoTickJob;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job uiBindingJob;
    private androidx.wear.ambient.AmbientModeSupport.AmbientController ambientController;
    private com.example.exercise.ExerciseFragment.AmbientModeHandler ambientModeHandler;
    @java.lang.Deprecated()
    public static final long CHRONO_TICK_MS = 200L;
    @org.jetbrains.annotations.NotNull()
    private static final com.example.exercise.ExerciseFragment.Companion Companion = null;
    
    public ExerciseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.exercise.HealthServicesManager getHealthServicesManager() {
        return null;
    }
    
    public final void setHealthServicesManager(@org.jetbrains.annotations.NotNull()
    com.example.exercise.HealthServicesManager p0) {
    }
    
    private final com.example.exercise.MainViewModel getViewModel() {
        return null;
    }
    
    private final com.example.exercise.databinding.FragmentExerciseBinding getBinding() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
    
    private final void startEndExercise() {
    }
    
    private final void tryStartExercise() {
    }
    
    private final void pauseResumeExercise() {
    }
    
    private final void bindViewsToService() {
    }
    
    private final void unbindViewsFromService() {
    }
    
    private final void updateExerciseStatus(androidx.health.services.client.data.ExerciseState state) {
    }
    
    private final void updateButtons(androidx.health.services.client.data.ExerciseState state) {
    }
    
    private final void updateMetrics(androidx.health.services.client.data.DataPointContainer latestMetrics) {
    }
    
    private final void updateLaps(int laps) {
    }
    
    private final void startChronometer() {
    }
    
    private final void stopChronometer() {
    }
    
    private final void updateChronometer() {
    }
    
    private final void resetDisplayedFields() {
    }
    
    private final void setAmbientUiState(boolean isAmbient) {
    }
    
    private final void performOneTimeUiUpdate() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u00a2\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0004H\u0002J\b\u0010\t\u001a\u00020\u0004H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/example/exercise/ExerciseFragment$AmbientModeHandler;", "", "(Lcom/example/exercise/ExerciseFragment;)V", "onAmbientEvent", "", "event", "Lcom/example/exercise/AmbientEvent;", "onAmbientEvent$app_debug", "onEnterAmbient", "onExitAmbient", "onUpdateAmbient", "app_debug"})
    public final class AmbientModeHandler {
        
        public AmbientModeHandler() {
            super();
        }
        
        public final void onAmbientEvent$app_debug(@org.jetbrains.annotations.NotNull()
        com.example.exercise.AmbientEvent event) {
        }
        
        private final void onEnterAmbient() {
        }
        
        private final void onExitAmbient() {
        }
        
        private final void onUpdateAmbient() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/example/exercise/ExerciseFragment$Companion;", "", "()V", "CHRONO_TICK_MS", "", "app_debug"})
    static final class Companion {
        
        private Companion() {
            super();
        }
    }
}