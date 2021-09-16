package tab;

public abstract class Tab {

    private TabLogic tabLogic;

    Tab(TabLogic tabLogic){
        this.tabLogic = tabLogic;
    }

    public boolean getValue(){
        return tabLogic.getValue();
    }

    public TabLogic getTabLogic() {
        return tabLogic;
    }

    public abstract TabUI getTabUI();

}
