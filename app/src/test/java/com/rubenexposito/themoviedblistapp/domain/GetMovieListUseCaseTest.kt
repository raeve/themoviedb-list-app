package com.rubenexposito.themoviedblistapp.domain

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import com.rubenexposito.themoviedblistapp.domain.interactor.BaseUseCase
import com.rubenexposito.themoviedblistapp.domain.interactor.GetMovieListUseCase
import com.rubenexposito.themoviedblistapp.domain.model.Movie
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class GetMovieListUseCaseTest {

    @Mock
    lateinit var theMovieDbRepository: TheMovieDbRepository

    @Mock
    lateinit var callback: BaseUseCase.Callback<List<Movie>>

    private val useCase by lazy {
        GetMovieListUseCase(
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
        useCase.execute(callback)
        verify(callback).onCompleted(any())
    }

    @Test
    fun `should execute on error when call is unsuccessful`() {
        givenUnsuccessfulCall()
        useCase.execute(callback)
        verify(callback).onError(any())
    }

    private fun givenSuccessfulCall() {
        whenever(theMovieDbRepository.getMovies()).thenReturn(Single.just(emptyList()))
    }

    private fun givenUnsuccessfulCall() {
        whenever(theMovieDbRepository.getMovies()).thenReturn(Single.error(Throwable()))
    }
}