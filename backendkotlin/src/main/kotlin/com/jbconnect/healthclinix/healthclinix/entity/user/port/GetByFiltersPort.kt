package com.jbconnect.healthclinix.healthclinix.entity.user.port

import org.springframework.data.domain.Page

fun interface GetByFiltersPort<in I, I1, O> {

    fun execute(i: I, i1: I1): Page<O>

}