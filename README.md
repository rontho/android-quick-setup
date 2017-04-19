TODO 
====

* Add leak canary and add documentation in this doc on how to use and run them
* Add stetho and add documentation in this doc on how to use and run them
* Add an example of a interceptor
* Separated the build dependency (like in ACA)
* Add Unit test example
* Add Espresso test example and add documentation in this doc on how to use and run them
* Display image with Picasso

android-quick-setup [![Build Status](https://travis-ci.org/rontho/android-quick-setup.svg?branch=master)](https://travis-ci.org/rontho/android-quick-setup)
===================


This is a base Android project that allow me to start a new Android project from scratch.

Every new application you build need to have basically the same structure, libraries and it's painfull
to do it every time.

With this project, you will get a walking skeleton of a basic Android app you can reuse to build your own.

The project is based on the Android clean Architecture project, with some simplification and multiple
useful libraries I like to have in my projects (list below), and configure the base module to make Dagger work out of the box.

This project also show you how you can use those libraries with a working example in the app for each of them. 
It also demonstrate how you write unit test and give you a idea of how you can run UI test using espresso.


## How To

 ### Use the Clean Architecure
 
 In this new version of the Android quick setup project, I will use a slightly customized version 
 of the well know Android Clean Architecture (https://github.com/android10/Android-CleanArchitecture)
 
 TODO : explain the MVP with binding. Explain the UseCaseRunner role. Explain ORMLite. Explain Http calls politic
 
 ### Use Stetho and LeakCanary
 
 TODO

## List of libraries used

  * ORMLite
  * _Dagger (deprecated) --> Dagger 2_
  * _RetroFit --> RetroFit 2 with usage of Interceptor_
  * _Otto (deprecated) --> Guava EventBus_
  * _ImageLoader (deprecated)  --> Picasso_
  * **NEW : ContraintLayout**
  * **NEW : ButterKnife (for view injection)**
  * **NEW : Espresso (for UI testing)**
  * **NEW : Stetho (for development only)**
  * **NEW : LeakCanary (for development only)**
  * JUnit 4+, Mockito, Hamcrest (For testing)

## Changelog

  * Remove the now deprecated OTTO EventBus and replaced it by Guava EventBus
  * Update all the libraries version, including the support libraries and target api
  * Removed dependencies to Robolectric and introduced Espresso
  * Use the Clean Architecture (introduced 3 modules : presentatio, domain, data)
  * Add unit and UI test
  * MultiDex Support
  
## In the Next version

 * Create a caching system for the EventBus to avoid unecessary http calls
 * Support of Java 8 (demonstrate how we can use it in the app)
 * Handle Android Permission
 * Firebase integration : Authentication, Notifications, Crash Report, Deep Linking...

## See also

Dagger can be replaced by ToothPick, you can use Glide instead of Picasso
RxJava2 can be used instead of GuavaEventBus and the UseCaseRunner.


  
