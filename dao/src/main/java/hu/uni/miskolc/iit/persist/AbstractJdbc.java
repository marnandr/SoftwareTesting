/*
 * Copyright (C) Ztar Mobile, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by armandorivas, Oct 12, 2017.
 */
package hu.uni.miskolc.iit.persist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractJdbc {
    /**
     * Logger for this class.
     */
    private static final Logger log = LoggerFactory.getLogger(AbstractJdbc.class);

    /**
     * The jdbcTemplate.
     */
    private NamedParameterJdbcTemplate jdbcTemplate;

    /**
     * Injects the dataSource.
     * 
     * @param dataSource
     *            The dataSource.
     */
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    /**
     * Gets the jdbcTemplate object.
     * 
     * @return The JDBC template object.
     */
    protected NamedParameterJdbcTemplate getJdbc() {
        return jdbcTemplate;
    }

    /**
     * Check the number of records affected.
     * 
     * @param affected
     *            The affected records.
     */
    protected void checkAffected(int affected) {
        if (affected != 1) {
            log.error("More than one record was affected by this operation: " + affected);
            throw new IllegalStateException("More than one record was affected: " + affected);
        }
    }

    /**
     * Check the number of records affected.
     * 
     * @param affected
     *            The affected records.
     * @param warn
     *            When this flag is set as true, then it just prints the logs.s
     */
    protected void checkAffected(int affected, boolean warn) {
        if (warn) {
            if (affected != 1) {
                log.warn("More than one record was affected by this operation: " + affected);
            }
        } else {
            checkAffected(affected);
        }
    }

    /**
     * Utility used to convert parameters to be executed into the DB.
     * 
     * @param list
     *            List of parameters.
     * @return The parameters.
     */
    protected Map<String, String>[] getArrayData(List<Map<String, String>> list) {
        @SuppressWarnings("unchecked")
        Map<String, String>[] maps = new HashMap[list.size()];

        Iterator<Map<String, String>> iterator = list.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Map<String, String> map = (Map<String, String>) iterator.next();
            maps[i++] = map;
        }
        return maps;
    }
}
