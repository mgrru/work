package com.ru.dao;

import java.util.List;

import com.ru.entity.Bill;
import com.ru.entity.Shop;

public interface BillDao {
  void add(Bill bill);

  List<Bill> get_all_by_shop(Shop shop);
}
