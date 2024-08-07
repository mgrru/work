package com.ru.dao;

import java.util.List;

import com.ru.entity.Master;
import com.ru.entity.Pet;
import com.ru.entity.Shop;

public interface PetDao {
  void add(Pet pet);

  void del(Pet pet);

  void update(Pet pet);

  List<Pet> get_all_by_master(Master master);
  
  List<Pet> get_all_by_shop(Shop shop);
}
