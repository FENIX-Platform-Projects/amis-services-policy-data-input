package org.fao.fenix.amis.policy.dao.jdbc;


import org.fao.fenix.amis.policy.dao.jdbc.entities.cpl.CplDb;
import org.fao.fenix.amis.policy.dto.full.Cpl;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fabrizio on 5/6/14.
 */
public class CplDB_Test {

    static CplDb dao = null;


    public static void main(String[] args) {

        dao = new CplDb();
        retrieve_test();
        retrieveAll_test();

        Cpl firstCpl = new Cpl(1000013, null, 1, 1, null, 1, null, 1, null, 0, null, 1, null, 1, null, 1, null, 1, null, 1, null);

        Cpl updateCpl = new Cpl(1000013, null, 1, 2, null, 1, null, 1, null, 0, null, 1, null, 1, null, 1, null, 1, null, 1, null);


        insert(firstCpl);
        update(updateCpl);
        remove(1000013);
    }


    public static void retrieve_test() {

        int id = 1;

        Cpl Cpl = dao.retrieve(id);
        System.out.println(Cpl.equals(null));

    }


    public static void retrieveAll_test() {

        List<Cpl> commodities = dao.retrieveAll();
        System.out.println(commodities.size() > 1);
    }

    public static void insert(Cpl Cpl) {

        try {
            Cpl oldCpl = dao.insert(Cpl);
            System.out.println(oldCpl.getCplId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(Cpl Cpl) {

        try {
            Cpl oldCpl = dao.updateRecordToTable(Cpl);
            System.out.println(oldCpl.getCplId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void remove(int id) {
        Cpl Cpl = dao.delete(id);
        System.out.println("DELETE " + Cpl.getCplId());
    }


}

