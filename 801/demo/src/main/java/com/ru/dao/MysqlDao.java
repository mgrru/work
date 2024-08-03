package com.ru.dao;

import java.sql.*;

public class MysqlDao {
  private String driver = "com.mysql.cj.jdbc.Driver";
  private String url = "jdbc:mysql://localhost:3306/pet?useUnicode=true&characterEncoding=UTF-8&useSSL=false&serverTimezone=Asia/Shanghai";
  private String name = "root";
  private String password = "123";
  private Connection connection = null;

  /**
   * 获取数据库连接
   * 
   * @return
   */
  public Connection getConnection() {
    if (connection == null) {
      try {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, name, password);
      } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
      }
    }
    return connection;// 返回连接对象
  }

  /**
   * 关闭数据库连接
   * 
   * @param connection 数据库连接
   * @param statement  请求对象
   * @param resultSet  结果集
   */
  public void closeAll(Connection connection, Statement statement, ResultSet resultSet) {
    if (resultSet != null) {
      try {
        resultSet.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (statement != null) {
      try {
        statement.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
    if (connection != null) {
      try {
        connection.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * 增、删、改的操作
   * 
   * @param sql   SQL语句
   * @param param 参数的字符串数组
   * @return 影响的行数
   */
  public int executeUpdate(String sql, Object[] param) {
    PreparedStatement statement = null;
    int num = 0;
    connection = getConnection();
    try {
      statement = connection.prepareStatement(sql);
      if (param != null) {
        for (int i = 0; i < param.length; i++) {
          statement.setObject(i + 1, param[i]);
        }
      }
      num = statement.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      closeAll(connection, statement, null);
    }
    return num;
  }
}
