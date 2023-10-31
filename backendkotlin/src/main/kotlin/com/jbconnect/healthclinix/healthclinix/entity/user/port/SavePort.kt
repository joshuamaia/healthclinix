package com.jbconnect.healthclinix.healthclinix.entity.user.port

fun interface SavePort<in I, O> {
    fun execute(i: I) : O

}