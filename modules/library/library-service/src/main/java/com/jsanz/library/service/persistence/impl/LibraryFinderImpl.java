package com.jsanz.library.service.persistence.impl;



import java.util.ArrayList;
import java.util.List;

import com.jsanz.library.model.Library;
import com.jsanz.library.model.impl.LibraryImpl;
import com.jsanz.library.service.persistence.LibraryFinder;
import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


@Component(service = LibraryFinder.class)
public class LibraryFinderImpl extends LibraryFinderBaseImpl implements LibraryFinder {
    @Reference
    private CustomSQL customSQL;

    public static final String FIND_BY_ALL =
    LibraryFinder.class.getName() +
        ".findByAll";

        

    @Override
    public List<Library> findByAll(String query) {
        Session session = null;
        try {
            session = openSession();
            String sql = customSQL.get(getClass() ,FIND_BY_ALL);
            SQLQuery q = session.createSQLQuery(sql);
            q.setCacheable(false);
            q.addEntity("JAVI_Library", LibraryImpl.class);

            QueryPos qPos = QueryPos.getInstance(q);
            qPos.add(query);
            qPos.add(query);
            qPos.add(query);
            qPos.add(query);
    


            List<Library> result = (List<Library>) q.list();
            return result;
        }
        catch (Exception e) {
            try {
                throw new SystemException(e);
            }
            catch (SystemException se) {
                se.printStackTrace();
            }
        }
        finally {
            closeSession(session);
        }
    
        return null;
    }


}
