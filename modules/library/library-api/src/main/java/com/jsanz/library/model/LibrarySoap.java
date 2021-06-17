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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.jsanz.library.service.http.LibraryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class LibrarySoap implements Serializable {

	public static LibrarySoap toSoapModel(Library model) {
		LibrarySoap soapModel = new LibrarySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setISBN(model.getISBN());
		soapModel.setTitle(model.getTitle());
		soapModel.setWriter(model.getWriter());
		soapModel.setPublication(model.getPublication());

		return soapModel;
	}

	public static LibrarySoap[] toSoapModels(Library[] models) {
		LibrarySoap[] soapModels = new LibrarySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LibrarySoap[][] toSoapModels(Library[][] models) {
		LibrarySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LibrarySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LibrarySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LibrarySoap[] toSoapModels(List<Library> models) {
		List<LibrarySoap> soapModels = new ArrayList<LibrarySoap>(
			models.size());

		for (Library model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LibrarySoap[soapModels.size()]);
	}

	public LibrarySoap() {
	}

	public long getPrimaryKey() {
		return _ISBN;
	}

	public void setPrimaryKey(long pk) {
		setISBN(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getISBN() {
		return _ISBN;
	}

	public void setISBN(long ISBN) {
		_ISBN = ISBN;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getWriter() {
		return _writer;
	}

	public void setWriter(String writer) {
		_writer = writer;
	}

	public Date getPublication() {
		return _publication;
	}

	public void setPublication(Date publication) {
		_publication = publication;
	}

	private String _uuid;

	private long _ISBN;

	private String _title;
	private String _writer;
	private Date _publication;

}