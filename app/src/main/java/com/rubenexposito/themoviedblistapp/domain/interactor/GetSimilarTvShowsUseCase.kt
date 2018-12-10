package com.rubenexposito.themoviedblistapp.domain.interactor

import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import io.reactivex.Scheduler
import io.reactivex.Single

class GetSimilarTvShowsUseCase(
    private val theMovieDbRepository: TheMovieDbRepository,
    observeOn: Scheduler,
    subscribeOn: Scheduler
) : BaseUseCase<List<TvShow>>(observeOn, subscribeOn) {

    override fun createSingle(data: Map<String, Any>?): Single<List<TvShow>> = try {
        val id: Int = requireNotNull(data?.get(PARAM_ID) as Int)
        val language: String = requireNotNull(data[PARAM_LANGUAGE] as String)
        val page: Int = requireNotNull(data[PARAM_PAGE] as Int)
       theMovieDbRepository.getSimilarTvShows(id, language, page)
    } catch (exception: IllegalArgumentException) {
        Single.error(exception)
    }

    companion object {
        const val PARAM_ID = "param:id"
        const val PARAM_LANGUAGE = "param:language"
        const val PARAM_PAGE = "param:page"
    }
}