package sn.groupeisi.dao;

import java.util.List;

public interface Repo<T> {
    public int create(T t);
    public List<T> getAll();
    public T get(int id);
}
