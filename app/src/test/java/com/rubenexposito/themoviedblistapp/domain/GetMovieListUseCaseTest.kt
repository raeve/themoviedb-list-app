package com.rubenexposito.themoviedblistapp.domain

import io.reactivex.schedulers.Schedulers
import org.junit.Before
import org.mockito.MockitoAnnotations

class GetMovieListUseCaseTest {

    private val useCase by lazy {
        GetMovieListUseCase(Schedulers.trampoline(), Schedulers.trampoline())
    }

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
    }
}