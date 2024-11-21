package edu.upc.dsa;

import edu.upc.dsa.models.Item;

import java.util.ArrayList;
import java.util.List;

public interface StoreManager {

        public Item getItembyId(String id);

        public List<Item> getAllItems();

        public void addItem(Item item);

        public void deleteItem(String name);





}
