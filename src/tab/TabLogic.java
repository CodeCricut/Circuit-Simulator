package tab;

import observer.Updatable;

public abstract class TabLogic implements Updatable {

    protected boolean value = false;

    public boolean getValue(){
        return value;
    }
}
