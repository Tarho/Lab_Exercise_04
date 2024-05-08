package com.example.exercise;

/**
 * Service that listens to the exercise state of the app. Local clients can bind to this service to
 * access the exercise state and associated metrics.
 *
 * This service manages its own lifecycle. Once a client binds to it, it calls [startService] on
 * itself and registers for exercise state. When there are no bound clients, if there isn't an
 * active exercise, this service stops itself. If there is an active exercise, it moves itself to
 * the foreground with an ongoing notification so that the user has an easy way back into the app.
 *
 * (see [Bound Services](https://developer.android.com/guide/components/bound-services))
 */
@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 ?2\u00020\u0001:\u0002?@B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020\'H\u0002J\b\u0010(\u001a\u00020)H\u0002J\u0006\u0010*\u001a\u00020)J\b\u0010+\u001a\u00020)H\u0002J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\u0012\u00100\u001a\u00020)2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\"\u00101\u001a\u00020\u00072\b\u0010.\u001a\u0004\u0018\u00010/2\u0006\u00102\u001a\u00020\u00072\u0006\u00103\u001a\u00020\u0007H\u0016J\u0012\u00104\u001a\u00020\u001d2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0006\u00105\u001a\u00020)J\b\u00106\u001a\u00020)H\u0002J\u0006\u00107\u001a\u00020)J\u0010\u00108\u001a\u00020)2\u0006\u00109\u001a\u00020:H\u0002J\b\u0010;\u001a\u00020)H\u0002J\u0006\u0010<\u001a\u00020)J\u0006\u0010=\u001a\u00020)J\b\u0010>\u001a\u00020)H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0016\u001a\u00020\u00178\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u000e\u0010\u001c\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010 \u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0011R\u0012\u0010\"\u001a\u00060#R\u00020\u0000X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\r0\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u0011\u00a8\u0006A"}, d2 = {"Lcom/example/exercise/ExerciseService;", "Landroidx/lifecycle/LifecycleService;", "()V", "_activeDurationCheckpoint", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Landroidx/health/services/client/data/ExerciseUpdate$ActiveDurationCheckpoint;", "_exerciseLaps", "", "_exerciseState", "Landroidx/health/services/client/data/ExerciseState;", "_latestMetrics", "Landroidx/health/services/client/data/DataPointContainer;", "_locationAvailabilityState", "Landroidx/health/services/client/data/LocationAvailability;", "activeDurationCheckpoint", "Lkotlinx/coroutines/flow/StateFlow;", "getActiveDurationCheckpoint", "()Lkotlinx/coroutines/flow/StateFlow;", "exerciseLaps", "getExerciseLaps", "exerciseState", "getExerciseState", "healthServicesManager", "Lcom/example/exercise/HealthServicesManager;", "getHealthServicesManager", "()Lcom/example/exercise/HealthServicesManager;", "setHealthServicesManager", "(Lcom/example/exercise/HealthServicesManager;)V", "isBound", "", "isForeground", "isStarted", "latestMetrics", "getLatestMetrics", "localBinder", "Lcom/example/exercise/ExerciseService$LocalBinder;", "locationAvailabilityState", "getLocationAvailabilityState", "buildNotification", "Landroid/app/Notification;", "createNotificationChannel", "", "endExercise", "handleBind", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onRebind", "onStartCommand", "flags", "startId", "onUnbind", "pauseExercise", "postOngoingActivityNotification", "prepareExercise", "processExerciseUpdate", "exerciseUpdate", "Landroidx/health/services/client/data/ExerciseUpdate;", "removeOngoingActivityNotification", "resumeExercise", "startExercise", "stopSelfIfNotRunning", "Companion", "LocalBinder", "app_debug"})
public final class ExerciseService extends androidx.lifecycle.LifecycleService {
    @javax.inject.Inject()
    public com.example.exercise.HealthServicesManager healthServicesManager;
    @org.jetbrains.annotations.NotNull()
    private final com.example.exercise.ExerciseService.LocalBinder localBinder = null;
    private boolean isBound = false;
    private boolean isStarted = false;
    private boolean isForeground = false;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.health.services.client.data.ExerciseState> _exerciseState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<androidx.health.services.client.data.ExerciseState> exerciseState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.health.services.client.data.DataPointContainer> _latestMetrics = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<androidx.health.services.client.data.DataPointContainer> latestMetrics = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _exerciseLaps = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> exerciseLaps = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.health.services.client.data.ExerciseUpdate.ActiveDurationCheckpoint> _activeDurationCheckpoint = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<androidx.health.services.client.data.ExerciseUpdate.ActiveDurationCheckpoint> activeDurationCheckpoint = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<androidx.health.services.client.data.LocationAvailability> _locationAvailabilityState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<androidx.health.services.client.data.LocationAvailability> locationAvailabilityState = null;
    private static final int NOTIFICATION_ID = 1;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NOTIFICATION_CHANNEL = "com.example.exercise.ONGOING_EXERCISE";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NOTIFICATION_CHANNEL_DISPLAY = "Ongoing Exercise";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NOTIFICATION_TITLE = "Exercise Sample";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String NOTIFICATION_TEXT = "Ongoing Exercise";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String ONGOING_STATUS_TEMPLATE = "Ongoing Exercise #duration#";
    private static final long UNBIND_DELAY_MILLIS = 3000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.example.exercise.ExerciseService.Companion Companion = null;
    
