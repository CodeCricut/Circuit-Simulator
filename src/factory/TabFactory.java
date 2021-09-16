package factory;

import component.Component;
import tab.InputTabLogic;
import tab.OutputTabLogic;
import tab.InputTab;
import tab.OutputTab;
import tab.InputTabUI;
import tab.OutputTabUI;
import tab.TabPositioner;

/*
    Responsibilities:
    * Creates input and output tabs, with logic such as what to do when they are clicked
 */

class TabFactory {

    static InputTab createInputTab(InputTabUI inputTabUI, InputTabLogic inputTabLogic){
        return new InputTab(inputTabUI, inputTabLogic);
    }

    static OutputTab createOutputTab(OutputTabUI outputTabUI, OutputTabLogic outputTabLogic){
        return new OutputTab(outputTabUI, outputTabLogic);
    }

    static InputTabUI createInputTabBody(int tabNum){
        int x = TabPositioner.getInputX();
        int y = TabPositioner.getInputY(tabNum);
        int w = TabPositioner.getTabWidth();
        int h = TabPositioner.getTabHeight();
        return new InputTabUI(x, y, w, h);
    }

    static OutputTabUI createOutputTabBody(int numOfOutputs, int tabNum){
        int x = TabPositioner.getOutputX();
        int y = TabPositioner.getOutputY(numOfOutputs, tabNum);
        int w = TabPositioner.getTabWidth();
        int h = TabPositioner.getTabHeight();
        return new OutputTabUI(x, y, w, h);
    }

    static InputTabLogic createInputTabLogic(){
        return new InputTabLogic();
    }

    static OutputTabLogic createOutputTabLogic(Component c){
        return new OutputTabLogic(c);
    }
}
