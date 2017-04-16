android-quick-setup [![Build Status](https://travis-ci.org/rontho/android-quick-setup.svg?branch=master)](https://travis-ci.org/rontho/android-quick-setup)
===================

This is a base Android project that allow me to start a new Android project from scratch with couple of good libraries I will use in my projects and configure the base module to make Dagger work out of the box. 
It also allow me to use Robolectric in my unit test.

## Introduced the clean architecture
 
 In this new version of the Android quick setup project, I will use a slightly customized version 
 of the well know Android Clean Architecture (https://github.com/android10/Android-CleanArchitecture)

## List of technologies used

  * Gradle
  * Dagger --> Dagger 2
  * RetroFit 2
  * Otto (deprecated) --> Guava EventBus
  * ImageLoader (deprecated)  --> Picasso 
  * JUnit 4+
  * Mockito
  * Hamcrest
  * Robolectric
  * NEW : ButterKnife (for view injection)

## In this version

  * Remove the now deprecated OTTO EventBus and replaced it by Guava EventBus
  * Update all the libraries version, including the support libraries and target api
  
## In the Next version

 * User dagger to provide Activity Context
 * Create a caching system base on OTTO
 * Use Retrofit to make async http request
 * Add an exemple of a full backend to frontend communication
 * Add Espresso testing

## See also

Dagger can be replaced by ToothPick, you can use Glide instead of Picasso


  
