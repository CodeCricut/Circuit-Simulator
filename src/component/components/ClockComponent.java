package component.components;


import component.Component;

public class ClockComponent extends Component {

    private double lastPulseMillis = 0;
    private static final double millisBetweenPulses = 10;

    private boolean value = false;

    /**
     * The clock component outputs a positive value on regular intervals. If getlogicalOutput() is
     * called and the time between pulses has elapsed since the last pulse, then the value will be positive, and the
     * the pulse timer will be reset.
     * @return
     */
    @Override
    public boolean getLogicalOutput() {
        double timeSincePulse = System.currentTimeMillis() - lastPulseMillis;

        if (timeSincePulse >= millisBetweenPulses){
            value = !value;
            lastPulseMillis = System.currentTimeMillis();
        }
        return value;
    }
}
