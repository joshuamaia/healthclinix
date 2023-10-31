package com.jbconnect.healthclinix.healthclinix.security.port

fun interface LoginPort<in I, O> {
    fun execute(i: I): O
}