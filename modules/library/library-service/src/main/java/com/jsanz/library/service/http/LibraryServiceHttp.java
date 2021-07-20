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

package com.jsanz.library.service.http;

import com.jsanz.library.service.LibraryServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>LibraryServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LibraryServiceSoap
 * @generated
 */
public class LibraryServiceHttp {

	public static com.jsanz.library.model.Library save(
		HttpPrincipal httpPrincipal, com.jsanz.library.model.Library library) {

		try {
			MethodKey methodKey = new MethodKey(
				LibraryServiceUtil.class, "save", _saveParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, library);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.jsanz.library.model.Library)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.jsanz.library.model.Library remove(
		HttpPrincipal httpPrincipal, com.jsanz.library.model.Library library) {

		try {
			MethodKey methodKey = new MethodKey(
				LibraryServiceUtil.class, "remove", _removeParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey, library);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.jsanz.library.model.Library)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.jsanz.library.model.Library update(
		HttpPrincipal httpPrincipal, com.jsanz.library.model.Library library) {

		try {
			MethodKey methodKey = new MethodKey(
				LibraryServiceUtil.class, "update", _updateParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, library);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.jsanz.library.model.Library)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(LibraryServiceHttp.class);

	private static final Class<?>[] _saveParameterTypes0 = new Class[] {
		com.jsanz.library.model.Library.class
	};
	private static final Class<?>[] _removeParameterTypes1 = new Class[] {
		com.jsanz.library.model.Library.class
	};
	private static final Class<?>[] _updateParameterTypes2 = new Class[] {
		com.jsanz.library.model.Library.class
	};

}