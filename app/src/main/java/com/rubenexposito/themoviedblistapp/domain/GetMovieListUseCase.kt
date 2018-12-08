package com.rubenexposito.themoviedblistapp.domain

import io.reactivex.Scheduler

class GetMovieListUseCase(private val observeOn: Scheduler, private val subscribeOn: Scheduler) {
}