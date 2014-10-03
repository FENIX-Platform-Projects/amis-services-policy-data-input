package org.fao.fenix.amis.policy.dao.jdbc;

import org.fao.fenix.amis.policy.dao.jdbc.entities.commodity.CommodityDb;
import org.fao.fenix.amis.policy.dto.full.Commodity;
import org.fao.fenix.amis.policy.dto.full.Policy;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by fabrizio on 5/6/14.
 */
public class CommodityDb_Test {

    static CommodityDb dao = null;


    public static void main(String[] args) {

        dao = new CommodityDb();
        retrieve_test();
        retrieveAll_test();

        Commodity firstCommodity = new Commodity(10000, null, null, null, null, null, null, null, null, 0, null);

        Commodity updateCommodity = new Commodity(10000, null, null, null, null, null, null, null, null, 100, null);


        insert(firstCommodity);
        update(updateCommodity);
        remove(901);
    }


    public static void setUpClass() throws Exception {
        Policy firstPolicy = new Policy(1065, 1054001, 901, 943, null, null, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null);
        Policy updatePolicy = new Policy(1066, 1054001, 901, 943, "UPDATE", null, null, null, null, null, null, null, null, null, null, null, null
                , null, null, null, null, null, null, null, null, null, null, 0, null, null, null, null, null, null, null, null);

    }


    public static void retrieve_test() {

        int id = 1;

        Commodity commodity = dao.retrieve(id);
        System.out.println(commodity.equals(null));

    }


    public static void retrieveAll_test() {

        List<Commodity> commodities = dao.retrieveAll();
        System.out.println(commodities.size() > 1);
    }

    public static void insert(Commodity commodity) {

        try {
            Commodity oldCommodity = dao.insert(commodity);
            System.out.println(oldCommodity.getCommodityId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void update(Commodity commodity) {

        try {
            Commodity oldCommodity = dao.updateRecordToTable(commodity);
            System.out.println(oldCommodity.getCommodityId());
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    public static void remove(int id) {
        Commodity commodity = dao.delete(id);
        System.out.println("DELETE " + commodity.getCommodityId());
    }


}

