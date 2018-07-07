package net.java.main.interfaces;

import net.java.main.models.spells.Spell;
import net.java.main.models.units.Unit;

import java.util.List;

public interface CombatHandler {

    void setUnit(Unit unit);

    Unit pickNextTarget(List<Unit> targetCandidates);

    Spell generateAttack();
}
