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

package com.jsanz.library.service.persistence;

import com.jsanz.library.model.Library;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the library service. This utility wraps <code>com.jsanz.library.service.persistence.impl.LibraryPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryPersistence
 * @generated
 */
public class LibraryUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Library library) {
		getPersistence().clearCache(library);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Library> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Library> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Library> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Library> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Library update(Library library) {
		return getPersistence().update(library);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Library update(
		Library library, ServiceContext serviceContext) {

		return getPersistence().update(library, serviceContext);
	}

	/**
	 * Returns all the libraries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching libraries
	 */
	public static List<Library> findByUuid(String uuid) {
		return getPersistence().findByUuid(uuid);
	}

	/**
	 * Returns a range of all the libraries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of matching libraries
	 */
	public static List<Library> findByUuid(String uuid, int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	 * Returns an ordered range of all the libraries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching libraries
	 */
	public static List<Library> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the libraries where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching libraries
	 */
	public static List<Library> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Library> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByUuid(
			uuid, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public static Library findByUuid_First(
			String uuid, OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the first library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	public static Library fetchByUuid_First(
		String uuid, OrderByComparator<Library> orderByComparator) {

		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	 * Returns the last library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public static Library findByUuid_Last(
			String uuid, OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the last library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	public static Library fetchByUuid_Last(
		String uuid, OrderByComparator<Library> orderByComparator) {

		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where uuid = &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public static Library[] findByUuid_PrevAndNext(
			long ISBN, String uuid,
			OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByUuid_PrevAndNext(
			ISBN, uuid, orderByComparator);
	}

	/**
	 * Removes all the libraries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public static void removeByUuid(String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	 * Returns the number of libraries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching libraries
	 */
	public static int countByUuid(String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	 * Returns all the libraries where title = &#63;.
	 *
	 * @param title the title
	 * @return the matching libraries
	 */
	public static List<Library> findByTitle(String title) {
		return getPersistence().findByTitle(title);
	}

	/**
	 * Returns a range of all the libraries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of matching libraries
	 */
	public static List<Library> findByTitle(String title, int start, int end) {
		return getPersistence().findByTitle(title, start, end);
	}

	/**
	 * Returns an ordered range of all the libraries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching libraries
	 */
	public static List<Library> findByTitle(
		String title, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the libraries where title = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param title the title
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching libraries
	 */
	public static List<Library> findByTitle(
		String title, int start, int end,
		OrderByComparator<Library> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByTitle(
			title, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first library in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public static Library findByTitle_First(
			String title, OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the first library in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	public static Library fetchByTitle_First(
		String title, OrderByComparator<Library> orderByComparator) {

		return getPersistence().fetchByTitle_First(title, orderByComparator);
	}

	/**
	 * Returns the last library in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public static Library findByTitle_Last(
			String title, OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the last library in the ordered set where title = &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	public static Library fetchByTitle_Last(
		String title, OrderByComparator<Library> orderByComparator) {

		return getPersistence().fetchByTitle_Last(title, orderByComparator);
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where title = &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public static Library[] findByTitle_PrevAndNext(
			long ISBN, String title,
			OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByTitle_PrevAndNext(
			ISBN, title, orderByComparator);
	}

	/**
	 * Removes all the libraries where title = &#63; from the database.
	 *
	 * @param title the title
	 */
	public static void removeByTitle(String title) {
		getPersistence().removeByTitle(title);
	}

	/**
	 * Returns the number of libraries where title = &#63;.
	 *
	 * @param title the title
	 * @return the number of matching libraries
	 */
	public static int countByTitle(String title) {
		return getPersistence().countByTitle(title);
	}

	/**
	 * Returns all the libraries where writer = &#63;.
	 *
	 * @param writer the writer
	 * @return the matching libraries
	 */
	public static List<Library> findByWriter(String writer) {
		return getPersistence().findByWriter(writer);
	}

	/**
	 * Returns a range of all the libraries where writer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param writer the writer
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of matching libraries
	 */
	public static List<Library> findByWriter(
		String writer, int start, int end) {

		return getPersistence().findByWriter(writer, start, end);
	}

	/**
	 * Returns an ordered range of all the libraries where writer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param writer the writer
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching libraries
	 */
	public static List<Library> findByWriter(
		String writer, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return getPersistence().findByWriter(
			writer, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the libraries where writer = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param writer the writer
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching libraries
	 */
	public static List<Library> findByWriter(
		String writer, int start, int end,
		OrderByComparator<Library> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByWriter(
			writer, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first library in the ordered set where writer = &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public static Library findByWriter_First(
			String writer, OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByWriter_First(writer, orderByComparator);
	}

	/**
	 * Returns the first library in the ordered set where writer = &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	public static Library fetchByWriter_First(
		String writer, OrderByComparator<Library> orderByComparator) {

		return getPersistence().fetchByWriter_First(writer, orderByComparator);
	}

	/**
	 * Returns the last library in the ordered set where writer = &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public static Library findByWriter_Last(
			String writer, OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByWriter_Last(writer, orderByComparator);
	}

	/**
	 * Returns the last library in the ordered set where writer = &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	public static Library fetchByWriter_Last(
		String writer, OrderByComparator<Library> orderByComparator) {

		return getPersistence().fetchByWriter_Last(writer, orderByComparator);
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where writer = &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public static Library[] findByWriter_PrevAndNext(
			long ISBN, String writer,
			OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByWriter_PrevAndNext(
			ISBN, writer, orderByComparator);
	}

	/**
	 * Removes all the libraries where writer = &#63; from the database.
	 *
	 * @param writer the writer
	 */
	public static void removeByWriter(String writer) {
		getPersistence().removeByWriter(writer);
	}

	/**
	 * Returns the number of libraries where writer = &#63;.
	 *
	 * @param writer the writer
	 * @return the number of matching libraries
	 */
	public static int countByWriter(String writer) {
		return getPersistence().countByWriter(writer);
	}

	/**
	 * Returns all the libraries where ISBN = &#63;.
	 *
	 * @param ISBN the isbn
	 * @return the matching libraries
	 */
	public static List<Library> findByISBN(long ISBN) {
		return getPersistence().findByISBN(ISBN);
	}

	/**
	 * Returns a range of all the libraries where ISBN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param ISBN the isbn
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of matching libraries
	 */
	public static List<Library> findByISBN(long ISBN, int start, int end) {
		return getPersistence().findByISBN(ISBN, start, end);
	}

	/**
	 * Returns an ordered range of all the libraries where ISBN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param ISBN the isbn
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching libraries
	 */
	public static List<Library> findByISBN(
		long ISBN, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return getPersistence().findByISBN(ISBN, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the libraries where ISBN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param ISBN the isbn
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching libraries
	 */
	public static List<Library> findByISBN(
		long ISBN, int start, int end,
		OrderByComparator<Library> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByISBN(
			ISBN, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first library in the ordered set where ISBN = &#63;.
	 *
	 * @param ISBN the isbn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public static Library findByISBN_First(
			long ISBN, OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByISBN_First(ISBN, orderByComparator);
	}

	/**
	 * Returns the first library in the ordered set where ISBN = &#63;.
	 *
	 * @param ISBN the isbn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	public static Library fetchByISBN_First(
		long ISBN, OrderByComparator<Library> orderByComparator) {

		return getPersistence().fetchByISBN_First(ISBN, orderByComparator);
	}

	/**
	 * Returns the last library in the ordered set where ISBN = &#63;.
	 *
	 * @param ISBN the isbn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public static Library findByISBN_Last(
			long ISBN, OrderByComparator<Library> orderByComparator)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByISBN_Last(ISBN, orderByComparator);
	}

	/**
	 * Returns the last library in the ordered set where ISBN = &#63;.
	 *
	 * @param ISBN the isbn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	public static Library fetchByISBN_Last(
		long ISBN, OrderByComparator<Library> orderByComparator) {

		return getPersistence().fetchByISBN_Last(ISBN, orderByComparator);
	}

	/**
	 * Removes all the libraries where ISBN = &#63; from the database.
	 *
	 * @param ISBN the isbn
	 */
	public static void removeByISBN(long ISBN) {
		getPersistence().removeByISBN(ISBN);
	}

	/**
	 * Returns the number of libraries where ISBN = &#63;.
	 *
	 * @param ISBN the isbn
	 * @return the number of matching libraries
	 */
	public static int countByISBN(long ISBN) {
		return getPersistence().countByISBN(ISBN);
	}

	/**
	 * Caches the library in the entity cache if it is enabled.
	 *
	 * @param library the library
	 */
	public static void cacheResult(Library library) {
		getPersistence().cacheResult(library);
	}

	/**
	 * Caches the libraries in the entity cache if it is enabled.
	 *
	 * @param libraries the libraries
	 */
	public static void cacheResult(List<Library> libraries) {
		getPersistence().cacheResult(libraries);
	}

	/**
	 * Creates a new library with the primary key. Does not add the library to the database.
	 *
	 * @param ISBN the primary key for the new library
	 * @return the new library
	 */
	public static Library create(long ISBN) {
		return getPersistence().create(ISBN);
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library that was removed
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public static Library remove(long ISBN)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().remove(ISBN);
	}

	public static Library updateImpl(Library library) {
		return getPersistence().updateImpl(library);
	}

	/**
	 * Returns the library with the primary key or throws a <code>NoSuchLibraryException</code> if it could not be found.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public static Library findByPrimaryKey(long ISBN)
		throws com.jsanz.library.exception.NoSuchLibraryException {

		return getPersistence().findByPrimaryKey(ISBN);
	}

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 */
	public static Library fetchByPrimaryKey(long ISBN) {
		return getPersistence().fetchByPrimaryKey(ISBN);
	}

	/**
	 * Returns all the libraries.
	 *
	 * @return the libraries
	 */
	public static List<Library> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of libraries
	 */
	public static List<Library> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of libraries
	 */
	public static List<Library> findAll(
		int start, int end, OrderByComparator<Library> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the libraries.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of libraries
	 */
	public static List<Library> findAll(
		int start, int end, OrderByComparator<Library> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the libraries from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of libraries.
	 *
	 * @return the number of libraries
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static LibraryPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<LibraryPersistence, LibraryPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(LibraryPersistence.class);

		ServiceTracker<LibraryPersistence, LibraryPersistence> serviceTracker =
			new ServiceTracker<LibraryPersistence, LibraryPersistence>(
				bundle.getBundleContext(), LibraryPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}