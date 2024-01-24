package game;

import game.thing.HealthPotion;
import game.thing.Treater;
import game.thing.Jump;

import java.util.ArrayList;
import java.util.Objects;

public class Inventory {
    ArrayList<Thing> list = new ArrayList<>();

    public static Inventory all = new Inventory();

    static {
        all.add(new Thing("goldCoin", "золотая монета", 0, 0, 10), 0);
        all.add(new Thing("silverCoin", "серебряная монета", 0, 0, 1), 0);

        all.add(new HealthPotion("healthPotion", "зелье исцеления",0 ,2 ,0), 0);
        all.add(new Jump("jumpForward", "прыжок вперёд", 0, 3, 0, 5), 0);
        all.add(new Jump("jumpBack", "прыжок назад", 0, 2, 7, -5), 0);
        all.add(new Thing("waterBottle", "бутылка с водой", 0, 0, 9), 0);
        all.add(new Treater("apple", "яблоко", 0, 1, 2, 1), 0);
        all.add(new Thing("mint", "мята", 0, 0, 5), 0);
        all.add(new Thing("crystal", "кристалл", 0, 7, 0), 0);
    }

    public Thing find(String id) {
        for (int i = 0; i < list.size(); i++) {
            if (Objects.equals(id, list.get(i).id)){
                return list.get(i);
            }
        }
        return null;
    }


    public void showItems() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).count + "  " + list.get(i).title);
        }
        if (list.isEmpty()){
            System.out.println("У вас нет никаких предметов");
        }
    }

    public Thing add(Thing shopItem, int count) {
        Thing thingAdd = find(shopItem.id);
        if (thingAdd == null){
            thingAdd = shopItem.clone();
            list.add(thingAdd);
        }
        thingAdd.addCount(count);
        return thingAdd;
    }

    public int getCount(String thingId) {
        Thing thing = find(thingId);
        return thing != null? thing.getCount(): 0;
    }

    public void addCount(String thingId, int addCount) {
        Thing thing = find(thingId);
        if (thing == null) {
            if (all.find(thingId) == null){
                System.out.println("Предмет " + thingId + " не найден");
                return;
            }
            add(all.find(thingId), addCount);
            return;
        }
        thing.count += addCount;
    }

    public void append(Inventory from) {
        for (int i = 0; i < from.list.size(); i++){
            add(from.list.get(i), 0);
        }
    }


    public void showAllowedItems() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println("   " + list.get(i).id + "  " + list.get(i).title);
        }
    }

    public boolean hasAny() {
        return !list.isEmpty();
    }
}

