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

package com.jsanz.library.service.impl;

import com.jsanz.library.model.Library;
import com.jsanz.library.service.LibraryLocalService;
import com.jsanz.library.service.LibraryLocalServiceUtil;
import com.jsanz.library.service.base.LibraryLocalServiceBaseImpl;

import com.jsanz.library.service.persistence.LibraryUtil;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the library local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.jsanz.library.service.LibraryLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.jsanz.library.model.Library",
	service = AopService.class
)
public class LibraryLocalServiceImpl extends LibraryLocalServiceBaseImpl {

	public List<Library> getAll() {
		return LibraryUtil.findAll();
	}

	public List<Library> findByTitle(String title) {
		return LibraryUtil.findByTitle(title);
	}
	
	public List<Library> findByISBN(long ISBN) {
		return LibraryUtil.findByISBN(ISBN);
	}

	public List<Library> findByWriter(String writer) {
		return LibraryUtil.findByWriter(writer);
	}
}