/**
 * Nether Controller class.
 *
 * @author Alex Merana
 *
 */
public class NetherController {

    /**
     * Constructs a model object.
     */
    private NetherModel model;

    private final int CONVERSION_RATE = 8;

    /**
     * Constructs a view object.
     */
    private NetherDesign view;

    /**
     * Updates the view to match what the model has stored.
     *
     * @param model
     *            model object
     * @param view
     *            view object
     */
    public void updateViewToMatchModel(NetherModel model, NetherDesign view) {
        this.model = model;
        this.view = view;

        this.view.updateOutputs(this.model.xOut(), this.model.yOut(),
                this.model.zOut());
    }

    /**
     * Demo constructor.
     *
     * @param model
     *            model object.
     * @param view
     *            view object.
     */
    public NetherController(NetherModel model, NetherDesign view) {
        this.model = model;
        this.view = view;

        this.updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Checks to see if there is a correct value in the text-fields.
     *
     * @param x
     *            input
     * @return boolean corresponding to answer
     */
    public boolean canCovert(String x) {
        try {
            Integer.parseInt(x);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Converts coordinate to correct coordinate counterpart.
     *
     * @param x
     *            coordinate
     * @return converted coordinate
     */
    public String conversionToNether(String x) {
        if (this.canCovert(x)) {
            int temp = Integer.parseInt(x);
            temp = temp / this.CONVERSION_RATE;
            return temp + "";
        } else {
            return "ERROR";
        }
    }

    /**
     * processes the conversion.
     *
     * @param x
     *            x-coordinate
     * @param y
     *            y-coordinate
     * @param z
     *            z-coordinate
     */
    public void processConvertEvent(String x, String y, String z) {
        if (this.view.comboBoxIndex() == 0) {
            this.model.setOutputs(this.conversionToNether(x), y,
                    this.conversionToNether(z));
        } else {
            this.model.setOutputs(this.conversionToOverworld(x), y,
                    this.conversionToOverworld(z));
        }

        this.updateViewToMatchModel(this.model, this.view);
    }

    /**
     * Converts coordinate to correct coordinate counterpart.
     *
     * @param x
     *            coordinate
     * @return converted coordinate
     */
    public String conversionToOverworld(String x) {
        if (this.canCovert(x)) {
            int temp = Integer.parseInt(x);
            temp = temp * this.CONVERSION_RATE;
            return temp + "";
        } else {
            return "ERROR";
        }
    }

}
