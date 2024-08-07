package com.ru.service;

import java.util.List;

import com.ru.entity.Bill;
import com.ru.entity.Master;
import com.ru.entity.Pet;
import com.ru.entity.Shop;

public interface BillAble {
  void checkout(Shop shop, Master master, Pet pet, int money);

  List<Bill> get_bills();
}
