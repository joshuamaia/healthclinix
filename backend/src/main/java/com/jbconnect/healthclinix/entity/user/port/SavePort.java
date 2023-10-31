package com.jbconnect.healthclinix.entity.user.port;

public interface SavePort<IN, OUT> {

    OUT execute(IN in);
}
