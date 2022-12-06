package com.google.android.gms.tasks;

/* compiled from: com.google.android.gms:play-services-tasks@@18.0.1 */
public final class DuplicateTaskCompletionException extends IllegalStateException {
    private DuplicateTaskCompletionException(String str, Throwable th) {
        super(str, th);
    }

    public static IllegalStateException of(Task<?> task) {
        String str;
        if (!task.isComplete()) {
            return new IllegalStateException("DuplicateTaskCompletionException can only be created from completed Task.");
        }
        Exception exception = task.getException();
        if (exception != null) {
            str = "failure";
        } else if (task.isSuccessful()) {
            String valueOf = String.valueOf(task.getResult());
            String.valueOf(valueOf).length();
            str = "result ".concat(String.valueOf(valueOf));
        } else {
            str = task.isCanceled() ? "cancellation" : "unknown issue";
        }
        return new DuplicateTaskCompletionException(str.length() != 0 ? "Complete with: ".concat(str) : new String("Complete with: "), exception);
    }
}
