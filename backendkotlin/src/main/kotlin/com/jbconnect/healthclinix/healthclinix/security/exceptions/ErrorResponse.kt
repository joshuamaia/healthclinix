package com.jbconnect.healthclinix.healthclinix.security.exceptions

import java.time.LocalDateTime

class ErrorResponse(val status : Int , val path : String , val message : String? , val timespamp :LocalDateTime ) {
}