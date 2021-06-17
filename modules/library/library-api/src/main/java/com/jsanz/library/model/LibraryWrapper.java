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

package com.jsanz.library.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Library}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Library
 * @generated
 */
public class LibraryWrapper
	extends BaseModelWrapper<Library>
	implements Library, ModelWrapper<Library> {

	public LibraryWrapper(Library library) {
		super(library);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("ISBN", getISBN());
		attributes.put("title", getTitle());
		attributes.put("writer", getWriter());
		attributes.put("publication", getPublication());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long ISBN = (Long)attributes.get("ISBN");

		if (ISBN != null) {
			setISBN(ISBN);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String writer = (String)attributes.get("writer");

		if (writer != null) {
			setWriter(writer);
		}

		Date publication = (Date)attributes.get("publication");

		if (publication != null) {
			setPublication(publication);
		}
	}

	/**
	 * Returns the isbn of this library.
	 *
	 * @return the isbn of this library
	 */
	@Override
	public long getISBN() {
		return model.getISBN();
	}

	/**
	 * Returns the primary key of this library.
	 *
	 * @return the primary key of this library
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the publication of this library.
	 *
	 * @return the publication of this library
	 */
	@Override
	public Date getPublication() {
		return model.getPublication();
	}

	/**
	 * Returns the title of this library.
	 *
	 * @return the title of this library
	 */
	@Override
	public String getTitle() {
		return model.getTitle();
	}

	/**
	 * Returns the uuid of this library.
	 *
	 * @return the uuid of this library
	 */
	@Override
	public String getUuid() {
		return model.getUuid();
	}

	/**
	 * Returns the writer of this library.
	 *
	 * @return the writer of this library
	 */
	@Override
	public String getWriter() {
		return model.getWriter();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the isbn of this library.
	 *
	 * @param ISBN the isbn of this library
	 */
	@Override
	public void setISBN(long ISBN) {
		model.setISBN(ISBN);
	}

	/**
	 * Sets the primary key of this library.
	 *
	 * @param primaryKey the primary key of this library
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the publication of this library.
	 *
	 * @param publication the publication of this library
	 */
	@Override
	public void setPublication(Date publication) {
		model.setPublication(publication);
	}

	/**
	 * Sets the title of this library.
	 *
	 * @param title the title of this library
	 */
	@Override
	public void setTitle(String title) {
		model.setTitle(title);
	}

	/**
	 * Sets the uuid of this library.
	 *
	 * @param uuid the uuid of this library
	 */
	@Override
	public void setUuid(String uuid) {
		model.setUuid(uuid);
	}

	/**
	 * Sets the writer of this library.
	 *
	 * @param writer the writer of this library
	 */
	@Override
	public void setWriter(String writer) {
		model.setWriter(writer);
	}

	@Override
	protected LibraryWrapper wrap(Library library) {
		return new LibraryWrapper(library);
	}

}