package com.company;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class DbSql {
    private Connection connection;
    private Statement stmt;

    DbSql(){
        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://sqlite/students.db";
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void createStuderende() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Studerende (\n"
                + "stdnr integer PRIMARY KEY,\n"
                + "fnavn TEXT NOT NULL , "
                + "enavn TEXT NOT NULL , "
                + "adresse TEXT NOT NULL , "
                + "postnr TEXT NOT NULL , "
                + "mobil TEXT NOT NULL , "
                + "klasse TEXT NOT NULL ) ";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("The Studerende table has been created");

        stmt.close();

    }

    public void createFag() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS Fag (\n"
                + "fagnr integer PRIMARY KEY,\n"
                + "fagnavn TEXT NOT NULL ) ";


        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("The Fag table has been created");

        stmt.close();
    }

    public void createStudFag() throws SQLException {
        DbSql mysql = new DbSql();
        String sql = "CREATE TABLE IF NOT EXISTS StudFag (\n"
                + "stdnr integer NOT NULL ,\n"
                + "fagnr TEXT NOT NULL ,  PRIMARY KEY (stdnr, fagnr) )" ;


        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("The StudFag table has been created");

        stmt.close();
        mysql.connection.close();

    }

    public void indsaetstud(Studerende s) throws SQLException {
        DbSql mysql = new DbSql();
        String sql = "INSERT INTO Studerende (stdnr, fnavn, "
                + " enavn, adresse, postnr, mobil, klasse) "
                + "VALUES('" + s.getStdnr() + "', '" +
                s.getFnavn() + "', '" + s.getEnavn() + "','" +
                s.getAdresse() + "','" + s.getPostnr() + "','" +
                s.getMobil() + "','" + s.getKlasse() + "' ) ";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("Student " + s.getFnavn() + " has been added to the list");

        stmt.close();
        mysql.connection.close();
    }

    public void indsaetfag(Fag f) throws SQLException {
        DbSql mysql = new DbSql();
        String sql = "INSERT INTO Fag (fagnr, fagnavn) "
                + "VALUES('" + f.getFagnr() + "', '" + f.getFagnavn() + "' ) ";

        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("Fag " + f.getFagnavn() + " has been added to the list");

        stmt.close();
        mysql.connection.close();

    }

    public void updatestudklasse(int stdnr, String nyklasse) throws SQLException {
        DbSql mysql = new DbSql();
        String sql = "UPDATE Studerende SET klasse = '" + nyklasse + "' WHERE stdnr = " + stdnr;

        Statement stmt = connection.createStatement();
        stmt.execute(sql);

        System.out.println("Studerende med stdnr " + stdnr + " har f??et opdateret sin klasse.");

        stmt.close();
        mysql.connection.close();

    }

    public void soegstud(int stdnr) throws SQLException {
        DbSql mysql = new DbSql();
        String sql = "SELECT * FROM Studerende WHERE stdnr = " + stdnr;

        Statement stmt = connection.createStatement();
        ResultSet resultset = stmt.executeQuery(sql);

        String fnavn = resultset.getString("fnavn");
        System.out.println(fnavn);
    }

    public ArrayList<Studfag> alleOplysninger() {
        ArrayList<Studfag> tabel = new ArrayList<Studfag>();
        String sql = "SELECT * FROM Studerende " +
                "INNER JOIN studfag ON Studerende.stdnr = studfag.stdnr " +
                "INNER JOIN Fag ON studfag.fagnr = Fag.fagnr";
        try {
            Statement stat = connection.createStatement();
            ResultSet rs = stat.executeQuery(sql);

            int i = 0;
            while (rs.next()) {
                Studfag sf = new Studfag();
                sf.getS().setStdnr(rs.getInt("stdnr"));
                sf.getS().setFnavn(rs.getString("fnavn"));
                sf.getS().setEnavn(rs.getString("enavn"));
                sf.getS().setAdresse(rs.getString("adresse"));
                sf.getS().setPostnr(rs.getString("postnr"));
                sf.getS().setMobil(rs.getString("mobil"));
                sf.getS().setKlasse(rs.getString("klasse"));
                sf.getF().setFagnr(rs.getInt("fagnr"));
                sf.getF().setFagnavn(rs.getString("fagnavn"));
                tabel.add(sf);
                i++;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tabel;
    }




}
