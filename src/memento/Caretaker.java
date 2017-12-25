package memento;

import java.util.Stack;

public class Caretaker {
    private Stack<Memento> undoStack = new Stack<>();
    private Stack<Memento> redoStack = new Stack<>();
    public Caretaker(){}
    public void setUndoStack(Memento memento){
        undoStack.push(memento);
    }
    public Memento getUndo(){
        return undoStack.pop();
    }
    public void setRedoStack(Memento memento){
        redoStack.push(memento);
    }
    public Memento getRedo(){
        return redoStack.pop();
    }
    public void clearRedoStack() {
        while (!(this.isRedoEmpty())) {
            redoStack.clear();
        }
    }
    public void clearUndoStack(){
        while (!(this.isUndoEmpty())) {
            undoStack.clear();
        }
    }
    public Boolean isUndoEmpty(){
        return undoStack.empty();
    }
    public Boolean isRedoEmpty(){
        return redoStack.empty();
    }

}
