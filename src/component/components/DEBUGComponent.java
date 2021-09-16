package component.components;

import component.Component;
import javafx.application.Platform;
import observer.Updatable;

public class DEBUGComponent extends Component implements Updatable {

    /**
     * The debug component will display the input value as either a 1 for true, or a 0 for false. The value is displayed
     * on the component label. Because the label is on the JavaFx thread and is being updated from the LogicThread, the
     * instructions to update the label must go inside the Platform.runlater() lambda.
     */
    @Override
    public void update() {
        Platform.runLater(() -> {
            if (getLogicalOutput())
                componentUI.setLabel("1");
            else
                componentUI.setLabel("0");
        });
    }
}
