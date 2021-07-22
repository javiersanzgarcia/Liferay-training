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

package com.jsanz.library.service.persistence.impl;

import com.jsanz.library.exception.NoSuchLibraryException;
import com.jsanz.library.model.Library;
import com.jsanz.library.model.impl.LibraryImpl;
import com.jsanz.library.model.impl.LibraryModelImpl;
import com.jsanz.library.service.persistence.LibraryPersistence;
import com.jsanz.library.service.persistence.impl.constants.JAVIPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.sql.Timestamp;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the library service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LibraryPersistence.class)
public class LibraryPersistenceImpl
	extends BasePersistenceImpl<Library> implements LibraryPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LibraryUtil</code> to access the library persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LibraryImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the libraries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching libraries
	 */
	@Override
	public List<Library> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Library> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<Library> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<Library> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Library> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Library> list = null;

		if (useFinderCache) {
			list = (List<Library>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Library library : list) {
					if (!uuid.equals(library.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LIBRARY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LibraryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Library>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByUuid_First(
			String uuid, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = fetchByUuid_First(uuid, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLibraryException(sb.toString());
	}

	/**
	 * Returns the first library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByUuid_First(
		String uuid, OrderByComparator<Library> orderByComparator) {

		List<Library> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByUuid_Last(
			String uuid, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = fetchByUuid_Last(uuid, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchLibraryException(sb.toString());
	}

	/**
	 * Returns the last library in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByUuid_Last(
		String uuid, OrderByComparator<Library> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Library> list = findByUuid(
			uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Library[] findByUuid_PrevAndNext(
			long ISBN, String uuid,
			OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		uuid = Objects.toString(uuid, "");

		Library library = findByPrimaryKey(ISBN);

		Session session = null;

		try {
			session = openSession();

			Library[] array = new LibraryImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, library, uuid, orderByComparator, true);

			array[1] = library;

			array[2] = getByUuid_PrevAndNext(
				session, library, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Library getByUuid_PrevAndNext(
		Session session, Library library, String uuid,
		OrderByComparator<Library> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIBRARY_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(library)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Library> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the libraries where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Library library :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(library);
		}
	}

	/**
	 * Returns the number of libraries where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching libraries
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIBRARY_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "library.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(library.uuid IS NULL OR library.uuid = '')";

	private FinderPath _finderPathWithPaginationFindByTitle;
	private FinderPath _finderPathWithPaginationCountByTitle;

	/**
	 * Returns all the libraries where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the matching libraries
	 */
	@Override
	public List<Library> findByTitle(String title) {
		return findByTitle(title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Library> findByTitle(String title, int start, int end) {
		return findByTitle(title, start, end, null);
	}

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
	@Override
	public List<Library> findByTitle(
		String title, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return findByTitle(title, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Library> findByTitle(
		String title, int start, int end,
		OrderByComparator<Library> orderByComparator, boolean useFinderCache) {

		title = Objects.toString(title, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByTitle;
		finderArgs = new Object[] {title, start, end, orderByComparator};

		List<Library> list = null;

		if (useFinderCache) {
			list = (List<Library>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Library library : list) {
					if (!StringUtil.wildcardMatches(
							library.getTitle(), title, '_', '%', '\\', true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LIBRARY_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LibraryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTitle) {
					queryPos.add(title);
				}

				list = (List<Library>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first library in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByTitle_First(
			String title, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = fetchByTitle_First(title, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("titleLIKE");
		sb.append(title);

		sb.append("}");

		throw new NoSuchLibraryException(sb.toString());
	}

	/**
	 * Returns the first library in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByTitle_First(
		String title, OrderByComparator<Library> orderByComparator) {

		List<Library> list = findByTitle(title, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last library in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByTitle_Last(
			String title, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = fetchByTitle_Last(title, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("titleLIKE");
		sb.append(title);

		sb.append("}");

		throw new NoSuchLibraryException(sb.toString());
	}

	/**
	 * Returns the last library in the ordered set where title LIKE &#63;.
	 *
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByTitle_Last(
		String title, OrderByComparator<Library> orderByComparator) {

		int count = countByTitle(title);

		if (count == 0) {
			return null;
		}

		List<Library> list = findByTitle(
			title, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where title LIKE &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param title the title
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library[] findByTitle_PrevAndNext(
			long ISBN, String title,
			OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		title = Objects.toString(title, "");

		Library library = findByPrimaryKey(ISBN);

		Session session = null;

		try {
			session = openSession();

			Library[] array = new LibraryImpl[3];

			array[0] = getByTitle_PrevAndNext(
				session, library, title, orderByComparator, true);

			array[1] = library;

			array[2] = getByTitle_PrevAndNext(
				session, library, title, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Library getByTitle_PrevAndNext(
		Session session, Library library, String title,
		OrderByComparator<Library> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIBRARY_WHERE);

		boolean bindTitle = false;

		if (title.isEmpty()) {
			sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
		}
		else {
			bindTitle = true;

			sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindTitle) {
			queryPos.add(title);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(library)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Library> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the libraries where title LIKE &#63; from the database.
	 *
	 * @param title the title
	 */
	@Override
	public void removeByTitle(String title) {
		for (Library library :
				findByTitle(
					title, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(library);
		}
	}

	/**
	 * Returns the number of libraries where title LIKE &#63;.
	 *
	 * @param title the title
	 * @return the number of matching libraries
	 */
	@Override
	public int countByTitle(String title) {
		title = Objects.toString(title, "");

		FinderPath finderPath = _finderPathWithPaginationCountByTitle;

		Object[] finderArgs = new Object[] {title};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIBRARY_WHERE);

			boolean bindTitle = false;

			if (title.isEmpty()) {
				sb.append(_FINDER_COLUMN_TITLE_TITLE_3);
			}
			else {
				bindTitle = true;

				sb.append(_FINDER_COLUMN_TITLE_TITLE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindTitle) {
					queryPos.add(title);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TITLE_TITLE_2 =
		"library.title LIKE ?";

	private static final String _FINDER_COLUMN_TITLE_TITLE_3 =
		"(library.title IS NULL OR library.title LIKE '')";

	private FinderPath _finderPathWithPaginationFindByWriter;
	private FinderPath _finderPathWithPaginationCountByWriter;

	/**
	 * Returns all the libraries where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the matching libraries
	 */
	@Override
	public List<Library> findByWriter(String writer) {
		return findByWriter(writer, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Library> findByWriter(String writer, int start, int end) {
		return findByWriter(writer, start, end, null);
	}

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
	@Override
	public List<Library> findByWriter(
		String writer, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return findByWriter(writer, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Library> findByWriter(
		String writer, int start, int end,
		OrderByComparator<Library> orderByComparator, boolean useFinderCache) {

		writer = Objects.toString(writer, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByWriter;
		finderArgs = new Object[] {writer, start, end, orderByComparator};

		List<Library> list = null;

		if (useFinderCache) {
			list = (List<Library>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Library library : list) {
					if (!StringUtil.wildcardMatches(
							library.getWriter(), writer, '_', '%', '\\',
							true)) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LIBRARY_WHERE);

			boolean bindWriter = false;

			if (writer.isEmpty()) {
				sb.append(_FINDER_COLUMN_WRITER_WRITER_3);
			}
			else {
				bindWriter = true;

				sb.append(_FINDER_COLUMN_WRITER_WRITER_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LibraryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWriter) {
					queryPos.add(writer);
				}

				list = (List<Library>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first library in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByWriter_First(
			String writer, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = fetchByWriter_First(writer, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("writerLIKE");
		sb.append(writer);

		sb.append("}");

		throw new NoSuchLibraryException(sb.toString());
	}

	/**
	 * Returns the first library in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByWriter_First(
		String writer, OrderByComparator<Library> orderByComparator) {

		List<Library> list = findByWriter(writer, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last library in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByWriter_Last(
			String writer, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = fetchByWriter_Last(writer, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("writerLIKE");
		sb.append(writer);

		sb.append("}");

		throw new NoSuchLibraryException(sb.toString());
	}

	/**
	 * Returns the last library in the ordered set where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByWriter_Last(
		String writer, OrderByComparator<Library> orderByComparator) {

		int count = countByWriter(writer);

		if (count == 0) {
			return null;
		}

		List<Library> list = findByWriter(
			writer, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where writer LIKE &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param writer the writer
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library[] findByWriter_PrevAndNext(
			long ISBN, String writer,
			OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		writer = Objects.toString(writer, "");

		Library library = findByPrimaryKey(ISBN);

		Session session = null;

		try {
			session = openSession();

			Library[] array = new LibraryImpl[3];

			array[0] = getByWriter_PrevAndNext(
				session, library, writer, orderByComparator, true);

			array[1] = library;

			array[2] = getByWriter_PrevAndNext(
				session, library, writer, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Library getByWriter_PrevAndNext(
		Session session, Library library, String writer,
		OrderByComparator<Library> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIBRARY_WHERE);

		boolean bindWriter = false;

		if (writer.isEmpty()) {
			sb.append(_FINDER_COLUMN_WRITER_WRITER_3);
		}
		else {
			bindWriter = true;

			sb.append(_FINDER_COLUMN_WRITER_WRITER_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindWriter) {
			queryPos.add(writer);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(library)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Library> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the libraries where writer LIKE &#63; from the database.
	 *
	 * @param writer the writer
	 */
	@Override
	public void removeByWriter(String writer) {
		for (Library library :
				findByWriter(
					writer, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(library);
		}
	}

	/**
	 * Returns the number of libraries where writer LIKE &#63;.
	 *
	 * @param writer the writer
	 * @return the number of matching libraries
	 */
	@Override
	public int countByWriter(String writer) {
		writer = Objects.toString(writer, "");

		FinderPath finderPath = _finderPathWithPaginationCountByWriter;

		Object[] finderArgs = new Object[] {writer};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIBRARY_WHERE);

			boolean bindWriter = false;

			if (writer.isEmpty()) {
				sb.append(_FINDER_COLUMN_WRITER_WRITER_3);
			}
			else {
				bindWriter = true;

				sb.append(_FINDER_COLUMN_WRITER_WRITER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindWriter) {
					queryPos.add(writer);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_WRITER_WRITER_2 =
		"library.writer LIKE ?";

	private static final String _FINDER_COLUMN_WRITER_WRITER_3 =
		"(library.writer IS NULL OR library.writer LIKE '')";

	private FinderPath _finderPathWithPaginationFindByPublication;
	private FinderPath _finderPathWithoutPaginationFindByPublication;
	private FinderPath _finderPathCountByPublication;

	/**
	 * Returns all the libraries where publication = &#63;.
	 *
	 * @param publication the publication
	 * @return the matching libraries
	 */
	@Override
	public List<Library> findByPublication(Date publication) {
		return findByPublication(
			publication, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Library> findByPublication(
		Date publication, int start, int end) {

		return findByPublication(publication, start, end, null);
	}

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
	@Override
	public List<Library> findByPublication(
		Date publication, int start, int end,
		OrderByComparator<Library> orderByComparator) {

		return findByPublication(
			publication, start, end, orderByComparator, true);
	}

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
	@Override
	public List<Library> findByPublication(
		Date publication, int start, int end,
		OrderByComparator<Library> orderByComparator, boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByPublication;
				finderArgs = new Object[] {_getTime(publication)};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByPublication;
			finderArgs = new Object[] {
				_getTime(publication), start, end, orderByComparator
			};
		}

		List<Library> list = null;

		if (useFinderCache) {
			list = (List<Library>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Library library : list) {
					if (!Objects.equals(
							publication, library.getPublication())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_LIBRARY_WHERE);

			boolean bindPublication = false;

			if (publication == null) {
				sb.append(_FINDER_COLUMN_PUBLICATION_PUBLICATION_1);
			}
			else {
				bindPublication = true;

				sb.append(_FINDER_COLUMN_PUBLICATION_PUBLICATION_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(LibraryModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublication) {
					queryPos.add(new Timestamp(publication.getTime()));
				}

				list = (List<Library>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first library in the ordered set where publication = &#63;.
	 *
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByPublication_First(
			Date publication, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = fetchByPublication_First(
			publication, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publication=");
		sb.append(publication);

		sb.append("}");

		throw new NoSuchLibraryException(sb.toString());
	}

	/**
	 * Returns the first library in the ordered set where publication = &#63;.
	 *
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByPublication_First(
		Date publication, OrderByComparator<Library> orderByComparator) {

		List<Library> list = findByPublication(
			publication, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last library in the ordered set where publication = &#63;.
	 *
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library
	 * @throws NoSuchLibraryException if a matching library could not be found
	 */
	@Override
	public Library findByPublication_Last(
			Date publication, OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = fetchByPublication_Last(
			publication, orderByComparator);

		if (library != null) {
			return library;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("publication=");
		sb.append(publication);

		sb.append("}");

		throw new NoSuchLibraryException(sb.toString());
	}

	/**
	 * Returns the last library in the ordered set where publication = &#63;.
	 *
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching library, or <code>null</code> if a matching library could not be found
	 */
	@Override
	public Library fetchByPublication_Last(
		Date publication, OrderByComparator<Library> orderByComparator) {

		int count = countByPublication(publication);

		if (count == 0) {
			return null;
		}

		List<Library> list = findByPublication(
			publication, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the libraries before and after the current library in the ordered set where publication = &#63;.
	 *
	 * @param ISBN the primary key of the current library
	 * @param publication the publication
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library[] findByPublication_PrevAndNext(
			long ISBN, Date publication,
			OrderByComparator<Library> orderByComparator)
		throws NoSuchLibraryException {

		Library library = findByPrimaryKey(ISBN);

		Session session = null;

		try {
			session = openSession();

			Library[] array = new LibraryImpl[3];

			array[0] = getByPublication_PrevAndNext(
				session, library, publication, orderByComparator, true);

			array[1] = library;

			array[2] = getByPublication_PrevAndNext(
				session, library, publication, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Library getByPublication_PrevAndNext(
		Session session, Library library, Date publication,
		OrderByComparator<Library> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_LIBRARY_WHERE);

		boolean bindPublication = false;

		if (publication == null) {
			sb.append(_FINDER_COLUMN_PUBLICATION_PUBLICATION_1);
		}
		else {
			bindPublication = true;

			sb.append(_FINDER_COLUMN_PUBLICATION_PUBLICATION_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(LibraryModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindPublication) {
			queryPos.add(new Timestamp(publication.getTime()));
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(library)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Library> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the libraries where publication = &#63; from the database.
	 *
	 * @param publication the publication
	 */
	@Override
	public void removeByPublication(Date publication) {
		for (Library library :
				findByPublication(
					publication, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(library);
		}
	}

	/**
	 * Returns the number of libraries where publication = &#63;.
	 *
	 * @param publication the publication
	 * @return the number of matching libraries
	 */
	@Override
	public int countByPublication(Date publication) {
		FinderPath finderPath = _finderPathCountByPublication;

		Object[] finderArgs = new Object[] {_getTime(publication)};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LIBRARY_WHERE);

			boolean bindPublication = false;

			if (publication == null) {
				sb.append(_FINDER_COLUMN_PUBLICATION_PUBLICATION_1);
			}
			else {
				bindPublication = true;

				sb.append(_FINDER_COLUMN_PUBLICATION_PUBLICATION_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindPublication) {
					queryPos.add(new Timestamp(publication.getTime()));
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PUBLICATION_PUBLICATION_1 =
		"library.publication IS NULL";

	private static final String _FINDER_COLUMN_PUBLICATION_PUBLICATION_2 =
		"library.publication = ?";

	public LibraryPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Library.class);

		setModelImplClass(LibraryImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the library in the entity cache if it is enabled.
	 *
	 * @param library the library
	 */
	@Override
	public void cacheResult(Library library) {
		entityCache.putResult(
			LibraryImpl.class, library.getPrimaryKey(), library);

		library.resetOriginalValues();
	}

	/**
	 * Caches the libraries in the entity cache if it is enabled.
	 *
	 * @param libraries the libraries
	 */
	@Override
	public void cacheResult(List<Library> libraries) {
		for (Library library : libraries) {
			if (entityCache.getResult(
					LibraryImpl.class, library.getPrimaryKey()) == null) {

				cacheResult(library);
			}
			else {
				library.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all libraries.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(LibraryImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the library.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Library library) {
		entityCache.removeResult(LibraryImpl.class, library.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Library> libraries) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Library library : libraries) {
			entityCache.removeResult(
				LibraryImpl.class, library.getPrimaryKey());
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(LibraryImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new library with the primary key. Does not add the library to the database.
	 *
	 * @param ISBN the primary key for the new library
	 * @return the new library
	 */
	@Override
	public Library create(long ISBN) {
		Library library = new LibraryImpl();

		library.setNew(true);
		library.setPrimaryKey(ISBN);

		String uuid = PortalUUIDUtil.generate();

		library.setUuid(uuid);

		return library;
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library that was removed
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library remove(long ISBN) throws NoSuchLibraryException {
		return remove((Serializable)ISBN);
	}

	/**
	 * Removes the library with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library that was removed
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library remove(Serializable primaryKey)
		throws NoSuchLibraryException {

		Session session = null;

		try {
			session = openSession();

			Library library = (Library)session.get(
				LibraryImpl.class, primaryKey);

			if (library == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLibraryException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(library);
		}
		catch (NoSuchLibraryException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Library removeImpl(Library library) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(library)) {
				library = (Library)session.get(
					LibraryImpl.class, library.getPrimaryKeyObj());
			}

			if (library != null) {
				session.delete(library);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (library != null) {
			clearCache(library);
		}

		return library;
	}

	@Override
	public Library updateImpl(Library library) {
		boolean isNew = library.isNew();

		if (!(library instanceof LibraryModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(library.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(library);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in library proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Library implementation " +
					library.getClass());
		}

		LibraryModelImpl libraryModelImpl = (LibraryModelImpl)library;

		if (Validator.isNull(library.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			library.setUuid(uuid);
		}

		Session session = null;

		try {
			session = openSession();

			if (library.isNew()) {
				session.save(library);

				library.setNew(false);
			}
			else {
				library = (Library)session.merge(library);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			Object[] args = new Object[] {libraryModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {libraryModelImpl.getPublication()};

			finderCache.removeResult(_finderPathCountByPublication, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByPublication, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((libraryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					libraryModelImpl.getOriginalUuid()
				};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {libraryModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((libraryModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByPublication.
					 getColumnBitmask()) != 0) {

				Object[] args = new Object[] {
					libraryModelImpl.getOriginalPublication()
				};

				finderCache.removeResult(_finderPathCountByPublication, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPublication, args);

				args = new Object[] {libraryModelImpl.getPublication()};

				finderCache.removeResult(_finderPathCountByPublication, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByPublication, args);
			}
		}

		entityCache.putResult(
			LibraryImpl.class, library.getPrimaryKey(), library, false);

		library.resetOriginalValues();

		return library;
	}

	/**
	 * Returns the library with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the library
	 * @return the library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLibraryException {

		Library library = fetchByPrimaryKey(primaryKey);

		if (library == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLibraryException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return library;
	}

	/**
	 * Returns the library with the primary key or throws a <code>NoSuchLibraryException</code> if it could not be found.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library
	 * @throws NoSuchLibraryException if a library with the primary key could not be found
	 */
	@Override
	public Library findByPrimaryKey(long ISBN) throws NoSuchLibraryException {
		return findByPrimaryKey((Serializable)ISBN);
	}

	/**
	 * Returns the library with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ISBN the primary key of the library
	 * @return the library, or <code>null</code> if a library with the primary key could not be found
	 */
	@Override
	public Library fetchByPrimaryKey(long ISBN) {
		return fetchByPrimaryKey((Serializable)ISBN);
	}

	/**
	 * Returns all the libraries.
	 *
	 * @return the libraries
	 */
	@Override
	public List<Library> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Library> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Library> findAll(
		int start, int end, OrderByComparator<Library> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Library> findAll(
		int start, int end, OrderByComparator<Library> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Library> list = null;

		if (useFinderCache) {
			list = (List<Library>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LIBRARY);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LIBRARY;

				sql = sql.concat(LibraryModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Library>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the libraries from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Library library : findAll()) {
			remove(library);
		}
	}

	/**
	 * Returns the number of libraries.
	 *
	 * @return the number of libraries
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LIBRARY);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ISBN";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LIBRARY;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LibraryModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the library persistence.
	 */
	@Activate
	public void activate() {
		_finderPathWithPaginationFindAll = new FinderPath(
			LibraryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			LibraryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);

		_finderPathCountAll = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			LibraryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			LibraryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByUuid", new String[] {String.class.getName()},
			LibraryModelImpl.UUID_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByUuid", new String[] {String.class.getName()});

		_finderPathWithPaginationFindByTitle = new FinderPath(
			LibraryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTitle",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByTitle = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByTitle",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByWriter = new FinderPath(
			LibraryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByWriter",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByWriter = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByWriter",
			new String[] {String.class.getName()});

		_finderPathWithPaginationFindByPublication = new FinderPath(
			LibraryImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByPublication",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByPublication = new FinderPath(
			LibraryImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByPublication", new String[] {Date.class.getName()},
			LibraryModelImpl.PUBLICATION_COLUMN_BITMASK);

		_finderPathCountByPublication = new FinderPath(
			Long.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByPublication", new String[] {Date.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(LibraryImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = JAVIPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = JAVIPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = JAVIPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_LIBRARY =
		"SELECT library FROM Library library";

	private static final String _SQL_SELECT_LIBRARY_WHERE =
		"SELECT library FROM Library library WHERE ";

	private static final String _SQL_COUNT_LIBRARY =
		"SELECT COUNT(library) FROM Library library";

	private static final String _SQL_COUNT_LIBRARY_WHERE =
		"SELECT COUNT(library) FROM Library library WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "library.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Library exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Library exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LibraryPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid"});

	static {
		try {
			Class.forName(JAVIPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}