package domain.repository;

import domain.entities.Item;

public interface ItemRepository {
  Item findById(Long idItem);
}
