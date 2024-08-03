package com.ru.dao;

import java.util.List;

public interface Bill {
  void save(Bill bill);
  List<Bill> get_all();
}
