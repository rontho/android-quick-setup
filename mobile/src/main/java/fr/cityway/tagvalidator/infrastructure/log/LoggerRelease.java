package fr.cityway.tagvalidator.infrastructure.log;

/**
 * The release version of the logger
 */
public class LoggerRelease implements Logger {
    @Override
    public void d(String tag, String message) {
        //do nothing
    }

    @Override
    public void i(String message) {
        //do nothing
    }

    @Override
    public void i(String tag, String message) {
        //do nothing
    }

    @Override
    public void e(String tag, String message, Throwable throwable) {
        //do nothing
    }
}