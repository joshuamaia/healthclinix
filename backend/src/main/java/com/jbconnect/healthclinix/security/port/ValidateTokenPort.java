package com.jbconnect.healthclinix.security.port;

public interface ValidateTokenPort<IN, OUT> {

    OUT execute(IN in);
}
