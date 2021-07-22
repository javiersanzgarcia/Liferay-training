package com.jsanz.rest.library.application;

import com.jsanz.library.model.Library;
import com.jsanz.library.service.LibraryLocalService;
import com.jsanz.library.service.LibraryLocalServiceUtil;
import com.jsanz.library.service.LibraryService;
import com.jsanz.rest.library.model.LibraryDTO;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.portlet.PortletClassLoaderUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Request;

import java.util.*;

/**
 * @author pracker
 */
@Component(
        property = {
                JaxrsWhiteboardConstants.JAX_RS_APPLICATION_BASE + "=/library",
                JaxrsWhiteboardConstants.JAX_RS_NAME + "=Library.Rest"
        },
        service = Application.class
)
public class RestLibraryApplication extends Application {

    // Register the service as osgi module
    public Set<Object> getSingletons() {
        return Collections.singleton(this);
    }
    
    @Reference
    LibraryLocalService libraryLocalService;

    @Reference
    LibraryService libraryService;

    // http://localhost/o/rest/library/getAll
    @GET
    @Path("/getAll")
    @Produces("application/json")
    public List<LibraryDTO> getAll() {
        List<LibraryDTO> books = new ArrayList<>();
        List<Library> booksSB = libraryLocalService.getAll();
        for (Library library : booksSB) {
            LibraryDTO book = new LibraryDTO(library);
            books.add(book);
        }
        return books;
    }

    @POST
    @Produces("application/json")
    public LibraryDTO save(LibraryDTO request) {
        Library library = generateSBObject(request);
        // System.out.println("Store in the database: " + library.toString());
        Library newBook = libraryService.save(library);
        // System.out.println("Stored" + newBook.toString());
        return new LibraryDTO(newBook);

    }

    @DELETE
    @Produces("application/json")
    public LibraryDTO remove(LibraryDTO request) {
        Library library = generateSBObject(request);
        Library deleteBook = libraryService.remove(library);
        return new LibraryDTO(deleteBook);

    }
    
    @PUT
    @Path("/update")
    @Produces("application/json")
    public LibraryDTO update(LibraryDTO request) {
    	Library library = generateSBObject(request);
    	Library updateBook = libraryService.update(library);
    	return new LibraryDTO(updateBook);
    }
    
    
    @GET
    @Path("/search?query={query}")
    @Produces("application/json")
    public List<LibraryDTO> search(@PathParam("query") String query)
    {
    	DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(LibraryDTO.class, "lib", PortletClassLoaderUtil.getClassLoader());
    	
    	dynamicQuery.add(RestrictionsFactoryUtil.or(
    			RestrictionsFactoryUtil.like("lib.ISBN", "%" + query + "%"), 
    			RestrictionsFactoryUtil.or(
    					RestrictionsFactoryUtil.like("lib.title", "%" + query + "%"),
    					RestrictionsFactoryUtil.or(
    							RestrictionsFactoryUtil.like("lib.publication", "%" + query + "%"), 
    							RestrictionsFactoryUtil.like("lib.writer", "%" + query + "%")))));
    	    	
    	List<LibraryDTO> foundBooks = LibraryLocalServiceUtil.dynamicQuery(dynamicQuery);
    	return foundBooks;
    }
    
    @GET
    @Path("/getPermissions?userId={userId}")
    @Produces("application/json")
    public List<String> getPermissions(@PathParam("userId") long userId)
    {
    	List<Role> userRoles = RoleLocalServiceUtil.getUserRoles(userId);
    	List<String> roleNames = new ArrayList<>();
    	for (Role role : userRoles)
    	{
    		roleNames.add(role.getName());
    	}
    	return roleNames;
    }
    
    
    private Library generateSBObject(LibraryDTO book) {
        Library bookToReturn = libraryLocalService.createLibrary(book.getISBN());
        bookToReturn.setTitle(book.getTitle() != null ? book.getTitle() : "");
        bookToReturn.setWriter(book.getWriter() != null ? book.getWriter() : "");
        bookToReturn.setPublication(book.getPublication() != null ? book.getPublication() : new Date());
        return bookToReturn;
    }

}