package org.kuali.db.jdbc;

import static org.apache.commons.lang.StringUtils.isNotEmpty;
import static org.kuali.db.jdbc.DatabaseType.POSTGRESQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.apache.commons.lang.Validate;

/**
 * Various JDBC related utility methods
 */
public class JDBCUtils {

    List<JDBCConfiguration> jdbcConfigs;

    /**
     * Given a database type, return the corresponding JDBC configuration
     *
     * @return JDBCConfiguration
     */

    public JDBCConfiguration getDatabaseConfiguration(final DatabaseType type) {
        for (JDBCConfiguration jdbcConfig : jdbcConfigs) {
            if (jdbcConfig.getType().equals(type)) {
                return jdbcConfig;
            }
        }
        return JDBCConfiguration.UNKNOWN_CONFIG;
    }

    /**
     * Given a JDBC url, attempt to locate the corresponding JDBCConfig object
     *
     * @param url
     * @return JDBCConfiguration
     */
    public JDBCConfiguration getDatabaseConfiguration(final String url) {
        Validate.isTrue(isNotEmpty(url));

        for (JDBCConfiguration jdbcConfig : jdbcConfigs) {
            String urlFragment = jdbcConfig.getUrlFragment();
            if (url.contains(urlFragment)) {
                return jdbcConfig;
            }
        }
        return JDBCConfiguration.UNKNOWN_CONFIG;
    }

    /**
     * Given a JDBC connection URL, extract only the database name.
     *
     * @param url
     * a JDBC connection URL
     * @return the database name
     */
    public String getDatabaseName(final String url) {
        int leftIndex = url.lastIndexOf("/");
        if (leftIndex == -1) {
            leftIndex = url.lastIndexOf(":");
        }
        leftIndex++;

        int rightIndex = url.length();
        if (url.indexOf("?") != -1) {
            rightIndex = url.indexOf("?");
        } else if (url.indexOf(";") != -1) {
            rightIndex = url.indexOf(";");
        }

        return url.substring(leftIndex, rightIndex);
    }

    /**
     * Given a JDBC connection URL, generate a new connection URL to connect directly to the database server itself (ie:
     * no database specified).
     *
     * @param url
     * a JDBC connection URL
     * @return a new JDBC connection URL to connect directly to the database server
     */
    public String getServerUrl(final String url) {
        int rightIndex = url.length();
        if (url.lastIndexOf("/") != -1) {
            rightIndex = url.lastIndexOf("/");
        } else if (url.lastIndexOf(":") != -1) {
            rightIndex = url.lastIndexOf(":");
        }

        String baseUrl = url.substring(0, rightIndex);

        // TODO This next line is nasty, but it works for nearly every postgresql server.
        // If we have to add another exception to this for another database server, then I highly recommend refactoring
        // this to a more elegant solution.
        if (POSTGRESQL.equals(getDatabaseConfiguration(url).getType())) {
            baseUrl += "/postgres";
        }

        String options = "";
        int optionsIndex = url.indexOf("?");
        if (optionsIndex == -1) {
            optionsIndex = url.indexOf(";");
        }
        if (optionsIndex != -1) {
            options = url.substring(optionsIndex);
        }

        return baseUrl + options;
    }

    public static void closeQuietly(final ResultSet rs, final Statement stmt, final Connection conn) {
        closeQuietly(rs);
        closeQuietly(stmt);
        closeQuietly(conn);
    }

    public static void closeQuietly(final Statement stmt, final Connection conn) {
        closeQuietly(null, stmt, conn);
    }

    public static void closeQuietly(final ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            rs.close();
        } catch (SQLException e) {
            // ignore
        }
    }

    public static void closeQuietly(final Statement stmt) {
        if (stmt == null) {
            return;
        }
        try {
            stmt.close();
        } catch (SQLException e) {
            // ignore
        }
    }

    public static void closeQuietly(final Connection conn) {
        if (conn == null) {
            return;
        }
        try {
            conn.close();
        } catch (SQLException e) {
            // ignore
        }
    }

    public static void rollbackQuietly(final Connection conn) {
        if (conn == null) {
            return;
        }
        try {
            conn.rollback();
        } catch (SQLException e) {
            // ignore
        }
    }

    /**
     * @return the jdbcConfigs
     */
    public List<JDBCConfiguration> getJdbcConfigs() {
        return jdbcConfigs;
    }

    /**
     * @param jdbcConfigs
     * the jdbcConfigs to set
     */
    public void setJdbcConfigs(final List<JDBCConfiguration> jdbcConfigs) {
        this.jdbcConfigs = jdbcConfigs;
    }

}
