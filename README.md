
Introduction
    With this document I attempt to present the project by presenting the technology, the architecture, and the logic used to develop this project.

Architecture
    In this project I used the MVVM architecture wishes it to be based on the principle of clean architecture.

Presentation layer :
    This layer has the responsibility to present the result to the user.
    this layer breaks down into two parts:
    view(fragment,Activity) : show the result
    presenter ( viewModel) : present the result
    uses cases layer :
    This layer has the responsibility to manager the complex task and the business rule    of the project

Repository:
    this layer has the responsibility of the business logic of the project and the data management
    to ensure the validated data and the app work also in offline mode i implement the single source of truth design pattern


Tools :
    dataStore :to store the light data it’s work like sharedPreference but with courtine management
    retrofit :to ensure the communication with server
    hilt : dependency Injection
    Flow & channel : to transfer the data between different layer
    workManager : for the background task (upload file)
    android networking module (download)
    function interface or closure function: that return a callback
    navigation component to ensure the navigation between fragments
    liveData to present the data from viewModel to the view



Dependency Injection
to ensure the independence in the project i use the dependency injection design pattern by all the class have an implementation (interface) .i try to manage the dependency Injection by using  the HILT library 
