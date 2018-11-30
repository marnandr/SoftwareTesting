package hu.uni.miskolc.iit.impl;

import hu.uni.miskolc.iit.dao.AdministratorServiceDao;

import java.lang.String;
import hu.uni.miskolc.iit.persist.AbstractJdbc;
import hu.uni.miskolc.iit.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import java.util.Properties;

import java.sql.ResultSet;
import java.sql.SQLException;




import java.util.HashMap;

public class RequestServiceImpl extends AbstractJdbc implements RequestService {

    /**
     * Returns a hash code value for the object. This method is
     * supported for the benefit of hash tables such as those provided by
     * {@link HashMap}.
     * <p>
     * The general contract of {@code hashCode} is:
     * <ul>
     * <li>Whenever it is invoked on the same object more than once during
     * an execution of a Java application, the {@code hashCode} method
     * must consistently return the same integer, provided no information
     * used in {@code equals} comparisons on the object is modified.
     * This integer need not remain consistent from one execution of an
     * application to another execution of the same application.
     * <li>If two objects are equal according to the {@code equals(Object)}
     * method, then calling the {@code hashCode} method on each of
     * the two objects must produce the same integer result.
     * <li>It is <em>not</em> required that if two objects are unequal
     * according to the {@link Object#equals(Object)}
     * method, then calling the {@code hashCode} method on each of the
     * two objects must produce distinct integer results.  However, the
     * programmer should be aware that producing distinct integer results
     * for unequal objects may improve the performance of hash tables.
     * </ul>
     * <p>
     * As much as is reasonably practical, the hashCode method defined by
     * class {@code Object} does return distinct integers for distinct
     * objects. (This is typically implemented by converting the internal
     * address of the object into an integer, but this implementation
     * technique is not required by the
     * Java&trade; programming language.)
     *
     * @return a hash code value for this object.
     * @see Object#equals(Object)
     * @see System#identityHashCode
     */

    @Autowired
    @Qualifier(value = "requestServiceDao")
    private Properties sqlStatements;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean requestCreate(int TeacherID, String course) {
        return false;
    }

    @Override
    public boolean checkRequstStatus(int RequestID) {
        String sql = sqlStatements.getProperty("select.requeststatus");
        String tmp = getJdbc().query(sql,  new AdministratorServiceDaoImpl.AdministratorRequestMapper());
        return;
}
