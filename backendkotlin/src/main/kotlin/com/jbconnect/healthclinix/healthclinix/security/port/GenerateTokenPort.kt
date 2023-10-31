package com.jbconnect.healthclinix.healthclinix.security.port

fun interface GenerateTokenPort<in I, O> {
    fun execute(i: I): O
}