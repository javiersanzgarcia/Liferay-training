/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 * <p>
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 * <p>
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.jsanz.library.service.impl;

import com.jsanz.library.model.Library;
import com.jsanz.library.service.LibraryLocalServiceUtil;
import com.jsanz.library.service.base.LibraryServiceBaseImpl;

import com.jsanz.library.service.persistence.LibraryUtil;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

import java.util.List;

/**
 * The implementation of the library remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.jsanz.library.service.LibraryService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryServiceBaseImpl
 */
@Component(
        property = {
                "json.web.service.context.name=javi",
                "json.web.service.context.path=Library"
        },
        service = AopService.class
)
public class LibraryServiceImpl extends LibraryServiceBaseImpl {
    public Library save(Library library) {
        System.out.println("Storing in the database");
        Library libraryStored = null;
        try {
            libraryStored = LibraryLocalServiceUtil.addLibrary(library);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return libraryStored;
    }
    
    public Library remove(Library library) {
    	System.out.println("Removing from the database");
    	Library libraryToRemove = null;
    	try {
    		libraryToRemove = LibraryLocalServiceUtil.deleteLibrary(library);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return libraryToRemove;
    }
    
    public Library update(Library library) {
    	System.out.println("Updating at the database");
    	Library libraryToRemove = null;
    	try {
    		libraryToRemove = LibraryLocalServiceUtil.updateLibrary(library);
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
    	return libraryToRemove;
    }
}