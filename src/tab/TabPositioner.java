package tab;

import component.ComponentPositioner;

public class TabPositioner {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private static final int TAB_SPACING = 20;

    public static int getTabWidth(){
        return WIDTH;
    }

    public static int getTabHeight(){
        return HEIGHT;
    }

    public static int getInputX(){
        int bodyWidth = ComponentPositioner.getWidth();
        return -(bodyWidth + WIDTH) / 2;
    }

    public static int getInputY(int inputNum){
        int bodyHeight = ComponentPositioner.getHeight();
        int zero = -bodyHeight /  2;

        return zero + (inputNum + 1) * TAB_SPACING;
    }

    public static int getOutputX(){
        return (ComponentPositioner.getWidth() + WIDTH) / 2;
    }

    public static int getOutputY(int numOfOutputs, int outputNum){
        int bodyHeight = ComponentPositioner.getHeight();
        int zero = -bodyHeight /  2;

        int y =  Math.round(zero + (bodyHeight / (numOfOutputs +1)) * (outputNum + 1));
        return y;
    }
}
