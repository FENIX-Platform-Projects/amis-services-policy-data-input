package org.fao.fenix.amis.policy.dao.jdbc;

import org.fao.fenix.amis.policy.dao.jdbc.entities.sharedGroup.SharedGroupDb;
import org.fao.fenix.amis.policy.dto.full.SharedGroup;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fabrizio on 5/6/14.
 */
public class SharedGroupDB_Test {

    static SharedGroupDb dao = null;


    public static void main(String[] args) {
        dao = new SharedGroupDb();
        retrieve_test();
        retrieveAll_test();

        SharedGroup firstSharedGroup = new SharedGroup(1000013, 23213, null, null, null);

        SharedGroup updateSharedGroup = new SharedGroup(1000013, 23213, null, null, null);

        insert(firstSharedGroup);
        update(updateSharedGroup);
        remove(23213);
    }


    public static void retrieve_test() {

        int id = 8;

        SharedGroup sharedGroup = dao.retrieve(id);
        System.out.println(sharedGroup.getIdSingle());

    }


    public static void retrieveAll_test() {

        List<SharedGroup> sharedGroups = dao.retrieveAll();
        System.out.println(sharedGroups.size() > 1);
    }


    public static void insert(SharedGroup SharedGroup) {

        try {
            SharedGroup oldSharedGroup = dao.insert(SharedGroup);
            System.out.println(oldSharedGroup.getIdSingle());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(SharedGroup SharedGroup) {

        try {
            SharedGroup oldSharedGroup = dao.updateRecordToTable(SharedGroup);
            System.out.println(oldSharedGroup.getIdSingle());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void remove(int id) {
        SharedGroup sharedGroup = dao.delete(id);
        System.out.println("DELETE " + sharedGroup.getIdSingle());
    }


}