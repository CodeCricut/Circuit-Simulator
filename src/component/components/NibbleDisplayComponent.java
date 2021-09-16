package component.components;

import component.Component;
import javafx.application.Platform;
import observer.Updatable;
import tab.InputTab;

public class NibbleDisplayComponent extends Component implements Updatable {
    @Override
    public void update() {
        int intValue = 0;
        int currentExponent = 1;
        for (InputTab inputTab : inputTabs) {
            intValue += (inputTab.getValue() ? 1 : 0) * currentExponent;
            currentExponent *= 2;
        }


        int finalIntValue = intValue;
        Platform.runLater(() -> componentUI.setLabel(Integer.toString(finalIntValue)));
    }
}
