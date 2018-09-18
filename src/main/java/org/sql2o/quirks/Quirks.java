package org.sql2o.quirks;

import org.sql2o.converters.Converter;

import java.io.InputStream;
import java.sql.*;
import java.util.Map;
import java.util.UUID;

/**
 * Interface for JDBC driver specific quirks.
 * See {@link NoQuirks} for defaults.
 *
 * @author aldenquimby@gmail.com
 * @since 4/6/14
 */
public interface Quirks {

    /**
     * @param ofClass
     * @param <E>
     * @return converter for class
     */
    <E> Converter<E> converterOf(Class<E> ofClass);

    void addConverter(Class<?> type, Converter<?> converter);

    /**
     * @return name of column at index {@code colIdx} for result set {@code meta}
     */
    String getColumnName(ResultSetMetaData meta, int colIdx) throws SQLException;

    /**
     * @return true if queries should return generated keys by default, false otherwise
     */
    boolean returnGeneratedKeysByDefault();

    void setParameter(PreparedStatement statement, int paramIdx, Object value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, InputStream value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, int value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, Integer value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, long value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, Long value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, String value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, Timestamp value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, Time value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, boolean value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, Boolean value) throws SQLException;
    void setParameter(PreparedStatement statement, int paramIdx, UUID value) throws SQLException;

    Object getRSVal(ResultSet rs, int idx) throws SQLException;

    void closeStatement(Statement statement) throws SQLException;

}
