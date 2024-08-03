package com.ru.dao;

import com.ru.entity.Pet;

public interface PetDao {
  void save(Pet pet);

  void del(Pet pet);

  void update(Pet pet);
}
