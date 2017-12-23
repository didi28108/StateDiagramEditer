package builder;

import model.State;
import model.Transition;

public class Modelsupervier {
    TransitionBuilder transitionBuilder;
    StateBuilder stateBuilder;
    public Modelsupervier(){};
    public void state_contruct(){
        stateBuilder = new StateBuilder();
        stateBuilder.createText();
        stateBuilder.createMain();
        stateBuilder.addelse();
        stateBuilder.combined();
    }
    public void transition_contuct(){
        transitionBuilder = new TransitionBuilder();
        transitionBuilder.createText();
        transitionBuilder.createMain();
        transitionBuilder.addelse();
        transitionBuilder.combined();
    }
    public State getStateModel(){
        return (State)stateBuilder.getModle();
    }
    public Transition getTransition(){
        return (Transition)transitionBuilder.getModle();
    }
}
