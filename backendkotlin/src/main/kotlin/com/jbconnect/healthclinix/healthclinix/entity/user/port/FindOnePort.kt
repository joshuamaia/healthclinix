package com.jbconnect.healthclinix.healthclinix.entity.user.port

fun interface FindOnePort<in I, O> {
    fun execute(i: I) : O

}