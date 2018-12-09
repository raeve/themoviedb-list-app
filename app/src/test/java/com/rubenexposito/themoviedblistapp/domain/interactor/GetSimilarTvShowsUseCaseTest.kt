package com.rubenexposito.themoviedblistapp.domain.interactor

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.rubenexposito.themoviedblistapp.domain.TheMovieDbRepository
import com.rubenexposito.themoviedblistapp.domain.model.TvShow
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetSimilarTvShowsUseCaseTest {

    @Mock
    lateinit var theMovieDbRepository: TheMovieDbRepository

    @Mock
    lateinit var callback: BaseUseCase.Callback<List<TvShow>>

    private val useCase by lazy {
        GetSimilarTvShowsUseCase(
                theMovieDbRepository,
                Schedulers.trampoline(),
                Schedulers.trampoline()
        )
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun `should execute on completed when call is successful`() {
        givenSuccessfulCall()
        useCase.execute(callback, givenMapNotNull())
        verify(callback).onCompleted(any())
    }

    @Test
    fun `should execute on error when call is unsuccessful`() {
        givenUnsuccessfulCall()
        useCase.execute(callback, givenMapNotNull())
        verify(callback).onError(any())
    }

    private fun givenMapNotNull() = mapOf(GetSimilarTvShowsUseCase.PARAM_ID to 1, GetSimilarTvShowsUseCase.PARAM_LANGUAGE to "en-US", GetSimilarTvShowsUseCase.PARAM_PAGE to 1)

    private fun givenSuccessfulCall() {
        whenever(theMovieDbRepository.getSimilarTvShows(1)).thenReturn(Single.just(emptyList()))
    }

    private fun givenUnsuccessfulCall() {
        whenever(theMovieDbRepository.getSimilarTvShows(1)).thenReturn(Single.error(Throwable()))
    }
}