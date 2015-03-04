android-quick-setup
===================

This is a base Android project that allow me to start a new Android project from scratch with couple of good libraries I will use in my projects and configure the base module to make Dagger work out of the box. It also allow me to use Robolectric in my unit test.

## If you are using AndroidStudio

If you are using AndroidStudio you need to add that [plugin](https://github.com/evant/android-studio-unit-test-plugin), otherwise the test wont compile. 

## List of technologies used

  * Gradle
  * Dagger
  * RetroFit (okHttp)
  * Otto
  * ImageLoader (Novoda)
  * JUnit 4+
  * Mockito
  * Hamcrest
  * Robolectric

## In this version

  * Added a a working OTTO EventBus
  * Added a DaoFactory based on ORMLite
  
## In the Next version

 * User dagger to provide Activity Context
 * Create a caching system base on OTTO
 * Use Retrofit to make async http request
 * Add an exemple of a full backend to frontend communication

## See also

[Android Unit Test](https://github.com/JCAndKSolutions/android-unit-test)


  
