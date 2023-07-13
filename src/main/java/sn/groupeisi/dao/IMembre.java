package sn.groupeisi.dao;

import sn.groupeisi.entity.Membre;

public interface IMembre extends Repo<Membre> {
    Membre findName(String clientUsername);
}
