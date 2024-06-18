package infra.repository.memory;

import java.util.ArrayList;

import domain.entities.Item;
import domain.repository.ItemRepository;

public class ItemRepositoryMemory implements ItemRepository {

  private ArrayList<Item> items;

  public ItemRepositoryMemory() {
    this.items = new ArrayList<>();
    this.items.add(new Item(1L, "Música", "CD", 30));
    this.items.add(new Item(2L, "Vídeo", "DVD", 50));
    this.items.add(new Item(3L, "Vídeo", "VHS", 10));
    this.items.add(new Item(4L, "Instrumentos Musicais", "Guitarra", 1000, 100, 30, 10, 3));
    this.items.add(new Item(5L, "Instrumentos Musicais", "Amplificador", 5000, 100, 50, 50, 20));
    this.items.add(new Item(6L, "Acessórios", "Cabo", 30, 10, 10, 10, 0.9));
  }

  @Override
  public Item findById(Long idItem) {
    for (Item item : items) {
      if ((item.getIdItem()).equals(idItem)) {
        return item;
      }
    }
    return null;
  }

}
