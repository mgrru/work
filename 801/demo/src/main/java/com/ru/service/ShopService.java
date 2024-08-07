package com.ru.service;

import java.util.List;

import com.ru.entity.Pet;

public interface ShopService extends BuyAble, SellAble, BreedAble, BillAble, LoginAble {

  List<Pet> get_pets_in_stock();

  List<Pet> get_breed_pets();

  void charge(Pet pet);

  int get_balance();
}
