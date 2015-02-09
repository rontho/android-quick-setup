package fr.rontho.aqs.infrastructure.log;

/**
 * Wrapper around the Android Logger that allow us to activate and de-activate the log for debug and release purposes.
 */
public interface Logger {

    public void d(final String tag, final String message);
    public void i(final String message);
    public void i(final String tag, final String message);
    public void e(final String tag, final String message, final Throwable throwable);
}
