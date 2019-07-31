import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 * View class.
 *
 * @author Alex Merana
 *
 */
@SuppressWarnings("serial")
public class NetherDesign extends JFrame implements ActionListener {

    /**
     * JFrame used.
     */
    public JFrame frmNetherCalculator;

    /**
     * List of text fields.
     */
    private JTextField xInput, yInput, zInput, xOut, yOut, zOut;

    /**
     * Convert button.
     */
    private JButton convertButton;

    /**
     * A combo box of the conversion options.
     */
    private JComboBox comboBox;
    /**
     * Labels for the combo box.
     */
    private String[] labels = { "Nether", "Over-World" };

    /**
     * Controller object.
     */
    private NetherController controller;

    /**
     * Assigns controller.
     *
     * @param controller
     *            controller object
     */
    public void registerObserver(NetherController controller) {
        this.controller = controller;
    }

    /**
     * Updates the output.
     *
     * @param x
     *            xOut
     * @param y
     *            yOut
     * @param z
     *            zOut
     */
    public void updateOutputs(String x, String y, String z) {
        this.xOut.setText(x);
        this.yOut.setText(y);
        this.zOut.setText(z);
    }

    /**
     * Reports what the combo box selection is.
     *
     * @return combo box index
     */
    public int comboBoxIndex() {
        return this.comboBox.getSelectedIndex();
    }

    /**
     * Create the application.
     */
    public NetherDesign() {
        this.initialize();
    }

    /**
     *
     * @param event
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        /*
         * Set cursor to indicate computation on-going; this matters only if
         * processing the event might take a noticeable amount of time as seen
         * by the user
         */
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        /*
         * Determine which event has occurred that we are being notified of by
         * this callback; in this case, the source of the event (i.e, the widget
         * calling actionPerformed) is all we need because only buttons are
         * involved here, so the event must be a button press; in each case,
         * tell the controller to do whatever is needed to update the model and
         * to refresh the view
         */
        Object source = event.getSource();
        if (source == this.convertButton) {
            this.controller.processConvertEvent(this.xInput.getText(),
                    this.yInput.getText(), this.zInput.getText());

        }
        /*
         * Set the cursor back to normal (because we changed it at the beginning
         * of the method body)
         */
        this.setCursor(Cursor.getDefaultCursor());
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        this.frmNetherCalculator = new JFrame();
        this.frmNetherCalculator.setTitle("Nether Calculator");
        this.frmNetherCalculator.setBounds(100, 100, 453, 335);
        this.frmNetherCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.xInput = new JTextField();
        this.xInput.setText("0");
        this.xInput.setColumns(10);

        JLabel lblNewLabel = new JLabel("X:");

        this.yInput = new JTextField();
        this.yInput.setText("0");
        this.yInput.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Y:");

        this.zInput = new JTextField();
        this.zInput.setText("0");
        this.zInput.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Z:");

        JLabel lblNewLabel_3 = new JLabel("Convert to...");

        this.xOut = new JTextField();
        this.xOut.setEditable(false);
        this.xOut.setColumns(10);

        this.yOut = new JTextField();
        this.yOut.setEditable(false);
        this.yOut.setColumns(10);

        this.zOut = new JTextField();
        this.zOut.setEditable(false);
        this.zOut.setColumns(10);

        this.convertButton = new JButton("Convert");
        this.convertButton.addActionListener(this);

        this.comboBox = new JComboBox(this.labels);

        GroupLayout groupLayout = new GroupLayout(
                this.frmNetherCalculator.getContentPane());
        groupLayout.setHorizontalGroup(groupLayout
                .createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup().addGap(19)
                        .addGroup(groupLayout.createParallelGroup(
                                Alignment.TRAILING)
                                .addGroup(groupLayout
                                        .createParallelGroup(Alignment.LEADING)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(lblNewLabel_2))
                                .addComponent(lblNewLabel))
                        .addPreferredGap(ComponentPlacement.UNRELATED)
                        .addGroup(groupLayout
                                .createParallelGroup(Alignment.LEADING)
                                .addComponent(this.xInput,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addComponent(this.yInput,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGroup(groupLayout
                                                .createParallelGroup(
                                                        Alignment.LEADING)
                                                .addGroup(groupLayout
                                                        .createSequentialGroup()
                                                        .addGap(18)
                                                        .addGroup(groupLayout
                                                                .createParallelGroup(
                                                                        Alignment.LEADING)
                                                                .addComponent(
                                                                        this.convertButton)
                                                                .addComponent(
                                                                        lblNewLabel_3)))
                                                .addGroup(groupLayout
                                                        .createSequentialGroup()
                                                        .addPreferredGap(
                                                                ComponentPlacement.UNRELATED)
                                                        .addComponent(
                                                                this.comboBox,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE))))
                                .addComponent(this.zInput,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addGap(10)
                        .addGroup(groupLayout
                                .createParallelGroup(Alignment.LEADING)
                                .addComponent(this.zOut,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.yOut,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE)
                                .addComponent(this.xOut,
                                        GroupLayout.PREFERRED_SIZE,
                                        GroupLayout.DEFAULT_SIZE,
                                        GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(101, Short.MAX_VALUE)));
        groupLayout.setVerticalGroup(groupLayout
                .createParallelGroup(Alignment.LEADING)
                .addGroup(groupLayout.createSequentialGroup()
                        .addGroup(groupLayout
                                .createParallelGroup(Alignment.LEADING)
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addGap(83)
                                        .addGroup(groupLayout
                                                .createParallelGroup(
                                                        Alignment.BASELINE)
                                                .addComponent(this.xInput,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel))
                                        .addGap(18)
                                        .addGroup(groupLayout
                                                .createParallelGroup(
                                                        Alignment.BASELINE)
                                                .addComponent(this.yInput,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_1)
                                                .addComponent(this.comboBox,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE))
                                        .addGap(18)
                                        .addGroup(groupLayout
                                                .createParallelGroup(
                                                        Alignment.BASELINE)
                                                .addComponent(this.zInput,
                                                        GroupLayout.PREFERRED_SIZE,
                                                        GroupLayout.DEFAULT_SIZE,
                                                        GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblNewLabel_2)))
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addGap(56).addComponent(lblNewLabel_3))
                                .addGroup(groupLayout.createSequentialGroup()
                                        .addGap(83)
                                        .addComponent(this.xOut,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(18)
                                        .addComponent(this.yOut,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)
                                        .addGap(18).addComponent(this.zOut,
                                                GroupLayout.PREFERRED_SIZE,
                                                GroupLayout.DEFAULT_SIZE,
                                                GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(ComponentPlacement.RELATED, 48,
                                Short.MAX_VALUE)
                        .addComponent(this.convertButton).addGap(46)));
        this.frmNetherCalculator.getContentPane().setLayout(groupLayout);
    }
}
