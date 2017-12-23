package memento;

import model.StateDiagram;

public class Memento {
    private StateDiagram stateDiagram;
    public Memento(StateDiagram sd){
        this.stateDiagram = sd;
    }

    public StateDiagram getStateDiagram() {
        return this.stateDiagram;
    }
}
