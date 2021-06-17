package com.jsanz.rest.library.application;

import com.jsanz.library.model.Library;
import com.jsanz.library.service.LibraryLocalService;
import com.jsanz.library.service.LibraryService;
import com.jsanz.rest.library.model.LibraryDTO;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.jaxrs.whiteboard.JaxrsWhiteboardConstants;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
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

    private Library generateSBObject(LibraryDTO book) {
        Library bookToReturn = libraryLocalService.createLibrary(book.getISBN());
        bookToReturn.setTitle(book.getTitle() != null ? book.getTitle() : "");
        bookToReturn.setWriter(book.getWriter() != null ? book.getWriter() : "");
        bookToReturn.setPublication(book.getPublication() != null ? book.getPublication() : new Date());
        return bookToReturn;
    }

}