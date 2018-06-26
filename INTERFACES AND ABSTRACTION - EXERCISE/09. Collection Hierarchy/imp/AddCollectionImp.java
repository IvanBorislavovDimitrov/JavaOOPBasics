package imp;

import interfaces.AddCollection;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionImp implements AddCollection {

    protected List<String> elements;

    public AddCollectionImp() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(String item) {
        int index = this.elements.size();
        this.elements.add(item);

        return index;
    }
}
