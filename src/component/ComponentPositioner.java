package component;

public class ComponentPositioner {
    private static final int WIDTH = 100;
    private static final int HEIGHT = 100;

    public static int getWidth(){
        return WIDTH;
    }

    public static int getHeight(){
        return HEIGHT;
    }

    public static int getCenterX(int x) {
        return x - (WIDTH / 2);
    }

    public static int getCenterY(int y){
        return y - (HEIGHT / 2);
    }
}
