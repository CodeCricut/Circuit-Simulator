package component.components;


import component.Component;
import javafx.scene.input.MouseButton;

public class ToggleComponent extends Component {

    private boolean toggled = false;

    /**
     * The toggle component can be toggled between an on and off state by the user. The user can toggle the component
     * by right clicking the main body of the component.
     */
//    public ToggleComponent() {
//        // This check must be done, because the UI is null on component creation.
//        if (componentUI != null) {
//            componentUI.getRectangleBody().setOnMouseClicked(event -> {
//                if (event.getButton() == MouseButton.SECONDARY) {
//                    toggled = !toggled;
//                }
//            });
//        }
//    }

    public void setToggleBehavior(){
        componentUI.getRectangleBody().setOnMouseClicked(event -> {
            if (event.getButton() == MouseButton.SECONDARY) {
                toggled = !toggled;
            }
        });
    }

    @Override
    public boolean getLogicalOutput() {
        return toggled;
    }
}
