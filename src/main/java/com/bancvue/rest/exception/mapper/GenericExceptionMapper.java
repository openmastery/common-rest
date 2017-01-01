/**
 * Copyright 2017 BancVue, LTD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bancvue.rest.exception.mapper;

import com.bancvue.rest.exception.ErrorResponseFactory;
import lombok.extern.slf4j.Slf4j;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Slf4j
@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception> {

    public static final String INTERNAL_SERVER_ERROR_MSG = "An internal server error occurred.";

    @Override
    public Response toResponse(Exception exception) {
        log.error(INTERNAL_SERVER_ERROR_MSG, exception);
        return ErrorResponseFactory.makeErrorResponse(Response.Status.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR_MSG);
    }

}
