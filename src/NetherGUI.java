/**
 * Converts Overworld and Nether coordinates to their counter-parts.
 *
 *
 * @author Alex Merana
 *
 */
public final class NetherGUI {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private NetherGUI() {
    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        NetherDesign window = new NetherDesign();
        window.frmNetherCalculator.setVisible(true);
        NetherModel model = new NetherModel();
        NetherController controller = new NetherController(model, window);
        window.registerObserver(controller);
    }

}
