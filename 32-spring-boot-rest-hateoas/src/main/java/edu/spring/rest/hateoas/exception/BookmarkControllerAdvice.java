package edu.spring.rest.hateoas.exception;


/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import org.springframework.hateoas.mediatype.vnderrors.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

// tag::code[]
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
class BookmarkControllerAdvice {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<VndErrors> userNotFoundExceptionHandler(final UserNotFoundException e) {
		return error(e, HttpStatus.NOT_FOUND, e.getMessage());
	}

	private ResponseEntity<VndErrors> error(
			final Exception exception, final HttpStatus httpStatus, final String logRef) {
		final String message =
				Optional.of(exception.getMessage()).orElse(exception.getClass().getSimpleName());
		return new ResponseEntity<>(new VndErrors(logRef, message), httpStatus);
	}

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<VndErrors> assertionException(final IllegalArgumentException e) {
		return error(e, HttpStatus.NOT_FOUND, e.getLocalizedMessage());
	}
}
// end::code[]
