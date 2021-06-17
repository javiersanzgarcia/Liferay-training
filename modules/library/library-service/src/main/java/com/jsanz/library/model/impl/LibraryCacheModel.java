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

package com.jsanz.library.model.impl;

import com.jsanz.library.model.Library;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Library in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LibraryCacheModel implements CacheModel<Library>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LibraryCacheModel)) {
			return false;
		}

		LibraryCacheModel libraryCacheModel = (LibraryCacheModel)object;

		if (ISBN == libraryCacheModel.ISBN) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, ISBN);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ISBN=");
		sb.append(ISBN);
		sb.append(", title=");
		sb.append(title);
		sb.append(", writer=");
		sb.append(writer);
		sb.append(", publication=");
		sb.append(publication);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Library toEntityModel() {
		LibraryImpl libraryImpl = new LibraryImpl();

		if (uuid == null) {
			libraryImpl.setUuid("");
		}
		else {
			libraryImpl.setUuid(uuid);
		}

		libraryImpl.setISBN(ISBN);

		if (title == null) {
			libraryImpl.setTitle("");
		}
		else {
			libraryImpl.setTitle(title);
		}

		if (writer == null) {
			libraryImpl.setWriter("");
		}
		else {
			libraryImpl.setWriter(writer);
		}

		if (publication == Long.MIN_VALUE) {
			libraryImpl.setPublication(null);
		}
		else {
			libraryImpl.setPublication(new Date(publication));
		}

		libraryImpl.resetOriginalValues();

		return libraryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		ISBN = objectInput.readLong();
		title = objectInput.readUTF();
		writer = objectInput.readUTF();
		publication = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(ISBN);

		if (title == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (writer == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(writer);
		}

		objectOutput.writeLong(publication);
	}

	public String uuid;

	public long ISBN;

	public String title;
	public String writer;
	public long publication;

}