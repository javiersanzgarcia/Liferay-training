/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jsanz.library.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LibraryService}.
 *
 * @author Brian Wing Shun Chan
 * @see LibraryService
 * @generated
 */
public class LibraryServiceWrapper
	implements LibraryService, ServiceWrapper<LibraryService> {

	public LibraryServiceWrapper(LibraryService libraryService) {
		_libraryService = libraryService;
	}

	@Override
	public com.jsanz.library.model.Library delete(
		com.jsanz.library.model.Library library) {

		return _libraryService.delete(library);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _libraryService.getOSGiServiceIdentifier();
	}

	@Override
	public com.jsanz.library.model.Library save(
		com.jsanz.library.model.Library library) {

		return _libraryService.save(library);
	}

	@Override
	public com.jsanz.library.model.Library update(
		com.jsanz.library.model.Library library) {

		return _libraryService.update(library);
	}

	@Override
	public LibraryService getWrappedService() {
		return _libraryService;
	}

	@Override
	public void setWrappedService(LibraryService libraryService) {
		_libraryService = libraryService;
	}

	private LibraryService _libraryService;

}