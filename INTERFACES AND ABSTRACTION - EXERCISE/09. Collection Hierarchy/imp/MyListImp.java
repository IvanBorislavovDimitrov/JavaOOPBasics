package imp;

import interfaces.MyList;

public class MyListImp extends AddRemoveCollectionImp implements MyList {

    @Override
    public int used() {
        return this.elements.size();
    }

    @Override
    public String remove() {
        return this.elements.remove(0);
    }
}
