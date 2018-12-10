# themoviedb-list-app
An app to list movies from [MovieDB API](https://developers.themoviedb.org/3/getting-started/introduction)

## Usage

To retrieve data from [TMDB API](https://developers.themoviedb.org/3/getting-started), you need to create an account and replace the api key in *BaseConfig.kt* with your credentials
```kotlin
    const val API_KEY = "your_public_key"
```


## Summary

* Kotlin app based on Clean Architecture (MVP pattern)
* Interactors connected to the different layers using Repository pattern.
* Dependency injection handled with Dagger2
* Asynchronous events with RxKotlin
* Unit tests using Mockito
* _(Work in progress)_ UI tests with Espresso
* Used [TMDB API](https://developers.themoviedb.org/3/getting-started) as network provider. Endpoints used **tv/popular** and **tv/{tv_id}/similar**


## Libraries

* [Dagger](https://google.github.io/dagger/)
* [RxKotlin](https://github.com/ReactiveX/RxKotlin)
* [Retrofit](https://square.github.io/retrofit/)
* [Picasso](https://square.github.io/picasso/)
* [Lottie](https://airbnb.design/lottie)
* [Mockito](https://github.com/nhaarman/mockito-kotlin/)