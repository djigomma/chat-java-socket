package sn.groupeisi;

import sn.groupeisi.config.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory();
    }
}