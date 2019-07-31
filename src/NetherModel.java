/**
 * Model class.
 *
 * @author Alex Merana
 *
 */
public class NetherModel {

    /**
     * Inputs and outputs.
     */
    private String xInput, yInput, zInput, xOut, yOut, zOut;

    /**
     * Initializes text fields.
     */
    public NetherModel() {

        this.xInput = "0";
        this.yInput = "0";
        this.zInput = "0";
        this.xOut = "";
        this.yOut = "";
        this.zOut = "";

    }

    /**
     * Sets the inputs.
     *
     * @param x
     *            x text-field
     * @param y
     *            y text-field
     * @param z
     *            z text-field
     */
    public void setInputs(String x, String y, String z) {
        this.xInput = x;
        this.yInput = y;
        this.zInput = z;
    }

    /**
     * Sets the outputs.
     *
     * @param x
     *            x text-field
     * @param y
     *            y text-field
     * @param z
     *            z text-field
     */
    public void setOutputs(String x, String y, String z) {
        this.xOut = x;
        this.yOut = y;
        this.zOut = z;
    }

    /**
     * returns xInput.
     *
     * @return xInput
     */
    public String xOut() {
        return this.xOut;
    }

    /**
     * returns yInput.
     *
     * @return yInput
     */
    public String yOut() {
        return this.yOut;
    }

    /**
     * returns zInput.
     *
     * @return zInput
     */
    public String zOut() {
        return this.zOut;
    }
}
