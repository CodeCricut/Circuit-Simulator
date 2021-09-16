package tab;

import component.Component;

public class OutputTabLogic extends TabLogic {

    Component component;

    public OutputTabLogic(Component component){
        this.component = component;
    }

    @Override
    public void update() {
        value = component.getLogicalOutput();
    }
}
