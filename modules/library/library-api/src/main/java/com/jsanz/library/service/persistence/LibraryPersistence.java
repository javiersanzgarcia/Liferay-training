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

import com.jsanz.library.exception.NoSuchLibraryException;
import com.jsanz.library.model.Library;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryUtil
 * @generated
 */
@ProviderType
public interface LibraryPersistence extends BasePersistence<Library> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LibraryUtil} to access the library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the libraries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching libraries
	 */
	public java.util.List<Library> findByUuid(String uuid);

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
	public java.util.List<Library> findByUuid(String uuid, int start, int end);

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
	public java.util.List<Library> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

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
	public java.util.List<Library> findByUuid(
		String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public Library findByUuid_First(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Returns the first library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	public Library fetchByUuid_First(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns the last library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public Library findByUuid_Last(
			String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Returns the last library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	public Library fetchByUuid_Last(
		String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns the libraries before and after the current library in the ordered set where uuid = &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public Library[] findByUuid_PrevAndNext(
			long ISBN, String uuid,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Removes all the libraries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	public void removeByUuid(String uuid);

	/**
	 * Returns the number of libraries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching libraries
	 */
	public int countByUuid(String uuid);

	/**
	 * Returns all the libraries where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching libraries
	 */
	public java.util.List<Library> findByTitle(String title);

	/**
	 * Returns a range of all the libraries where title LIKE &#63;.
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
	public java.util.List<Library> findByTitle(
		String title, int start, int end);

	/**
	 * Returns an ordered range of all the libraries where title LIKE &#63;.
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
	public java.util.List<Library> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns an ordered range of all the libraries where title LIKE &#63;.
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
	public java.util.List<Library> findByTitle(
		String title, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first library in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public Library findByTitle_First(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Returns the first library in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	public Library fetchByTitle_First(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns the last library in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public Library findByTitle_Last(
			String title,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Returns the last library in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	public Library fetchByTitle_Last(
		String title,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns the libraries before and after the current library in the ordered set where title LIKE &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public Library[] findByTitle_PrevAndNext(
			long ISBN, String title,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Removes all the libraries where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 */
	public void removeByTitle(String title);

	/**
	 * Returns the number of libraries where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching libraries
	 */
	public int countByTitle(String title);

	/**
	 * Returns all the libraries where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the matching libraries
	 */
	public java.util.List<Library> findByWriter(String writer);

	/**
	 * Returns a range of all the libraries where writer LIKE &#63;.
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
	public java.util.List<Library> findByWriter(
		String writer, int start, int end);

	/**
	 * Returns an ordered range of all the libraries where writer LIKE &#63;.
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
	public java.util.List<Library> findByWriter(
		String writer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns an ordered range of all the libraries where writer LIKE &#63;.
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
	public java.util.List<Library> findByWriter(
		String writer, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first library in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public Library findByWriter_First(
			String writer,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Returns the first library in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	public Library fetchByWriter_First(
		String writer,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns the last library in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public Library findByWriter_Last(
			String writer,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Returns the last library in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	public Library fetchByWriter_Last(
		String writer,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns the libraries before and after the current library in the ordered set where writer LIKE &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public Library[] findByWriter_PrevAndNext(
			long ISBN, String writer,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Removes all the libraries where writer LIKE &#63; from the database.
	 *
	 * @param writer the writer
	 */
	public void removeByWriter(String writer);

	/**
	 * Returns the number of libraries where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the number of matching libraries
	 */
	public int countByWriter(String writer);

	/**
	 * Returns all the libraries where publication = &#63;.
	 *
	 * @param publication the publication
	 * @return the matching libraries
	 */
	public java.util.List<Library> findByPublication(Date publication);

	/**
	 * Returns a range of all the libraries where publication = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param publication the publication
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @return the range of matching libraries
	 */
	public java.util.List<Library> findByPublication(
		Date publication, int start, int end);

	/**
	 * Returns an ordered range of all the libraries where publication = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param publication the publication
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching libraries
	 */
	public java.util.List<Library> findByPublication(
		Date publication, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns an ordered range of all the libraries where publication = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LibraryModelImpl</code>.
	 * </p>
	 *
	 * @param publication the publication
	 * @param start the lower bound of the range of libraries
	 * @param end the upper bound of the range of libraries (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching libraries
	 */
	public java.util.List<Library> findByPublication(
		Date publication, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first library in the ordered set where publication = &#63;.
	 *
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public Library findByPublication_First(
			Date publication,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Returns the first library in the ordered set where publication = &#63;.
	 *
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	public Library fetchByPublication_First(
		Date publication,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns the last library in the ordered set where publication = &#63;.
	 *
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	public Library findByPublication_Last(
			Date publication,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Returns the last library in the ordered set where publication = &#63;.
	 *
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	public Library fetchByPublication_Last(
		Date publication,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

	/**
	 * Returns the libraries before and after the current library in the ordered set where publication = &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public Library[] findByPublication_PrevAndNext(
			long ISBN, Date publication,
			com.liferay.portal.kernel.util.OrderByComparator<Library>
				orderByComparator)
		throws NoSuchLibraryException;

	/**
	 * Removes all the libraries where publication = &#63; from the database.
	 *
	 * @param publication the publication
	 */
	public void removeByPublication(Date publication);

	/**
	 * Returns the number of libraries where publication = &#63;.
	 *
	 * @param publication the publication
	 * @return the number of matching libraries
	 */
	public int countByPublication(Date publication);

	/**
	 * Caches the library in the entity cache if it is enabled.
	 *
	 * @param library the library
	 */
	public void cacheResult(Library library);

	/**
	 * Caches the libraries in the entity cache if it is enabled.
	 *
	 * @param libraries the libraries
	 */
	public void cacheResult(java.util.List<Library> libraries);

	/**
	 * Creates a new library with the primary key. Does not add the library to the database.
	 *
	 * @param ISBN the primary key for the new library
	 * @return the new library
	 */
	public Library create(long ISBN);

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library that was removed
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public Library remove(long ISBN) throws NoSuchLibraryException;

	public Library updateImpl(Library library);

	/**
	 * Returns the library with the primary key or throws a <code>NoSuchLibraryException</code> if it could not be found.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	public Library findByPrimaryKey(long ISBN) throws NoSuchLibraryException;

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 */
	public Library fetchByPrimaryKey(long ISBN);

	/**
	 * Returns all the libraries.
	 *
	 * @return the libraries
	 */
	public java.util.List<Library> findAll();

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
	public java.util.List<Library> findAll(int start, int end);

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
	public java.util.List<Library> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator);

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
	public java.util.List<Library> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Library>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the libraries from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of libraries.
	 *
	 * @return the number of libraries
	 */
	public int countAll();

}