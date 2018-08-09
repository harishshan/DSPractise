package com.blogspot.harishshan.practise1;
import java.util.List;
import java.util.ArrayList;
class Originator {
    private String state;
    public void set(String state) {
        this.state = state;
        System.out.println("Originator: Setting state to " + state);
    } 
    public Memento saveToMemento() {
        System.out.println("Originator: Saving to Memento.");
        return new Memento(this.state);
    } 
    public void restoreFromMemento(Memento memento) {
        this.state = memento.getSavedState();
        System.out.println("Originator: State after restoring from Memento: " + state);
    } 
    public static class Memento {
        private final String state;
        public Memento(String stateToSave) {
            state = stateToSave;
        }
        private String getSavedState() {
            return state;
        }
    }
}
 
class CareTaker {
    public static void main(String[] args) {
        List<Originator.Memento> savedStates = new ArrayList<Originator.Memento>();
        Originator originator = new Originator();
        originator.set("State1");
        originator.set("State2");
        savedStates.add(originator.saveToMemento());
        originator.set("State3");
        savedStates.add(originator.saveToMemento());
        originator.set("State4"); 
        originator.restoreFromMemento(savedStates.get(1));   
    }
}
