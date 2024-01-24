package game;

public class Thing implements Cloneable {
    protected String id;
    protected String title;
    protected int count;
    public int goldPrice;
    public int silverPrice;
    public boolean canUse() {
        return false;
    }
    public boolean use(Player player){
        return false;
    }
    public boolean craft(Player player){
        return false;
    }

    public Thing(String id, String title, int count, int goldPrice, int silverPrice) {
        this.id = id;
        this.title = title;
        this.count = count;
        this.goldPrice = goldPrice;
        this.silverPrice = silverPrice;
    }



    @Override
    public Thing clone() {
        try {
            Thing clone = (Thing) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public String getTitle() {
        return title;
    }

    public int getCount() {
        return count;
    }

    public void addCount(int addCount) {
        count += addCount;
    }

    public boolean canCraft() {
        return false;
    }
}