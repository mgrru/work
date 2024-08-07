package com.ru;

import java.sql.Timestamp;

import com.ru.dao.AccountDao;
import com.ru.dao.PetDao;
import com.ru.dao.impl.MasterDaoImpl;
import com.ru.dao.impl.PetDaoImpl;
import com.ru.dao.impl.ShopDaoImpl;
import com.ru.entity.Account;
import com.ru.entity.Master;
import com.ru.entity.Pet;
import com.ru.entity.Shop;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Account master = new Master(0, "null", "", 0);
        System.out.println("Hello World!" + master);

        Shop shop = new Shop(0, "null", "", 0);
        Pet pet = new Pet(2, 1, 0, "dog1", "dog", 100, 50, new Timestamp(1000));

        PetDao pet_dao = new PetDaoImpl();
        AccountDao master_dao = new MasterDaoImpl();
        AccountDao shop_dao = new ShopDaoImpl();

        master_dao.add(master);
        shop_dao.add(shop);
        pet_dao.add(pet);

        master_dao.get_all().forEach(System.out::println);
        
    }
}
