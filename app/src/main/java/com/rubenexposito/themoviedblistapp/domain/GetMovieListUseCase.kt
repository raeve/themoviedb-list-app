package com.rubenexposito.themoviedblistapp.domain

import com.rubenexposito.themoviedblistapp.domain.model.Movie
import io.reactivex.Scheduler
import io.reactivex.Single

class GetMovieListUseCase(observeOn: Scheduler, subscribeOn: Scheduler): BaseUseCase<Movie>(observeOn, subscribeOn) {

    override fun createSingle(data: Map<String, Any>?): Single<Movie> {
        return Single.just(null)
    }
}