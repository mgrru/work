package com.ru;

import com.ru.dao.PetDao;
import com.ru.dao.impl.PetDaoImpl;
import com.ru.entity.Account;
import com.ru.entity.Master;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Account master = new Master(1, "fufu", "123", 100);
        System.out.println("Hello World!" + master);

        PetDao pet_dao = new PetDaoImpl();
        
    }
}
