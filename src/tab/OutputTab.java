package tab;

import main.Main;

public class OutputTab extends Tab {

    private OutputTabUI tabUI;
    public OutputTab(OutputTabUI tabUI, TabLogic tabLogic) {
        super(tabLogic);
        this.tabUI = tabUI;
        tabUI.setOnMouseClicked(event -> {
            System.out.println("Output clicked");
            Main.getComponentPanel().outputClicked(this);
        });
    }

    @Override
    public TabUI getTabUI() {
        return tabUI;
    }
}
