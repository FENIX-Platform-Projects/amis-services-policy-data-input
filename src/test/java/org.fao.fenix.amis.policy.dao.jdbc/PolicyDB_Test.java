package org.fao.fenix.amis.policy.dao.jdbc;

import org.fao.fenix.amis.policy.dao.jdbc.entities.policy.PolicyDb;
import org.fao.fenix.amis.policy.dto.full.Policy;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fabrizio on 5/6/14.
 */
public class PolicyDB_Test {

    static PolicyDb dao = null;


    public static void main(String[] args) {

        dao = new PolicyDb();
        retrieve_test();
        retrieveAll_test();

        Policy firstPolicy = new Policy(1065, 1054001, 901, 943, null, null, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null);

        Policy updatePolicy = new Policy(1066, 1054001, 901, 943, "UPDATE", null, null, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null);

        insertPolicy(firstPolicy);
        updatePolicy(updatePolicy);
        removePolicy(1065);
    }


    public static void setUpClass() throws Exception {
        Policy firstPolicy = new Policy(1065, 1054001, 901, 943, null, null, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null);
        Policy updatePolicy = new Policy(1066, 1054001, 901, 943, "UPDATE", null, null, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null);

    }


    public static void retrieve_test() {

        int id = 1;

        Policy policy = dao.retrieve(id);
        System.out.println(policy.equals(null));

    }


    public static void retrieveAll_test() {

        List<Policy> policies = dao.retrieveAll();
        System.out.println(policies.size() > 1);
    }

    public static void insertPolicy(Policy policy) {

        try {
            Policy oldPolicy = dao.insert(policy);
            System.out.println(oldPolicy.getCplId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void updatePolicy(Policy policy) {

        try {
            Policy oldPolicy = dao.updateRecordToTable(policy);
            System.out.println(oldPolicy.getCplId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void removePolicy(int id) {
        Policy policy = dao.delete(id);
        System.out.println("DELETE " + policy.getCplId());
    }


}

