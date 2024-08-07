package com.ru.service;

public interface MasterService extends BuyAble, SellAble, LoginAble {
  int get_balance();
}
