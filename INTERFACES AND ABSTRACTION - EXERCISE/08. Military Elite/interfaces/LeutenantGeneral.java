package interfaces;

import java.util.List;
import java.util.Set;

public interface LeutenantGeneral extends Private {
    void addPrivate(Soldier soldier);

    List<Soldier> getPrivates();

}
