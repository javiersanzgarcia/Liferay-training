package com.jsanz.rest.library.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;

import com.jsanz.library.model.Library;
import com.jsanz.library.service.LibraryLocalService;
import com.jsanz.library.service.LibraryService;
import com.jsanz.rest.library.model.LibraryDTO;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

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

    // http://localhost/o/rest/library/find?query=text
    @GET
    @Path("/find")
    @Produces("application/json")
    public List<LibraryDTO> find(@QueryParam("query") String search) {
        List<LibraryDTO> books = new ArrayList<>();
        List<Library> booksSB = libraryLocalService.findByAll2(search);
        for (Library library : booksSB) {
            LibraryDTO book = new LibraryDTO(library);
            books.add(book);
        }
        return books;
    }

    @GET
    @Path("/test")
    @Produces("application/json")
    public String test(@QueryParam("data") String data) {
        return "seems to be working ✅\n " + data;
    }


    // http://localhost/o/rest/library/getRoles
    @GET
    @Path("/getRoles/{userId}")
    @Produces("application/json")
    public List<String> getRoles(@PathParam("userId") String userIdString){
        System.out.println(userIdString);
        List<String> result = new ArrayList<>();
        long userId = Long.parseLong(userIdString);
        result.add(userIdString);
        List<Role> roles =  RoleLocalServiceUtil.getUserRoles(userId);
        for(Role role : roles ){
            result.add(role.getName());
        }
        return result;

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
    public String delete(LibraryDTO request) {
        Library library = generateSBObject(request);
        // System.out.println("Store in the database: " + library.toString());
        libraryService.delete(library);
        // System.out.println("Stored" + newBook.toString());
        return "ok";

    }

    @POST
    @Path("/update")
    @Produces("application/json")
    public String edit(LibraryDTO request) {
        Library library = generateSBObject(request);
        // System.out.println("Store in the database: " + library.toString());
        libraryService.update(library);
        // System.out.println("Stored" + newBook.toString());
        return "ok";

    }

    private Library generateSBObject(LibraryDTO book) {
        Library bookToReturn = libraryLocalService.createLibrary(book.getISBN());
        bookToReturn.setTitle(book.getTitle() != null ? book.getTitle() : "");
        bookToReturn.setWriter(book.getWriter() != null ? book.getWriter() : "");
        bookToReturn.setPublication(book.getPublication() != null ? book.getPublication() : new Date());
        return bookToReturn;
    }

}