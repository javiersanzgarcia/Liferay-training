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
 * Provides a wrapper for {@link LibraryLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see LibraryLocalService
 * @generated
 */
public class LibraryLocalServiceWrapper
	implements LibraryLocalService, ServiceWrapper<LibraryLocalService> {

	public LibraryLocalServiceWrapper(LibraryLocalService libraryLocalService) {
		_libraryLocalService = libraryLocalService;
	}

	/**
	 * Adds the library to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param library the library
	 * @return the library that was added
	 */
	@Override
	public com.jsanz.library.model.Library addLibrary(
		com.jsanz.library.model.Library library) {

		return _libraryLocalService.addLibrary(library);
	}

	/**
	 * Creates a new library with the primary key. Does not add the library to the database.
	 *
	 * @param ISBN the primary key for the new library
	 * @return the new library
	 */
	@Override
	public com.jsanz.library.model.Library createLibrary(long ISBN) {
		return _libraryLocalService.createLibrary(ISBN);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the library from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param library the library
	 * @return the library that was removed
	 */
	@Override
	public com.jsanz.library.model.Library deleteLibrary(
		com.jsanz.library.model.Library library) {

		return _libraryLocalService.deleteLibrary(library);
	}

	/**
	 * Deletes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ISBN the primary key of the library
	 * @return the library that was removed
	 * @throws PortalException if a library with the primary key could not be found
	 */
	@Override
	public com.jsanz.library.model.Library deleteLibrary(long ISBN)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryLocalService.deleteLibrary(ISBN);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _libraryLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _libraryLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.jsanz.library.model.impl.LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _libraryLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.jsanz.library.model.impl.LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _libraryLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _libraryLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _libraryLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.jsanz.library.model.Library fetchLibrary(long ISBN) {
		return _libraryLocalService.fetchLibrary(ISBN);
	}

	@Override
	public java.util.List<com.jsanz.library.model.Library> findByTitle(
		String title) {

		return _libraryLocalService.findByTitle(title);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _libraryLocalService.getActionableDynamicQuery();
	}

	@Override
	public java.util.List<com.jsanz.library.model.Library> getAll() {
		return _libraryLocalService.getAll();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _libraryLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.jsanz.library.model.impl.LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of libraries
	 */
	@Override
	public java.util.List<com.jsanz.library.model.Library> getLibraries(
		int start, int end) {

		return _libraryLocalService.getLibraries(start, end);
	}

	/**
	 * Returns the number of libraries.
	 *
	 * @return the number of libraries
	 */
	@Override
	public int getLibrariesCount() {
		return _libraryLocalService.getLibrariesCount();
	}

	/**
	 * Returns the library with the primary key.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library
	 * @throws PortalException if a library with the primary key could not be found
	 */
	@Override
	public com.jsanz.library.model.Library getLibrary(long ISBN)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryLocalService.getLibrary(ISBN);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _libraryLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _libraryLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the library in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LibraryLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param library the library
	 * @return the library that was updated
	 */
	@Override
	public com.jsanz.library.model.Library updateLibrary(
		com.jsanz.library.model.Library library) {

		return _libraryLocalService.updateLibrary(library);
	}

	@Override
	public LibraryLocalService getWrappedService() {
		return _libraryLocalService;
	}

	@Override
	public void setWrappedService(LibraryLocalService libraryLocalService) {
		_libraryLocalService = libraryLocalService;
	}

	private LibraryLocalService _libraryLocalService;

}