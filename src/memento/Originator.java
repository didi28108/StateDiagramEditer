package memento;

import model.StateDiagram;

public class Originator {
    private static Originator instance = null;
    private Caretaker caretaker;
    private Originator(){
        caretaker = new Caretaker();
    }
    public static Originator getInstance(){
        if(instance == null){
            instance = new Originator();
        }
        return instance;
    }
    public StateDiagram undoCommand(StateDiagram stateDiagram){
        StateDiagram tmp = null;
        if(!(caretaker.isUndoEmpty())){
            tmp = caretaker.getUndo().getStateDiagram();
            caretaker.setRedoStack(new Memento(stateDiagram));
        }
        return tmp;
    }
    public StateDiagram redoCommand(StateDiagram stateDiagram){
        StateDiagram tmp = null;
        if(!(caretaker.isRedoEmpty())){
            tmp = caretaker.getRedo().getStateDiagram();
            caretaker.setUndoStack(new Memento(stateDiagram));
        }
        return tmp;
    }
    public void setMemeto(StateDiagram stateDiagram){
        caretaker.setUndoStack(new Memento(stateDiagram));
        caretaker.clearRedoStack();
    }
    public void clearall(){
        caretaker.clearRedoStack();
        caretaker.clearUndoStack();
    }
}
