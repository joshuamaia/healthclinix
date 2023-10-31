package com.jbconnect.healthclinix.security.port;

public interface GenerateTokenPort<IN, OUT>{
    OUT execute(IN in);
}
