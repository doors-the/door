package com.construction.dao;

import com.construction.entity.TProject;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author doors
 * @Date 2021/9/6
 */
public class TProjectDao {

    //数据库url、用户名和密码
    static final String URL = "jdbc:mysql://localhost:3306/constructiondb?useSSL=true&useUnicode=true&characterEncoding=utf8";
    static final String USER = "root";
    static final String PASS = "123456";

    public static Connection getConnection() {

        Connection connection = null;

        try {
            //1、注册JDBC驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2、获取数据库连接
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }

    //查询
    public ArrayList<TProject> list() {
        ArrayList<TProject> arrayList = new ArrayList<>();
        try {
            Connection connection = getConnection();
            Statement statement = connection.createStatement();
            String sql = "select * from t_project";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) { //遍历结果集，取出数据
                TProject tProject = new TProject();

                tProject.setProjectId(resultSet.getString("Project_id"));
                tProject.setProjectName(resultSet.getString("Project_name"));
                tProject.setDeputyName(resultSet.getString("Deputy_name"));
                tProject.setTelephone(resultSet.getString("Telephone"));
                tProject.setAddr(resultSet.getString("Addr"));

                arrayList.add(tProject);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return arrayList;
    }

    //增加
    public void addTProject(TProject tProject){

        try {
            Connection connection = getConnection();
            PreparedStatement preparedStatement = null;

            String sql = "insert into t_project value (?,?,?,?,?)";

            preparedStatement =  connection.prepareStatement(sql);
            preparedStatement.setString(1,tProject.getProjectId());
            preparedStatement.setString(2,tProject.getProjectName());
            preparedStatement.setString(3,tProject.getDeputyName());
            preparedStatement.setString(4,tProject.getTelephone());
            preparedStatement.setString(5,tProject.getAddr());

            preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }

}
