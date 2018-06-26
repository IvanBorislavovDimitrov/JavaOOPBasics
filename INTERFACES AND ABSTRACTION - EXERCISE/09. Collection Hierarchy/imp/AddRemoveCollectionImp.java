package imp;

import interfaces.AddRemoveCollection;

public class AddRemoveCollectionImp extends AddCollectionImp implements AddRemoveCollection {

    @Override
    public int add(String item) {
        this.elements.add(0, item);

        return 0;
    }

    @Override
    public String remove() {
        return this.elements.remove(this.elements.size() - 1);
    }
}