    public ExerciseService() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.exercise.HealthServicesManager getHealthServicesManager() {
        return null;
    }
    
    public final void setHealthServicesManager(@org.jetbrains.annotations.NotNull()
    com.example.exercise.HealthServicesManager p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<androidx.health.services.client.data.ExerciseState> getExerciseState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<androidx.health.services.client.data.DataPointContainer> getLatestMetrics() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getExerciseLaps() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<androidx.health.services.client.data.ExerciseUpdate.ActiveDurationCheckpoint> getActiveDurationCheckpoint() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<androidx.health.services.client.data.LocationAvailability> getLocationAvailabilityState() {
        return null;
    }
    
    /**
     * Prepare exercise in this service's coroutine context.
     */
    public final void prepareExercise() {
    }
    
    /**
     * Start exercise in this service's coroutine context.
     */
    public final void startExercise() {
    }
    
    /**
     * Pause exercise in this service's coroutine context.
     */
    public final void pauseExercise() {
    }
    
    /**
     * Resume exercise in this service's coroutine context.
     */
    public final void resumeExercise() {
    }
    
    /**
     * End exercise in this service's coroutine context.
     */
    public final void endExercise() {
    }
    
    @java.lang.Override()
    public int onStartCommand(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent, int flags, int startId) {
        return 0;
    }
    
    private final void stopSelfIfNotRunning() {
    }
    
    private final void processExerciseUpdate(androidx.health.services.client.data.ExerciseUpdate exerciseUpdate) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public android.os.IBinder onBind(@org.jetbrains.annotations.NotNull()
    android.content.Intent intent) {
        return null;
    }
    
    @java.lang.Override()
    public void onRebind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
    }
    
    private final void handleBind() {
    }
    
    @java.lang.Override()
    public boolean onUnbind(@org.jetbrains.annotations.Nullable()
    android.content.Intent intent) {
        return false;
    }
    
    private final void removeOngoingActivityNotification() {
    }
    
    private final void postOngoingActivityNotification() {
    }
    
    private final void createNotificationChannel() {
    }
    
    private final android.app.Notification buildNotification() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/exercise/ExerciseService$Companion;", "", "()V", "NOTIFICATION_CHANNEL", "", "NOTIFICATION_CHANNEL_DISPLAY", "NOTIFICATION_ID", "", "NOTIFICATION_TEXT", "NOTIFICATION_TITLE", "ONGOING_STATUS_TEMPLATE", "UNBIND_DELAY_MILLIS", "", "bindService", "", "context", "Landroid/content/Context;", "serviceConnection", "Landroid/content/ServiceConnection;", "unbindService", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        public final void bindService(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.content.ServiceConnection serviceConnection) {
        }
        
        public final void unbindService(@org.jetbrains.annotations.NotNull()
        android.content.Context context, @org.jetbrains.annotations.NotNull()
        android.content.ServiceConnection serviceConnection) {
        }
    }
    
    /**
     * Local clients will use this to access the service.
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/example/exercise/ExerciseService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/example/exercise/ExerciseService;)V", "getService", "Lcom/example/exercise/ExerciseService;", "app_debug"})
    public final class LocalBinder extends android.os.Binder {
        
        public LocalBinder() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.example.exercise.ExerciseService getService() {
            return null;
        }
    }
}