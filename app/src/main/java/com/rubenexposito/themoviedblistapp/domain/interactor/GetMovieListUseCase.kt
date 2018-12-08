package com.rubenexposito.themoviedblistapp.domain.interactor

import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.model.Movie
import io.reactivex.Scheduler
import io.reactivex.Single

class GetMovieListUseCase(private val theMovieDbRepository: TheMovieDbRepository, observeOn: Scheduler, subscribeOn: Scheduler): BaseUseCase<List<Movie>>(observeOn, subscribeOn) {

    override fun createSingle(data: Map<String, Any>?): Single<List<Movie>> {
        return theMovieDbRepository.getMovies()
    }
}