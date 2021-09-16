package tab;

import main.Main;

public class InputTab extends Tab {

    private InputTabUI tabUI;

    public InputTab(InputTabUI tabUI, TabLogic tabLogic) {
        super(tabLogic);
        this.tabUI = tabUI;
        tabUI.setOnMouseClicked(event -> {
            System.out.println("Input clicked");
            Main.getComponentPanel().inputClicked(this);
        });
    }

    @Override
    public TabUI getTabUI() {
        return tabUI;
    }
}
