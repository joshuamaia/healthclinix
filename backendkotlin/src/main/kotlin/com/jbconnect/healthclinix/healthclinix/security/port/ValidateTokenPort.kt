package com.jbconnect.healthclinix.healthclinix.security.port

fun interface ValidateTokenPort <in I, O> {
    fun execute(i: I): O
}