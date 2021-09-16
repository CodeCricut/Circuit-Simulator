package main;

import observer.Updatable;

import java.util.ArrayList;

/*
    Responsibilities:
    * Keep track of all of the component.components
    * Add component.components
    * Update and notify the component.components on a loop
 */

public class LogicThread extends Thread {

    private static final int MILLIS_TO_WAIT = 10;

    private ArrayList<Updatable> updatablesToBeAdded = new ArrayList<>();
    private ArrayList<Updatable> updatables = new ArrayList<>();

    public void run() {
        for (int i = 0; i != -1; i++) {
            updatables.addAll(updatablesToBeAdded);
            updatablesToBeAdded.clear();
            for (Updatable u : updatables){
                u.update();
            }

            try {
                Thread.sleep(MILLIS_TO_WAIT);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void addUpdatable(Updatable u){
        updatablesToBeAdded.add(u);
    }

    public ArrayList<Updatable> getUpdatables() {
        return updatables;
    }
}
